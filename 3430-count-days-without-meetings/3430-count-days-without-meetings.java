class Solution {
    public int countDays(int days, int[][] meetings) {
        if(meetings.length==0)return days;
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int start=meetings[0][0];
        int end=meetings[0][1];
        int meetDays=0;

        for(int i=1;i<meetings.length;i++){
           int currStart=meetings[i][0];
           int currEnd=meetings[i][1];
           if(currStart > end){
            //non overlapping 
            days -= end-start+1;   //reduce prev interval's meet days
            start=currStart;        //update start and end to current interval
            end=currEnd;
           }else{
            //overlapping-we extend the end  and check over prev intervals start and this intervals end 
            //merge overlapping as (start=start and end=currEnd)
            end=Math.max(end,currEnd);
           }
        }
        //add this interval
        days -= end-start+1;
        return days;
    }
}
// [[1,3],[5,7],[9,10]]
//[[2,4],[1,3]]