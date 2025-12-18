package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackOpretions {
    public boolean isParanthesBalanced(String str){

        Map<Character, Character> map  = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        map.put('>','<');

        Stack<Character> stack = new Stack<>();

        for(char ch: str.toCharArray()){
            if(map.containsValue(ch)){
                stack.push(ch);
            }else if(map.containsKey(ch)){
                if(stack.isEmpty()) return false;
                if(stack.pop() != map.get(ch)) return false;
            }
        }

        return stack.isEmpty();
    }
}
