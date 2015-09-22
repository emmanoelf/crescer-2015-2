public class IrishDwarf extends Dwarf{
    
    public IrishDwarf(String nome){
        super(nome);
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        super(nome, dataNascimento);
    }

    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i = 0; i < inventario.listaDeItens.size(); i++){
                this.inventario.getItens().get(i).ganha1000UnidadesESoma();
            }
        }
    }
}