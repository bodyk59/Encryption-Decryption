abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}


class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }
}

class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getPerimeter() {
        return 2 * (this.a + this.b);
    }

    @Override
    double getArea() {
        return this.a * this.b;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * this.radius * Math.PI;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
}