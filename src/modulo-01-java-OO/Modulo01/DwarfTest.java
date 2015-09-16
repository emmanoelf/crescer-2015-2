

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest{
    
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void testaDanoFlechada(){
        Dwarf d = new Dwarf();
        int aux1 = d.getVida();
        d.receberFlechada();
        int aux2 = d.getVida();
        int aux3 = aux2-aux1;
        assertEquals(-10, aux3);
    }
}