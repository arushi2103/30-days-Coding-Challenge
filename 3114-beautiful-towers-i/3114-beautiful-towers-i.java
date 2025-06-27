class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long maxSum = 0;

        // Try each index as the peak
        for (int peak = 0; peak < n; peak++) {
            long sum = heights[peak];

            // Go left (non-decreasing to peak)
            int leftMin = heights[peak];
            for (int i = peak - 1; i >= 0; i--) {
                leftMin = Math.min(leftMin, heights[i]);
                sum += leftMin;
            }

            // Go right (non-increasing from peak)
            int rightMin = heights[peak];
            for (int i = peak + 1; i < n; i++) {
                rightMin = Math.min(rightMin, heights[i]);
                sum += rightMin;
            }

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
