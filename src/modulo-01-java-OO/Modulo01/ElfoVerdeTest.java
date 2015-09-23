import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void elfoVerdeAtacaUmDwarf() {
        ElfoVerde green = new ElfoVerde("Fandango");
        green.atirarFlecha(new Dwarf("Virgulino"));

        assertEquals(2, green.getExperiencia());
    }

    @Test
    public void elfoVerdeAtacaUmDwarfEIrishDwarf() {
        ElfoVerde green = new ElfoVerde("Green Elf");
        Dwarf common = new Dwarf("Common Dwarf");
        IrishDwarf irish = new IrishDwarf("Virgulino");
        green.atirarFlecha(irish);
        green.atirarFlecha(common);
        assertEquals(4, green.getExperiencia());
    }

    @Test
    public void elfoVerdeAdicionaEspadaValiriana() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        sortudo.adicionarItem(new Item("Espada de aço valiriano", 1));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada de aço valiriano", 1));
        assertEquals(esperado, sortudo.getInventario());
    }

    @Test
    public void elfoVerdeAdicionaItemComDescricaoInvalida() {
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        sortudo.adicionarItem(new Item("Molejão", 1));
        Inventario esperado = new Inventario();
        assertEquals(esperado, sortudo.getInventario());
    }

    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroENulo() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        sortudo.adicionarItem(new Item("Arco e Flecha de Vidro", 1));
        sortudo.adicionarItem(null);
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco e Flecha de Vidro", 1));
        assertEquals(esperado, sortudo.getInventario());
    }
    
    @Test
    public void elfoVerdeAdicionaArcoEFlechaVidroEDescricaoNula() {
        ElfoVerde sortudo = new ElfoVerde("Celeborn");
        sortudo.adicionarItem(new Item("Arco e Flecha de Vidro", 1));
        sortudo.adicionarItem(new Item(null, 1));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco e Flecha de Vidro", 1));
        assertEquals(esperado, sortudo.getInventario());
    }

}