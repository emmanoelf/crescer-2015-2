public class Orc extends Personagem{

    public Orc(String nome)
    {
        this.nome = nome;
        this.status = Status.VIVO;
    }
    
    public void receberDano() {
        int dano = getItem("Escudo Uruk-Hai") == null ? 10 : 6;
        perderVida(dano);
    }
    
    public void receberAtaqueDoOrc(Orc orc) {
        this.receberDano();
    }
    
    public void atacarPersonagem(Personagem alvo){
        boolean podeAtacarComEspada = podeAtacarComEspada();
        boolean podeAtacarComArco = podeAtacarComArco();
        if(podeAtacarComEspada || podeAtacarComArco){
            alvo.receberAtaqueDoOrc(this);
            if(!podeAtacarComEspada){
                debitarFlecha();
            }
        }else{
            status = Status.FUGINDO;
        }
                
        /*if(podeAtacarComEspada()){
            alvo.receberAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            alvo.receberAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }*/
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
    
    private void definirStatusComBaseNaVida(){
        super.status = vida <= 0 ? Status.MORTO : Status.FERIDO;
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
}