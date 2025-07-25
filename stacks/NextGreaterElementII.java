package stacks;

import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        // Initialize result with -1
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }

        // Traverse the array twice (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            // Pop all elements smaller or equal to nums[idx]
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[idx]) {
                stack.pop();
            }

            // Only fill result during the first pass
            if (i < n && !stack.isEmpty()) {
                res[idx] = nums[stack.peek()];
            }

            stack.push(idx);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int[] nums2 = {1, 2, 3, 4, 3};

        int[] result1 = nextGreaterElements(nums1);
        int[] result2 = nextGreaterElements(nums2);

        System.out.print("Output 1: ");
        for (int val : result1) System.out.print(val + " ");
        System.out.println();

        System.out.print("Output 2: ");
        for (int val : result2) System.out.print(val + " ");
    }
}
