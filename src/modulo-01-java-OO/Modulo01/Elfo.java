 /**
 * Representa objetos do tipo Elfo.
 */
 public class Elfo {
    private String nome;
    private int flechas, experiencia;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
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
   
    public void atirarFlecha(Dwarf d) {
        flechas--;
        experiencia++;
        d.receberFlechada();
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
    
    public String getNome(){
        return nome;
    }
    
    public int getFlechas(){
        return this.flechas;
    }
    
    public void setFlechas(int flechas){
        if(flechas> this.flechas)
        this.flechas = flechas;
    }
    
    public String toString(){
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " níveis de experiência.";
    }
    
}