public class ReverseString {
    public static String reverse(String str) {
        if (str.length() < 2) {
            return str;
        }
        char[] charArr = str.toCharArray();

        int low = 0, high = str.length() - 1;

        while (low < high) {
            char temp = charArr[low];
            charArr[low++] = charArr[high];
            charArr[high--] = temp;
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        String str = "Hello";

        System.out.println("The Reversed string is: " + reverse(str));
    }
}
