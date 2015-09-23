public class ElfoNoturno extends Elfo{
    
    public ElfoNoturno(String nome){
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas){
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf d){
        super.atirarFlecha(d);
        super.experiencia += 2;
        double vidaAtual = super.vida;
        double vidaAposCalculo = super.vida * 0.05;
        super.vida =  (int) vidaAtual - vidaAposCalculo;
        if(this.vida <= 0){
            this.status = Status.MORTO;
            super.vida = 0;
        }
    }

}
