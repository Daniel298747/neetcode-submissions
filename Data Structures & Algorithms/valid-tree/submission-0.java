class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n - 1 )return false;
        List<List<Integer>> adj =  new ArrayList<>();

        for(int i = 0; i < n; i++){

            adj.add(new ArrayList<>());
      }

      for(int [] nei : edges){

        adj.get(nei[0]).add(nei[1]);
        adj.get(nei[1]).add(nei[0]);
      }

      Set <Integer> visited = new HashSet<>();
      return dfs(0, -1, adj, visited) && visited.size() == n;
      

    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited){

        visited.add(node);
        for(int check : adj.get(node)){

        if(check == parent ) continue;
        if(visited.contains(check)) return false;

        if(!dfs(check,node,adj,visited))return false;
        }

return true;
    }

}
