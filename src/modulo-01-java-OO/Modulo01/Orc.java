public class Orc extends Personagem{

    public Orc(String nome)
    {
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public void levarAtaqueDeAnao() {
        
        if(getItem("Escudo Uruk-Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(5);
        }
    }
    
    public void levarAtaqueDeElfo() {
        perderVida(8);
    }
    
    public void atacarAnao(Dwarf anao){
        if(podeAtacarComEspada()){
            anao.receberAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            anao.receberAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public void atacarElfo(Elfo elfo){
        if(podeAtacarComEspada()){
            elfo.receberAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            elfo.receberAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
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

    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }
    
    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
    
    private void perderVida(int qtdVidaPerdida) {
        this.vida -= qtdVidaPerdida;
        
        if(vida <= 0){
            vida = 0;
            this.status = Status.MORTO;
        }
        else {
            this.status = Status.FERIDO;
        }
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
}