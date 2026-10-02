class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,0,candidates, target, new ArrayList<>(), result);
        return result;
    }
        
        private void backtrack(int index, int total, int[]candidates,int target, List<Integer> current, List<List<Integer>> result){
    if(total == target ){
    result.add(new ArrayList<>(current));
    }

    if(total > target) return;

    for(int i = index; i < candidates.length; i++){

        if(i > index && candidates[i] == candidates[i - 1]){
            continue;
        }

        current.add(candidates[i]);

     

       backtrack(i + 1, total + candidates[i], candidates, target, current, result );
          current.remove(current.size()-1);



        
    }

        }
    
}
