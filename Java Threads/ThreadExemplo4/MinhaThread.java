package threadexemplo4;


public class MinhaThread implements Runnable {
    private String nome;
    private int tempo;
    
    public MinhaThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }
    
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.nome + " - contador: " + i);
                Thread.sleep(this.tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(this.nome + " finalizada!");
    }
}
 