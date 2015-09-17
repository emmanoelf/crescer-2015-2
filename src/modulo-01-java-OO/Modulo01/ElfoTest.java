

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
    Elfo f1 = new Elfo("Legolas");
    Elfo f2 = new Elfo ("Taetokhan");
    Elfo f3 = new Elfo("Whenul", 15);
    Dwarf d = new Dwarf();
    Dwarf d1 = new Dwarf();
    @Test
    public void elfoRecebeNomeEFlechasNoParametro(){
        assertEquals("Whenul", f3.getNome());
        assertEquals(15, f3.getFlechas());
    }
    
    @Test
    public void elfoRecebeSomenteNomeE42FlechasSaoDefault(){
        assertEquals("Legolas", f1.getNome());
        assertEquals(42, f1.getFlechas());
    }
    
    
    @Test
    public void verificaSeNoToStringTemONomeDoElfo(){
        String texto = f2.toString();
        texto.contains("Taetokhan");
    }
    
    @Test
    public void umElfoAtirandoEm2Dwarfs(){
        f1.atirarFlecha(d);
        f1.atirarFlecha(d1);
        assertEquals(40, f1.getFlechas());
        assertEquals(2, f1.getExperiencia());
    }
    
    @Test
    public void doisElfosAtiramFlechasEm1Dwarf(){
        f1.atirarFlecha(d);
        f3.atirarFlecha(d);
        assertEquals(41, f1.getFlechas());
        assertEquals(14, f3.getFlechas());
        assertEquals(1, f1.getExperiencia());
        assertEquals(1, f3.getExperiencia());
    }
    
}
