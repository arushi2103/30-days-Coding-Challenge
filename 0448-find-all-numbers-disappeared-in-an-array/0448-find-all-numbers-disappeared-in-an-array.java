class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    
    //place each number in it's right position and traverse through array 
    //then again check if the index does not have intended number then add that number to the list 

    ArrayList<Integer> res= new ArrayList<>();

    for(int i=0; i<nums.length; i++){
        while(nums[i]!= nums[nums[i]-1]){
        int temp = nums[i];
        nums[i]=nums[temp-1];
        nums[temp-1]=temp;
        }
    }
    for(int i=0; i<nums.length; i++){
        if(nums[i] != i+1 ){
            res.add(i+1);
        }
    }
    return res;
    }
}
