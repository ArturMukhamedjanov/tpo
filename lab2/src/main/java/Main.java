
import csv.CsvWriter;
import math.logarithm.Logarithm;
import math.logarithm.NaturalLogarithm;
import math.function.Function;
import math.trigonometry.*;

public class Main {
    public static void main(String[] args) {
        Sinus sinus = new Sinus();
        sinus.setN(50);

        Cosinus cosinus = new Cosinus(sinus);
        Tangens tangens = new Tangens(sinus, cosinus);
        NaturalLogarithm naturalLogarithm = new NaturalLogarithm();
        naturalLogarithm.setN(100);

        Logarithm logarithm2 = new Logarithm(naturalLogarithm, 2);
        Logarithm logarithm3 = new Logarithm(naturalLogarithm, 3);
        Logarithm logarithm5 = new Logarithm(naturalLogarithm, 5);
        Logarithm logarithm10 = new Logarithm(naturalLogarithm, 10);
        Function function = new Function(sinus, tangens,  naturalLogarithm, logarithm2, logarithm3, logarithm5, logarithm10);
        CsvWriter csvWriter = new CsvWriter(0.1, 5.0, 0.2);
        csvWriter.write("src/main/resources/csv/naturalLogarithm.csv", naturalLogarithm);
        csvWriter.write("src/main/resources/csv/sinus.csv", sinus);
        csvWriter.write("src/main/resources/csv/tangens.csv", tangens);
        csvWriter.write("src/main/resources/csv/function.csv", function);
        csvWriter.write("src/main/resources/csv/log2.csv", logarithm2);
        csvWriter.write("src/main/resources/csv/log3.csv", logarithm3);
        csvWriter.write("src/main/resources/csv/log5.csv", logarithm5);
        csvWriter.write("src/main/resources/csv/log10.csv", logarithm10);
    }
}
