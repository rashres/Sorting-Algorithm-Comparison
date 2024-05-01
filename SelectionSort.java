import java.util.Comparator;

public class SelectionSort {
    private static long comparisons = 0;

    public static <T> void sort(T[] array, Comparator<T> comp) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (comp.compare(array[j], array[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            T temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }

    public static long getComparisons() {
        return comparisons;
    }
}

