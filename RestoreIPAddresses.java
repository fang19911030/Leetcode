/**
 * Created by fang on 5/3/17.
 */
import java.util.*;
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length()<4 || s.length()>12){
            return res;
        }
        String valid="";
        help(s,0,s.length()-1,res, 0, valid);
        return res;
    }

    private void help(String s, int l, int r,List<String> res,int nums, String valid){    //substring also need consider index
        if(nums==4 && l >r){
            int length = valid.length();
            valid = valid.substring(0,length-1);
            res.add(valid);
            return;
        }
        if(l>r && nums != 4){
            return;
        }
        int num = s.charAt(l)-'0';
        if(num>=3){

            if(l+2<=r+1){                           //without this , index will out of range
                String newValid = valid+s.substring(l,l+2)+".";
                help(s,l+2,r,res,nums+1,newValid);
            }
            if(l+1<=r+1) {
                String newValid = valid + s.substring(l, l + 1) + ".";
                help(s, l + 1, r, res, nums + 1, newValid);
            }
        }else if(num>0){
            if(l+3<=r+1 && Integer.valueOf(s.substring(l,l+3))<=255){
                String newValid = valid + s.substring(l,l+3)+".";
                help(s,l+3,r,res,nums+1,newValid);
            }
            if(l+2<=r+1) {
                String newValid = valid + s.substring(l, l + 2) + ".";
                help(s, l + 2, r, res, nums + 1, newValid);
            }
            String newValid = valid + s.substring(l,l+1)+".";
            help(s,l+1,r, res, nums+1,newValid);
        }else{
            String newValid = valid+s.substring(l,l+1)+".";
            help(s,l+1,r,res,nums+1,newValid);
        }
    }

    public static void main(String[] args){
        String s1 = "2552151135";
        RestoreIPAddresses solution = new RestoreIPAddresses();
        List<String> res = solution.restoreIpAddresses(s1);
        for(String tmp:res){
            System.out.println(tmp);
        }
       // System.out.println(s1.substring(0,55));
    }
}
