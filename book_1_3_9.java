package basic_DS;

import java.io.IOException;

public class book_1_3_9 {
    static Stack<Character> expressStack = new Stack<>();

    public static void main(String[] args) {
        char c = 0;
        while (c!='\n') {
            try {
                c = (char) System.in.read();
                if (c!=')')
                    expressStack.push(c);
                else {
                    addLeftBracket();
                    expressStack.push(')');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printResult();


    }
    private static void printResult() {
        Stack<Character> tmp = new Stack<>();
        while (!expressStack.isEmpty()){
            tmp.push(expressStack.pop());
        }
        while (!tmp.isEmpty())
        System.out.print(tmp.pop());
    }
    private static void addLeftBracket() { //添加左括号方法
        Character cTemp = 0;
        Stack<Character> tmp = new Stack<>();  //缓存栈
        while (true) {
            cTemp = expressStack.pop();
            tmp.push(cTemp);
            if (cTemp=='+' || cTemp=='-' || cTemp=='*'){
                if (expressStack.peak()==')') {
                    while (expressStack.peak()!='('){
                        tmp.push(expressStack.pop());
                    }

                }
                    tmp.push(expressStack.pop()); //将符号前面的数字或者左括号放入缓存栈



                if (expressStack.peak()==null || expressStack.peak()!='('){
                    expressStack.push('(');  //如果数字前的没有括号，那么补全括号

                    //补全完成，将缓存栈内容放回表达式栈
                    while (!tmp.isEmpty())
                        expressStack.push(tmp.pop());
                    return;
                }else tmp.push(expressStack.pop());  //否则将括号取出，直至补全括号
            }
        }

    }
}

