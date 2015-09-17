public class Dwarf{
    private int vida;
    private Status status;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome){
        this();
        this.nome = nome;
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public Dwarf(){
        this.status = status.VIVO;
        this.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void receberFlechada(){
       if(this.vida > 0){
           this.vida -= 10;
        }
       if(this.vida == 0){
           status = this.status.MORTO;
           this.vida = 0;
        }
    }
    
   public double getNumeroSorte(){
       double valorInicial = 101.0;
       if(this.getDataNascimento().ehBissexto() && (this.vida >=80 && this.vida <=90)){
           valorInicial *= -33;
        }
       if(!this.getDataNascimento().ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
           valorInicial *= 33;
           valorInicial %= 100;
        }
       return valorInicial;
    }
}