public class Dwarf{
    private int vida;
    private Status status;
    private String nome;
    
    public Dwarf(){
        this.vida = 110;
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
    
    public void receberFlechada(){
       if(this.vida > 0){
           this.vida -= 10;
        }
       if(this.vida == 0){
           status = this.status.MORTO;
           this.vida = 0;
        }
    }
}