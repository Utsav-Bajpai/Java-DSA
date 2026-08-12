class LRUCache {
    class Node{
        int key, val;
        Node prev, next;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    private Map<Integer, Node> cont;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        cont = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cont.containsKey(key))return -1;
        Node temp = cont.get(key);
        int val = temp.val;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(cont.containsKey(key)){
            update(key, value);
            return;
        }
        Node temp = new Node(key, value);
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
        cont.put(key, temp);
        if (cont.size() > capacity) remove();
    }
    private void update(int key, int value){
        Node temp = cont.get(key);
        temp.val = value;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
    }
    private void remove(){
        Node temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
        cont.remove(temp.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */