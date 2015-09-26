import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNormalTest
{

    @Test
    public void exercitoDe1ElfoAtacaHordaDe2Dwarves() {
        Dwarf d1 = new Dwarf("Muradin");
        Dwarf d2 = new Dwarf("Falstad");
        ArrayList<Dwarf> hordaInimiga = new ArrayList<Dwarf>(Arrays.asList(d1,d2));
        Elfo e1 = new ElfoVerde("Verdonildo");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 100;
        exercito.alistarElfo(e1);
        exercito.atacar(hordaInimiga);
        assertEquals(new ArrayList<Elfo>(Arrays.asList(e1)), exercito.getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
    }

    @Test
    public void exercitoDe3ElfosAtacamHordaDe3Dwarves(){
        Dwarf d1 = new Dwarf("Falstad");
        Dwarf d2 = new Dwarf("Muradin");
        Dwarf d3 = new Dwarf("Dwarf");
        ArrayList<Dwarf> hordaInimiga = new ArrayList<Dwarf>(Arrays.asList(d1,d2,d3));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Elfo e1 = new ElfoVerde("Verdonildo");
        Elfo e2 = new ElfoVerde("Verdonildo Segundo");
        Elfo e3 = new ElfoVerde("Verdonildo Terceiro");
        double vidaEsperada = 80;
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        exercito.atacar(hordaInimiga);
        assertEquals(new ArrayList<Elfo>(Arrays.asList(e1,e2,e3)), exercito.getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
        assertEquals(vidaEsperada, d3.getVida(), 0.0);
    }

    @Test
    public void estrategia3Elfos2Dwarves() {
        Dwarf d1 = new Dwarf("Falstad");
        Dwarf d2 = new Dwarf("Muradin");
        ArrayList<Dwarf> hordaInimiga = new ArrayList<Dwarf>(Arrays.asList(d1, d2));
        Elfo e1 = new ElfoVerde("Green Elf 1");
        Elfo e2 = new ElfoNoturno("Green Elf 2");
        Elfo e3 = new ElfoVerde("Green Elf 3");
        Elfo e4 = new ElfoNoturno("Tyrande");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 70;
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        exercito.alistarElfo(e4);
        exercito.atacar(hordaInimiga);
        assertEquals(new ArrayList<Elfo>(Arrays.asList(e4, e3, e2, e1)), exercito.getOrdemDoUltimoAtaque());
        assertEquals(vidaEsperada, d1.getVida(), .0);
        assertEquals(vidaEsperada, d2.getVida(), .0);
    }

    @Test
    public void duasOndasDeAtaqueCom3ElfosE1Dwarf(){
        Dwarf d1 = new Dwarf("Falstad");
        ArrayList<Dwarf> hordaInimiga = new ArrayList<Dwarf>(Arrays.asList(d1));
        Elfo e1 = new ElfoNoturno("Tyrande");
        Elfo e2 = new ElfoVerde("Verdonildo");
        Elfo e3 = new ElfoVerde("Verdonildo Segundo");
        ArrayList<Elfo> esperado = new ArrayList<Elfo>(Arrays.asList(e3,e2,e1));
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        double vidaEsperada = 50;
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        exercito.atacar(hordaInimiga);
        exercito.atacar(hordaInimiga);
        ArrayList<Elfo> historico = exercito.getOrdemDoUltimoAtaque();
        for(Elfo elfo : esperado){
            assertTrue(historico.contains(elfo));
        }
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
    }

}

