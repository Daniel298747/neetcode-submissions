class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

      List<List<Integer>> result = new ArrayList<>();
      backtrack(0,0, target, nums, new ArrayList<>(), result);
      return result;

    }
        

        private void backtrack(int i, int total, int target, int[]nums, List<Integer> current, List<List<Integer>> result){

     if(total == target){
        result.add(new ArrayList<>(current));
        return;
     }

     if(i >= nums.length || total > target) return;

     current.add(nums[i]);
     backtrack(i, total + nums[i], target, nums, current, result);
     current.remove(current.size() - 1);

    backtrack(i + 1, total, target, nums, current, result);




        }
    
}
