import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeCheckerApp676{
    public static void main(String[] args) {
        String input = "rotor";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeContext context = new PalindromeContext(stackStrategy);
        System.out.println("Stack Strategy: " + input + " -> " + context.executeStrategy(input));

        // Use Deque-based strategy
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        context.setStrategy(dequeStrategy);
        System.out.println("Deque Strategy: " + input + " -> " + context.executeStrategy(input));
    }
}

interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.isPalindrome(input);
    }
}