class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int [] indegree = new int [numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList <>());
        }

        for(int [] pre : prerequisites){

            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a);
            indegree[a]++;
        }

    Queue <Integer> queue = new LinkedList<>();

    for(int i = 0; i < numCourses; i++){
        if(indegree[i] == 0){

            queue.add(i);
        }
    }

    int count = 0;
    int [] order = new int[numCourses];

    while(!queue.isEmpty()){
        int course = queue.poll();
        order[count] = course;
        count++;
       


       for( int next : graph.get(course))
       {
        indegree[next] --;
        if(indegree[next] == 0){

            queue.add(next);
        }


        
       }
    }

    if(count == numCourses){
        return order;
    }

    else{
        return new int[0];
    }
    

    }
}
