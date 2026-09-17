class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map <String, List<String>> map = new HashMap <>();

        for(String s : strs){
      
      char [] chars = s.toCharArray();
      Arrays.sort(chars);
      String sort = new String(chars);

      List <String> group = map.getOrDefault(sort, new ArrayList <>());
      group.add(s);
      map.put(sort, group);

        }

        return new ArrayList <>(map.values());
        
    }
}
