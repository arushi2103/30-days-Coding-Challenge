class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length() <=1) return false;
        Stack<Character> stack= new Stack<>();
        

        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty())return false;

                if(ch == ')' && stack.peek() != '(') {
                return false;
                }else if( ch == '}' && stack.peek() != '{'){
                    return false;
                }else if (ch == ']' && stack.peek() != '[') {
                    return false;
                }else{
                    // if it is a valid parenthesis at the top - remove topmost character 
                    stack.pop();
                }
            }
        }
        // stack should be empty 
        return stack.isEmpty();



        //------------------------------------------
        
        
    }
}