
package program;

/**
 *
 * @author pc
 */
class Triangle extends Shape {
    double sideA;
    double sideB;
    double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getArea() {
        double haftPerimeter = getPerimeter() / 2;
        return Math.sqrt(haftPerimeter
                * (haftPerimeter - sideA)
                * (haftPerimeter - sideB)
                * (haftPerimeter - sideC));
    }

    @Override
    public void printResult() {
        System.out.println("----- Triangle -----");
        System.out.println("Side A: " + getSideA());
        System.out.println("Side B: " + getSideB());
        System.out.println("Side C: " + getSideC());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}