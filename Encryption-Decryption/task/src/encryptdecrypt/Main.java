package encryptdecrypt;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try (Crypto crypto = new Crypto(args)) {
            crypto.run();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Crypto implements Runnable, Closeable {
    private PrintWriter output = new PrintWriter(System.out);
    private ChoosingAlgorithm choosingAlgorithm = new ChoosingAlgorithm();
    private String mode = "enc";
    private boolean closed = false;

    public Crypto(String[] args) throws IllegalArgumentException, IOException {
        int key = 0;
        String data = "";

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("Missing value for -mode");
                    } else if (!"enc".equals(args[i + 1]) && !"dec".equals(args[i + 1])) {
                        throw new IllegalArgumentException("Illegal value for -mode");
                    }
                    this.mode = args[i + 1];
                    break;
                case "-key":
                    if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("Missing value for -key");
                    } else if (!args[i + 1].matches("[0-9]+")) {
                        throw new IllegalArgumentException("Illegal value for -key");
                    }
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-in":
                    if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("Missing value for -in");
                    }
                    data = new String(Files.readAllBytes(Paths.get(args[i + 1])));
                    break;
                case "-out":
                    if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                        throw new IllegalArgumentException("Missing value for -out");
                    }
                    this.output = new PrintWriter(new File(args[i + 1]));
                    break;
            }
        }

        for (int i = 0; i < args.length; i++) {
            if ("-data".equals(args[i])) {
                if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                    throw new IllegalArgumentException("Missing value for -data");
                }
                data = args[i + 1];
            }
        }

        for (int i = 0; i < args.length; i++) {
            if ("-alg".equals(args[i])) {
                if (i + 1 == args.length || args[i + 1].startsWith("-")) {
                    throw new IllegalArgumentException("Missing value for -alg");
                }

                if (args[i + 1].equals("unicode")) {
                    choosingAlgorithm.setAlgorithm(new Unicode(data, key));
                }

                if (args[i + 1].equals("shift")) {
                    choosingAlgorithm.setAlgorithm(new Shift(data, key));
                }
            }
        }
    }

    private boolean isClosed() {
        return this.closed;
    }

    @Override
    public void close() {
        this.output.close();
        this.closed = true;
    }

    @Override
    public void run() {
        if (this.isClosed()) {
            return;
        }

        if ("enc".equals(this.mode)) {
            this.output.println(choosingAlgorithm.encrypt());
        } else {
            this.output.println(choosingAlgorithm.decrypt());
        }
    }
}