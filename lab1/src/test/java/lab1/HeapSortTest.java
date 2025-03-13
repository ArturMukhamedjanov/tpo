package lab1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RunWith(Parameterized.class)
public class HeapSortTest {

    private final int[] input;
    private final int[] expected;

    public HeapSortTest(int[] input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameters(name = "sort({0})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{5}, new int[]{5}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5}},
                {new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5}, new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}},
                {new int[]{7, 2, 1, 8, 6, 3, 5, 4}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}},
                // Generated test cases
                {generate(10), null},
                {generate(100), null},
                {generate(1000), null},
                {generate(5000),null}
        });
    }

    private static int[] generate(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 2);
        }
        return arr;
    }


    @Test
    public void testQuickSort() {
        int[] arrCopy = Arrays.copyOf(input, input.length);
        HeapSort.sort(arrCopy);
        int[] expectedResult = (expected == null) ? Arrays.stream(input).sorted().toArray() : expected;
        assertArrayEquals(expectedResult, arrCopy);
    }
}
