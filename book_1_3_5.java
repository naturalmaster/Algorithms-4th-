package basic_DS;

public class book_1_3_5 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int N =50;
        while (N>0) {
            stack.push(N%2);
            N/=2;
        }
        for (int i : stack) {
            System.out.print(i);
        }

    }
}
