import java.util.Comparator;

public class HeapSort<T> {
    private static long comparisons = 0;
    private static Object[] heap;
    private static int size;

    public static <T> void sort(T[] array, Comparator<T> comp) {
        heap = array;
        size = array.length;
        comparisons = 0; 

        for (int i = size / 2 - 1; i >= 0; i--) {
            downheap(i, comp);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            downheap(0, comp);
        }
    }


    private static <T> void upheap(int index, Comparator<T> comp) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && comp.compare((T)heap[index], (T)heap[parentIndex]) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
            comparisons++; 
        }
    }

    private static <T> void downheap(int index, Comparator<T> comp) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        while (leftChildIndex < size) {
            int smallerChildIndex = leftChildIndex;
            if (rightChildIndex < size) {
                comparisons++; 
                if (comp.compare((T) heap[rightChildIndex], (T) heap[leftChildIndex]) < 0) {
                    smallerChildIndex = rightChildIndex;
                }
            }

            comparisons++; 
            if (comp.compare((T) heap[index], (T) heap[smallerChildIndex]) > 0) {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            } else {
                break;
            }
        }
    }

    private static void swap(int index1, int index2) {
        Object temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public static long getComparisons() {
        return comparisons;
    }
}
