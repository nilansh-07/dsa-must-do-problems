import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        buildParentheses(result, "", 0, 0, n);
        return result;
    }

    private static void buildParentheses(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        if (open < max) {
            buildParentheses(result, current + "(", open + 1, close, max);
        }

        if (close < open) {
            buildParentheses(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;

        List<String> combinations = generateParenthesis(n);

        System.out.println("All valid combinations of parentheses:");
        for (String s : combinations) {
            System.out.println(s);
        }
    }
}
