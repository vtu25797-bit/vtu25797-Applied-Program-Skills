import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // index for popped

        for (int x : pushed) {
            stack.push(x);

            // Pop while top matches popped[j]
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, sequence is valid
        return stack.isEmpty();
    }
}
