public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int[] longs = nums1.length>=nums2.length? nums1:nums2;
        int[] shorts = nums1.length<nums2.length? nums1:nums2;
        if(nums1 == null || nums2 == null || nums1.length==0|| nums2.length == 0){
            return new int[0];
        }
        
        Arrays.sort(longs);
        Arrays.sort(shorts);
        int minimum = shorts[0];
        int maximum = shorts[shorts.length-1];
        
        int left = binarysearch(longs, minimum);
        System.out.print("left:" + left);

        List<Integer> res = new LinkedList<>();
        Map<Integer, Integer> times = new HashMap<>();
        //right = right>=longs.length? longs.length-1:right;
        //System.out.print("right: "+ right);
        for(int i=left;i<longs.length;i++){
            if(times.containsKey(longs[i])){
                int time = times.get(longs[i])+1;
                times.put(longs[i],time);
            }else{
                times.put(longs[i],1);
            }
        }
        for(int i=0;i<shorts.length;i++){
            if(times.containsKey(shorts[i])){
                if(times.get(shorts[i])>1){
                    res.add(shorts[i]);
                    int time = times.get(shorts[i])-1;
                    times.put(shorts[i],time);
                }else{
                    res.add(shorts[i]);
                    times.remove(shorts[i]);
                }
            }
        }
        int[] res2 = new int[res.size()];
        for(int i=0;i<res.size();i++){
            res2[i] = res.get(i);
        }
        return res2;
        

        
        
        
    }
    
    private int binarysearch(int[] nums, int n){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(n>nums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}