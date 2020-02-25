
public class AsciiCharSequence implements CharSequence {
    private byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars.clone();
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int i) {
        return (char) chars[i];
    }

    @Override
    public AsciiCharSequence subSequence(int i, int i1) {
        return new AsciiCharSequence(toString().substring(i, i1).getBytes());
    }

    @Override
    public String toString() {
        return new String(chars);
    }
}