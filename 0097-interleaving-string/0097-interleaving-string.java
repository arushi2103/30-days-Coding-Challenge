class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n=s1.length(), m=s2.length(), l=s3.length();
        if(n+m != l)return false;

        boolean[][] dp =new boolean[n+1][m+1];
        dp[0][0]=true;
        //first column compares s1 with s3 -fill
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        //first row compares s2 with s3 - fill 
        for(int j=1;j<=m;j++){
            dp[0][j]=dp[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
        }

        // we fill the dp table now , 
        //each cell is true if
        // s1[i-1][j]==s3[i+j-1] && dp[i-1][j]==true
        //or
        // s2[i][j-1]==s3[i+j-1] && dp[i][j-1]==true
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=
                (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1))||
                (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        //at the end if the last cell is true - result is true
        return dp[n][m];
    }
}

// the below greedy logic is correct but fails for some test cases - here we have to use DP - check it out in above code 

// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s1==null)s1="";
//         if(s2==null)s2="";
//         if(s3==null)return false;

//         if(s1.length() + s2.length() != s3.length())return false;
//         int i=0, j=0,k=0;
//         while(i<s3.length()){
//             boolean matched=false;
//             if(j<s1.length() && s3.charAt(i)== s1.charAt(j)){
//                 j++;
//                 matched=true;
//             }else if(k<s2.length() && s3.charAt(i)==s2.charAt(k)){
//                 k++;
//                 matched =true;
//             }
//             if(!matched)return false;
//             i++;
//         }
        
//         return j==s1.length() && k==s2.length();
//     }
// }   