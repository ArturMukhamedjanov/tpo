package math.trigonometry;

import lombok.RequiredArgsConstructor;
import math.interfaces.Calculable;

@RequiredArgsConstructor
public class Tangens implements Calculable {
    private final Sinus sinus;
    private final Cosinus cosinus;

    private final double epsilon = 0.001;
    public double calculate(double x) {
        double cosinusResult = cosinus.calculate(x);
        if (Math.abs(cosinusResult) < epsilon) {
            throw new ArithmeticException("zero division");
        }
        return sinus.calculate(x) / cosinusResult;
    }
}
