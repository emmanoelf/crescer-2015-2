public class Dwarf{
    private int vida;
    private Status status;
    private String nome;
    private int experiencia;
    private DataTerceiraEra dataNascimento;

    public Dwarf(String nome){
        this.vida = 110;
        this.status = status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        this.nome = nome;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public int getVida(){
        return this.vida;
    }

    public Status getStatus(){
        return this.status;
    }

    public String getNome(){
        return this.nome;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public DataTerceiraEra getDataNascimento(){
        return this.dataNascimento;
    }

    public void receberFlechada(){
        double sorteLancada = getNumeroSorte();
        if(sorteLancada < 0){
            experiencia += 2;
        }else if(sorteLancada >= 0 && sorteLancada <= 100){
            getVida();
        }else{
            if(this.vida > 0){
                this.vida -= 10;
            }
            if(this.vida == 0){
                status = this.status.MORTO;
            }
        }
    }

    public double getNumeroSorte(){
        double valorInicial = 101.0;
        if(this.getDataNascimento().ehBissexto() && (this.vida >=80 && this.vida <=90)){
            return valorInicial * -33;
        }
        if(!this.getDataNascimento().ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            return (valorInicial * 33) %100;
        }
        return valorInicial;
    }
}