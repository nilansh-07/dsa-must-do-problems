import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        int n = arr.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int remainder = target - arr[i];
            if (mp.containsKey(remainder)) {
                return new int[] { mp.get(remainder), i };
            }
            mp.put(arr[i], i);
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 8, 2, 9, 18 };
        int target = 10;

        int[] result = twoSum(arr, target);

        System.out.println("The indices are " + result[0] + " and " + result[1] + ".");
    }
}
