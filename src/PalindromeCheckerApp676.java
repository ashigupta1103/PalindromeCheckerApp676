
public class PalindromeCheckerApp676{
    public static void main(String[] args) {

        String input = "level";

        // Create an instance of PalindromeChecker
        PalindromeChecker checker = new PalindromeChecker();

        // Use the service to check palindrome
        boolean isPalindrome = checker.checkPalindrome(input);

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}

// Encapsulated palindrome logic
class PalindromeChecker {

    // Method responsible only for palindrome checking
    public boolean checkPalindrome(String input) {

        if (input == null || input.length() <= 1) {
            return true;
        }

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}