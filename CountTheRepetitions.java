
import java.util*;

public class ConuntTheRepetitions{
	public int getMaxRepetitions(String s1, int n1, String s2 , int n2){
		if(!ableToObtain(s1,s2)) return 0;
		int cnt = 0;
		int k = -1;

		String s = s1;
		StringBuilder remainBuilder;              //record 'remain String'
		ArrayList<String> stringList = new ArrayList<>();
		ArrayList<Integer> countList = new ArrayList<>();

		stringList.add("");
		countList.add(0);
		for(int i=0;i<n1;i++){
			remainBuilder = new StringBuilder();
			cnt += getRemain(s, s2, remainBuilder);
			String remain = remainBuilder.toString();
			if((k=stringList.indexOf(remain))!= -1) break;

			stringList.add(remain);
			countList.add(cnt);
			s = remain+s1;
		}

		if(k==-1) return cnt/n2;
		int countOfLoop = cnt-countList.get(k);
		int loopLength = stringList.size()-k;

		cnt = countList.get(k);
		n1 -=k;
		cnt += countOfLoop *(n1/loopLength);
		n1 %=loopLength;
		cnt += countList.get(k+n1)-countList.get(k);
		return cnt/n2;
	}

	private boolean ableToObtain(String s1, String s2){
		boolean[] cnt = new boolean[26];
		for(char c:s1.toCharArray()){

			cnt[c-'a'] = true;
		}

		for(char c:s2.toCharArray()){
			if(!cnt[c-'a']){
				return false;
			}
		}
		return true;

	}
	private int getRemain(String s1, String s2, StringBuilder remain) {
        int cnt=0, lastMatch=-1, p2=0;
        for (int p1=0;p1<s1.length();p1++) {
            if (s1.charAt(p1)==s2.charAt(p2)) {
                if (++p2==s2.length()) {
                    p2=0;
                    cnt++;
                    lastMatch=p1;
                }
            }
        }
        remain.append(s1.substring(lastMatch+1));
        return cnt;
    }
}