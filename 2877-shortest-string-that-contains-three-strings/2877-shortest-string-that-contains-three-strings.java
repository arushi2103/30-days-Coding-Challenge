class Solution {
    public String minimumString(String a, String b, String c) {
        
    String[] strs = new String[]{a, b, c};
        String result = null;

        // All 6 permutations of indices
        int[][] perms = {
            {0, 1, 2}, {0, 2, 1},
            {1, 0, 2}, {1, 2, 0},
            {2, 0, 1}, {2, 1, 0}
        };

        for (int[] p : perms) {
            String merged = merge(merge(strs[p[0]], strs[p[1]]), strs[p[2]]);
            if (result == null ||
                merged.length() < result.length() ||
                (merged.length() == result.length() && merged.compareTo(result) < 0)) {
                result = merged;
            }
        }

        return result;
    }

    private String merge(String s1, String s2) {
        if (s1.contains(s2)) return s1;

        int maxOverlap = 0;
        for (int i = 1; i <= Math.min(s1.length(), s2.length()); i++) {
            if (s1.endsWith(s2.substring(0, i))) {
                maxOverlap = i;
            }
        }

        return s1 + s2.substring(maxOverlap);
    }

}