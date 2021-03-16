package threadexemplo3;

public class ThreadMedia implements Runnable {
    private Integer[] numeros;
    private double media;
    
    public ThreadMedia(Integer[] numeros){
        this.numeros = numeros;
        this.media = 0.0;
    }

    public double getMedia() {
        return this.media;
    }
    
    public void run(){
        int soma = 0;
        for(int num : numeros){
            soma += num;
        }
        
        media = soma / numeros.length;
    }
    
    
    
}
