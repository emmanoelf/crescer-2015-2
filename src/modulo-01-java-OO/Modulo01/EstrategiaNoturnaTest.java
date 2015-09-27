import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNoturnaTest{

    @Test
    public void exercitoDeElfosAtaca(){
        Dwarf d1 = new Dwarf("Muradin");
        Dwarf d2 = new Dwarf("Falstad");
        Elfo e1 = new ElfoVerde("Verdonildo");
        Elfo e2 = new ElfoNoturno("Tyrande");
        Elfo e3 = new ElfoVerde("Verdonildo Segundo");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        ArrayList<Dwarf> dwarves = new ArrayList<>();
        int vidaEsperada = 80;
        ArrayList<Elfo> ordemAtaqueEsperada = new ArrayList<>(Arrays.asList(e1, e3));
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        dwarves.add(d1);
        dwarves.add(d2);
        exercito.atacar(dwarves);
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
    }
    
    @Test
    public void quatroElfos3Noturnos1VerdeAtacam2DwarvesMasSo2NoturnosPodemAtacar(){
        Dwarf d1 = new Dwarf("Muradin");
        Dwarf d2 = new Dwarf("Falstad");
        double vidaEsperada = 80;
        Elfo e1 = new ElfoNoturno("Tyrande");
        Elfo e2 = new ElfoNoturno("Tyrande Segunda");
        Elfo e3 = new ElfoNoturno("Tyrande Terceira");
        Elfo e4 = new ElfoVerde("Veronilda");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaNoturna());
        exercito.alistarElfo(e1);
        exercito.alistarElfo(e2);
        exercito.alistarElfo(e3);
        exercito.alistarElfo(e4);
        exercito.atacar(new ArrayList<>(Arrays.asList(d1, d2)));
        ArrayList<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        int noturnosQueAtiraram = 0;
        for(Elfo elfo : ordemAtaque){
            if(elfo instanceof ElfoNoturno){
                noturnosQueAtiraram++;
            }
        }
        assertEquals(2, noturnosQueAtiraram);
        assertEquals(vidaEsperada, d1.getVida(), 0.0);
        assertEquals(vidaEsperada, d2.getVida(), 0.0);
    } 
    
    @Test
    public void quatroElfos3NoturnosSendoUmMortoE1VerdeAtacam2AnoesMasSo1NoturnoPodeAtacar() {
        Dwarf balin = new Dwarf("Falstad");
        Dwarf stalin = new Dwarf("Muradin");
        double vidaEsperada = 90;
        Elfo noturno1 = new ElfoNoturno("Tyrande");
        Elfo noturno2 = new ElfoNoturno("Tyrande Segunda");
        Elfo noturno3 = new ElfoNoturno("Tyrande Terceira");
        for (int i = 0; i<90; i++) {
            noturno3.atirarFlecha(new Dwarf("Falstad"));
        }
        Elfo verde1 = new ElfoVerde("Green 1");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new EstrategiaNoturna());
        exercito.alistarElfo(noturno1);
        exercito.alistarElfo(noturno2);
        exercito.alistarElfo(noturno3);
        exercito.alistarElfo(verde1);
        exercito.atacar(new ArrayList<>(Arrays.asList(balin, stalin)));
        ArrayList<Elfo> ordemAtaques = exercito.getOrdemDoUltimoAtaque();
        int noturnosQueAtiraram = 0;
        for (Elfo elfo : ordemAtaques) {
            if (elfo instanceof ElfoNoturno) {
                noturnosQueAtiraram++;
            }
        }
        assertEquals(1, noturnosQueAtiraram);
        assertEquals(vidaEsperada, balin.getVida(), .0);
        assertEquals(vidaEsperada, stalin.getVida(), .0);
    }
}
