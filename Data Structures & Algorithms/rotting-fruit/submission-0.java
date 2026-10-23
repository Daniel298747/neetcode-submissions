class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int freshfruits = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshfruits++;
                }
            }
        }

        if (freshfruits == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty() && freshfruits > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                for (int[] d : dirs) {
                    int nr = cell[0] + d[0], nc = cell[1] + d[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        freshfruits--;
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            minutes++;
        }

        return freshfruits == 0 ? minutes : -1;
    }
}