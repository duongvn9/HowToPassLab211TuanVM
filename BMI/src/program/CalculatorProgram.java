package program;

public class CalculatorProgram {

    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        // get input first number
        double memory = InputUtils.inputDoubleNumber();
        // loop until user input '=' to display result
        while (true) {
            Operator op = InputUtils.inputOperator();
            // check if user input '='
            if (op == Operator.EQUAL) {
                System.out.println("Result: " + memory);
                return;
            }
            double nextNumber;

            //loop until user input valid number
            while (true) {
                nextNumber = InputUtils.inputDoubleNumber();
                try {
                    // get memory value
                    memory = calculateNormalNumber(memory, op, nextNumber);
                    System.out.println("Memory: " + memory);
                    break;
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by 0.");
                }
            }
        }
    }

    public static void bmiCalculator() {
        System.out.println("------ BMI Calculator ------");
        // get input weight from user
        double weight = InputUtils.inputDoubleWeight();
        // get input height from user
        double height = InputUtils.inputDoubleHeight();

        // calculate value of BMI
        double BMIValue = calculateBMIValue(weight, height);

        // get BMI Status
        BMIStatus status = getBmiStatusByValue(weight, height);
        System.out.printf("BMI Number: %.2f", BMIValue);
        System.out.println();
        System.out.println("BMI Status: " + status.getBmiStatus());
    }

    public static double calculateNormalNumber(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                // check if number b is 0
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by 0.");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator. Please input (+, -, *, /, ^)");
        }
    }

    // method calculate bmi to get value of BMI
    public static double calculateBMIValue(double weight, double heightCM) {
        // convert height cm to m
        double heightM = heightCM / 100.0;
        return weight / (heightM * heightM);
    }

    // method calculate bmi to return bmi status
    public static BMIStatus getBmiStatusByValue(double weight, double heightCM) {
        double bmi = calculateBMIValue(weight, heightCM);
        if (bmi < 19) {
            return BMIStatus.UNDERSTANDARD;
        } else if (bmi >= 19 && bmi < 25) {
            return BMIStatus.STANDARD;
        } else if (bmi >= 25 && bmi < 30) {
            return BMIStatus.OVERWEIGHT;
        } else if (bmi >= 30 && bmi < 40) {
            return BMIStatus.FAT;
        } else {
            return BMIStatus.VERYFAT;
        }
    }

    static void displayMainScreen() {
        System.out.println("======== Calculator Program ==========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
    }
}
