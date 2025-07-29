public class MaxProduct {

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(num, max * num);
            min = Math.min(num, min * num);

            result = Math.max(result, max);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = { -2, 3, -4 };

        System.out.println("Max Product of nums3: " + maxProduct(nums));
    }
}
