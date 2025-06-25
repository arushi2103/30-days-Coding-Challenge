class Solution {
    public int maximumPopulation(int[][] logs) {
        
    int[] years = new int[2051]; // years from 1950 to 2050

        // Apply the difference array approach
        for (int[] log : logs) {
            years[log[0]]++;      // Birth year included
            years[log[1]]--;      // Death year excluded
        }

        int maxPopulation = 0;
        int maxYear = 1950;
        int currentPopulation = 0;

        for (int year = 1950; year <= 2050; year++) {
            currentPopulation += years[year];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                maxYear = year;
            }
        }

        return maxYear;
    }
}