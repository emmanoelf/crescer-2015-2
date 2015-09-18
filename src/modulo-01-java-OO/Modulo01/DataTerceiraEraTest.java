
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest{
    
    @Test
    public void dia15DeAbrilDe2003(){
        DataTerceiraEra dte = new DataTerceiraEra(15,4,2003);
        assertEquals(15, dte.getDia());
        assertEquals(4, dte.getMes());
        assertEquals(2003, dte.getAno());
    }
    
    @Test
    public void ano2008EhBissexto(){
        boolean bissexto;
        bissexto = new DataTerceiraEra(5,9,2008).ehBissexto();
        assertTrue(bissexto);
    }
    
    @Test
    public void ano2011NaoEhBissexto(){
        boolean bissexto;
        bissexto = new DataTerceiraEra(19,11,2011).ehBissexto();
        assertFalse(bissexto);
    }
}
