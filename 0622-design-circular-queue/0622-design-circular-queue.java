class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }
    
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count++;
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count--;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.queue[this.headIndex];
    }
    
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }
    
    public boolean isEmpty() {
        return this.count == 0;
    }
    
    public boolean isFull() {
        return this.count == this.capacity;
    }
}