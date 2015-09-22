import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrcTest{
    @Test
    public void orcNasceVivoEComVida130(){
        Orc orc = new Orc();
        int vidaEsperada = 130;
        assertEquals(Status.VIVO, orc.getStatus());
        assertEquals(vidaEsperada, orc.getVida());
    }
    
}
