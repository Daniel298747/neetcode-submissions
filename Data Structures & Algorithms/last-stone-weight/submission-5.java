class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue <Integer> queue = new PriorityQueue <>(Comparator.reverseOrder());

        for(int n : stones){

            queue.add(n);
        }

        while(queue.size() > 1){

            int stone1 = queue.poll();
            int stone2 = queue.poll();

            if(stone1 != stone2){
                queue.add(stone1 - stone2);
            }

           
        }
         if(queue.size() == 0){

                return 0;
            }
    return queue.peek();
        
    }
}
