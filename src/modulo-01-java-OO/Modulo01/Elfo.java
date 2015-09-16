public class Elfo {
    private String nome;
    private int flechas;
    private double experiencia;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public Elfo(String n){
        nome = n;
        flechas = 42;
    }
    
    public void atirarFlechar(){
        flechas = flechas -1;
        experiencia = experiencia +1;
    }
    
}