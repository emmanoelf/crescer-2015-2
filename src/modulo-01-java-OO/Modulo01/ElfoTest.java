

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
    public void elfoComNomeEFlechas(){
        String nome = "abc";
        int flechas = 15;
        Elfo f1 = new Elfo(nome, flechas);
        assertEquals("abc", f1.getNome());
        assertEquals(15, f1.getFlechas());
    }
    
    @Test
    public void elfoComNomeE42Flechas(){
        String nome = "Legolas";
        Elfo f1 = new Elfo(nome, 42);
        assertEquals(nome, f1.getNome());
        assertEquals(42, f1.getFlechas());
    }
    
    @Test
    public void elfoComInteger(){
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
        int flechas = 15;
        int experiencia = 0;
        flechas--;
        experiencia++;
        Dwarf d = new Dwarf();
        d.receberFlechada();
        assertEquals(14, flechas);
        assertEquals(1, experiencia);
    }
    
    @Test
    public void elfoAtiraFlechaRefactory(){
        int experiencia = 32;
        int flechas = 95;
        boolean acertar = true;
        boolean acertaraux = false;
        if(acertaraux){
            experiencia++;
        }
        if(acertar){
            experiencia++;
        }
        flechas--;
        assertEquals(33, experiencia);
        assertEquals(94, flechas);
    }
    
}
