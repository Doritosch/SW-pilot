package procedure02;

public class RoadToBiodome08 {
    private static final int BASE_SIZE = 10;
    private static final int GROW_SIZE = 10;
    private static int[] queue;
    private static int front = 0, rear = 0;
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("입력값이 없습니다. 다시 입력해주세요.");
            return;
        }

        queue = new int[BASE_SIZE];

        for(int i=0; i<args.length; i++) {
            enqueue(Integer.parseInt(args[i]));
        }

        while(!isEmpty()) {
            int data = peek();
            dequeue();
            System.out.println("자원 " + data + "을 제공했습니다.");
        }
        System.out.println("모든 요청이 처리되습니다.");
    }
    private static void growQueue() {
        int[] newQueue = new int[queue.length + GROW_SIZE];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        queue = newQueue;
    }
    private static int enqueue(int data) {
        if (rear == queue.length) {
            growQueue();
            System.out.println("Queue의 크기가 " + queue.length + "으로 늘어났습니다.");
        }
        return queue[rear++] = data;
    }
    private static int dequeue() {
        return queue[front++];
    }
    private static int peek() {
        return queue[front];
    }
    private static boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }
}
