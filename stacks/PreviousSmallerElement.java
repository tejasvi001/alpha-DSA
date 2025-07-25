package stacks;

import java.util.Stack;

public class PreviousSmallerElement {

    public static void main(String[] args) {
        int arr[] = {100, 80, 60, 70, 60, 85, 100};
        int pse[] = new int[arr.length];

        previousSmallerElement(arr, pse);

        System.out.println("Array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nPSE");
        for (int i = 0; i < pse.length; i++) {
            System.out.print(pse[i] + " ");
        }
    }

    private static void previousSmallerElement(int[] arr, int[] pse) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
    }
}

