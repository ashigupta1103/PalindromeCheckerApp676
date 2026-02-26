
public class PalindromeCheckerApp676{
    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";  // Hardcoded string

        // Normalize string: remove spaces & convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Apply two-pointer palindrome logic
        boolean isPalindrome = true;
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end)) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Print result
        if (isPalindrome) {
            System.out.println("\"" + input + "\" is a Palindrome (ignoring case & spaces).");
        } else {
            System.out.println("\"" + input + "\" is NOT a Palindrome (ignoring case & spaces).");
        }
    }
}