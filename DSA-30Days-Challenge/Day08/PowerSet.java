import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void generate(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);             // Choose
            generate(i + 1, nums, current, result); // Explore
            current.remove(current.size() - 1);     // Unchoose (backtrack)
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = getSubsets(nums);

        System.out.println("All possible subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
