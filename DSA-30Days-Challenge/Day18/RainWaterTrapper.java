public class RainWaterTrapper {

    public static int trapWater(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    totalWater += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
                
            } else {
                if (height[right] < rightMax) {
                    totalWater += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }

        }

        return totalWater;
    }

    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        int trappedWater = trapWater(height);

        System.out.println("Total trapped water: " + trappedWater + " units");
    }
}
