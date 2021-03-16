package threadexemplo3;

public class ThreadAcimaMedia implements Runnable {
    private Integer[] numeros;
    private double media;
    private int qtdAcimaMedia;

    public ThreadAcimaMedia(Integer[] numeros, double media) {
        this.numeros = numeros;
        this.media = media;
        this.qtdAcimaMedia = 0;
    }

    public int getQtdAcimaMedia() {
        return this.qtdAcimaMedia;
    }
    
    public void run(){
        for(int num : numeros){
            if(num > media){
                qtdAcimaMedia++;
            }
        }
    }
    
    
    
}
