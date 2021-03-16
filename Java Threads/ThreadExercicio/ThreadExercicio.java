package threadexercicio;

public class ThreadExercicio {

    public static void main(String[] args) {
        MinhaThread thread1 = new MinhaThread("Thread 1", 500, 1, 5); // atrasos diferentes para notar quando cada Thread está em execução
        MinhaThread thread2 = new MinhaThread("Thread 2", 700, 6, 10);
        MinhaThread thread3 = new MinhaThread("Thread 3", 900, 11, 15);
        
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
