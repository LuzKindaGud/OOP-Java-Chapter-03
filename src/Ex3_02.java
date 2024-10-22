class MyPolynomial {
    private double[] coeffs;

    // Constructor
    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    // Get the degree of the polynomial
    public int getDegree() {
        return coeffs.length - 1;
    }

    // Evaluate the polynomial at a given value of x
    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < coeffs.length; i++) {
            result += coeffs[i] * Math.pow(x, i);
        }
        return result;
    }

    // Add two polynomials
    public MyPolynomial add(MyPolynomial right) {
        // Find the length of the longer polynomial
        int maxLength = Math.max(this.coeffs.length, right.coeffs.length);
        // Create a new array to store the coefficients of the result
        double[] resultCoeffs = new double[maxLength];
        // Add the coefficients of the two polynomials
        for (int i = 0; i < maxLength; i++) {
            resultCoeffs[i] = (i < this.coeffs.length ? this.coeffs[i] : 0) + (i < right.coeffs.length ? right.coeffs[i] : 0);
        }
        // Create a new MyPolynomial object and return it
        return new MyPolynomial(resultCoeffs);
    }

    // Multiply two polynomials
    public MyPolynomial multiply(MyPolynomial right) {
        // Find the length of the new polynomial
        int length = this.coeffs.length + right.coeffs.length - 1;
        // Create a new array to store the coefficients of the result
        double[] resultCoeffs = new double[length];
        // Multiply the coefficients of the two polynomials
        for (int i = 0; i < this.coeffs.length; i++) {
            for (int j = 0; j < right.coeffs.length; j++) {
                resultCoeffs[i + j] += this.coeffs[i] * right.coeffs[j];
            }
        }
        // Create a new MyPolynomial object and return it
        return new MyPolynomial(resultCoeffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = coeffs.length - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                if (i == 0) {
                    sb.append(coeffs[i]);
                } else if (i == 1) {
                    sb.append(coeffs[i]).append("x");
                } else {
                    sb.append(coeffs[i]).append("x^").append(i);
                }
                if (i > 0) {
                    sb.append(" + ");
                }
            }
        }
        return sb.toString();
    }
}
public class Ex3_02 {
    public static void main(String[] args) {
        // Test Constructor
        MyPolynomial p1 = new MyPolynomial(2.0, 3.0, 4.0); // 2 + 3x + 4x^2
        System.out.println("Polynomial p1: " + p1);

        MyPolynomial p2 = new MyPolynomial(1.0, 0.0, -1.0); // 1 - x^2
        System.out.println("Polynomial p2: " + p2);

        // Test getDegree method
        System.out.println("Degree of p1: " + p1.getDegree());
        System.out.println("Degree of p2: " + p2.getDegree());

        // Test evaluate method
        double x = 2.0;
        System.out.println("p1 evaluated at x = " + x + ": " + p1.evaluate(x));
        System.out.println("p2 evaluated at x = " + x + ": " + p2.evaluate(x));

        // Test add method
        MyPolynomial sum = p1.add(p2);
        System.out.println("Sum of p1 and p2: " + sum);

        // Test multiply method
        MyPolynomial product = p1.multiply(p2);
        System.out.println("Product of p1 and p2: " + product);

        // Test toString method
        System.out.println("p1 as string: " + p1.toString());
        System.out.println("p2 as string: " + p2.toString());
    }
}
