/*using: x= (-b + sqrt[ b^2 - 4 a* c])/2a  { a=1, b=1, c=-2 }

x= floor((-1 + sqrt(1+8*n))/2);*/ 




public class Solution {
    public int arrangeCoins(int n) {
        return (int) Math.floor((-1 + Math.sqrt(1+8L*n))/2.0);
    }
}