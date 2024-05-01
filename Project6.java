// Rahul Shrestha
// Project 6
// COSC 20803

//A program to compare five sorting algorithms: selection sort, insertion sort, heap sort, merge sort, and quick sort.

import java.util.*;

public class Project6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of words to sort:");
        int numberOfWords = Integer.parseInt(scanner.nextLine());
        String[] words = new String[numberOfWords];
        System.out.println("Enter the words:");
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = scanner.nextLine();
        }
        scanner.close();

        Comparator<String> comparator = String::compareTo;

        System.out.println("Algorithm       | Comparisons | Time (Milliseconds)");
        System.out.println("===================================================");

        performSorts("Selection Sort", words, comparator);
        performSorts("Insertion Sort", words, comparator);
        performSorts("Heap Sort", words, comparator);
        performSorts("Merge Sort", words, comparator);
        performSorts("Quick Sort", words, comparator);
    }

    private static void performSorts(String sortName, String[] original, Comparator<String> comparator) {
        String[] array = Arrays.copyOf(original, original.length);
        long startTime = System.nanoTime(); // Start time in nanoseconds
        long comparisons = 0;
        switch (sortName) {
            case "Selection Sort":
                SelectionSort.sort(array, comparator);
                comparisons = SelectionSort.getComparisons();
                break;
            case "Insertion Sort":
                InsertionSort.sort(array, comparator);
                comparisons = InsertionSort.getComparisons();
                break;
            case "Heap Sort":
                HeapSort.sort(array, comparator);
                comparisons = HeapSort.getComparisons();
                break;
            case "Merge Sort":
                MergeSort.sort(array, comparator);
                comparisons = MergeSort.getComparisons();
                break;
            case "Quick Sort":
                QuickSort.sort(array, comparator);
                comparisons = QuickSort.getComparisons();
                break;
        }
        long endTime = System.nanoTime(); // End time in nanoseconds
        double time = (endTime - startTime) / 1_000_000.0; // Convert nanoseconds to milliseconds with decimal
        System.out.printf("%-15s | %10d  | %10.3f ms\n", sortName, comparisons, time); // Print time with three decimal places
    }


}
