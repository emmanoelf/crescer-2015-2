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
    
    @Test
    public void orcUrukHaiPerdeEspadaEAtacaComArcoQueGanhouEUmaFlecha(){
        Orc orc = new OrcUrukHai("Thosburogg");
        Dwarf anao = new Dwarf("Falstad");
        orc.removerItem(new Item("Espada", 1));
        orc.adicionarItem(new Item("Arco", 1));
        orc.adicionarItem(new Item("Flecha", 1));
        Inventario inventarioEsperado = new Inventario();
        inventarioEsperado.adicionarItem(new Item("Escudo Uruk-Hai", 1));
        inventarioEsperado.adicionarItem(new Item("Arco", 1));
        orc.atacarPersonagem(anao);
        assertEquals(102, anao.getVida(), 0.0);
        assertEquals(inventarioEsperado, orc.getInventario());
    }
    
    @Test
    public void orcUrukHaiFogePorqueNaoTemArmaParaAtacar(){
        Orc orc = new OrcUrukHai("Thosburogg");
        orc.removerItem(new Item("Espada", 1));
        Elfo legolas = new Elfo("Legolas");
        double vidaEsperada = 100;
        orc.atacarPersonagem(legolas);
        assertEquals(Status.FUGINDO, orc.getStatus());
        assertEquals(vidaEsperada, legolas.getVida(), 0.0);
    }
    
    @Test
    public void orcUrukHaiRecebeAtaqueDeUrukHai(){
        Orc urukHaiAlvo = new OrcUrukHai("Thosburogg");
        Orc urukHaiAtacante = new OrcUrukHai("Muradin");
        urukHaiAlvo.receberAtaqueDoOrc(urukHaiAtacante);
        assertEquals(urukHaiAlvo.getVida(), 144, 0.0);
    }
    
    @Test
    public void orcUrukHaiRecebeAtaqueDeSnaga(){
        Orc urukHaiAlvo = new OrcUrukHai("Thosburogg");
        Orc snagaAtacante = new OrcSnaga("Falstad");
        urukHaiAlvo.receberAtaqueDoOrc(snagaAtacante);
        assertEquals(urukHaiAlvo.getVida(), 144, 0.0);
    }
}
