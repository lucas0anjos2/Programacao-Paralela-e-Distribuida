package threadexemplo02;

public class ThreadExemplo02 {
  
    public static void main(String[] args) {
        MinhaThread t1 = new MinhaThread("Thread 1", 1000);
        t1.start();
        
        MinhaThread t2 = new MinhaThread("Thread 2", 600);
        t2.start();
    }
    
}
