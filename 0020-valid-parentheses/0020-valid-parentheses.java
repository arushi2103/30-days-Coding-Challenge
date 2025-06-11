class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length() <=1) return false;
        Stack<Character> stack= new Stack<>();
        Map<Character,Character> hmap= Map.of(
             ')', '(', 
            '}', '{', 
            ']', '['
        );

        for(char ch : s.toCharArray()){
            if( hmap.containsKey(ch)){
                // it is a closing bracket - 
                // check is stack is empty return false 
                // if top element is not the same opening as closing 
                if (stack.isEmpty() || stack.peek() != hmap.get(ch)){
                    return false;
                }else{
                    // if top stack element and the current char make a vaid parenthesis - pop the topmost element 
                    stack.pop();
                }
            }else{
                //it is an opening bracket - push to stack
                stack.push(ch);
            }
        }
        return stack.isEmpty(); 



        //------------------------------------------
        
        
    }
}