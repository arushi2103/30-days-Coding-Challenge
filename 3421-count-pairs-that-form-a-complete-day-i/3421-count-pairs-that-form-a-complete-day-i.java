class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int i=0; int counter=0;
        while(i<hours.length){
            int j=i+1;
            while(j<hours.length){
                int completehour=hours[i] + hours[j];
                if(completehour % 24 ==0){
                    counter++;
                }
                j++;
            }
            i++;
        }
        return counter;
    }
}