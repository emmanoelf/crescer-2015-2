import java.util.ArrayList;

public class Inventario{
    ArrayList<Item> listaDeItens;
    
    public Inventario(){
        this.listaDeItens = new ArrayList<>();
    }
    
    public ArrayList<Item> getItens(){
        return this.listaDeItens;
    }
    
    public void adicionarItem(Item item){
        this.listaDeItens.add(item);
    }
    
    public void perderItem(Item item){
        this.listaDeItens.remove(item);
    }
}