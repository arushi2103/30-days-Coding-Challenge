class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int product=1;
        
        int[] pre= new int[n];
        pre[0]=1;
        //create prefix product array - except current index
        for(int i=1; i<n; i++)pre[i] = pre[i-1]*nums[i-1];
        int[] suf= new int[nums.length];
        suf[n-1]=1;
        //create the suffix product array - except the current index
        for(int i= n-2; i>=0; i--)suf[i]=suf[i+1]*nums[i+1];

        for(int i=0; i<n; i++){
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
}