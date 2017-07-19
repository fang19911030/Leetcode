public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F); 
        if(C<E || G<A){
            return area1 + area2;
        }
        if(B> H || F>D){
            return area1+area2;
        }
        
        int r2 = Math.min(D,H);
        int r1 = Math.min(C,G);
        int l2 = Math.max(B,F);
        int l1 = Math.max(A, E);
        return area1+area2-(r1-l1)*(r2-l2);

    }
}