package school.sptech;

import school.sptech.especialistas.DesenvolvedorWeb;
import school.sptech.especialistas.DesenvolvedorMobile;

import java.util.ArrayList;
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
        for(Desenvolvedor desenvolvedor: desenvolvedores){
            soma+=desenvolvedor.calcularSalario();
        }
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        List<Desenvolvedor> qtdMobile = new ArrayList<>();

        for(Desenvolvedor desenvolvedor: desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorMobile) {
                qtdMobile.add(desenvolvedor);
            }
        }
        return qtdMobile.size();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> qtdDesenvolvedores = new ArrayList<>();

        for(Desenvolvedor desenvolvedor: desenvolvedores){
            if(desenvolvedor.calcularSalario()>=salario){
                qtdDesenvolvedores.add(desenvolvedor);
            }
        }
        return qtdDesenvolvedores;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor desenvolvedorMenorSalario = desenvolvedores.get(0);
        for(Desenvolvedor desenvolvedor: desenvolvedores) {
            if (desenvolvedorMenorSalario.calcularSalario() > desenvolvedor.calcularSalario()) {
                desenvolvedorMenorSalario = desenvolvedor;
            }
        }
        return desenvolvedorMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> qtdDesenvolvedores = new ArrayList<>();
        for(Desenvolvedor desenvolvedor: desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorWeb){

                DesenvolvedorWeb web = (DesenvolvedorWeb)desenvolvedor;
                if (web.getBackend().equalsIgnoreCase(tecnologia) ||
                        web.getFrontend().equalsIgnoreCase(tecnologia) ||
                        web.getSgbd().equalsIgnoreCase(tecnologia))
                qtdDesenvolvedores.add(desenvolvedor);

            } else if (desenvolvedor instanceof DesenvolvedorMobile) {

                if(desenvolvedor instanceof DesenvolvedorMobile){
                    DesenvolvedorMobile mobile = (DesenvolvedorMobile)desenvolvedor;
                    if (mobile.getLinguagem().equalsIgnoreCase(tecnologia) ||
                            mobile.getPlataforma().equalsIgnoreCase(tecnologia)) {
                        qtdDesenvolvedores.add(desenvolvedor);

                    }
                }
            }
        }
        return qtdDesenvolvedores;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;
        for(Desenvolvedor desenvolvedor: desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorMobile){
                DesenvolvedorMobile mobile = (DesenvolvedorMobile)desenvolvedor;
                if(mobile.getLinguagem().equalsIgnoreCase(tecnologia)||
                        mobile.getPlataforma().equalsIgnoreCase(tecnologia)){
                    soma+=mobile.calcularSalario();
                }
            }
            if(desenvolvedor instanceof DesenvolvedorWeb){
                DesenvolvedorWeb web = (DesenvolvedorWeb)desenvolvedor;
                if(web.getBackend().equalsIgnoreCase(tecnologia) ||
                        web.getFrontend().equalsIgnoreCase(tecnologia) ||
                        web.getSgbd().equalsIgnoreCase(tecnologia)){
                    soma+=web.calcularSalario();
                }
            }
        }
    return soma;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
