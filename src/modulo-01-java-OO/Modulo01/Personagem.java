public abstract class Personagem{
    protected String nome;
    protected double vida;
    protected int experiencia;
    protected Status status;
    protected Inventario inventario;

    public Personagem(){
        this.inventario = new Inventario();
    }

    public Inventario getInventario(){
        return this.inventario;
    }
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void removerItem(Item item){
        this.inventario.perderItem(item);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getVida(){
        return this.vida;
    }
    
    public int getExperiencia(){
        return this.experiencia;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
        public void receberAtaqueDoOrc(Orc orc){
        int dano = orc.getDanoDeAtaque();
        this.vida -= dano;
    }
}
