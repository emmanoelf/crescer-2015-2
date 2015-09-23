import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class OrcSnagaTest{
    @Test
    public void criaSnaga(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        
        int vidaEsperada = 70;
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Arco",1));
        inventarioEsperado.adicionarItem(new Item("Flecha",5));
        
        assertEquals(vidaEsperada, orcSnaga.getVida());
        assertEquals(inventarioEsperado, orcSnaga.getInventario());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeAnao(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        
        orcSnaga.levarAtaqueDeAnao();
        
        assertEquals(60, orcSnaga.getVida());
    }
    
    @Test
    public void orcSnagaRecebeDanoDeElfo(){
        OrcSnaga orc = new OrcSnaga("Ukarggoth");
        
        orc.levarAtaqueDeElfo();
        
        assertEquals(62, orc.getVida());
    }
    
    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Elfo elfo = new Elfo(null);
        
        for(int i = 0; i < 6; i++){
            orcSnaga.atacarElfo(elfo);
        }
        
        assertEquals(Status.FUGINDO, orcSnaga.getStatus());
    }
    
    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){
    
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Elfo elfo = new Elfo(null);
        
        orcSnaga.atacarElfo(elfo);
        
        int qtdFlechas = orcSnaga.getInventario().getItemPorDescricao("Flecha").getQuantidade();
        
        assertEquals(4, qtdFlechas);
        
    }
    
}
