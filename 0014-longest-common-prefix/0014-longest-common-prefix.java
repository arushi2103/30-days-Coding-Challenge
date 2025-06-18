class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0)return "";

        String prefix=strs[0];
        for(int i=0;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                //trim thr prefix from end till it contains the common prefix only 
                prefix= prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
        
    }
}


// take 1st string as prefix- now compare each letter with next string and - substring till it matched 
//         if(strs==null || strs.length==0)return "";

//         String prefix=strs[0];
//         for(int i=1;i<strs.length;i++){
//             int j=0;
//             //check index bounds first then compare characters
//             while(j<prefix.length() && j<strs[i].length() && prefix.charAt(j)==strs[i].charAt(j) ){
//                 j++;
//             }
//                 prefix=prefix.substring(0,j);
//                 //early check if prefix is empty-no common prefix
//                 if(prefix.isEmpty())return "";
//         }
//         return prefix;