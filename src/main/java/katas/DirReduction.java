package katas;

import java.util.HashMap;
import java.util.Stack;

public class DirReduction {
    public static String [] dirReduc(String[] arr){

        HashMap<String,String> map = new HashMap<>();
        map.put("NORTH", "SOUTH");
        map.put("SOUTH", "NORTH");
        map.put("EAST", "WEST");
        map.put("WEST", "EAST");

        Stack<String> stack = new Stack<>();

        for (String direction:arr){
            if (stack.empty()){
                stack.push(direction.toUpperCase());
            } else if (direction.equalsIgnoreCase(map.get(stack.peek()))) {
                stack.pop();
            } else {
                stack.push(direction.toUpperCase());
            }
        }

        return stack.toArray(new String[stack.size()]);

    }
}
