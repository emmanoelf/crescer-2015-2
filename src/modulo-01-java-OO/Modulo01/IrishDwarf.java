public class IrishDwarf extends Dwarf{

    
    public IrishDwarf(){
        
    }
    
    public IrishDwarf(String nome){
        
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){
        
    }

    public void tentarSorte(){
        if(this.getNumeroSorte() == -3333.0){
            for(int i = 0; i < inventario.listaDeItens.size(); i++){
                this.inventario.getItens().get(i).shimbalaie();
            }
        }
    }
}