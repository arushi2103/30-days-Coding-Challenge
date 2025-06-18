class Solution {
    public String longestCommonPrefix(String[] strs) {
        //tale 1st string as prefix- now compare each letter with next string and - substring till it matched 
        if(strs==null || strs.length==0)return "";

        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<prefix.length() && j<strs[i].length() && prefix.charAt(j)==strs[i].charAt(j) ){
                j++;
            }
                prefix=prefix.substring(0,j);
                if(prefix.isEmpty())return "";
        }
        return prefix;
    }
}