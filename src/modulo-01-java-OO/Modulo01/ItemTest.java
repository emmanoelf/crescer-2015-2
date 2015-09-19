import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest{
    
    @Test
    public void itemSendoCriado(){
        Item i = new Item("Adaga", 2);
        assertEquals("Adaga", i.getDescricao());
        assertEquals(2, i.getQuantidade());
    }
    
    @Test
    public void itemCriadoComQuantidadeNegativa(){
        Item i = new Item("Potion", -5);
        int quantidadeEsperada = -5;
        assertEquals(quantidadeEsperada, i.getQuantidade());
    }
    
    @Test
    public void itemCriadoComDescricaoNull(){
        Item i = new Item(null, 9);
        assertEquals(null, i.getDescricao());
    }
}
