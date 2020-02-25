package encryptdecrypt;

public class ChoosingAlgorithm {
    private Algorithms algorithm;

    public void setAlgorithm(Algorithms algorithm) {
        this.algorithm = algorithm;
    }

    public String encrypt() {
        return this.algorithm.encrypt();
    }

    public String decrypt() {
        return this.algorithm.decrypt();
    }
}