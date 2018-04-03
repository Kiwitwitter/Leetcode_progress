//
// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
//
//
// Follow up:
// Could you do both operations in O(1) time complexity?
//
// Example:
//
// LRUCache cache = new LRUCache( 2 /* capacity */ );
//
// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4
//
//


class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        
    }
    
    HashMap<Integer, Node> map;
    int capacity, count;
    Node head, tail;
    
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    
    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            int result = node.val;
            deleteNode(node);
            addToHead(node);
            return result;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null){
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            if(count<capacity){
                count++;
                addToHead(node);
            }else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */