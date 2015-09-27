import java.util.*;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf>dwarves){
        ordemDoUltimoAtaque.clear();
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscar(Status.VIVO);
        ArrayList<Elfo> elfosOrdenados = new ArrayList<>();
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoVerde){
                elfosOrdenados.add(elfo);
            }
        }
        for(Elfo elfo : elfosVivos){
            if(elfo instanceof ElfoNoturno){
                elfosOrdenados.add(elfo);
            }
        }
        for(Elfo elfo : elfosOrdenados){
            ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
        }
    }
}