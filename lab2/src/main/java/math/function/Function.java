package math.function;

import lombok.RequiredArgsConstructor;
import math.interfaces.Calculable;
import math.logarithm.Logarithm;
import math.logarithm.NaturalLogarithm;
import math.trigonometry.*;

@RequiredArgsConstructor
public class Function implements Calculable {
    private final Sinus sinus;
    private final Tangens tangens;
    private final NaturalLogarithm naturalLogarithm;
    private final Logarithm logarithm2;
    private final Logarithm logarithm3;
    private final Logarithm logarithm5;
    private final Logarithm logarithm10;


    public double calculate(double x) {
        double result;
        if (x <= 0) {
            // x <= 0 : (((((sin(x) + tan(x)) + sin(x)) * sin(x)) * (tan(x) ^ 2)) ^ 2)
            double sinX = sinus.calculate(x);
            double tanX = tangens.calculate(x);
            result = Math.pow((((sinX + tanX) + sinX) * sinX) * Math.pow(tanX, 2), 2);
        } else {
            // x > 0 : (((((log_3(x) * ln(x)) * ln(x)) + log_5(x)) ^ 3) / ((ln(x) + (log_2(x) ^ 2)) * (log_10(x) ^ 3)))
            double lnX = naturalLogarithm.calculate(x);
            double log2X = logarithm2.calculate(x);
            double log3X = logarithm3.calculate(x);
            double log5X = logarithm5.calculate(x); // Assuming you have a logarithm5 instance
            double log10X = logarithm10.calculate(x);
            double numerator = Math.pow((((log3X * lnX) * lnX) + log5X), 3);
            double denominator = (lnX + Math.pow(log2X, 2)) * Math.pow(log10X, 3);
            result = numerator / denominator;
        }
        return result;
    }
}
