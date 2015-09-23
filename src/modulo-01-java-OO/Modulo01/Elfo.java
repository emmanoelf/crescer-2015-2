 /**
 * Representa objetos do tipo Elfo.
 */
 public class Elfo extends Personagem{
    private int flechas;
    
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
        this.status = Status.VIVO;
        this.vida = 80;
        this.inventario = new Inventario();
    }
    
    /*
    public Elfo(String nome, Integer flechas) {
        this(nome);
        if (flechas != null) {
            this.flechas = flechas;
        }
    }*/
    
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
    
    public void atacarOrc(Orc orc){
        orc.receberDano();
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
     *
     *  public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    */
    
    public int getFlechas(){
        return this.flechas;
    }
    
    /*
    public void setFlechas(int flechas){
        if(flechas> this.flechas)
        this.flechas = flechas;
    }*/
    
    public String toString(){
        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;
        
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, 
        this.flechas, flechaNoSingular ? "flecha" : "flechas", 
        this.experiencia, nivelNoSingular ? "nível" : "níveis");
    }
    
}
