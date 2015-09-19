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
}
