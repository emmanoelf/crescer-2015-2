import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.*;

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
    public void alistarElfosVerdesENoturnosAlistaTodos() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
    }
    
    @Test
    public void alistarElfosVerdesENoturnosAlistaTodosMenosBase() {
        // Arrange
        Elfo elfo = new ElfoNoturno("Night Legolas");
        Elfo elfo2 = new ElfoNoturno("Night Legolas 2");
        Elfo elfo3 = new ElfoVerde("Green Legolas");
        Elfo elfoBase = new Elfo("Normal Legolas");
        HashMap<String, Elfo> exercitoEsperado = new HashMap<>();
        exercitoEsperado.put(elfo.getNome(), elfo);
        exercitoEsperado.put(elfo2.getNome(), elfo2);
        exercitoEsperado.put(elfo3.getNome(), elfo3);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        exercito.alistarElfo(elfoBase);
        exercito.alistarElfo(elfo);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        // Assert
        HashMap<String, Elfo> obtido = exercito.getExercito();
        assertEquals(exercitoEsperado, obtido);
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
    public void buscarElfoAlistadoComVarios() {
        // Arrange
        String nomeElfo = "Legolas II";
        Elfo esperado = new ElfoVerde(nomeElfo);
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(esperado);
        exercito.alistarElfo(new ElfoVerde("green elf"));
        exercito.alistarElfo(new ElfoNoturno("Night Elf"));
        // Act
        Elfo obtido = exercito.buscar(nomeElfo);
        // Assert
        assertEquals(esperado, obtido);
    }
    
    @Test
    public void buscarElfoPeloNomeNãoAlistado() {
        // Arrange
        Elfo esperado = null;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        // Act
        Elfo obtido = exercito.buscar("John Elf Doe");
        // Assert
        assertEquals(esperado, obtido);
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
    
    @Test
    public void buscaElfosMortos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ElfoNoturno elfoMorto1 = new ElfoNoturno("Dead Elf 1");
        ElfoNoturno elfoMorto2 = new ElfoNoturno("Dead Elf 2");
        for (int i = 0; i < 90; i++) {
            elfoMorto1.atirarFlecha(new Dwarf(""));
            elfoMorto2.atirarFlecha(new Dwarf(""));
        }
        ArrayList<Elfo> mortosEsperados = new ArrayList<>(Arrays.asList(
                    elfoMorto2, elfoMorto1
                ));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfoVivo1);
        exercito.alistarElfo(elfoVivo2);
        exercito.alistarElfo(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        ArrayList<Elfo> mortos = exercito.buscar(Status.MORTO);
        // Assert
        assertEquals(mortosEsperados, mortos);
    }
    
    @Test
    public void buscaElfosVivos() {
        // Arrange
        ElfoVerde elfoVivo1 = new ElfoVerde("Green 1");
        ElfoNoturno elfoVivo2 = new ElfoNoturno("Aa");
        ElfoVerde elfoVivo3 = new ElfoVerde("BB");
        ArrayList<Elfo> vivosEsperado = new ArrayList<>(Arrays.asList(
                    elfoVivo2, elfoVivo3, elfoVivo1
                ));
        ElfoNoturno elfoMorto1 = new ElfoNoturno("Dead Elf 1");
        ElfoNoturno elfoMorto2 = new ElfoNoturno("Dead Elf 2");
        for (int i = 0; i < 90; i++) {
            elfoMorto1.atirarFlecha(new Dwarf(""));
            elfoMorto2.atirarFlecha(new Dwarf(""));
        }
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(elfoMorto1);
        exercito.alistarElfo(elfoMorto2);
        exercito.alistarElfo(elfoVivo1);
        exercito.alistarElfo(elfoVivo2);
        exercito.alistarElfo(elfoVivo3);
        // Act
        exercito.agruparPorStatus();
        ArrayList<Elfo> vivos = exercito.buscar(Status.VIVO);
        // Assert
        assertEquals(vivosEsperado, vivos);
    }
}
