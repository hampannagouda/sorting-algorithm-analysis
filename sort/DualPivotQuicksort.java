//effective Java code implementing Dual Pivot QuickSort 
package sort;

import java.util.Arrays;

public class DualPivotQuicksort {

    public static void main(String[] args) {
        int sum = 0;
        int arr[] = {5, 3, -8, -6, 2, -1};

        // Calculate sum of absolute values
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] < 0 ? -arr[i] : arr[i];
        }

        // Sort the array using Dual Pivot QuickSort
        dualPivotQuickSort(arr, 0, arr.length - 1);

        // Output
        System.out.println("This is a test file.");
        System.out.println("The sum of absolute values is: " + sum);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void dualPivotQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int[] piv = partition(arr, low, high);
            dualPivotQuickSort(arr, low, piv[0] - 1);
            dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
            dualPivotQuickSort(arr, piv[1] + 1, high);
        }
    }

    static int[] partition(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        int lp = arr[low];
        int rp = arr[high];

        int j = low + 1;
        int g = high - 1;
        int k = low + 1;

        while (k <= g) {
            if (arr[k] < lp) {
                swap(arr, k, j);
                j++;
            } else if (arr[k] >= rp) {
                while (arr[g] > rp && k < g) {
                    g--;
                }
                swap(arr, k, g);
                g--;
                if (arr[k] < lp) {
                    swap(arr, k, j);
                    j++;
                }
            }
            k++;
        }

        j--;
        g++;

        swap(arr, low, j);
        swap(arr, high, g);

        return new int[]{j, g};
    }
}
