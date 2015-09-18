public class Item{
    private String descricao;
    private int quantidade;
    
    public Item(String d, int q){
        this.descricao = d;
        this.quantidade = q;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
}