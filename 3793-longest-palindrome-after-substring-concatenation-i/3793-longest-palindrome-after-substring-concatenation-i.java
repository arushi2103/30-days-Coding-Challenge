public class Solution {
    public int longestPalindrome(String s, String t) {
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subS = s.substring(i, j + 1);
                if(isPalindrome(subS)){
                    maxLen=Math.max(maxLen,subS.length());
                }
                for (int k = 0; k < t.length(); k++) {
                    for (int l = k; l < t.length(); l++) {
                        String subT = t.substring(k, l + 1);
                        if(isPalindrome(subT)){
                            maxLen=Math.max(maxLen,subT.length());
                        }
                        String combined = subS + subT;
                        if (isPalindrome(combined)) {
                            maxLen = Math.max(maxLen, combined.length());
                        }
                    }
                }
            }
        }

        return maxLen;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }
}
