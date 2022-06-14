import java.util.*;


public class LeetCode {

    public static void main(String []args) {

        String s="[]";
        System.out.println(isValid(s));

        s="()[]{}";
        System.out.println(isValid(s));

        s="(]";
        System.out.println(isValid(s));

        s="([)]";
        System.out.println(isValid(s));

        s="{[]}";
        System.out.println(isValid(s));

    }

    //https://leetcode.com/problems/valid-parentheses/
    public static boolean isValid(String s) {
        int length = s.length();
        int leftCounter=0;
        int rightCounter=0;
        Stack<Character> leftSide= new Stack<Character>();
        Stack<Character> rightSide= new Stack<Character>();
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                leftSide.push(s.charAt(i));
                leftCounter+=1;
            }
            else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                rightCounter+=1;
                char leftChar;
                if(leftSide.size()>0)
                    leftChar=leftSide.pop();
                else{
                    return false;
                }
                if(leftChar=='(' && s.charAt(i)==')') {
                    rightSide.push(s.charAt(i));
                }
                else if(leftChar=='[' && s.charAt(i)==']') {
                    rightSide.push(s.charAt(i));
                }
                else if(leftChar=='{' && s.charAt(i)=='}') {
                    rightSide.push(s.charAt(i));
                }
                else{
                    return false;
                }
            }
            else{

            }
        }
        if(rightCounter!=leftCounter){
            return false;
        }

        return true;
    }
}
