import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class InventarioTest{
    
    @Test
    public void adicionandoUmItemNoInventario(){
        Item i = new Item("Adaga", 4);
        Inventario inv = new Inventario();
        inv.adicionarItem(i);
        assertEquals(i, inv.getItens().get(0));
    }
    
    @Test
    public void adicionandoUmItemComQuantidadeNegativaNoInventario(){
        Item i = new Item("Daibo", -2);
        Inventario inv = new Inventario();
        inv.adicionarItem(i);
        assertEquals(i, inv.getItens().get(0));
    }
    
    @Test
    public void adicionandoVariosItensNoInventario(){
        Item i1 = new Item("Adaga", 3);
        Item i2 = new Item("Besta de duas mãos", 5);
        Item i3 = new Item("Cajado", 2);
        Inventario inv = new Inventario();
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        assertEquals(i1, inv.getItens().get(0));
        assertEquals(i2, inv.getItens().get(1));
        assertEquals(i3, inv.getItens().get(2));
    }
    
    @Test
    public void adiciona2ItensNoInventarioEPerde1(){
        Item i1 = new Item("Kevlar", 3);
        Item i2 = new Item("Capacete desgastado", 5);
        Inventario inv = new Inventario();
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.perderItem(i1);
        assertEquals(i2, inv.getItens().get(0));
    }
    
     @Test
    public void variosItensNoInventarioSaoSeparadosPorVirgula(){
        Inventario inv = new Inventario();
        Item i1 = new Item("Escudo", 2);
        Item i2 = new Item("Daibo", 1);
        Item i3 = new Item("Aljava", 4);
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        String retornoEsperado = "Escudo,Daibo,Aljava";
        assertEquals(retornoEsperado, inv.getDescricoesItens());
    }
    
    @Test
    public void procuraOItemComMaiorQuantidadeNoInventario(){
        Inventario inv = new Inventario();
        Item i1 = new Item("Adaga", 500);
        Item i2 = new Item("Kukri", 1);
        Item i3 = new Item("Cinto", 30);
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        int quantidadeEsperada = 500;
        assertEquals(quantidadeEsperada, inv.getItemComMaiorQuantidade().getQuantidade());
    }
    
    @Test
    public void procuraOItemComMenorQuantidadeNegativa(){
        Inventario inv = new Inventario();
        Item i1 = new Item("Kevlar", -2);
        Item i2 = new Item("Cloth armor", -3);
        Item i3 = new Item("Frostmourne", -1);
        Item i4 = new Item("Shadowmourne", -6);
        inv.adicionarItem(i1);
        inv.adicionarItem(i2);
        inv.adicionarItem(i3);
        inv.adicionarItem(i4);
        int quantidadeEsperada = -1;
        assertEquals(quantidadeEsperada, inv.getItemComMaiorQuantidade().getQuantidade());
    }
}
