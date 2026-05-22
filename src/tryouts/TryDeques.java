package tryouts;

import java.util.*;

public class TryDeques {

    /* Create and print a Deque
     * @return void
     * Approach: Using ArrayDeque
     * Example: input A, B -> output [A, B]
     * */
    public static void createDeque() {
        Deque<String> deque = new ArrayDeque<>();
        deque.offerLast("A");
        deque.offerLast("B");
        System.out.println(deque);
    }

    /* Add and remove from both ends of a Deque
     * @return void
     * Approach: Using offerFirst, offerLast, pollFirst, and pollLast
     * Example: input A, B, C -> output First: A, Last: C, Final: [B]
     * */
    public static void basicOperations() {
        Deque<String> deque = new ArrayDeque<>();
        deque.offerFirst("B");
        deque.offerFirst("A");
        deque.offerLast("C");
        System.out.println("First: " + deque.pollFirst());
        System.out.println("Last: " + deque.pollLast());
        System.out.println(deque);
    }

    /* Use Deque as a Stack
     * @return void
     * Approach: Using push(), peek(), and pop()
     * Example: input 1, 2, 3 -> output 3 2 1
     * */
    public static void useAsStack() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) System.out.print(stack.pop() + " ");
        System.out.println();
    }

    /* Use Deque as a Queue
     * @return void
     * Approach: Add at rear and remove from front
     * Example: input 1, 2, 3 -> output 1 2 3
     * */
    public static void useAsQueue() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(1);
        queue.offerLast(2);
        queue.offerLast(3);
        while (!queue.isEmpty()) System.out.print(queue.pollFirst() + " ");
        System.out.println();
    }

    /* Check if a string is a palindrome
     * @return void
     * Approach: Compare characters from both ends using Deque
     * Example: input "madam" -> output true
     * */
    public static void palindromeUsingDeque() {
        String input = "madam";
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) deque.offerLast(ch);
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }

    /* Find maximum in every sliding window
     * @return void
     * Approach: Use Deque to store useful indexes in decreasing value order
     * Example: input [1, 3, -1, -3, 5, 3, 6, 7], k=3 -> output [3, 3, 5, 5, 6, 7]
     * */
    public static void slidingWindowMaximum() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> result = new ArrayList<>();
        Deque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!indexes.isEmpty() && indexes.peekFirst() <= i - k) indexes.pollFirst();
            while (!indexes.isEmpty() && nums[indexes.peekLast()] <= nums[i]) indexes.pollLast();
            indexes.offerLast(i);
            if (i >= k - 1) result.add(nums[indexes.peekFirst()]);
        }
        System.out.println(result);
    }
}
