class Solution {
    public int climbStairs(int n) {
        if (n<=1) return 1;
        int currentways=0;
        int prev1=1;    //1 way to reach step 1
        int prev2=1;    //1 way to reach step 0
        for(int i=2; i<=n;i++){
            currentways= prev1+prev2;
            prev2=prev1;
            prev1=currentways;
        }
        return currentways;
    }
}