import java.util.Comparator;

public class MergeSort {
    private static long comparisons = 0;

    public static <K> void sort(K[] S, Comparator<K> comp) {
        if (S.length < 2) return;
        // Divide
        int mid = S.length / 2;
        K[] S1 = (K[]) new Object[mid];
        K[] S2 = (K[]) new Object[S.length - mid];
        System.arraycopy(S, 0, S1, 0, mid);
        System.arraycopy(S, mid, S2, 0, S.length - mid);

        sort(S1, comp);
        sort(S2, comp);

        merge(S1, S2, S, comp);
    }

    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length) {
                S[i + j] = S1[i++];
            } else if (i == S1.length) {
                S[i + j] = S2[j++];
            } else {
                comparisons++;
                if (comp.compare(S1[i], S2[j]) < 0) {
                    S[i + j] = S1[i++];
                } else {
                    S[i + j] = S2[j++];
                }
            }
        }
    }

    public static long getComparisons() {
        return comparisons;
    }
}
