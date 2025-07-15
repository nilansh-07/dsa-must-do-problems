public class CountingBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = countBits(n);

        System.out.print("Bit Counts: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
