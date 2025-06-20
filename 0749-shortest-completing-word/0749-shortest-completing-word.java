import java.util.HashMap;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char ch : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch))
                hmap.put(ch, hmap.getOrDefault(ch, 0) + 1);
        }
        String res = "";
        int minLength = Integer.MAX_VALUE;
        for (String word : words) {
            HashMap<Character, Integer> tempMap = new HashMap<>(hmap);
            int length = word.length();
            for (char ch : word.toCharArray()) {
                if (tempMap.containsKey(ch)) {
                    tempMap.put(ch, tempMap.getOrDefault(ch, 0) - 1);
                    if (tempMap.get(ch) == 0) {
                        tempMap.remove(ch);
                    }
                }
            }
            if (tempMap.isEmpty() && length < minLength) {
                res = word;
                minLength = length;
            }
        }
        return res;
    }
}
