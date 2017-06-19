/*
If a or b is negative this means we are emptying a jug of x or y gallons respectively.

Similarly if a or b is positive this means we are filling a jug of x or y gallons respectively.

x = 4, y = 6, z = 8.

GCD(4, 6) = 2

8 is multiple of 2

so this input is valid and we have:

-1 * 4 + 6 * 2 = 8
*/



public class Solution{
	public boolean canMeasureWater(int x, int y,int z){
		if(x+y<z){
			return false;
		}
		if(x == z || y == z || x+y == z) return true;
		return z%GCD(x, y) == 0;
	}

	public int GCD(int a, int b){            find greatest common divisor
		while(b!= 0){
			int temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
}