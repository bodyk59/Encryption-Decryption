
class Complex {

    double real;
    double image;

    void add(Complex complex) {
        this.real += complex.real;
        this.image += complex.image;
    }

    void subtract(Complex complex) {
        this.real -= complex.real;
        this.image -= complex.image;
    }
}