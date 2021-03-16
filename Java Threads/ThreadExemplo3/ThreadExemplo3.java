package threadexemplo3;


public class ThreadExemplo3 {

    public static void main(String[] args) {
        Integer[] numeros = new Integer[] {4, 9, 10, 2, 15};
        
        ThreadMedia thread1 = new ThreadMedia(numeros);
        Thread t1 = new Thread(thread1);
        t1.start();
        
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Média final: " + thread1.getMedia());
        
        ThreadAcimaMedia thread2 = new ThreadAcimaMedia(numeros, thread1.getMedia());
        Thread t2 = new Thread(thread2);
        
        t2.start();
        
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("QTD acima da media: " + thread2.getQtdAcimaMedia());
        

    }
    
}
