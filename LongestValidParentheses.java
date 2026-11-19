import java.util.Scanner;

public class LongestValidParentheses {
    static int longestValidParentheses(String s) {
        int longest = 0;
        int balance = 0;
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            length++;
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                longest = Math.max(longest, length);
            } else if (balance < 0) {
                balance = 0;
                length = 0;
            }
        }

        balance = 0;
        length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            length++;
            if (s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                longest = Math.max(longest, length);
            } else if (balance < 0) {
                balance = 0;
                length = 0;
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                System.out.println(longestValidParentheses(input));
            }
        }
    }
}