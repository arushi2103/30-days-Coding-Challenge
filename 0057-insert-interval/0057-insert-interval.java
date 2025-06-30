class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> result=new ArrayList<>();
        boolean inserted=false;
        for(int[] interval : intervals){
           if(interval[1]<newInterval[0])result.add(interval); //non overlappping
           else if(interval[0]>newInterval[1]){                // current start after new interval ends 
            if(!inserted){
                result.add(newInterval);
                inserted=true;
            }
            result.add(interval);
        }else{                                                  // overlapping - merge with new interval
           newInterval[0]=Math.min(interval[0],newInterval[0]);
           newInterval[1]=Math.max(interval[1],newInterval[1]);
        }
        }
        if(!inserted)result.add(newInterval);                   //if even after traversing it is not inserted - add it at the end 
        return result.toArray(new int[result.size()][]);
        
    }
    
}