class Solution {
    public boolean isAnagram(String s, String t) {

        HashMap <Character, Integer> map1 = new HashMap<>();
       

        if(s.length() != t.length() ){
            return false;
        }

      
           for(char c : s.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0)+1);
           }

        

         for(char c : t.toCharArray()){

            map1.put(c, map1.getOrDefault(c,0)-1);
            
        }

        

        for(int v : map1.values()){

            if( v != 0){
                return false;
            }
        }

        return true;
    }
}

