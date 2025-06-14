class Solution {
    public int countCompleteDayPairs(int[] hours) {

        HashMap<Integer,Integer> freqMap=new HashMap<>();
        int count=0;
        for(int h:hours){
            //extra hours we have 
            int rem = h%24;
            //no. of hours we need to make a full day 
            int complement =(24 -rem ) % 24;

            // ..check if how many indexes we have with the complement - add the value as count of pairs wrt index
            if(freqMap.containsKey(complement)){
                count += freqMap.get(complement);
            }

            // .. if we do not have any complement wrt to this index 
            // .. we put this rem in map - so that when we come across a index that needs a complement equal to this rem(extra hour it takes
            //   and makes a full day
            freqMap.put(rem, freqMap.getOrDefault(rem,0)+1);
        }
        return count;
        
    }
}


// brute force approach would be 
        // int i=0; int counter=0;
        // while(i<hours.length){
        //     int j=i+1;
        //     while(j<hours.length){
        //         int completehour=hours[i] + hours[j];
                
        //         if(completehour % 24 ==0){
        //             counter++;
        //         }
        //         j++;
        //     }
        //     i++;
        // }
        // return counter;
        // TC: O(n^2)