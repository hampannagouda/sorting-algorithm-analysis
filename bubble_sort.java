
// Algorithm: Bubble Sort
// Best Case: O(n)
// Worst Case: O(n^2)
// Space Complexity: O(1)
// Stable: Yes

import java.util.*;
class bubble_sort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

    int[] arr = new int[n];
    for(int i=0;i<n;i++){
        arr[i] = in.nextInt();
    }
    for(int i=0;i<arr.length - 1;i++){

     
    for(int j=0;j<arr.length - i - 1;j++){
          if(arr[j] > arr[j + 1]){
              int temp = arr[j];
              arr[j] = arr[j + 1];
              arr[j + 1] = temp;
          }
      }
    }
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i] + " ");
    }
}
}