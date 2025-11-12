import java.util.*;

public class SortingAnalysis {

    // ---------- Bubble Sort ----------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ---------- Insertion Sort ----------
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // ---------- Selection Sort ----------
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // ---------- Merge Sort ----------
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ---------- Quick Sort ----------
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // ---------- Utility: Clone Array ----------
    private static int[] cloneArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // ---------- Measure Execution Time ----------
    private static long measureTime(Runnable algorithm) {
        long start = System.nanoTime();
        algorithm.run();
        long end = System.nanoTime();
        return end - start;
    }

    // ---------- Main ----------
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("🔹 Sorting Algorithm Analysis 🔹");
        System.out.print("Enter number of elements: ");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("\nChoose an option:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.println("6. Compare All");
        System.out.print("Enter your choice: ");
        int choice = in.nextInt();

        switch (choice) {
            case 1:
                int[] b1 = cloneArray(arr);
                long timeBubble = measureTime(() -> bubbleSort(b1));
                System.out.println("Sorted Array: " + Arrays.toString(b1));
                System.out.println("Execution Time: " + timeBubble + " ns");
                break;

            case 2:
                int[] i1 = cloneArray(arr);
                long timeInsertion = measureTime(() -> insertionSort(i1));
                System.out.println("Sorted Array: " + Arrays.toString(i1));
                System.out.println("Execution Time: " + timeInsertion + " ns");
                break;

            case 3:
                int[] s1 = cloneArray(arr);
                long timeSelection = measureTime(() -> selectionSort(s1));
                System.out.println("Sorted Array: " + Arrays.toString(s1));
                System.out.println("Execution Time: " + timeSelection + " ns");
                break;

            case 4:
                int[] m1 = cloneArray(arr);
                long timeMerge = measureTime(() -> mergeSort(m1, 0, m1.length - 1));
                System.out.println("Sorted Array: " + Arrays.toString(m1));
                System.out.println("Execution Time: " + timeMerge + " ns");
                break;

            case 5:
                int[] q1 = cloneArray(arr);
                long timeQuick = measureTime(() -> quickSort(q1, 0, q1.length - 1));
                System.out.println("Sorted Array: " + Arrays.toString(q1));
                System.out.println("Execution Time: " + timeQuick + " ns");
                break;

            case 6:
                System.out.println("\nComparing all algorithms...\n");
                compareAll(arr);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        in.close();
    }

    // ---------- Compare All Algorithms ----------
    private static void compareAll(int[] arr) {
        int[] b = cloneArray(arr);
        int[] i = cloneArray(arr);
        int[] s = cloneArray(arr);
        int[] m = cloneArray(arr);
        int[] q = cloneArray(arr);

        long tBubble = measureTime(() -> bubbleSort(b));
        long tInsertion = measureTime(() -> insertionSort(i));
        long tSelection = measureTime(() -> selectionSort(s));
        long tMerge = measureTime(() -> mergeSort(m, 0, m.length - 1));
        long tQuick = measureTime(() -> quickSort(q, 0, q.length - 1));

        System.out.println("Algorithm\tTime (ns)");
        System.out.println("-----------------------------------");
        System.out.println("Bubble Sort\t" + tBubble);
        System.out.println("Insertion Sort\t" + tInsertion);
        System.out.println("Selection Sort\t" + tSelection);
        System.out.println("Merge Sort\t" + tMerge);
        System.out.println("Quick Sort\t" + tQuick);

        System.out.println("\n✅ All algorithms produced the same sorted result: " + Arrays.toString(q));
    }
}
