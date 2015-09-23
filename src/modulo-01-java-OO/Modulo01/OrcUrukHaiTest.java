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
        
        assertEquals(vidaEsperada, orcUrukHai.getVida());
        assertEquals(inventarioEsperado, orcUrukHai.getInventario());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeAnao(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        
        orcUrukHai.receberDano();
        
        assertEquals(144, orcUrukHai.getVida());
    }
    
    @Test
    public void orcUrukHaiRecebeDanoDeElfo(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        
        orcUrukHai.receberDano();
        
        assertEquals(144, orcUrukHai.getVida());
    }
}
