import java.util.*;

class Node {
    int key, val, freq;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    int size;
    Node head, tail;

    DLL() {
        size = 0;

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void addAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next = node;
        node.next.prev = node;

        size++;
    }

    void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }

    Node removelast() {
        if (size == 0)
            return null;

        Node temp = tail.prev;

        temp.prev.next = tail;
        tail.prev = temp.prev;

        size--;

        return temp;
    }
}

class LFUCache {
    private int capacity, minfreq, currsize;

    private Map<Integer, Node> cont;
    private Map<Integer, DLL> lfu;

    public LFUCache(int capacity) {
        cont = new HashMap<>();
        lfu = new HashMap<>();

        this.capacity = capacity;
        this.minfreq = 0;
        this.currsize = 0;
    }

    public int get(int key) {

        if (!cont.containsKey(key))
            return -1;

        Node temp = cont.get(key);

        update(temp);

        return temp.val;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        // Key already exists
        if (cont.containsKey(key)) {

            Node node = cont.get(key);

            node.val = value;

            update(node);

            return;
        }

        // Cache is full
        if (currsize == capacity) {

            DLL minList = lfu.get(minfreq);

            Node removed = minList.removelast();

            cont.remove(removed.key);

            currsize--;
        }

        // Create new node
        Node node = new Node(key, value);

        cont.put(key, node);

        DLL list = lfu.getOrDefault(1, new DLL());

        list.addAtFront(node);

        lfu.put(1, list);

        minfreq = 1;

        currsize++;
    }

    private void update(Node node) {

        int oldFreq = node.freq;

        DLL oldList = lfu.get(oldFreq);

        oldList.removeNode(node);

        // If this was the last node
        // with minimum frequency
        if (oldFreq == minfreq && oldList.size == 0) {
            minfreq++;
        }

        // Increase frequency
        node.freq++;

        // Add to new frequency list
        DLL newList =
            lfu.getOrDefault(node.freq, new DLL());

        newList.addAtFront(node);

        lfu.put(node.freq, newList);
    }
}