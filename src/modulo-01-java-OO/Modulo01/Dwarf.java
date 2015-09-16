public class Dwarf{
    private int vida;
    
    public Dwarf(){
        this.vida = 110;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public void receberFlechada(){
        this.vida -= 10;
    }
}