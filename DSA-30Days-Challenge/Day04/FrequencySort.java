import java.util.*;

public class FrequencySort {
    public static String frequencySort(String str) {
        // Step 1: Frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create buckets (ArrayList of Characters)
        // Workaround for Java's type system: use raw ArrayList array and cast
        @SuppressWarnings("unchecked")
        ArrayList<Character>[] buckets = (ArrayList<Character>[]) new ArrayList[str.length() + 1];

        // Step 3: Fill the buckets by frequency
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(entry.getKey());
        }

        // Step 4: Build the final string
        StringBuilder newStr = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (Character ch : buckets[i]) {
                    // Repeat character freq times
                    for (int j = 0; j < i; j++) {
                        newStr.append(ch);
                    }
                }
            }
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println("Sorted by frequency: " + frequencySort(str));
    }
}
