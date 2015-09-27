import java.util.*;
public interface EstrategiaDeAtaque{
    
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves);
    
}
