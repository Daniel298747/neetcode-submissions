

class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    private void dfs(int node, List<List<Integer>> adj, Set<Integer> visited) {
        visited.add(node);
        for (int next : adj.get(node)) {
            if (!visited.contains(next)) {
                dfs(next, adj, visited);
            }
        }
    }
}