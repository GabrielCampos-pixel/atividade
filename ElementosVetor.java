import java.util.Scanner;

public class ElementosVetor {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Digite o tamanho do vetor:");
        n = input.nextInt();
        int[]v = new int[n];
        System.out.println("Digite os elementos do vetor:");
        for(int i=0;i<n;i++) {
            v[i] = input.nextInt();
        }
        
        System.out.println("O maior elemento desse vetor é: " +maior(v,n-1));
    }
    static int maior(int[]v,int n) {
        if(n==0)return v[0];
        int maiorAnterior = maior(v,n-1);
        if(v[n] > maiorAnterior){
            return v[n];
        }else {
            return maiorAnterior;
        }
    }
}
