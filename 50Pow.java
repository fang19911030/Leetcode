public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if(n>=0){
            for(int i=0;i<n;i++){
                res *= x;
            }
            return res;
        }else{
            n = -n;
            for(int i = 0;i<n ;i++){
                res *= x;
            }
            return 1/res;
        }
    }
}

public class Solution {
    public double myPow(double x, int n) {
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        if(n%2==0) return myPow( myPow(x, n/2), 2);
        else return x*myPow( myPow(x, n/2), 2);
            
    }
}