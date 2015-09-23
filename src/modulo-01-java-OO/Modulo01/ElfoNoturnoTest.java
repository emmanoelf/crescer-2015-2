import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest{
    
    @Test
    public void elfoNoturnoPerdeVidaQuandoAtaca(){
        ElfoNoturno en = new ElfoNoturno("Ermanoteu");
        Dwarf dwarf = new Dwarf("Dwarf");
        double vidaEsperada = 95.0;
        en.atirarFlecha(dwarf);
        assertEquals(vidaEsperada, en.getVida(), 0.1);
    }
    
    @Test
    public void verificaSeOElfoNoturnoPerdeVidaQuandoAtiraMaisDeUmaFlecha(){
        ElfoNoturno en = new ElfoNoturno("Ermanoteu");
        Dwarf dwarf = new Dwarf("Dwarf");
        double vidaEsperada = 90.25;
        en.atirarFlecha(dwarf);
        en.atirarFlecha(dwarf);
        assertEquals(vidaEsperada, en.getVida(), 0.1);
    }
    
    @Test
    public void elfoNoturnoGanha3DeExperienciaACadaAtaque(){
        ElfoNoturno en = new ElfoNoturno("Illidan");
        Dwarf dwarf = new Dwarf("Dwarf");
        int experienciaEsperada = 3;
        en.atirarFlecha(dwarf);
        assertEquals(experienciaEsperada, en.getExperiencia());
    }
    
    @Test
    public void elfoNoturnoMorreAtirandoFlechas(){
        ElfoNoturno en = new ElfoNoturno("Sylvannas");
        Dwarf dwarf = new Dwarf("Dwarf");
        Status statusEsperado = Status.MORTO;
        for(int i = 0; i < 90; i++){
            en.atirarFlecha(dwarf);
        }
        assertEquals(0, en.getVida(), 0.5);
        assertEquals(statusEsperado, en.getStatus());
    }
}
