import java.util.*;

public class PalindromeCheckerApp676{
     public static void main(String[] args) {
         String input = "refer";
         Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < input.length(); i++) {
                deque.addLast(input.charAt(i));
            }
            boolean isPalindrome = true;
            while (deque.size() > 1) {
                char front = deque.removeFirst();
                char rear = deque.removeLast();
                if (front != rear) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                System.out.println(input + " is a Palindrome.");
            } else {
                System.out.println(input + " is NOT a Palindrome.");
            }
        }
    }