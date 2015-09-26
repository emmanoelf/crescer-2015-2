import java.util.ArrayList;
public class EstrategiaNormal implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public ArrayList<Elfo>getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }

    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscar(Status.VIVO);
        for(Elfo elfo : elfosVivos){
            ordemDoUltimoAtaque.add(elfo);
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
        }
    }
}
