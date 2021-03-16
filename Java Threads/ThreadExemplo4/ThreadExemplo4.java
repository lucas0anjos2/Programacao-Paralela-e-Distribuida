package threadexemplo4;

public class ThreadExemplo4 {

    public static void main(String[] args) {
        MinhaThread thread1 = new MinhaThread("Thread 1", 500);
        MinhaThread thread2 = new MinhaThread("Thread 2", 500);
        MinhaThread thread3 = new MinhaThread("Thread 3", 500);
        
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        
        t1.start();
        t2.start();
        t3.start();
    }    
}