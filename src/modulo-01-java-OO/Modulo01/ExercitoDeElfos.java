import java.util.*;
import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoDeElfos{
    HashMap <String, Elfo> exercito;
    HashMap <Status, ArrayList<Elfo>> grupoPorStatus = new HashMap<>();
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
    }
    
    public HashMap getExercito(){
        return this.exercito;
    }
    
    public HashMap getHashMap(){
        return this.exercito;
    }
    
    public Elfo buscar(String nome){
        return this.exercito.get(nome);
    }
    
    public void alistarElfo(Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
            this.exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public Elfo buscarElfoPorNome(Elfo elfo){
        return this.exercito.get(elfo.getNome());
    }
    
    public void agruparPorStatus() {
        grupoPorStatus.clear();
        
        for (Map.Entry<String, Elfo> parChaveValor : this.exercito.entrySet()) {
            
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            
            if (!grupoPorStatus.containsKey(status)) {
                grupoPorStatus.put(status, new ArrayList<Elfo>(Arrays.asList(elfo)));
            } else {
                grupoPorStatus.get(status).add(elfo);
            }
            
        }
    }
    
    public ArrayList<Elfo> buscar(Status status){
        return grupoPorStatus.get(status);
    }
    
    public void atacar(ArrayList<Dwarf> alvos){
        this.estrategia.atacar(this, alvos);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
    
    public void mudarEstrategia(EstrategiaDeAtaque estrategia){
        this.estrategia = estrategia;
    }
}
