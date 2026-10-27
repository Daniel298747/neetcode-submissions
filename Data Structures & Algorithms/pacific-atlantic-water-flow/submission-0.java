class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0) {

            return res;
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean [][] pacific = new boolean[row][col];
        boolean [][] atlantic = new boolean[row][col];

        for(int c = 0; c < col; c++){
            dfs(heights,pacific,0,c);
        }
              for(int r = 0; r < row; r++){
            dfs(heights,pacific,r,0);
        }
              for(int c = 0; c < col; c++){
            dfs(heights, atlantic, row - 1 ,c);
        }
              for(int r = 0; r < row; r++){
            dfs(heights,atlantic,r,col - 1);
        }

        for(int r = 0; r < heights.length; r++){

            for(int c = 0; c < heights[0].length; c++){

                if(pacific[r][c] && atlantic [r][c]){

                    res.add(Arrays.asList(r,c));
                }
            }
        }
        
        return res;
        
        
    }

    private int [][] directions = {{1,0}, {-1,0}, {0,-1},{0,1}};

    private void  dfs(int [][] heights, boolean [][] visited, int r, int c){
           visited[r][c] = true;

        for(int [] dir : directions){

            int newR = r + dir[0];
            int newC = c + dir[1];

            if(newC < 0 || newC >= heights[0].length || newR < 0 || newR >= heights.length ){
                continue;
            }

            if(visited[newR][newC]){
                continue;
            }

            if(heights[newR][newC] < heights[r][c]){
                continue;
            }

              dfs(heights, visited, newR, newC);


        } 

      

    }
}
