class MyComplex {
    private double real;
    private double imag;

    // Constructor
    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Getters and Setters
    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    // Other methods
    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + "+" + imag + "i";
    }

    public boolean isReal() {
        return imag == 0.0;
    }

    public boolean isImaginary() {
        return real == 0.0;
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return this.real == another.real && this.imag == another.imag;
    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public void addInto(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
    }

    public MyComplex addNew(MyComplex right) {
        return new MyComplex(this.real + right.real, this.imag + right.imag);
    }
}
public class Ex3_01 {
    public static void main(String[] args) {
        // Test Constructor
        MyComplex c1 = new MyComplex();
        System.out.println("Default Constructor:");
        System.out.println("Real: " + c1.getReal() + ", Imaginary: " + c1.getImag());

        MyComplex c2 = new MyComplex(3.0, 4.0);
        System.out.println("Parameterized Constructor:");
        System.out.println("Real: " + c2.getReal() + ", Imaginary: " + c2.getImag());

        // Test Setters
        c2.setReal(5.0);
        c2.setImag(6.0);
        System.out.println("After Setters:");
        System.out.println("Real: " + c2.getReal() + ", Imaginary: " + c2.getImag());

        // Test setValue method
        c2.setValue(1.0, 2.0);
        System.out.println("After setValue:");
        System.out.println("Real: " + c2.getReal() + ", Imaginary: " + c2.getImag());

        // Test toString method
        System.out.println("toString(): " + c2.toString());

        // Test isReal method
        System.out.println("Is Real: " + c2.isReal());

        // Test isImaginary method
        MyComplex c3 = new MyComplex(0.0, 3.0);
        System.out.println("Is Imaginary (c3): " + c3.isImaginary());

        // Test equals method
        System.out.println("Equals (1.0, 2.0): " + c2.equals(1.0, 2.0));
        System.out.println("Equals (MyComplex(1.0, 2.0)): " + c2.equals(new MyComplex(1.0, 2.0)));

        MyComplex c4 = new MyComplex(1.0, 2.0);
        System.out.println("Equals c2 and c4: " + c2.equals(c4));

        // Test magnitude method
        System.out.println("Magnitude: " + c2.magnitude());

        // Test addInto method
        MyComplex c5 = new MyComplex(1.0, 2.0);
        c5.addInto(new MyComplex(2.0, 3.0));
        System.out.println("After addInto (c5):");
        System.out.println("Real: " + c5.getReal() + ", Imaginary: " + c5.getImag());

        // Test addNew method
        MyComplex c6 = c2.addNew(new MyComplex(2.0, 3.0));
        System.out.println("After addNew (c6):");
        System.out.println("Real: " + c6.getReal() + ", Imaginary: " + c6.getImag());
    }
}