class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()<1)return 0;
        HashSet<Character> hs=new HashSet<>();
        int i=0,j=0,maxLen=Integer.MIN_VALUE;
        while(j<s.length() && i<s.length()){
            char ch=s.charAt(j);
            if(!hs.contains(ch)){
                hs.add(ch);
                j++;
                maxLen=Math.max(maxLen,j-i);
            }else{
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return maxLen;
    }
}