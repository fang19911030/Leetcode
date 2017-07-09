public class Solution {
    public int findMinArrowShots(int[][] points) {
        Comparator<int[]> cmp = new Comparator<int[]>(){
            @Override
            public int compare(int[]a, int[]b){
                if(a[1]!=b[1]) return a[1]-b[1];
                else return a[0]-b[0];
            }
        };
        
        Arrays.sort(points,cmp);
        int res = 0;
        int end = Integer.MIN_VALUE;
        for(int[] cur:points){
            if(cur[0]== Integer.MIN_VALUE || cur[0] >end){  //SPECIAL TEST CASE
                end = cur[1];
                res++;
            } 
        }
        return res;
    }
}