class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<>(wordDict); //store in set for fastv lookup: O(1)
        boolean[] dp=new boolean[n+1];          // dp[i] will be true if s(0 to i-1) can be segmented using the dictionary
        dp[0]=true;                             // Base case: empty string is always segmentable

        for(int i=1;i<=n;i++){
            for(int j=0; j<i;j++){
                //check if s(j to i ) is segmentable and s(j to i ) is present in the set
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;                         //here we memoize this part of the string and store in the dp array- 
                                                        // so that next time we are not again computing this - we right away use 
                                                        // this index value (true/false)
                    break;
                }
            }
        }
        return dp[n];
    }
}