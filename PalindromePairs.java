import java.util.*;

public class PalidromePairs {
	public List<List<Integer>> palindromeParis(String[] words){
		List<List<Integer>> ret = new ArrayList<>();
		
		if(words == null || words.length<2) return ret;
		
		Map<String, Integer>map = new HashMap<String, Integer>();

		for(int i=0;i<words.length;i++){
			map.put(words[i], i);
		}
		
		for(int i=0; i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				String str1 = words[i].substring(0,j);
				String str2 = words[i].substring(j);
				if(isPalindrome(str1)){
					String str2rvs = new StringBuilder(str2).reverse().toString();
					if(map.containsKey(str2rvs) && map.get(str2rvs)!=i){
						List<Integer> list = new ArrayList<Integer>();
						list.add(map.get(str2rvs));
						list.add(i);
						ret.add(list);
					}
				}
				if(isPalindrome(str2)){
					String str1rvs = new StringBuilder(str2).reverse().toString();
					if(map.containsKey(str1rvs) && map.get(str1rvs)!=i && str2.length()!=0){
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(map.get(str1rvs));
						ret.add(list);
					}
				}
			}
		}
		return ret;
	}
	
	public boolean isPalindrome(String s1){
		int left =0;
		int right = s1.length()-1;
		while(left<=right){
			if(s1.charAt(left)!= s1.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args){
		PalidromePairs solution = new PalidromePairs();
		String[] words = {"bat","tab","cat"};
		System.out.println(solution.palindromeParis(words));
	}

}
