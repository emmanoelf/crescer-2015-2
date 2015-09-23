

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest{
    
    Dwarf d = new Dwarf("Moddar");
    
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimli = new Dwarf("Gimli");
        assertEquals(110, gimli.getVida());
    }
    
    @Test
    public void reduz10DeVidaAposFlechada(){
        int aux1 = d.getVida();
        d.receberFlechada();
        int aux2 = d.getVida();
        int aux3 = aux2-aux1;
        assertEquals(-10, aux3);
    }
    
    @Test
    public void verificaSeDwarfTomouDano(){
        d.receberFlechada();
        assertEquals(100, d.getVida());
    }
    
    @Test
    public void dwarfRecebe11FlechadasEVidaÉ0(){
        int vidaEsperada = 0;
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        assertEquals(0, d.getVida());
    }
    
    @Test
    public void dwarfRecebe7FlechadasEVidaÉ40(){
        int vidaEsperada = 40;
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        assertEquals(40, d.getVida());
    }
    
    @Test
    public void dwarfMorreAoAtingir0DeVidaNaoAlteraParaVidaNegativa(){
       int vidaEsperada = 0;
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       d.receberFlechada();
       //tem uma flechada a mais e mesmo assim ele retorna 0
       assertEquals(vidaEsperada, d.getVida());
    }
    
    @Test
    public void dwarfNasceVivo(){
        Dwarf d = new Dwarf("Ermanoteu");
        assertEquals(Status.VIVO, d.getStatus());
    }
    
    @Test
    public void dwarfNasceEmDiaNegativo(){
        DataTerceiraEra dataNascimento = new DataTerceiraEra(-13,2,2003);
        Dwarf d = new Dwarf("Ermanotéia", dataNascimento);
        assertEquals(-13, dataNascimento.getDia());
        assertEquals(2, dataNascimento.getMes());
        assertEquals(2003, dataNascimento.getAno());
    }
    
    @Test
    public void dwarfNasceComDataDefault(){
        DataTerceiraEra dte = new DataTerceiraEra(1,1,1);
        Dwarf d = new Dwarf("Gimli");
        assertEquals(1, dte.getDia());
        assertEquals(1, dte.getMes());
        assertEquals(1, dte.getAno());
    }
    
    @Test
    public void dwarfNasceComONomeDeMeirelesEGetNumeroSorte(){
        Dwarf m = new Dwarf("Meireles");
        assertEquals(33.0, m.getNumeroSorte(), 1.0);
    }
    
    @Test
        public void dwarfNasceEmAnoNaoBissextoEGetNumeroSorte(){
        Dwarf d = new Dwarf("Gimli");
        assertEquals(101.0, d.getNumeroSorte(), 1.0);
    }
    
    @Test
    public void dwarfNasceEmAnoBissextoEGetNumeroSorte(){
        Dwarf d = new Dwarf("Dwarf", new DataTerceiraEra(15,9,2012));
        assertEquals(101.0, d.getNumeroSorte(), 1.0);
    }
        
     @Test
    public void dwarfNasceComDataEmAnoBissextoToma5FlechadasVerificaVidaEExperiencia(){
        Dwarf s = new Dwarf("Dwarf", new DataTerceiraEra(15,7,2008));//"Seixas"
        s.receberFlechada();
        s.receberFlechada();
        s.receberFlechada();
        s.receberFlechada();
        s.receberFlechada();
        assertEquals(90, s.getVida());
        assertEquals(6, s.getExperiencia());
    }
    
    @Test
    public void dwarfMeirelesNasceComDataEmAnoNaoBissextoToma7FlechadasVerificaVidaEExperiencia(){
        Dwarf m = new Dwarf("Meireles", new DataTerceiraEra(17,11,2003));
        m.receberFlechada();
        m.receberFlechada();
        m.receberFlechada();
        m.receberFlechada();
        m.receberFlechada();
        m.receberFlechada();
        m.receberFlechada();
        assertEquals(110, m.getVida());
        assertEquals(0, m.getExperiencia());
    }
    
    @Test
    public void dwarfNasceComDataEmAnoNaoBissextoToma9FlechadasVerificaVidaEExperiencia(){
        Dwarf d = new Dwarf("Dwarf", new DataTerceiraEra(15,7,2007));
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        assertEquals(20, d.getVida());
        assertEquals(0, d.getExperiencia());
    }
    
    @Test
     public void dwarfNasceComNomeEDataDeNascimento() {
        DataTerceiraEra esperada = new DataTerceiraEra(12,11,1987);
         Dwarf bernardin = new Dwarf("Bernardin", new DataTerceiraEra(12, 11, 1987));
        assertEquals(esperada, bernardin.getDataNascimento());
        assertEquals("Bernardin", bernardin.getNome());
    }
    
    @Test
    public void dwarfTentaASorteEGanha1000Itens(){
         Dwarf d = new Dwarf("Ermanoteu", new DataTerceiraEra(5,7,2008));
         d.getInventario().adicionarItem(new Item("Espada de duas mãos", 3));
         int quantidadeEsperada = 1003;
         d.receberFlechada();
         d.receberFlechada();
         d.receberFlechada();
         d.tentarSorte();
         assertEquals(quantidadeEsperada, d.getInventario().getItens().get(0).getQuantidade());
    }
    
    @Test
    public void dwarfTentaASorteENaoGanha1000Itens(){
        Dwarf d = new Dwarf("Ermanoteu", new DataTerceiraEra(3,8,2005));
        d.getInventario().adicionarItem(new Item("Mace", 4));
        int quantidadeEsperada = 4;
        d.receberFlechada();
        d.receberFlechada();
        d.receberFlechada();
        d.tentarSorte();
        assertEquals(quantidadeEsperada, d.getInventario().getItens().get(0).getQuantidade());
    }

    @Test
    public void dwarfRecebeEspadadaDoOrcUrukHai(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        Dwarf dwarf = new Dwarf("Ermanoteu");
        
        orcUrukHai.atacarPersonagem(dwarf);
        
        assertEquals(98, dwarf.getVida());
    }
    
    @Test
    public void dwarfRecebeFlechadaDoOrcSnaga(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Dwarf dwarf = new Dwarf("Ermanoteu");
        
        orcSnaga.atacarPersonagem(dwarf);
        
        assertEquals(102, dwarf.getVida());
    }
    
    @Test
    public void dwarfMataOrcUrukHai(){
        OrcUrukHai orcUrukHai = new OrcUrukHai("Ukarggoth");
        Dwarf dwarf = new Dwarf("Ermanoteu");
        
        int golpesAteMatarOrc = 24;
        
        for(int i = 0; i < golpesAteMatarOrc; i++){
            dwarf.atacarOrc(orcUrukHai);
            assertEquals(Status.FERIDO, orcUrukHai.getStatus());
        }
        dwarf.atacarOrc(orcUrukHai);
        assertEquals(Status.MORTO, orcUrukHai.getStatus());
    }
    
    @Test
    public void dwarfMataOrcSnaga(){
        OrcSnaga orcSnaga = new OrcSnaga("Ukarggoth");
        Dwarf dwarf = new Dwarf("Ermanoteu");
        
        int golpesAteMatarOrc = 6;
        
        for(int i = 0; i < golpesAteMatarOrc; i++){
            dwarf.atacarOrc(orcSnaga);
            assertEquals(Status.FERIDO, orcSnaga.getStatus());
        }
        
        dwarf.atacarOrc(orcSnaga);
        assertEquals(Status.MORTO, orcSnaga.getStatus());
    }

}
