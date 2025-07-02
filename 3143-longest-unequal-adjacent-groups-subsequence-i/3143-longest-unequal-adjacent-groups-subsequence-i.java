class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        
        if (n == 0) return result;

        // Start with either group 0 or 1
        for (int start = 0; start <= 1; start++) {
            List<String> temp = new ArrayList<>();
            int lastGroup = -1;
            for (int i = 0; i < n; i++) {
                if (lastGroup == -1 && groups[i] == start) {
                    temp.add(words[i]);
                    lastGroup = groups[i];
                } else if (lastGroup != -1 && groups[i] != lastGroup) {
                    temp.add(words[i]);
                    lastGroup = groups[i];
                }
            }
            if (temp.size() > result.size()) {
                result = temp;
            }
        }

        return result;
    }
}
