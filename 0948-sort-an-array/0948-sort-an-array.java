class Solution {
    public int[] sortArray(int[] nums) {
        int left=0, right=nums.length-1;
        mergeSort(nums,left,right);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right){
        if (left>=right)return; //ek hi element hai to sorted hi hai  : base case
        int mid= left+(right-left)/2;
         mergeSort(nums, left, mid);          // Left half ko sort karo
        mergeSort(nums, mid + 1, right);     // Right half ko sort karo
        merge(nums, left, mid, right);       // Dono sorted halves ko merge karo
    }
    public void merge(int[] nums, int left, int mid, int right){
        int[] leftArray=Arrays.copyOfRange(nums,left,mid+1);        //// left to mid included
        int[] rightArray=Arrays.copyOfRange(nums,mid+1,right+1);    // mid+1 to right included
        int i=0,j=0,k=left; //        // i -> leftArray ka pointer, j -> rightArray ka pointer, k -> nums[] ka pointer
        while(i<leftArray.length && j<rightArray.length){
            if(leftArray[i]<=rightArray[j])nums[k++]=leftArray[i++];
            else nums[k++]=rightArray[j++];
        }
        while(i<leftArray.length)nums[k++]=leftArray[i++];
        while(j<rightArray.length)nums[k++]=rightArray[j++];
    }

}