import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest{
    @Test
    public void irishDwarfTentaASorteEGanha(){
        IrishDwarf id = new IrishDwarf("Ermanoteu", new DataTerceiraEra(7,5,2004));
        id.getInventario().adicionarItem(new Item("Machado de duas mãos", 3));
        id.receberFlechada();
        id.receberFlechada();
        id.receberFlechada();
        id.tentarSorte();
        assertEquals(6009, id.getInventario().getItens().get(0).getQuantidade());
    }
    
    }
