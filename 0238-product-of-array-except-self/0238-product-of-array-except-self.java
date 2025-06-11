class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        //create a pref array to store the product of all the elements in left of the index 
        int [] pref = new int[n];
        pref[0]=1;
        for(int i=1; i<n; i++){
            pref[i]=pref[i-1] * nums[i-1];
        }

        int rightProduct=1;
        //take the product from right index and modify the pref array (i.e. multiply left product with right product in current index)
        for(int i=n-2;i>=0; i--){
            rightProduct *= nums[i+1];  // Update right product
            pref[i] = pref[i] * rightProduct; // Combine left and right products
        }

        return pref;
    }
}


//---------------------------------------------
// ALTERNATIVE  : CREATE A LEFT PRODUCT ARRAY(EXCEPT CURRENT INDEX) | CREATE RIGHT PRODUCT ARRAY (EXCEPT CURRENT INDEX) | MULTIPLY BOTH AT INDEX


//         int n=nums.length;
//         int[] ans = new int[n];
//         int product=1;
        
//         //contains the product of all elements to the left of index i
//         int[] pre= new int[n];
//         pre[0]=1; // nothing is in left 
//         for(int i=1; i<n; i++)pre[i] = pre[i-1]*nums[i-1];

//         //contains the product of all elements to the right of index i
//         int[] suf= new int[nums.length];
//         suf[n-1]=1; // nothing is in right 
//         for(int i= n-2; i>=0; i--)suf[i]=suf[i+1]*nums[i+1];


//         // product of all the elements from left and right
//         for(int i=0; i<n; i++){
//             ans[i] = pre[i] * suf[i];
//         }
//         return ans;