public class FindMaxSubArray {
    public static int findMaxSubarray(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;

        for (int num : nums) {
            totalSum += num;

            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        if (totalSum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        int[] inp = { 2, 1, -5, 4, -3, 1, -3, 4, -1 };

        System.out.println("Max Circular Subarray Sum: " + findMaxSubarray(inp));

    }
}
