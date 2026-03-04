package Atividade5;

public class Agenda {
    private Contato[] contatos;
    private int tamanho;

    public Agenda(int armazenamento) {
        this.contatos = new Contato[armazenamento];
        this.tamanho= 0;
    }

    public Contato[] getContatos() {return contatos;}
    public void setContatos(Contato[] contatos) {this.contatos = contatos;}

    public int getTamanho() {return tamanho;}
    public void setTamanho(int tamanho) {this.tamanho = tamanho;}
    
    public void adicionarContato(Contato contato) {
        if(tamanho >= contatos.length) {
            System.out.println("A agenda de contatos está cheia");
            return;
        }
        contatos[tamanho] = contato;
        tamanho++;
        System.out.println("O contato" +contato.getNome() + "foi adiconado a agenda");
    }

    public boolean removerContato(String nome) {
        for(int i = 0; i < tamanho; i++) {
            if(contatos[i].getNome().equalsIgnoreCase(nome)) {
                for(int j = i; j < tamanho -1; j++) {
                    contatos[j] = contatos[j + 1];
                }
                contatos[tamanho -1] = null;
                tamanho--;
                System.out.println("O contato" + nome +"foi removido com sucesso");
                return true;
            }
        }
        System.out.println("O contato" + nome +"não foi encontrado,se quiser remover outro tente novamente");
        return false;
    }

    public  Contato buscarContatoPorNome(String nome) {
        for(int i = 0; i < tamanho;i++) {
            if(contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        return null;
    }

    public Contato buscarContatoPorEmail(String email) {
        for(int i = 0; i < tamanho;i++) {
            if(contatos[i].getEmail().equalsIgnoreCase(email)) {
                return contatos[i];
            }
        }
        return null;
    }

    public Contato buscarContatoPorTelefone(int telefone) {
        for(int i = 0;i < tamanho;i++) {
            if(contatos[i].getTelefone() == telefone) {
            return contatos[i];
            }
        }
        return null;
    }
}
