class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.offer(nums[i]);
            while(pq.size()>k)pq.poll();
        }
        return pq.peek();
    }
}

//we used priority queue to sort and store the elements at once - meanwhile deleting the smaller elements from queue whenever size reaches greater than k - this way we have top k elements in queue - where peek() return the Kth largest element. 