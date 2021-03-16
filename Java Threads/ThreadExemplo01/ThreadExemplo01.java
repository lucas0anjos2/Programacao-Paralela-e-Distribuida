package threadexemplo01;

class TarefaEspecial implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 200; i++){
            System.out.print("U");
       }
    }
}


class Tarefa extends Thread {
    public void run(){
        rodar();
    }
    
    public void rodar(){
       for (int i = 0; i < 200; i++){
            System.out.print("T");
       } 
    }
}

public class ThreadExemplo01 {
   
    public static void main(String[] args) {
        Tarefa t1 = new Tarefa();
        t1.start();
        
        for (int i = 0; i < 200; i++){
            System.out.print("S");
        } 
        
        TarefaEspecial te = new TarefaEspecial();
        Thread t2 = new Thread(te);
        t2.start();
        
        
    }
    
}
