public class solution{
	public int divide(int divident, int divisor){
		int sign = 1;
		if((divident> 0 && divisor<0)||(divident<0 && divisor>0)){
			sign = -1;
		}

		long ldivident = Math.abs((long)divident);
		long ldivisor = Math.abs((long)divisor);

		if(ldivisor==0) return Integer.MAX_VALUE;
		if(ldivident==0|| ldivident<ldivisor) return 0;
		long lans = ldivide(ldivident, ldivisor);
		int ans;
		if(lans>Integer.MAX_VALUE){
			ans = (sign==1)? Integer.MAX_VALUE:Integer.MIN_VALUE;
		}else{
			ans = (int)(sign*lans);
		}
		return ans;

	}

	private long ldivide(long ldivident, long ldivisor){
		if(ldivident<ldivisor){
			return 0;
		}
		long sum = ldivisor;
		long res =1;
		while((sum+sum)<=ldivident){
			res +=res;
			sum += sum;
		}
		return res+ldivide(ldivident-sum,ldivisor);
	}
}