/* for string equation or similar problem preprocess the string to get rid of " ", boring test case*/

import java.util.*;
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Character> addAndMinus = new Stack<Character>();
        Stack<Integer> integers = new Stack<Integer>();
        MupltipyAndDivide(s,addAndMinus,integers);
        while(!addAndMinus.isEmpty()){
            char sym = addAndMinus.pop();
            int num2 = integers.pop();
            int num1 = integers.pop();
            if(sym=='+'){
                int res = num1 + num2;
                integers.push(res);
            }else{
                int res = num1 - num2;
                integers.push(res);
            }
        }
        return integers.pop();
    }

    private void MupltipyAndDivide(String s, Stack<Character> a, Stack<Integer> integers){
        for(int i=0;i<s.length();){
            if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                int num1 = integers.pop();
                int j = i+1;
                int num2 = 0;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    num2 = num2*10 + (s.charAt(j)-'0');
                    j++;
                }
                if(s.charAt(i) == '*'){
                    int res = num1*num2;
                    integers.push(res);
                    i = j;
                }else{
                    int res = num1/num2;
                    integers.push(res);
                    i= j;
                }
            }else if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i++)-'0';
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10+(s.charAt(i)-'0');
                    i++;
                }
                integers.push(num);

            }else if(s.charAt(i)=='+' || s.charAt(i)=='-'){
                a.push(s.charAt(i));
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args){
        String a ="45+25*10+5-5*1";
        String b = "45+25*10/5+5*5/5";
        BasicCalculator test = new BasicCalculator();
        System.out.println("a: "+ test.calculate(a));
        System.out.println("b: "+test.calculate(b));
    }
}