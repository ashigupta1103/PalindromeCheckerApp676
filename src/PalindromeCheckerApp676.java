import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeCheckerApp676{
    public static void main(String[] args) {
        String input = "A man a plan a canal Panama".replaceAll("\\s+", "").toLowerCase();

        long start, end;

        start = System.nanoTime();
        boolean result1 = twoPointerPalindrome(input);
        end = System.nanoTime();
        System.out.println("Two-pointer Iterative: " + result1 + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean result2 = stackPalindrome(input);
        end = System.nanoTime();
        System.out.println("Stack-based: " + result2 + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean result3 = dequePalindrome(input);
        end = System.nanoTime();
        System.out.println("Deque-based: " + result3 + " | Time: " + (end - start) + " ns");

        start = System.nanoTime();
        boolean result4 = recursivePalindrome(input, 0, input.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive: " + result4 + " | Time: " + (end - start) + " ns");
    }

    private static boolean twoPointerPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray())
            if (ch != stack.pop()) return false;
        return true;
    }

    private static boolean dequePalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    private static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }
}