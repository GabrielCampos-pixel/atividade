package ArvoreBinaria;
public class No {
    int x;
    private No esquerda;
    private No direita;

    public No(int x){
        this.x= x;
        this.esquerda = null;
        this.direita = null;
    }
}