import java.util.*;
public class KPairswithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1==null || nums2==null){
        	return null;
        }
        int[][] sum = getSum(nums1, nums2);
        HashMap<Integer,Queue<int[]>> sum_to_index = getMap(sum);
        int[] heap = new int[nums1.length*nums2.length];
        int index=0;
        for(int i=0;i<sum.length;i++){
        	for(int j=0;j<sum[0].length;j++){
        		heap[index++] = sum[i][j];
        	}
        }
        for(int i=0;i<heap.length;i++){
        	heapInsert(heap,i);
        }
        
        int heapsize = heap.length;
        for(int i=0;i<heap.length;i++){
        	swap(heap,0,heapsize-1);
        	heapsize--;
        	heapify(heap,0,heapsize);
        }
        
        /*print heap*/
        List<int[]>res = new LinkedList<>();
        for(int i=0; i<k & i<heap.length;i++){
        	int[] position = sum_to_index.get(heap[i]).poll();
        	int[] value={nums1[position[0]],nums2[position[1]]};
        	res.add(value);
        }
        return res;
    }
    
    private void heapInsert(int[]heap, int index){
    	while(index>0){
    		int parent = (index-1)/2;
    		if(heap[parent]<heap[index]){
    			swap(heap,parent,index);
        		index = parent;	
    		}else{
    			break;
    		}	
    	}
    }
    
    private void heapify(int[] heap, int index,int heapsize){
    	int left = 2*index+1;
    	int right = 2*index+2;
    	int largest = index;
    	while(left<heapsize){
    		if(heap[largest]<heap[left]){
    			largest = left;
    		}
    		if(right<heapsize && heap[largest]<heap[right]){
    			largest = right;
    		}
    		if(largest!= index){
    			swap(heap,largest,index);
    		}else{
    			break;
    		}
    		index = largest;
    		left = 2*index+1;
    		right = 2*index+2;
    	}
    }
    
    private void swap(int[]arr, int i, int j){
    	int tmp = arr[i];
    	arr[i]=arr[j];
    	arr[j] = tmp;
    }
    
    private int[][] getSum(int[] nums1, int[] nums2){
    	int[][] res = new int[nums1.length][nums2.length];
    	for(int i=0;i<nums1.length;i++){
    		for(int j=0;j<nums2.length;j++){
    			res[i][j]=nums1[i]+nums2[j];
    		}
    	}
    	return res;
    }
    
    private HashMap<Integer,Queue<int[]>> getMap(int[][] sum){
    	HashMap<Integer,Queue<int[]>> res = new HashMap<>();
    	for(int i=0;i<sum.length;i++){
    		for(int j=0;j<sum[0].length;j++){
    			if(res.containsKey(sum[i][j])){
    				int[] position ={i,j};
    				res.get(sum[i][j]).offer(position);
    			}else{
    				Queue<int[]> indexList = new LinkedList<>();
    				int[] position = {i,j};
    				indexList.offer(position);
    				res.put(sum[i][j], indexList);
    			}
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	int[] nums1 = {1,2,11};
    	int[] nums2 = {2,4,6};
    	
    	KPairswithSmallestSums solution = new KPairswithSmallestSums();
    	List<int[]> res = solution.kSmallestPairs(nums1,nums2,5);
    }

}
