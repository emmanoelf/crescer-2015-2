

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
    Dwarf d = new Dwarf("Ermanoteu");
    Dwarf d1 = new Dwarf("Ermanoteia");
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
    
    public void elfoComNomeEFlechasInformadoToString(){
        Elfo f4 = new Elfo("Acabaram os nomes", 1000);
        String textoEsperado = "Acabaram os nomes, possui 1000 flechas e 0 niveis de experiência.";
        assertEquals(textoEsperado, f4.toString());
    }
    
    public void elfoComUmaFlechaInformadaToString(){
        Elfo f4 = new Elfo("MonoFlecha");
        String textoEsperado = "Monoflecha possui 1 flecha e 0 niveis de experiência.";
        assertEquals(textoEsperado, f4.toString());
    }
    
    @Test
    public void elfoComUmDeExperienciaToString(){
        Elfo elfo1 = new Elfo(null);
        elfo1.atirarFlecha(new Dwarf("Trasgo"));
        String textoEsperado = "null possui 41 flechas e 1 nível de experiência.";
        assertEquals(textoEsperado, elfo1.toString());
    }
    
    @Test
    public void umElfoAtirandoEm2Dwarves(){
        //Arrange
        Elfo f4 = new Elfo("Elfo Caçador");
        Dwarf d7 = new Dwarf("Khahrim");
        Dwarf d8 = new Dwarf("Linglo");
        int qntEsperada = 40;
        int experienciaEsperada = 2;
        int vidaEsperada = 100;
        //Act
        f4.atirarFlecha(d7);
        f4.atirarFlecha(d8);
        //Asserts
        assertEquals(qntEsperada, f4.getFlechas());
        assertEquals(experienciaEsperada, f4.getExperiencia());
        assertEquals(vidaEsperada, d7.getVida(), 0.5);
        assertEquals(vidaEsperada, d8.getVida(), 0.5);
    }
    
    @Test
    public void doisElfosAtiramEmDoisDwarves(){
        //Arrange
        Elfo f4 = new Elfo("Elfo Caçador");
        Elfo f5 = new Elfo("Segundo Elfo");
        Dwarf d7 = new Dwarf("Khahrim");
        Dwarf d8 = new Dwarf("Linglo");
        int qntEsperada = 40;
        int vidaEsperada = 90;
        int experienciaEsperada = 2;
        //Act
        f4.atirarFlecha(d7);
        f4.atirarFlecha(d8);
        f5.atirarFlecha(d7);
        f5.atirarFlecha(d8);
        //Asserts
        assertEquals(qntEsperada, f4.getFlechas(), 0.1);
        assertEquals(experienciaEsperada, f4.getExperiencia());
        assertEquals(qntEsperada, f5.getFlechas());
        assertEquals(experienciaEsperada, f5.getExperiencia());
        assertEquals(vidaEsperada, d7.getVida(), 0.1);
        assertEquals(vidaEsperada, d8.getVida(), 0.1);
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
    
    @Test
    public void elfoNasceVivo(){
        Elfo legolas = new Elfo("Legolas");
        assertEquals(Status.VIVO, legolas.getStatus());
    }
   
    @Test
    public void elfoRecebeEspadadaDoOrcUrukHai(){
        OrcUrukHai orc = new OrcUrukHai("");
        Elfo elfo = new Elfo(null);
        
        orc.atacarPersonagem(elfo);
        
        assertEquals(88, elfo.getVida(), 0.1);
    }
    
    @Test
    public void elfoRecebeFlechadaDoOrcSnaga(){
        OrcSnaga orc = new OrcSnaga("Ukarggoth");
        Elfo elfo = new Elfo(null);
        
        orc.atacarPersonagem(elfo);
        
        assertEquals(92, elfo.getVida(), 0.1);
    }
    
    @Test
    public void verificaContador(){
        int esperado = 1+ Elfo.getContadorDeELfos();
        Elfo f = new Elfo("Legolas");
        assertEquals(esperado, Elfo.getContadorDeELfos());
    }
    /*
    @Before
    public void setUp(){
        Elfo.resetaContador();
    }
    */
}
