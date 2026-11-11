class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] parent = new int[n + 1];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int [] edge : edges){

            int u = edge[0];
            int v = edge[1];

            int rootU = turn(parent,u);
            int rootV = turn(parent,v);

            if(rootU == rootV){

                return edge;
            }

            parent[rootU] = rootV;
        }

        return new int[0];
        
    }

    private int turn(int[] parent, int node ){

        if(parent[node] != node){

            parent[node] = turn(parent, parent[node]);
        }

        return parent[node];
    }
}
