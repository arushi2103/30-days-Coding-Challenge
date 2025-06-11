class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans = new int[n];
        int product=1;
        
        //contains the product of all elements to the left of index i
        int[] pre= new int[n];
        pre[0]=1; // nothing is in left 
        for(int i=1; i<n; i++)pre[i] = pre[i-1]*nums[i-1];

        //contains the product of all elements to the right of index i
        int[] suf= new int[nums.length];
        suf[n-1]=1; // nothing is in right 
        for(int i= n-2; i>=0; i--)suf[i]=suf[i+1]*nums[i+1];


        // product of all the elements from left and right
        for(int i=0; i<n; i++){
            ans[i] = pre[i] * suf[i];
        }
        return ans;
    }
}