package basic_DS;

import java.io.IOException;
import java.util.Scanner;

public class book_1_3_4 {
    static Stack<Character> Parentheses = new Stack<>();

    public static void main(String[] args) {
        char c = 0;
        Character mid;
        while (c!='\n') {
            try {
                c = (char) System.in.read();
                if (c=='('||c=='['||c=='{') {
                    Parentheses.push(c);
                }else if (c==')'||c==']'||c=='}') {
                   popAndCheck(c);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       System.out.println(Parentheses.isEmpty());
    }

    private static void popAndCheck(char c) {
        Character mid;
        char leftPart = 0;
        if (c==')') {
            leftPart='(';
        }else if (c == ']'){
            leftPart='[';

        }else if (c == '}'){
            leftPart='{';
        }

        while (true) {
            mid = Parentheses.pop();
            if (mid == null){
                Parentheses.push(c);
                break;
            } else if (mid == leftPart) break;
        }

    }
}

