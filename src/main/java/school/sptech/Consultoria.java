package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        } else {
            System.out.println("Não há vagas disponíveis.");
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            contratar(desenvolvedor);
        } else {
            System.out.println("O desenvolvedor não é fullstack.");
        }
    }

    public Double getTotalSalarios(){
        Double TotalSalario = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            TotalSalario += desenvolvedor.calcularSalario();
        }

        return TotalSalario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer contador= 0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile) {
                contador++;
            }
        }
        return contador;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> lista = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                lista.add(desenvolvedor);
            }
        }
        return lista;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor menorSalario = desenvolvedores.get(0);

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalario.calcularSalario()) {
                menorSalario = desenvolvedor;
            }
        }

        return menorSalario;
    }


    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresEncontrados = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile mobileDev = (DesenvolvedorMobile) dev;
                if (mobileDev.getPlataforma() != null && mobileDev.getPlataforma().equalsIgnoreCase(tecnologia) ||
                        mobileDev.getLinguagem() != null && mobileDev.getLinguagem().equalsIgnoreCase(tecnologia)) {
                    desenvolvedoresEncontrados.add(dev);
                }
            } else if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb webDev = (DesenvolvedorWeb) dev;
                if (webDev.getBackend() != null && webDev.getBackend().equalsIgnoreCase(tecnologia) ||
                        webDev.getFrontend() != null && webDev.getFrontend().equalsIgnoreCase(tecnologia) ||
                        webDev.getSgbd() != null && webDev.getSgbd().equalsIgnoreCase(tecnologia)) {
                    desenvolvedoresEncontrados.add(dev);
                }
            }
        }
        return desenvolvedoresEncontrados;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double totalSalario = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile mobileDev = (DesenvolvedorMobile) dev;
                if (mobileDev.getPlataforma() != null && mobileDev.getPlataforma().equalsIgnoreCase(tecnologia) ||
                        mobileDev.getLinguagem() != null && mobileDev.getLinguagem().equalsIgnoreCase(tecnologia)) {
                    totalSalario += mobileDev.calcularSalario();
                }
            } else if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb webDev = (DesenvolvedorWeb) dev;
                if (webDev.getBackend() != null && webDev.getBackend().equalsIgnoreCase(tecnologia) ||
                        webDev.getFrontend() != null && webDev.getFrontend().equalsIgnoreCase(tecnologia) ||
                        webDev.getSgbd() != null && webDev.getSgbd().equalsIgnoreCase(tecnologia)) {
                    totalSalario += webDev.calcularSalario();
                }
            }
        }

        return totalSalario;
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

}

