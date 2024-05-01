import java.util.Comparator;

public class InsertionSort {
    private static long comparisons = 0;

    public static <T> void sort(T[] array, Comparator<T> comp) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && comp.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
                comparisons++;
            }
            if (j >= 0) {
                comparisons++; 
            }
            array[j + 1] = key;
        }
    }

    public static long getComparisons() {
        return comparisons;
    }
}
