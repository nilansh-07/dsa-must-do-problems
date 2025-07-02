public class SortZeroOneTwo {
    public static void sortZeroOneTwo(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid++] = arr[low];
                arr[low++] = temp;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[high];
                arr[high--] = arr[mid];
                arr[mid] = temp;
            }
        }
    }
    // This approach is mainly known as Dutch National Flag Algorithm with (O(n)
    // Time, O(1) Space)

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 1, 1, 0, 0, 1, 2, 2, 0, 1, 1 };
        sortZeroOneTwo(arr);

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
