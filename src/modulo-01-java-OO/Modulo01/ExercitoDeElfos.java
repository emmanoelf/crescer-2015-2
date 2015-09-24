import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoDeElfos{
    HashMap <String, Elfo> exercito;
    HashMap <Status, ArrayList<Elfo>> grupoPorStatus;
    
    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
    }
    
    public HashMap getHashMap(){
        return this.exercito;
    }
    
    public void alistarElfo(ElfoNoturno elfoNoturno){
        this.exercito.put(elfoNoturno.getNome(), elfoNoturno);
    }
    
    public void alistarElfo(ElfoVerde elfoVerde){
        this.exercito.put(elfoVerde.getNome(), elfoVerde);
    }
    
    public Elfo buscarElfoPorNome(Elfo elfo){
        return this.exercito.get(elfo.getNome());
    }
    
    public void agruparPorStatus(){
        grupoPorStatus = new HashMap<>();
        for(Elfo elfo : this.exercito.values()){
            if(!grupoPorStatus.containsKey(elfo.getStatus())){
                grupoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
         grupoPorStatus.get(elfo.getStatus()).add(elfo);
        }
    }
    
    public ArrayList<Elfo> buscar(Status status){
        return grupoPorStatus.get(status);
    }
}
