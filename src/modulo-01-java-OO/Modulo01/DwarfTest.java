

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
    
    Dwarf d = new Dwarf();
    
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf();
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void reduz10DeVidaAposFlechada(){
        int aux1 = d.getVida();
        d.receberFlechada();
        int aux2 = d.getVida();
        int aux3 = aux2-aux1;
        assertEquals(-10, aux3);
    }
    
    @Test
    public void verificaSeDwarfTomouDano(){
        d.receberFlechada();
        assertEquals(100, d.getVida());
    }
    
    @Test
    public void dwarfRecebe11FlechadasEVidaÉ0(){
        int vidaEsperada = 0;
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        assertEquals(0, d.getVida());
    }
    
    @Test
    public void dwarfRecebe7FlechadasEVidaÉ40(){
        int vidaEsperada = 40;
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        assertEquals(40, d.getVida());
    }
    
    @Test
    public void dwarfMorreAoAtingir0DeVida(){
       int vidaEsperada = 110;
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       assertEquals(0, d.getVida());
    }
}