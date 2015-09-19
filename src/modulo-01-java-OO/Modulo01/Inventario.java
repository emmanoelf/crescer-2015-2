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
    
    public String getDescricoesItens(){
        String descricao = "";
        for(int i = 0; i < listaDeItens.size(); i++){
            descricao += listaDeItens.get(i).getDescricao();
            if(i != listaDeItens.size()-1){
                descricao += ",";
            }
        }
        return descricao;
    }
}