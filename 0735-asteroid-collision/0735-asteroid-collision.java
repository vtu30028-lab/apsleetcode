import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // Collision happens only when stack has a right-moving asteroid (positive)
            // and current asteroid is left-moving (negative)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(ast)) {
                    stack.pop(); // Top asteroid explodes, continue checking against next in stack
                    continue;
                } else if (Math.abs(top) == Math.abs(ast)) {
                    stack.pop(); // Both asteroids explode
                }
                destroyed = true; // Current asteroid explodes
                break;
            }
            
            // If current asteroid survived all collisions, add it to the stack
            if (!destroyed) {
                stack.push(ast);
            }
        }
        
        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}