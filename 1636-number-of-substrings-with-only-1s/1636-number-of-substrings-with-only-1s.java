class Solution {
    public int numSub(String s) {
        long count = 0;
        long result = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                // Add number of substrings from previous 1's sequence
                result = (result + count * (count + 1) / 2) % mod;
                count = 0;
            }
        }

        // Add any remaining 1's substrings
        result = (result + count * (count + 1) / 2) % mod;

        return (int) result;
    }
}
