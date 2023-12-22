package lab.O1first;

public class FirstLabClass {

    public static void main(String[] args) {
        System.out.println(calculate(1d, 1d, 10d, 10d));
    }

    /*
    variant 20
    C2 = 0 -> +
    C3 = 2 -> 2
    C5 = 0 -> *
    C7 = 6 -> double

     */
    public static double calculate(double a, double b, double n, double m) {
        double sum = 0;
        for (double i = a; i <= n; i++) {
            for (double j = b; j <= m; j++) {
                if (i + 2 == 0) {
                    throw new IllegalArgumentException();
                }

                sum += (i * j) / (i + 2);
            }
        }
        return sum;
    }


}
