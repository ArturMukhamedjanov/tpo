import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import math.function.Function;
import math.logarithm.Logarithm;
import math.logarithm.NaturalLogarithm;
import math.trigonometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Slf4j
public class FunctionTest {
    private static Sinus mockedSinus;
    private static Tangens mockedTangens;

    private static NaturalLogarithm mockedNaturalLogarithm;
    private static Logarithm mockedLogarithm2;
    private static Logarithm mockedLogarithm3;
    private static Logarithm mockedLogarithm5; // Added for log_5(x)
    private static Logarithm mockedLogarithm10;

    private static Sinus sinus;
    private static Cosinus cosinus;
    private static NaturalLogarithm naturalLogarithm;
    private static Logarithm logarithm2;
    private static Logarithm logarithm3;
    private static Logarithm logarithm5; // Added for log_5(x)
    private static Logarithm logarithm10;

    private final double epsilon = 0.1;

    @BeforeAll
    static void init() {
        mockedSinus = Mockito.mock(Sinus.class);
        mockedTangens = Mockito.mock(Tangens.class);

        mockedNaturalLogarithm = Mockito.mock(NaturalLogarithm.class);

        mockedLogarithm2 = Mockito.mock(Logarithm.class);
        mockedLogarithm3 = Mockito.mock(Logarithm.class);
        mockedLogarithm5 = Mockito.mock(Logarithm.class); // Added for log_5(x)
        mockedLogarithm10 = Mockito.mock(Logarithm.class);

        sinus = new Sinus();
        sinus.setN(100);

        cosinus = new Cosinus(sinus);

        naturalLogarithm = new NaturalLogarithm();
        naturalLogarithm.setN(100);

        logarithm2 = new Logarithm(naturalLogarithm, 2);
        logarithm3 = new Logarithm(naturalLogarithm, 3);
        logarithm5 = new Logarithm(naturalLogarithm, 5);
        logarithm10 = new Logarithm(naturalLogarithm, 10);

        try {
            Reader natLog = new FileReader("src/main/resources/csv/naturalLogarithm.csv");
            Reader sin = new FileReader("src/main/resources/csv/sinus.csv");
            Reader tan = new FileReader("src/main/resources/csv/tangens.csv"); // Updated for Tangens
            Reader log2 = new FileReader("src/main/resources/csv/log2.csv");
            Reader log3 = new FileReader("src/main/resources/csv/log3.csv");
            Reader log5 = new FileReader("src/main/resources/csv/log5.csv"); // Added for log_5(x)
            Reader log10 = new FileReader("src/main/resources/csv/log10.csv");

            for(CSVRecord record : CSVFormat.DEFAULT.parse(natLog)) {
                Mockito.when(mockedNaturalLogarithm.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(sin)) {
                Mockito.when(mockedSinus.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(tan)) {
                Mockito.when(mockedTangens.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log2)) {
                Mockito.when(mockedLogarithm2.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log3)) {
                Mockito.when(mockedLogarithm3.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log5)) {
                Mockito.when(mockedLogarithm5.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log10)) {
                Mockito.when(mockedLogarithm10.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV files: " + e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testMock(double value, double expected) {

        Function function = new Function(mockedSinus, mockedTangens, mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5, mockedLogarithm10);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

}