import java.util.Scanner;
import edu.princeton.cs.algs4.Stack; // Sử dụng Stack từ thư viện algs4

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Stack<Integer> stackNewest = new Stack<>();
        Stack<Integer> stackOldest = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng câu lệnh (queries): ");
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) { // Enqueue
                int x = scanner.nextInt();
                stackNewest.push(x);
            } else {
                // Đảo phần tử nếu stackOldest trống
                if (stackOldest.isEmpty()) {
                    while (!stackNewest.isEmpty()) {
                        stackOldest.push(stackNewest.pop());
                    }
                }

                if (type == 2) { // Dequeue
                    stackOldest.pop();
                } else if (type == 3) { // Print front elemento
                    System.out.println(stackOldest.peek());
                }
            }
        }
        scanner.close();
    }
}
