//  Write a multithreaded Java program to demonstrate the Producer-Consumer problem

package TW7;
import java.util.LinkedList;

class Buffer {
    private LinkedList<Integer> items = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

   
    public synchronized void produce(int item, String producerName) throws InterruptedException {
        while (items.size() == capacity) {
            System.out.println(producerName + " is waiting. Buffer is full.");
            wait();
        }

        items.add(item);
        System.out.println(producerName + " produced: " + item);

        notifyAll();
    }

    
    public synchronized int consume(String consumerName) throws InterruptedException {
        while (items.isEmpty()) {
            System.out.println(consumerName + " is waiting. Buffer is empty.");
            wait();
        }

        
        int consumedItem = items.removeFirst();
        System.out.println(consumerName + " consumed: " + consumedItem);
        notifyAll();

        return consumedItem;
    }
}

class Producer implements Runnable {
    private Buffer buffer;
    private String name;

    public Producer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i, name);
                Thread.sleep(500); // Simulate production time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;
    private String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                buffer.consume(name);
                Thread.sleep(3000); // Simulate consumption time
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TW7 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(3);

        Thread producerThread = new Thread(new Producer(buffer, "Producer"));
        Thread consumerThread = new Thread(new Consumer(buffer, "Consumer"));

        producerThread.start();
        consumerThread.start();
    }
}