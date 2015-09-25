import java.util.ArrayList;
public class EstrategiaNormal implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public ArrayList<Elfo>getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves){
        for(Elfo elfo : elfos){
            ordemDoUltimoAtaque.add(elfo);
                for(Dwarf dwarf : dwarves){
                    elfo.atirarFlecha(dwarf);
                }
            }
    }
}
