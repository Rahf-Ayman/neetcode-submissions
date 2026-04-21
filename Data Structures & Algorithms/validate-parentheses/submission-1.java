class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(' );
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))){
                    stack.pop();
                }else{
                   stack.push(s.charAt(i)); 
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
