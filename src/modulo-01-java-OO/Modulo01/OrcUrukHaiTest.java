import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcUrukHaiTest{
    @Test
    public void criaUrukHai(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        
        int vidaEsperada = 150;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Escudo Uruk-Hai",1));
        inventarioEsperado.adicionarItem(new Item("Espada",1));
        
        assertEquals(vidaEsperada, orcUrukHai.getVida(), 0.1);
        assertEquals(inventarioEsperado, orcUrukHai.getInventario());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeAnao(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        
        orcUrukHai.receberDano();
        
        assertEquals(144, orcUrukHai.getVida(), 0.1);
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeElfo(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        
        orcUrukHai.receberDano();
        
        assertEquals(144, orcUrukHai.getVida(), 0.1);
    }
    
    @Test
    public void orcUrukHaiMorre(){
        OrcUrukHai orcUH = new OrcUrukHai("Thosburogg");
        int vidaEsperada = 0;
        for(int i = 0; i <25; i++){
            orcUH.receberDano();
        }
        assertEquals(vidaEsperada, orcUH.getVida(), 0.1);
        assertEquals(Status.MORTO, orcUH.getStatus());
   }
   
   @Test
   public void orcUrukHaiAtacaElfo(){
       OrcUrukHai orcUH = new OrcUrukHai("Thosburogg");
       Elfo f1 = new Elfo("Legolas");
       int vidaEsperada = 88;
       orcUH.atacarPersonagem(f1);
       assertEquals(vidaEsperada, f1.getVida(), 0.1);
    }
    
    @Test
    public void orcUrukHaiAtacaDwarf(){
        OrcUrukHai orcUH = new OrcUrukHai("Thosburogg");
        Dwarf d1 = new Dwarf("Amaterasu");
        int vidaEsperada = 98;
        orcUH.atacarPersonagem(d1);
        assertEquals(vidaEsperada, d1.getVida(), 0.1);
    }
}
