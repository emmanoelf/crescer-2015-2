public class Item{
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void ganha1000Unidades(){
        this.quantidade += 1000;
    }

    public void ganha1000UnidadesESoma(){
        /*
        int contador = 0;
        for(int i = 0; i <= this.quantidade; i++){
            contador += i;
        }
        this.quantidade += contador;
        contador *= 1000;
        this.quantidade += contador;*/
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade += 1000 * pa + pa;
    }
}