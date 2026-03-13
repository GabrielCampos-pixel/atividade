import java.util.Scanner;

public class Potencia {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int x,n,resultado;
        System.out.println("Digite o numero que você deseja multiplicar:");
        x = input.nextInt();
        System.out.println("Digite o numero de vezes que você quer que o outro numero seja multiplicado por ele mesmo:");
        n = input.nextInt();
        resultado = potencia(x,n);
        System.out.println("Esse é o resultado da potencia:" +resultado);      
    }
    static int potencia(int x,int n) {
        if(n==0)return 1;
        return x *potencia(x,n-1);
    }
}