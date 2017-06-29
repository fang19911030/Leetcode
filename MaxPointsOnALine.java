public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null) return 0;
        if(points.length <=2) return points.length;
        
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer,Map<Integer,Integer>>();
        
        int result = 0;
        for(int i=0;i<points.length;i++){
            map.clear();
            int overlap = 0;
            int max = 0;
            for(int j=i+1;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x == 0 && y == 0){
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if(gcd!= 0){
                    x = x/gcd;
                    y = y/gcd;
                }
                if(map.containsKey(x)){
                    if(map.get(x).containsKey(y)){
                        int num = map.get(x).get(y)+1;
                        map.get(x).put(y,num);
                    }else{
                        map.get(x).put(y,1);
                    }
                }else{
                    Map<Integer,Integer> submap = new HashMap<Integer,Integer>();
                    submap.put(y,1);
                    map.put(x,submap);
                }
                max = Math.max(max,map.get(x).get(y));
            }
            result = Math.max(result,max+overlap+1);
        }
        return result;
    }
    
    private int generateGCD(int a, int b){
        if(b==0){
            return a;
        }
        else return generateGCD(b,a%b);
    }
}