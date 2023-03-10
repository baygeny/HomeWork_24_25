package Lambda;

public class LambdaCalculation {
    public static void main(String[] args) {
        Operation operationSum, operationSub, operationMulti, operationDiv;
        operationSum = (x, y) -> x + y;
        double sum = operationSum.Calculate(10, 20);
        System.out.println("Sum: " + sum);

        operationSub = (x, y) -> x - y;
        double sub = operationSub.Calculate(10, 20);
        System.out.println("Difference: " + sub);

        operationMulti = (x, y) -> x * y;
        double multi = operationMulti.Calculate(10, 20);
        System.out.println("Product: " + multi);

        operationDiv = (x, y) -> x / y;
        double div = operationDiv.Calculate(10, 20);
        System.out.println("Quotient: " + div);
    }

}
interface Operation {
    double Calculate(double x, int y);

}
