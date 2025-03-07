class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0, start=0, max=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){           
            if (map.containsKey(s.charAt(i))){
                start = Math.max(start ,map.get(s.charAt(i))+1);
                }
            //adding one here will give the exavct number of charcters including the current index char                     
            len = (i - start)+1;
            map.put(s.charAt(i), i);
            max = Math.max(len,max);
        }
        return max;    
    }
}