package encryptdecrypt;

public class Shift implements Algorithms {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String message;
    private int key;

    public Shift(String message, int key) {
        this.message = message;
        this.key = key;
    }

    @Override
    public String encrypt() {
        char[] encrypted = this.message.toCharArray();
        char temporary;

        for (int i = 0; i < encrypted.length; i++) {
            temporary = encrypted[i];

            if (Character.isLetter(encrypted[i])) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (Character.toLowerCase(encrypted[i]) == alphabet[j]) {
                        encrypted[i] = alphabet[keyTransformEnc(j, this.key)];
                        break;
                    }
                }
            } else {
                continue;
            }

            encrypted[i] = checkCases(temporary, encrypted[i]);
        }

        return String.valueOf(encrypted);
    }

    @Override
    public String decrypt() {
        char[] decrypted = this.message.toCharArray();
        char temporary;

        for (int i = 0; i < decrypted.length; i++) {
            temporary = decrypted[i];

            if (Character.isLetter(decrypted[i])) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (Character.toLowerCase(decrypted[i]) == alphabet[j]) {
                        decrypted[i] = alphabet[keyTransformDec(j, this.key)];
                        break;
                    }
                }
            } else {
                continue;
            }

            decrypted[i] = checkCases(temporary, decrypted[i]);
        }

        return String.valueOf(decrypted);
    }

    private int keyTransformEnc(int position, int key) {
        int sum = position + key;

        if (sum > alphabet.length - 1) {
            return sum - ((sum / alphabet.length) * alphabet.length);
        }

        return sum;
    }

    private int keyTransformDec(int position, int key) {
        if (position < key) {
            return alphabet.length - key + position;
        }

        return position - key;
    }

    private char checkCases(char c1, char c2) {
        if (Character.isUpperCase(c1)) {
            c2 = Character.toUpperCase(c2);
        }

        return c2;
    }
}