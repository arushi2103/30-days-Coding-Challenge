class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] arr= Integer.toString(n).toCharArray();
        if(arr.length==1)return n;
        int mark=arr.length; //mark this index as invalid 
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                arr[i-1]--;
                mark=i;
            }
        }
        for(int i=mark;i<arr.length;i++){
            arr[i]='9';
        }
        return Integer.parseInt(new String(arr));
    }
}

//my idea is two check last two digits -and if last digit is >last second- change last digit to 1 and decrese last second by 1;
//then i will check the last for last 2nd and 3rd digit with same process= this way i will traverse and modify from end to start 
// help me achieve that - don't provide complete solution  