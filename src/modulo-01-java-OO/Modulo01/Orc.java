public class Orc{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    protected Status status;
    protected Inventario inventario;

    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc(){
        this.status = Status.VIVO;
        this.vida = 130;
        this.inventario = new Inventario();
    }

    public Inventario getInventario(){
        return this.inventario;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getVida(){
        return this.vida;
    }

    public void receberDano(Elfo elfo) {
        if(this.vida > 0){
            this.vida -= 8;
        }
        if(this.vida <= 0){
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }

    public void receberDano(Dwarf dwarf) {
        if(this.inventario.procurarItem("Escudo UrukHai")&& this.vida > 0){
            this.vida -= -5;
        }
        if(this.vida <= 0){
            this.vida = 0;
            this.status = Status.MORTO;
        }
    }

    public void verificarItensEDano(){
        int dano = 0;
        if(this.inventario.procurarItem("Espada") && this.inventario.procurarItem("Arco") && this.inventario.procurarItem("Flecha")){
            dano = 12;
        }else if(this.inventario.procurarItem("Espada")){
            dano = 12;
        }else if(this.inventario.procurarItem("Arco") && this.inventario.procurarItem("Flecha")){
            this.inventario.verificarFlechasEDecrementa();
            dano = 8;
        }
    }
}