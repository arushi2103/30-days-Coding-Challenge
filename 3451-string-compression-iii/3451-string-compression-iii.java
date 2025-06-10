class Solution {
    public String compressedString(String word) {
        String comp="";
        int i=0;
        while(i <word.length() ){
            char ch=word.charAt(i);
            int count=0;
            // for each char check upto 9 counts and add the count and char in comp
            while(i<word.length() &&  word.charAt(i)==ch && count <9){
                count++;
                i++;
            }
            // when the next char mismatches - comes out of loop and  adds it into comp
            comp =comp + count + ch;
            //runs loop again for next char
        }
        return comp;
    }
}