class Solution {
    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;

        while(left < right){
    
    leftMax = Math.max(leftMax, height[left]);
    rightMax = Math.max(rightMax, height[right]);

    if(leftMax < rightMax){
       
       sum += leftMax - height[left];
      left++; 
    }
    else{

        sum += rightMax - height[right];
        right--;
    }



        }
        return sum;
        
    }
}
