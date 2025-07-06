public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int[] count = new int[26]; // tracks frequency of characters in the window
        int maxCount = 0; // max frequency of a single character in the window
        int start = 0, maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            count[currentChar - 'A']++;

            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            int windowSize = end - start + 1;

            // If more than k characters need to be changed, shrink the window
            if (windowSize - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);
        System.out.println("Longest possible length after at most " + k + " replacements: " + result);
    }
}
