class Solution {
    public int maximumPopulation(int[][] logs) {
        int n=logs.length;
        Arrays.sort(logs,(a,b)->Integer.compare(a[0],b[0]));
        HashMap<Integer,Integer> hmap= new HashMap<>();
        for(int[] log : logs){
            for(int i=log[0];i<log[1];i++){
                hmap.put(i,hmap.getOrDefault(i,0)+1);
            }
        }
        int maxYear=logs[0][0];
        int maxCount =Integer.MIN_VALUE;
        for(int[] log : logs ){
            int count = hmap.get(log[0]);
            if(count > maxCount || count==maxCount && log[0]<maxYear){
                maxCount =hmap.get(log[0]);
                maxYear = log[0];
            }
        }
        return maxYear;
    }
}