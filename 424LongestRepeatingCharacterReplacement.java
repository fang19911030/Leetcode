public class 424LongestRepeatingCharacterReplacement{
	public int characterReplacement(String s, int k){
		int[] count = new int[26];
		int maxCount = 0, maxLength = 0;
		int len = s.length();
		int start = 0;
		for(int end = 0;end<len;end++){
			maxCount = Math.max(maxCount,count[s.charAt(end)-'A']++);
			while(end-start+1-maxCount>k){
				count[s.charAt(start)-'A']--;
				start++;
			}
			maxLength = Math.max(end-start+1,maxLength);
		}
		return maxLength;
	}
}