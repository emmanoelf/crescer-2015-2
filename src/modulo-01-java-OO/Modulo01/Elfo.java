public class Elfo {
    private String nome;
    private int flechas = 42;
    private double experiencia;
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public void atirarFlechar(){
        flechas = flechas -1;
        experiencia = experiencia +1;
    }
    
    public void atirarFlechaRefactory(){
        boolean acertar = false;//default
        if(acertar == true){
            flechas--;
            experiencia++;
        }else{
            flechas--;
        }
    
    }
}