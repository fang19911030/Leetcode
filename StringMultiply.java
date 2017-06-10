import java.util.Stack;

/**
 * Created by fang on 6/10/17.
 */
public class StringMultiply {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.equals("0")|| num2.equals("0")){
            return "0";
        }
        Stack<String> sub = new Stack<>();
        String longer = num1.length()>=num2.length()? num1:num2;
        String shorter = num1.length()< num2.length()? num1:num2;
        int shortL = shorter.length();
        char[] longString = longer.toCharArray();
        for(int i=0;i<shortL;i++){
            int num = shorter.charAt(i)-'0';
            int zero = shortL-i-1;
            multiply(longString,num,zero,sub);
        }
        System.out.println("shorter is :"+shorter);
        System.out.println("longer is : "+longer);
        for(String tmp : sub){
            System.out.println(tmp);
        }
        if(sub.size()==1){
            return new StringBuilder(sub.pop()).reverse().toString();
        }else{
            String res = "0";
            while(!sub.isEmpty()){
                String tmp = sub.pop();
                res = add(res,tmp);
            }
            return new StringBuilder(res).reverse().toString();
        }

    }

    private void multiply(char[] array, int num, int zero,Stack<String> sub){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<zero;i++){
            sb.append("0");
        }
        int tenth = 0;
        for(int i=array.length-1;i>=0;i--){
            int d = array[i]-'0';
            int res = (d*num+tenth)%10;
            tenth = (d*num+tenth)/10;
            sb.append(res);
        }
        if(tenth!=0) sb.append(tenth);
        sub.push(sb.toString());
    }

    public String add(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] longer = str1.length>=str2.length? str1:str2;
        char[] shorter = str1.length<str2.length? str1:str2;
        StringBuilder sb = new StringBuilder();
        int add1 = 0;
        int index = 0;
        for(;index<shorter.length;index++){
            int num = longer[index]-'0',num2 = shorter[index]-'0';
            int res = (num+num2+add1)%10;
            add1 = (num+num2+add1)/10;
            sb.append(res);
        }
        for(;index<longer.length;index++){
            int num = longer[index]-'0';
            int res = (num+add1)%10;
            add1 = (num+add1)/10;
            sb.append(res);
        }
        if(add1==1) sb.append(add1);
        return sb.toString();


    }

    public static void main(String[] args){
        String s1 ="123456789";
        String s2 = "987654321";
        StringMultiply test = new StringMultiply();
        System.out.println(test.multiply(s1,s2));
        String s3 = "2235";
        String s4 = "9999";
        System.out.println(test.add(s3,s4));
    }

    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }  // This is the better one.

}