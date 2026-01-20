public class test {
    public static void main(String[] args) {
        int sum = 0;
        int arr[] = {5, 3, -8,-6, 2, -1};
        for(int i=0; i<arr.length; i++) {
            sum += arr[i] < 0 ? -arr[i] : arr[i];
        }
        System.out.println("This is a test file."+
                           "\nThe sum of absolute values is: " + sum);
    }
}
