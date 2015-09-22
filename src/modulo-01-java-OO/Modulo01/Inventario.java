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
    
    public Item getItemPorDescricao(String descricao){
        for(Item item : this.listaDeItens){
            if(item.getDescricao().equals(descricao)) {
                return item;
            }
        }
        return null;
        
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
    
    public Item getItemComMaiorQuantidade(){
        Item maiorQuantidade = listaDeItens.get(0);
        int maiorQtd = listaDeItens.get(0).getQuantidade();
        for(int i = 0; i < listaDeItens.size(); i++){
            int quantidade = listaDeItens.get(i).getQuantidade();
            if(maiorQtd < quantidade){
                maiorQuantidade = listaDeItens.get(i);
            }
        }
        return maiorQuantidade;
    }
    
    public void ordenarInventario(){
        Item temporario;
        for(int i = 0; i< this.listaDeItens.size(); i++){
            for(int j = 0; j< this.listaDeItens.size(); j++){
                if(this.listaDeItens.get(j).getQuantidade() > this.listaDeItens.get(i).getQuantidade()){
                    temporario = this.listaDeItens.get(i);
                    this.listaDeItens.set(i, this.listaDeItens.get(j));
                    this.listaDeItens.set(j, temporario);
                }
            }
        }
    }
   
    public boolean equals(Object obj){
        Inventario outroInventario = (Inventario)obj;
        return this.listaDeItens.equals(outroInventario.getItens());
    }
    
    public boolean procurarItem(String itemLocalizado){
        for(Item item : this.listaDeItens){
            if(item.equals(itemLocalizado)){
                return true;
            }
        }
        return false;
    }
    
    public void verificarFlechasEDecrementa(){
        int flechas;
        for(Item flecha : this.listaDeItens){
            if(flecha.getDescricao().equalsIgnoreCase("Flecha") && flecha.getQuantidade() >= 1){
                flechas = flecha.getQuantidade() -1;
            }
        }
    }
    
}
