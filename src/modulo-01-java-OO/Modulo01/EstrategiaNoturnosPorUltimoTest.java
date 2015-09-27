import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnosPorUltimoTest{
   
    @Test
    public void doisElfosVerdesAtacamPrimeiroDoQueOs3ElfosNoturnos(){
        Elfo e1 = new ElfoVerde("Verdoncio");
        Elfo e2 = new ElfoVerde("Verdoncio Segundo");
        Elfo en1 = new ElfoNoturno("Tyrande");
        Elfo en2 = new ElfoNoturno("Tyrande Segunda");
        Elfo en3 = new ElfoNoturno("Tyrande Terceira");
        ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(e1,e2,en2,en1,en3));
        int vidaEsperada = 60;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(en2);
        exercito.alistarElfo(en3);
        exercito.alistarElfo(en1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e1);
        Dwarf d1 = new Dwarf("Muradin");
        Dwarf d2 = new Dwarf("Falstad");
        ArrayList<Dwarf> dwarves = new ArrayList<>(Arrays.asList(d1, d2));
        exercito.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
        exercito.atacar(dwarves);
        assertEquals(ordemEsperada, exercito.getEstrategia().getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
    }
    
    @Test
    public void quatroElfosVerdesAtacamPrimeiroQue2Noturnos(){
        Elfo e1 = new ElfoVerde("Verdonildo");
        Elfo e2 = new ElfoVerde("Verdonildo Segundo");
        Elfo e3 = new ElfoVerde("Verdonildo Terceiro");
        Elfo e4 = new ElfoVerde("Verdonildo Quarto");
        Elfo en = new ElfoNoturno("Tyrande");
        Elfo en2 = new ElfoNoturno("Tyrande Segunda");
        ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(e2,e1,e4,e3,en2,en));
        int vidaEsperada = 50;
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistarElfo(en2);
        exercito.alistarElfo(en);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e4);
        exercito.alistarElfo(e3);
        Dwarf d1 = new Dwarf("Muradin");
        Dwarf d2 = new Dwarf("Falstad");
        ArrayList dwarves = new ArrayList<>(Arrays.asList(d1,d2));
        exercito.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
        exercito.atacar(dwarves);
        assertEquals(ordemEsperada, exercito.getEstrategia().getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
    }
}
