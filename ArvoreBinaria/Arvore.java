package ArovoreBinaria;
import No;
public class Arvore {
    private No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(int x) {
        if(raiz == null) {
            raiz.valor = x;
        }else if(x>raiz.valor){
            No novo = new No(x);
        }        
    }
}