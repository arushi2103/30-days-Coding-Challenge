class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=Integer.MAX_VALUE;
        if(prices.length==0)return 0;
        int[] profit=new int[prices.length];
        profit[0]=0;
        minPrice=prices[0];
        for(int i=1;i<prices.length;i++){
            minPrice=Math.min(prices[i],minPrice);
            profit[i]=Math.max(profit[i-1],prices[i]-minPrice);
        }
        return profit[prices.length-1];
        
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
//         int minPrice=Integer.MAX_VALUE;
//         int maxProfit=0;
//         for(int price:prices){
//             if(price<minPrice)minPrice=price;
//             maxProfit=Math.max(maxProfit,price-minPrice);
//         }
//         return maxProfit;
        
//     }
// }