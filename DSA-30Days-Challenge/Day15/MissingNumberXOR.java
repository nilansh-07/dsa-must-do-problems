public class MissingNumberXOR {

    public static int findMissing(int[] arr) {
        int n = arr.length;
        int xorAll = 0;
        int xorArr = 0;

        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        for (int num : arr) {
            xorArr ^= num;
        }

        return xorAll ^ xorArr;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 7, 8, 9 };
        int missing = findMissing(arr);
        System.out.println("The missing number is: " + missing);
    }
}
