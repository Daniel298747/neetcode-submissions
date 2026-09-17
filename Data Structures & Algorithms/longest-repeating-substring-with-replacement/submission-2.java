class Solution {
    public int characterReplacement(String s, int k) {

        HashMap < Character , Integer > count = new HashMap <>();

        int left = 0;
        int maxf = 0;
        int maxl = 0;
        
        for(int right = 0; right < s.length(); right++){
     char currentchar = s.charAt(right);
     count.put(currentchar, count.getOrDefault(currentchar,0) + 1);

     maxf = Math.max(maxf, count.get(currentchar));

     while ((right - left + 1) - maxf > k){
     char leftchar = s.charAt(left);
     count.put(leftchar,count.get(leftchar)-1);
     left++;
     }

       maxl = Math.max(maxl, right - left + 1);

        }

      return maxl;

      
    }
}
