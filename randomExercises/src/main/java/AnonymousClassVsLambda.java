public class AnonymousClassVsLambda {

    public static void main(String[] args) {

        ICalculator iCalculator = new ICalculator() {
            @Override
            public int calculate(int x, int y) {
                int sum = x+y;
                System.out.println(sum);
                return sum;
            }
        };
        ICalculator iCalculator1 = new ICalculator() {
            @Override
            public int calculate(int x, int y) {
                int product = x*y;
                System.out.println(product);
                return product;
            }
        };
        iCalculator.calculate(3, 4);
        iCalculator1.calculate(3, 4);

        ICalculator adder = (x,y) -> x + y;
        int sum = adder.calculate(3, 4);
        System.out.println(sum);

        ICalculator multiplier = (x,y) -> x * y;
        int product = multiplier.calculate(3, 4);
        System.out.println(product);

//        ICalculator divider = (x, y) -> x / y;
//        int quotient = divider.calculate(10, 2);
//        System.out.println(quotient);

        myLambdaArgMethod(multiplier, (x,y) -> x / y);
    }

    public static void myLambdaArgMethod(ICalculator multiplier, ICalculator divider) {
        int myLambdaArgMethodsProduct = multiplier.calculate(100, 2);
        int myLambdaArgMethodsQuotient = divider.calculate(100, 2);
        System.out.println(myLambdaArgMethodsProduct);
        System.out.println(myLambdaArgMethodsQuotient);
    }
}
