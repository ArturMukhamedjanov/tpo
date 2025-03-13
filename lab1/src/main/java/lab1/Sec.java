package lab1;

public class Sec {

    public static double cos(double x, int terms) {
        x = x % (2 * Math.PI);
        if (x < 0) {
            x += 2 * Math.PI;
        }

        int quadrant = (int) (x / (Math.PI / 2));
        double reducedX = x - quadrant * (Math.PI / 2);

        switch (quadrant % 4) {
            case 0:
                return computeCos(reducedX, terms);
            case 1:
                return -computeSin(reducedX, terms);
            case 2:
                return -computeCos(reducedX, terms);
            case 3:
                return computeSin(reducedX, terms);
            default:
                return 0;
        }
    }

    private static double computeCos(double x, int terms) {
        double result = 1.0;
        double term = 1.0;
        for (int n = 1; n < terms; n++) {
            term *= -x * x / ((2 * n - 1) * (2 * n));
            result += term;
        }
        return result;
    }

    private static double computeSin(double x, int terms) {
        double result = x;
        double term = x;
        for (int n = 1; n < terms; n++) {
            term *= -x * x / ((2 * n) * (2 * n + 1));
            result += term;
        }
        return result;
    }

    public static double sec(double x, int terms) {
        double normalizedX = x % (2 * Math.PI);
        if (normalizedX < 0) {
            normalizedX += 2 * Math.PI;
        }

        double tolerance = 1e-4;
        if (Math.abs(normalizedX - Math.PI / 2) < tolerance) {
            return (normalizedX < Math.PI / 2) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        if (Math.abs(normalizedX - 3 * Math.PI / 2) < tolerance) {
            return (normalizedX < 3 * Math.PI / 2) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }

        double cosValue = cos(normalizedX, terms);

        // Возвращаем бесконечность при очень малых значениях косинуса
        if (Math.abs(cosValue) < 1e-10) {
            return (cosValue >= 0) ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }

        return 1.0 / cosValue;
    }
}