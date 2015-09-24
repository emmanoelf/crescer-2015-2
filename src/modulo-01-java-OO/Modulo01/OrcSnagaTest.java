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

        assertEquals(vidaEsperada, orcSnaga.getVida(), 0.1);
        assertEquals(inventarioEsperado, orcSnaga.getInventario());
    }

    @Test
    public void orcSnagaRecebeDanoDeAnao(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");

        orcSnaga.receberDano();

        assertEquals(60, orcSnaga.getVida(), 0.1);
    }

    @Test
    public void orcSnagaRecebeDanoDeElfo(){
        OrcSnaga orc = new OrcSnaga("Ukarggoth");

        orc.receberDano();

        assertEquals(60, orc.getVida(), 0.1);
    }

    @Test
    public void orcSnagaFicaSemFlechasParaAtirarEFoge(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Elfo elfo = new Elfo(null);

        for(int i = 0; i < 6; i++){
            orcSnaga.atacarPersonagem(elfo);
        }

        assertEquals(Status.FUGINDO, orcSnaga.getStatus());
    }

    @Test
    public void orcSnagaAtiraFlechaEmElfoEFicaCom4Flechas(){

        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Elfo elfo = new Elfo(null);

        orcSnaga.atacarPersonagem(elfo);

        int qtdFlechas = orcSnaga.getInventario().getItemPorDescricao("Flecha").getQuantidade();

        assertEquals(4, qtdFlechas);

    }
    
    @Test
    public void orcSnagaRecebe6DeDanoPorqueGanhouUmEscudo(){
        Orc orc = new OrcSnaga("Zogshagbu");
        orc.adicionarItem(new Item("Escudo Uruk-Hai",1));
        orc.receberDano();
        assertEquals(64, orc.getVida(), 0.0);
    }

    @Test
    public void orcSnagaAtacaDwarf(){
        OrcSnaga orcS = new OrcSnaga("Zogshagbu");
        Dwarf d1 = new Dwarf("Bathudha");
        int vidaEsperada = 102;
        orcS.atacarPersonagem(d1);
        assertEquals(vidaEsperada, d1.getVida(), 0.1);
    }

    @Test
    public void orcSnagaAtacaElfo(){
        OrcSnaga orcS = new OrcSnaga("Zogshagbu");
        Elfo f1 = new Elfo ("Nasfinlan");
        int vidaEsperada = 92;
        orcS.atacarPersonagem(f1);
        assertEquals(vidaEsperada, f1.getVida(), 0.1);
    }
    
    @Test
    public void orcSnagaCausa12DeDanoEmElfoPorqueGanhouUmaEspadaEAtacou(){
        Orc orc = new OrcSnaga("Zogshagbu");
        orc.adicionarItem(new Item("Espada", 1));
        Elfo legolas = new Elfo("Legolas");
        double vidaEsperada = 88;
        orc.atacarPersonagem(legolas);
        assertEquals(vidaEsperada, legolas.getVida(), 0.0);
    }
    
    @Test
    public void orcSnagaFogePorqueNaoTemArmaParaAtacar(){
        Orc orc = new OrcSnaga("Zogshagbu");
        orc.removerItem(new Item("Arco", 1));
        orc.removerItem(new Item("Flecha", 5));
        Elfo legolas = new Elfo("Legolas");
        double vidaEsperada = 100;
        orc.atacarPersonagem(legolas);
        assertEquals(Status.FUGINDO, orc.getStatus());
        assertEquals(vidaEsperada, legolas.getVida(), 0.0);
    }
    
    @Test
    public void orcSnagaRecebeAtaqueDeUrukHai(){
        Orc snaga = new OrcSnaga("Zogshagbu");
        Orc urukHai = new OrcUrukHai("Uruk");       
        snaga.receberAtaqueDoOrc(urukHai);   
        assertEquals(60, snaga.getVida(), 0.0);
    }

    @Test
    public void orcSnagaMorre(){
        OrcSnaga orcS = new OrcSnaga("Zogshagbu");
        int vidaEsperada = 0;
        for(int i = 0; i < 7; i++){
            orcS.receberDano();
        }
        assertEquals(vidaEsperada, orcS.getVida(), 0.1);
        assertEquals(Status.MORTO, orcS.getStatus());
    }
}
