package encryptdecrypt;

public class Unicode implements Algorithms {
    private String message;
    private int key;

    public Unicode(String message, int key) {
        this.message = message;
        this.key = key;
    }

    @Override
    public String encrypt() {
        char[] encrypted = this.message.toCharArray();

        for (int i = 0; i < encrypted.length; i++) {
            encrypted[i] += this.key;
        }

        return String.valueOf(encrypted);
    }

    @Override
    public String decrypt() {
        char[] decrypted = this.message.toCharArray();

        for (int i = 0; i < decrypted.length; i++) {
            decrypted[i] -= this.key;
        }

        return String.valueOf(decrypted);
    }
}