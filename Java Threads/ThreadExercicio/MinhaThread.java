package threadexercicio;

public class MinhaThread implements Runnable {
    private String nome;
    private int tempo;
    private int inicioSeq;
    private int fimSeq;
    
    public MinhaThread(String nome, int tempo, int inicio, int fim) {
        this.nome = nome;
        this.tempo = tempo;
        this.inicioSeq = inicio;
        this.fimSeq = fim;
    }
    
    public void run() {
        try {
            for (int i = this.inicioSeq; i <= this.fimSeq; i++) {
                System.out.print(i);
                Thread.sleep(this.tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}