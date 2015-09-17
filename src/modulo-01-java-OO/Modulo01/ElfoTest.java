

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
    public void elfoAtiraFlechaNoDwarfGanhaExperienciaEPerdeFlechas(){
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
    
    @Test
    public void verificaSeNoToStringTemONomeDoElfo(){
        Elfo f1 = new Elfo("Taetokhan");
        String texto = f1.toString();
        texto.contains("Taetokhan");
    }
    
}
