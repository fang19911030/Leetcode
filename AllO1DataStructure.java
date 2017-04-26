public class AllOne{
	private Bucket head;
	private Bucket tail;

	private Map<Integer, Bucket> countBucketMap;
	private Map<String, Integer> keyCountMap;

	private class Bucket{
		int count;
		Set<String> keySet;
		Bucket next;
		Bucket pre;
		public Bucket(int cnt){
			count  = cnt;
			keySet = new HashSet<>();
		}
	}

	public AllOne(){
		head = new Bucket(Integer.MIN_VALUE);
		tail = new Bucket(Integer.MAX_VALUE);
		head.next= tail;
		tail.pre = head;
		countBucketMap = new HashMap<>();
		keyCountMap = new HashMap<>();
	}


	public void inc(String key){
		if(keyCountMap.containsKey(key)){
			changeKey(key,1);

		}else{
			keyCountMap.put(key,1);
			if(head.next.count != 1){
				addBucketAfter(new Bucket(1),head);
			}
			head.next.keySet.add(key);
			countBucketMap.put(1,head.next);
		}
	}

	public void dec(String key){
		if(keyCountMap.containsKey(key)){
			int count = keyCountMap.get(key);
			if(count==1){
				keyCountMap.remove(key);
				removeKeyFromBucket(countBucketMap.get(count),key);
			}else{
				changeKey(key,-1);
			}
		}
	}

	public String getMaxKey(){
		return tail.pre == head? "":(String)tail.pre.keySet.iterator().next();
	}

	public String getMinKey(){
		return head.next == tail? "":(String)head.next.keySet.iterator().next();
	}

	private void changeKey(String key, int offset){
		int count = keyCountMap.get(key);
		keyCountMap.put(key,count+offset);
		Bucket curBucket = countBucketMap.get(count);
		Bucket newBucket;
		if(countBucketMap.containsKey(count+offset)){
			newBucket = keyCountMap.get(count+offset);
		}else{
			newBucket = new Bucket(count+offset);
			countBucketMap.put(count+offset,newBucket);
			addBucketAfter(newBucket,offset==1? curBucket:curBucket.pre);
		}
		newBucket.keySet.add(key);
		removeKeyFromBucket(curBucket,key);
	}

	private void removeKeyFromBucket(Bucket bucket,String key){
		bucket.keySet.remove(key);
		if(bucket.keySet.size() == 0){
			removeKeyFromBucketList(bucket);
			countBucketMap.remove(bucket.count);
		}
	}

	private void removeBucketFromList(Bucket bucket){
		bucket.pre.next = bucket.next;
		bucket.next.pre = bucket.pre;
		bucket.next= null;
		bucket.pre = null;
	}

	private void addBucketAfter(Bucket newBucket,Bucket preBucket){
		newBucket.pre = preBucket;
		nreBucket.next= preBucket.next;
		preBucket.next.pre = newBucket;
		preBucket.next = newBucket;

	}
}