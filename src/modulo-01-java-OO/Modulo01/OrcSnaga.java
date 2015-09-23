public class OrcSnaga extends Orc{

    public OrcSnaga(String nome){
        super(nome);
        Item arco = new Item("Arco",1);
        Item flechas = new Item("Flecha", 5);
        this.inventario.adicionarItem(arco);
        this.inventario.adicionarItem(flechas);
        this.vida = 70;
    }
}