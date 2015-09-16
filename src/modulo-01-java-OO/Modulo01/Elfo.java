/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
<<<<<<< HEAD
    private int flechas = 42;
    private int experiencia;
=======
    private int flechas, experiencia;
>>>>>>> ad6150a3d6a02652fc4cf34571dd0f5bd709fd29
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
<<<<<<< HEAD
    
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
=======
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome, Integer flechas) {
        this(nome);
        if (flechas != null) {
            this.flechas = flechas;
        }
    }
    
    public Elfo(String nome) {
        this(nome, 42);
    }

    /* PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   
    public void atirarFlecha() {
        flechas--;
        experiencia++;
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
    
    /*
     * 
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }
     */
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
}
>>>>>>> ad6150a3d6a02652fc4cf34571dd0f5bd709fd29
