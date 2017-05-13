public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        String[] parts = S.split("-");
        String s="";
        for(String tmp:parts){
            s+=tmp;
        }
        String s2 = s.toUpperCase();
        if(s2.length()<K){
            return s2;
        }
        char[] original = s2.toCharArray();
        int oLength = original.length;
        int mod = oLength%K;
        int newLength = mod==0? oLength-1+oLength/K:oLength+oLength/K;
        
        char[] key= new char[newLength];
        int index = 0;
        if(mod == 0){
            int k=0;
            for(int i=0;i<newLength;i++){
                if(k!=K){
                    key[i] = original[index++];
                    k++;
                }else{
                    key[i]='-';
                    k=0;
                }
            }

        }else{
            int index2=0;
            for(int i=0;i<mod;i++){
                key[i]=original[index++];
                index2= i;
            }

            key[++index2]='-';
            int k=0;
            for(int i=index2+1;i<newLength;i++){
                if(k!=K){
                    key[i] = original[index++];
                    k++;
                }else{
                    key[i]='-';
                    k=0;
                }
            }

            
        }
        return String.valueOf(key);
    }
}