class A extends Abstract implements Interface {

    public void print() {
        System.out.println("class-A");
    }

    @Override
    public void instanceMethod1() {

    }

    @Override
    public void instanceMethod2() {

    }
}

class B extends A { }

class C extends B {

    public void print() {
        System.out.println("class-C");
    }

    public static void main(String[] args) {
        A instance = new C();
        instance.print();
    }
}

class D extends C {

    public void print() {
        System.out.println("class-D");
    }
}