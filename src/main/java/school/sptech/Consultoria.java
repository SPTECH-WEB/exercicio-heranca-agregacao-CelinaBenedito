package school.sptech;

import school.sptech.especialistas.DesenvolvedorWeb;
import school.sptech.especialistas.DesenvolvedorMobile;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas>desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
        }
    }
    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }
    public Double getTotalSalarios(){
        Double soma = 0.0;
        
    }
}
