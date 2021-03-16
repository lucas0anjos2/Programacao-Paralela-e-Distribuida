package entity;

public class Usuario {
    private String nome;
    private String[] respostas; // vetor com 5 posições armazenando as respostas
    private int nota;
    
    public Usuario(){
        this.nome = "";
        this.respostas = new String[5];
        this.nota = -1;
    }
    
    public Usuario(String nome, String[] respostas){
        this.nome = nome;
        this.respostas = respostas;
        this.nota = -1;
    }   

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public String getNome() {
        return nome;
    }

    public String[] getRespostas() {
        return respostas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }
    
    public void print(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Prova: ");
        for(int i = 0; i < respostas.length; i++){
            System.out.println((i + 1) + " - " + respostas[i]);
        }
        System.out.println("Nota = " + this.nota);
    }
    
}
