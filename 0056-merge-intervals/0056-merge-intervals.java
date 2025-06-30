class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]); //sort the array of intervals based on oth position
        List<int[]> result=new ArrayList<>();       //create an arraylist to add the merged intervals 
        int[]current=intervals[0];                  //take 1st interval as base case 
        for(int i=1;i<intervals.length;i++){
            if(current[1]>=intervals[i][0]){        //if endtime of prev and start of current overlap then merge and add in result
                current[1]=Math.max(intervals[i][1],current[1]); //max end time of both the intervals to be merged 
            }else{
                result.add(current);                //if not overlapping add prev in result
                current=intervals[i];               //and now make the next as current and move ahead
            }
        }
        result.add(current);                        //add the last interval
        return result.toArray(new int[result.size()][]);
    }
}