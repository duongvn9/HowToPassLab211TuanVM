package program;

/**
 *
 * @author pc
 */
public class Main {
    public static void main(String[] args) {
        // Step 1: Get input data for three shape
        // Get input data Rectangle
        Rectangle rectangle = HandleData.getDataRectangle();
        // Get input data Circle
        Circle circle = HandleData.getDataCircle();
        // Get input data Triangle
        Triangle triangle = HandleData.getDataTriangle();
        // Step 2: Display result
        HandleData.displayResult(rectangle, circle, triangle);
    }
}