import java.util.ArrayList;
import java.util.Collections;

public class MedianFinder {

    // Explicitly define as ArrayList<Integer> to avoid inference issues
    static ArrayList<Integer> nums = new ArrayList<Integer>();

    public static void addNum(int num) {
        nums.add(num);
        Collections.sort(nums); // Sort on every insert
    }

    public static double findMedian() {
        int n = nums.size();
        if (n % 2 == 1) {
            return nums.get(n / 2);
        } else {
            return (nums.get(n / 2 - 1) + nums.get(n / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println("Median: " + findMedian());
    }
}
