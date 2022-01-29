package LeetCode;

public class MyCircularQueue {
    private int[] circularQueue;
    private int front, rear, size;

    public MyCircularQueue(int k) {
        circularQueue = new int[k];
        front = rear = size = 0;
    }

    public boolean enQueue(int value) {
        if(size == circularQueue.length) return false;

        if(size !=0)//size가 0일떄는 rear와 front가 같음. 그러므로 안옮겨도 됨.
            rear = (++rear) % circularQueue.length;

        circularQueue[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0) return false;

        circularQueue[front] = 0;

        if(size != 1)//사이즈가 1이면 front==rear
            front = (++front) % circularQueue.length;

        size--;
        return true;
    }

    public int Front() {
        if(size == 0) return -1;

        return circularQueue[front];
    }

    public int Rear() {
        if(size == 0) return -1;

        return circularQueue[rear];
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;

        return false;
    }

    public boolean isFull() {
        if(size == circularQueue.length)
            return true;

        return false;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());

//        MyCircularQueue myCircularQueue = new MyCircularQueue(81);
//        System.out.println(myCircularQueue.enQueue(69));
//        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.enQueue(92));
//        System.out.println(myCircularQueue.enQueue(12));
//        System.out.println(myCircularQueue.deQueue());
//        System.out.println(myCircularQueue.isFull());
//        System.out.println(myCircularQueue.isFull());
//        System.out.println(myCircularQueue.Front());
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */