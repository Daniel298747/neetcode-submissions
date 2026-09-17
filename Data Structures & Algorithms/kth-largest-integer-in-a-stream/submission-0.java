class KthLargest {
    private final int k;
    private final PriorityQueue <Integer> minheap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>(k);
        
    for(int num: nums){
        add(num);
    }
    }
    
    public int add(int val) {
     
     minheap.offer(val);
        if(minheap.size() > k){
            minheap.poll();
       
        }

        return minheap.peek();
        
    }
}
