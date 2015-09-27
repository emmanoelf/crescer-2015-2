import java.util.*;
public class EstrategiaNoturna implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();

    public void atacar(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque.clear();
        exercito.agruparPorStatus();
        ArrayList<Elfo> elfosVivos = exercito.buscar(Status.VIVO);
        double intencoesDeAtaque = elfosVivos.size() * dwarves.size();
        double qtdMaxDeAtaqueDosElfosNoturnos = (int) intencoesDeAtaque * 0.3;
        int qtdDeAtaqueRealizadosPelosNoturnos = 0;
        for(Elfo elfo : elfosVivos){
            boolean ehElfoNoturno = elfo instanceof ElfoNoturno && qtdDeAtaqueRealizadosPelosNoturnos < qtdMaxDeAtaqueDosElfosNoturnos;
            if(elfo instanceof ElfoVerde || ehElfoNoturno){
                ordemDoUltimoAtaque.add(elfo);
            }
            for(Dwarf dwarf : dwarves){
                if(ehElfoNoturno){
                    elfo.atirarFlecha(dwarf);
                    qtdDeAtaqueRealizadosPelosNoturnos++;
                }

                if(elfo instanceof ElfoVerde){
                    elfo.atirarFlecha(dwarf);
                }
            }
        }

    }

    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
        return ordemDoUltimoAtaque;
    }
}