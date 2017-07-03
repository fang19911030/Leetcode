public class LRUCache {
    private Map<Integer,Integer> map;
    private int timestamp = 0;
    private int capacity;
    private Map<Integer,KeyWithTimestamp> update;
    class KeyWithTimestamp{
        public int key;
        public int timestamp;
        public KeyWithTimestamp(int key, int timestamp){
            this.key = key;
            this.timestamp = timestamp;
        }
    }
    PriorityQueue<KeyWithTimestamp> oldestKey;

    public LRUCache(int capacity) {
        Comparator cmp = new Comparator<KeyWithTimestamp>(){
            @Override
            public int compare(KeyWithTimestamp a, KeyWithTimestamp b){
                return a.timestamp-b.timestamp;
            }
        };

        oldestKey = new PriorityQueue<KeyWithTimestamp>(capacity,cmp);
        map = new HashMap<Integer,Integer>();
        this.capacity = capacity;
        update = new HashMap<>();

    }

    public int get(int key) {
        if(update.containsKey(key)){
            updateTimestamp(key);
        }

        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        if(oldestKey.size() == capacity && !map.containsKey(key)){
            KeyWithTimestamp oldest = oldestKey.poll();
            map.remove(oldest.key);
            update.remove(oldest.key);
            timestamp++;
            KeyWithTimestamp kt = new KeyWithTimestamp(key,timestamp);
            oldestKey.offer(kt);
            map.put(key,value);
            update.put(key,kt);
        }else if(oldestKey.size() == capacity && map.containsKey(key)){
            updateTimestamp(key);
            map.put(key,value);
        }else{
            if(map.containsKey(key)){
                updateTimestamp(key);
                map.put(key,value);
            }else{
                timestamp++;
                KeyWithTimestamp kt = new KeyWithTimestamp(key,timestamp);
                oldestKey.offer(kt);
                update.put(key,kt);
                map.put(key,value);
            }
        }

    }
    
    private void updateTimestamp(int key){
        timestamp++;
        KeyWithTimestamp cur = update.get(key);
        oldestKey.remove(cur);
        cur.timestamp = timestamp;
        oldestKey.offer(cur);
    }


    class Node{
        private int key;
        private int value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity, count;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    public void deleteNode(Node node){
        if(node == head && node == tail){
            head = tail = null;
        }else if(node == head){
            head = head.next;
        }else if(node == tail){
            tail = node.pre;
            tail.next = null;
        }else{
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
    public void addToHead(Node node){
        if(head == null && tail == null){
            head = tail = node;
            return ;
        }
        node.next = head;
        node.next.pre = node;
        node.pre = null;
        head = node;
    }
    public int get(int key) {
        if(map.get(key) == null) return -1;
        Node node = map.get(key);
        int res = node.value;
        deleteNode(node);
        addToHead(node);
        return res;
    }
    
    public void put(int key, int value) {
        if(map.get(key) != null){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            if(count < capacity){
                count ++;
                addToHead(node);
            }else{
                map.remove(tail.key);
                deleteNode(tail);
                addToHead(node);
            }
        }
    }
}