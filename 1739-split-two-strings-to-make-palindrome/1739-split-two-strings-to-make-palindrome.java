class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        //since we are taking  aprefix + bsuffix or bprefix + asuffix - we have to replace and check both ways 
        return check(a,b)||check(b,a);
        
    }
    boolean check(String a, String b){
        int i=0, j=b.length()-1;
        while(i<j && a.charAt(i)==b.charAt(j)){
            i++;
            j--;
        }
        //check if the remaining part is palindrome in either a or b 
        //if remaining part from i to j is palindrome in a so we can add suffix(from j to end) from b in a and it will be a palindrome 
        //if remaining part from i to j is palindrome in b so we can add prefix(0 to i) from a and it will be a palindrome 
        return isPalindrome(a,i,j) || isPalindrome(b,i,j);
        
    }

    boolean isPalindrome(String s,int start,int end){

        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}