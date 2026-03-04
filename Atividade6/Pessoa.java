package Atividade6;

public class Pessoa {
    private String nome;
    private Pessoa mae;
    private Pessoa pai;

    public Pessoa(String nome) {
        this.nome = nome;
        this.mae = null;
        this.pai = null;
    }

    public Pessoa(String nome, Pessoa mae, Pessoa pai) {
        this.nome = nome;
        this.mae = mae;
        this.pai = pai;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Pessoa getMae() {return mae;}
    public void setMae(Pessoa mae) {this.mae = mae;}

    public Pessoa getPai() {return pai;}
    public void setPai(Pessoa pai) {this.pai = pai;}

    public boolean Irmao(Pessoa nova) {
        if(nova== null || nova== this) {
            return false;
        }

        boolean mesmaMae = this.mae !=null && nova.getMae() !=null && this.mae == nova.getMae();
        boolean mesmoPai = this.pai !=null && nova.getPai() !=null && this.pai == nova.getPai();
        return mesmaMae || mesmoPai;
    }

    public boolean Antecessor(Pessoa nova) {
        if(nova== null) {
            return false;
        }
        return nova == this.mae || nova == this.pai;
    }

    public String toString() {
        String nomeMae = (mae !=null) ? mae.getNome() : "Desconhecida";
        String nomePai = (pai !=null) ? pai.getNome() : "Desconhecido";
        return nome + "Mae: " + nomeMae + ",Pai: " + nomePai + ".";
    }
}
