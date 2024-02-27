import java.util.ArrayDeque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        
        int[] result = new int[n - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements from the back of the deque until the current element is greater than the element at the back
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i); // Add the current index to the back of the deque
            
            // Remove the element from the front of the deque if it's outside the current window
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            // Add the maximum element from the front of the deque to the result array if the window size is >= k
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
