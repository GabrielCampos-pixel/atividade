package Atividade6;

public class ArvoreGenealogica {
    private Pessoa[] pessoas;
    private int tamanho;
    private static final int Capacidade = 100;

    public ArvoreGenealogica() {
        this.pessoas = new Pessoa[Capacidade];
        this.tamanho = 0;
    }
    public Pessoa[] getPessoas() {return pessoas;}

    public int getTamanho() {return tamanho;}
        
    public void adicionarPessoa(Pessoa pessoaNova) {
        if(tamanho >= pessoas.length) {
            Pessoa[] novaLista = new Pessoa[pessoas.length*2];
            for(int i=0; i < tamanho; i++) {
                novaLista[i] = pessoas[i];
            }
            pessoas = novaLista;
        }
        pessoas[tamanho] = pessoaNova;
        tamanho++;
    }
        
    public Pessoa buscarPorNome(String nome) {
        for(int i=0; i < tamanho; i++) {
            if(pessoas[i].getNome().equalsIgnoreCase(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public void removerPessoa(Pessoa pessoa) {
        for(int i=0; i < tamanho;i++) {
            if(pessoas[i] == pessoa) {
                for(int j=i; j < tamanho - 1;j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[tamanho -1] = null;
                tamanho--;
                return;
            }
        }
    }

    public Pessoa[] pesquisarFilhos(Pessoa pessoa) {
        Pessoa[] filhos = new Pessoa[tamanho];
        int cont = 0;
        for(int i=0;i < tamanho;i++) {
            Pessoa pessoaNova = pessoas[i];
            if(pessoaNova.getMae() == pessoa || pessoaNova.getPai() == pessoa) {
                filhos[cont] = pessoaNova;
                cont++;
            }
        }
        Pessoa[] resultado = new Pessoa[cont];
        for(int i=0;i < cont;i++) {
            resultado[i] = filhos[i];
        }
        return resultado;
    }
    public Pessoa[] pesquisarIrmaos(Pessoa pessoa) {
        Pessoa[] irmaos = new Pessoa[tamanho];
        int cont =0;

        for(int i =0;i < tamanho;i++) {
            Pessoa pessoaNova = pessoas[i];
            if(pessoaNova != pessoa && pessoa.Irmao(pessoaNova)) {
                irmaos[cont] = pessoaNova;
                cont++;
            }    
        }
        Pessoa[] resultado = new Pessoa[cont];
        for(int i=0;i < cont;i++) {
            resultado[i] = irmaos[i];
        }
        return resultado;

    }
    public void listarPessoas() {
        if(tamanho == 0) {
            System.out.println("Não há pessoas cadastradas.");
            return;
        }
        for(int i=0; i < tamanho;i++) {
            System.out.println("" + (i + 1) + "." + pessoas[i]);
        }
    }   
    
}
