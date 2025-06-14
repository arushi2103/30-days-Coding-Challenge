class Solution {
    public String longestPalindrome(String s) {
        if (s==null || s.length() < 1 )return null;
        String longestSubstring="";
        for(int i=0; i<s.length(); i++){
            String oddString = expand(s,i,i);
            String evenString = expand(s,i,i+1);
            String longer =(oddString.length()>evenString.length())? oddString : evenString;
            longestSubstring = (longer.length()>longestSubstring.length()) ? longer : longestSubstring;
        }
        return longestSubstring;
    }
    public String expand(String s, int left, int right){ 
        while(left>=0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left --;
            right ++;
        }
        return s.substring(left+1,right);
    }
}