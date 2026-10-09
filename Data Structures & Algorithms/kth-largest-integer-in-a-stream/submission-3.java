class KthLargest {
    private PriorityQueue <Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.queue = new PriorityQueue <Integer>();
        
        for(int n :  nums){

           
                add(n);
            }

        }
    
    
    public int add(int val) {

        queue.offer(val);

        if(queue.size() > k ){

            queue.poll();
        }

        return queue.peek();
        
    }
}

