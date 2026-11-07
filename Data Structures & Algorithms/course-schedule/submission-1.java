class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

    List<List<Integer>> graph = new ArrayList<>();
    int [] indegree = new int [numCourses];

    for(int i = 0; i < numCourses; i++){
 graph.add(new ArrayList<>());
    }

    for(int [] pre : prerequisites){

        int a = pre[0];
        int b = pre[1];

        graph.get(b).add(a);
        indegree[a]++;


    }
        
        int count = 0;

        Queue <Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){

            if(indegree[i] == 0){

                queue.add(i);
                
            }
        }

        while(!queue.isEmpty()){

            int poll = queue.poll();
            count++;

            for(int next : graph.get(poll)){
                indegree[next]--;

                if(indegree[next] == 0){
                    queue.add(next);
                }

            }
        }

        return count == numCourses;
    }
}
