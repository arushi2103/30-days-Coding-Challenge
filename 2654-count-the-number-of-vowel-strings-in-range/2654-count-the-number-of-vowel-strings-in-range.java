class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count++;
            }
        }

        return count;
    }
}
