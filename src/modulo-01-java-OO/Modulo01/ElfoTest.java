

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
    public void elfoCriadoComNomeEMuitasFlechas(){
        Elfo f4 = new Elfo("Jubileu", 2345);
        assertEquals(2345, f4.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNomeEDevendoFlechas(){
        Elfo f4 = new Elfo("Jubileu", -765);
        assertEquals(-765, f4.getFlechas());
    }
    
    @Test
    public void elfoRecebeSomenteNomeE42FlechasSaoDefault(){
        assertEquals("Legolas", f1.getNome());
        assertEquals(42, f1.getFlechas());
    }
    
    @Test
    public void elfoCriadoComNull(){
        Elfo f4 = new Elfo(null);
        assertNull(f4.getNome());
    }
    
    @Test
    public void elfoCriadoVazio(){
        Elfo f4 = new Elfo("");
        assertEquals("",f4.getNome());
    }
    
    @Test
    public void elfoCriadoCom0DeExperiencia(){
        Elfo f4 = new Elfo("Jubileu");
        assertEquals(0, f4.getExperiencia());
    }
    
    @Test
    public void verificaSeNoToStringTemONomeDoElfo(){
        String texto = f2.toString();
        texto.contains("Taetokhan");
    }
    
    @Test
    public void umElfoAtirandoEm2Dwarves(){
        //Arrange
        Elfo f4 = new Elfo("Elfo Caçador");
        Dwarf d7 = new Dwarf();
        Dwarf d8 = new Dwarf();
        int qntEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 100;
        //Act
        f4.atirarFlecha(d7);
        f4.atirarFlecha(d8);
        //Asserts
        assertEquals(qntEsperada, f4.getFlechas());
        assertEquals(experienciaEsperada, f4.getExperiencia());
        assertEquals(vidaEsperada, d7.getVida());
        assertEquals(vidaEsperada, d8.getVida());
    }
    
    @Test
    public void doisElfosAtiramEmDoisDwarves(){
        //Arrange
        Elfo f4 = new Elfo("Elfo Caçador");
        Elfo f5 = new Elfo("Segundo Elfo");
        Dwarf d7 = new Dwarf();
        Dwarf d8 = new Dwarf();
        int qntEsperada = 40;
        int vidaEsperada = 90;
        int experienciaEsperada = 2;
        //Act
        f4.atirarFlecha(d7);
        f4.atirarFlecha(d8);
        f5.atirarFlecha(d7);
        f5.atirarFlecha(d8);
        //Asserts
        assertEquals(qntEsperada, f4.getFlechas());
        assertEquals(experienciaEsperada, f4.getExperiencia());
        assertEquals(qntEsperada, f5.getFlechas());
        assertEquals(experienciaEsperada, f5.getExperiencia());
        assertEquals(vidaEsperada, d7.getVida());
        assertEquals(vidaEsperada, d8.getVida());
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
