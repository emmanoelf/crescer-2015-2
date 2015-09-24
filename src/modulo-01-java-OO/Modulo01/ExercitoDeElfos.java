import java.util.HashMap;
public class ExercitoDeElfos{
    HashMap <String, Elfo> exercito;
    
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
}
