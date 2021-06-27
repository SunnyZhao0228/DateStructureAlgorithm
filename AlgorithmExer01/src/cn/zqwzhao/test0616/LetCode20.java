package cn.zqwzhao.test0616;

import java.util.Stack;

/**
 *
 * 括号匹配
 *
 * @Auther: zhaoqw
 * @Date: 2021/6/16 - 06 - 16 - 17:49
 * @Description: cn.zqwzhao.test0616
 * @version: 1.0
 */
public class LetCode20 {
    /**
     * 看看括号是否匹配
     * @param left
     * @param right
     * @return
     */
    Boolean isMatch(char left, char right) {
        switch (right){
            case ')':
                return  left == '(';
            case ']':
                return  left == '[';
            case '}':
                return left == '{';
        }

        return false;
    }

    /**
     *
     *
     * @param s
     * @return
     */
    public Boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() == 0) return true;
        char[] chars = s.toCharArray();

        for (char currentChar : chars) {

            //遇到左括号直接入栈
            if(currentChar == ')'|| currentChar==']' || currentChar=='}') {
                //栈为空或者不是左括号，匹配不成功
                //匹配规则：看看当前括号能不呢和它前面第一个(也就是现在处在栈顶)的括号是否能匹配上
                if(stack.isEmpty() || !isMatch(stack.peek(),currentChar)) {
                    return false;

                }else {
                    stack.pop();
                }
            }else if(currentChar == '('|| currentChar=='[' || currentChar=='{') {
                stack.push(currentChar);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LetCode20 letCode20 = new LetCode20();
        Boolean valid = letCode20.isValid("");
        System.out.println(valid);

        System.out.println(letCode20.isValid("1+(3+4)"));
        System.out.println(letCode20.isValid("{}()}"));
        System.out.println(pattern("((3+4) +(2+9))"));

    }



    public static boolean pattern(String str) {
        //建立一个新的栈，然后遍历字符串的字符，进行比较
        Stack<Character> stack = new Stack<Character>();
        for(char c: str.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c==')') {
                if(stack.isEmpty()|| c != stack.pop())
                return false;
            }
        }
        return stack.isEmpty();
    }
}
