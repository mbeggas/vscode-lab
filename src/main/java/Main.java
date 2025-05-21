public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        double result = calc.calc(10, 5);
        calc.prtRes(result);

        OrderProcessor processor = new OrderProcessor();
        processor.printOrderSummary(MockData.getSampleOrder());
    }
}
