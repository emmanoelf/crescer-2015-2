public class OrcUrukHai extends Orc{
    
    public OrcUrukHai(String nome){
        super(nome);
        Item escudoUrukHai = new Item("Escudo Uruk-Hai",1);
        Item espada = new Item("Espada",1);
        this.inventario.adicionarItem(escudoUrukHai);
        this.inventario.adicionarItem(espada);
        this.vida = 150;
    }
}