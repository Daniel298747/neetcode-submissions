class Solution {
    public int lastStoneWeight(int[] stones) {

        if (stones == null ||stones.length == 0){

            return 0;
        }

        PriorityQueue <Integer> maxheap = new PriorityQueue<>((a,b) -> b - a);
        for(int num : stones)
        maxheap.offer(num);

        while(maxheap.size() > 1){

            int hold1 = maxheap.poll();
            int hold2 = maxheap.poll();

            if(hold1 != hold2){
           
       
           maxheap.add(hold1 - hold2);

            }
          
        }

        return maxheap.isEmpty() ? 0 : maxheap.peek();
        
    }
}
