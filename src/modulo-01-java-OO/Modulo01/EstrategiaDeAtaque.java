import java.util.ArrayList;
public interface EstrategiaDeAtaque{
    
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves);
    
}
