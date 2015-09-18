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
}
