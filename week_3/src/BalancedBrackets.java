import java.util.Scanner;
import edu.princeton.cs.algs4.Stack;

public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return "NO";
                char open = stack.pop();
                if ((c == ')' && open != '(') ||
                        (c == ']' && open != '[') ||
                        (c == '}' && open != '{')) {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng chuỗi test: ");
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}
