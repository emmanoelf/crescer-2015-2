import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;

public class ExercitoDeElfosTest{
   
    @Test 
    public void alistaElfoNoturno(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfis");
        HashMap <String, Elfo> hashEsperado = new HashMap<>();
        hashEsperado.put("Elfis", elfoNoturno);
        exercito.alistarElfo(elfoNoturno);
        assertEquals(hashEsperado, exercito.getHashMap());
    }
    
    @Test
    public void alistaElfoVerde(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfis");
        HashMap<String, Elfo> hashEsperado = new HashMap<>();
        hashEsperado.put("Elfis", elfoVerde);
        exercito.alistarElfo(elfoVerde);
        assertEquals(hashEsperado, exercito.getHashMap());
    }
    
    @Test
    public void buscarElfoNoturnoNoExercito(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Elfis");
        exercito.alistarElfo(elfoNoturno);
        Elfo elfoProcurado = exercito.buscarElfoPorNome(elfoNoturno);
        assertEquals(elfoNoturno, elfoProcurado);
    }
    
    @Test
    public void buscarElfoVerdeNoExercito(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Elfis");
        exercito.alistarElfo(elfoVerde);
        Elfo elfoProcurado = exercito.buscarElfoPorNome(elfoVerde);
        assertEquals(elfoVerde, elfoProcurado);
    }
    
    @Test
    public void buscarElfoVerdeEElfoNoturnoNoExercito(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Tyrande");
        ElfoVerde elfoVerde = new ElfoVerde("Elfis");
        exercito.alistarElfo(elfoNoturno);
        exercito.alistarElfo(elfoVerde);
        Elfo elfoNoturnoProcurado = exercito.buscarElfoPorNome(elfoNoturno);
        Elfo elfoVerdeProcurado = exercito.buscarElfoPorNome(elfoVerde);
        assertEquals(elfoNoturno, elfoNoturnoProcurado);
        assertEquals(elfoVerde, elfoVerdeProcurado);
    }
    
    @Test
    public void elfoMortoEAgrupadoPeloSeuStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoNoturno elfoNoturno = new ElfoNoturno("Tyrande");
        for(int i = 0; i < 90; i++){
            elfoNoturno.atirarFlecha(new Dwarf("Muradin"));
        }
        exercito.alistarElfo(elfoNoturno);
        exercito.agruparPorStatus();
        assertEquals(elfoNoturno, exercito.buscar(Status.MORTO).get(0));
    }
    
    @Test
    public void elfoVivoEAgrupadoPeloSeuStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Moises");
        exercito.alistarElfo(elfoVerde);
        exercito.agruparPorStatus();
        assertEquals(elfoVerde, exercito.buscar(Status.VIVO).get(0));
    }
    
    @Test
    public void doisElfosVivosAgrupadosPorSeusStatus(){
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ElfoVerde elfoVerde = new ElfoVerde("Moises");
        ElfoNoturno elfoNoturno = new ElfoNoturno("Tyrande");
        exercito.alistarElfo(elfoVerde);
        exercito.alistarElfo(elfoNoturno);
        exercito.agruparPorStatus();
        assertEquals(elfoNoturno, exercito.buscar(Status.VIVO).get(0));
        assertEquals(elfoVerde, exercito.buscar(Status.VIVO).get(1));
    }
}
