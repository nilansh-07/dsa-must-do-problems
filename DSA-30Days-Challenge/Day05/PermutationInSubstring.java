import java.util.Arrays;

public class PermutationInSubstring {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Freq[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                s2Freq[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(s1Freq, s2Freq)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2)); // true
    }
}
