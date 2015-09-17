

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ElfoTest{
    @Test
    public void elfoRecebeNomeEFlechasNoParametro(){
        Elfo f1 = new Elfo("Legolas", 15);
        assertEquals("Legolas", f1.getNome());
        assertEquals(15, f1.getFlechas());
    }
    
    @Test
    public void elfoRecebeSomenteNomeE42FlechasSaoDefault(){
        String nome = "Legolas";
        Elfo f1 = new Elfo(nome, 42);
        assertEquals(nome, f1.getNome());
        assertEquals(42, f1.getFlechas());
    }
    
    @Test
    public void elfoRecebeIntegerNoParametro(){
        String nome = "Taetokhan";
        Integer flechas = null;
        Integer arrow = 22;
        Elfo f1 = new Elfo(nome, flechas);
        Elfo f2 = new Elfo(nome, arrow);
        assertEquals(42, f1.getFlechas());
        assertEquals(22, f2.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaNoDwarf(){
        Elfo f1 = new Elfo("Taetokhan");
        int experiencia = 0;
        int flechas = 15;
        Dwarf d = new Dwarf();
        d.receberFlechada();
        flechas--;
        experiencia++;
        assertEquals(14, flechas);
        assertEquals(1, experiencia);
    }
    
    
}
