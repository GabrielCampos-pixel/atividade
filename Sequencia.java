import java.util.Scanner;
public class Sequencia {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n,sequencia;
        System.out.println("Informe quantos numeros terá sua sequencia:");
        n = input.nextInt();
        System.out.println("Digite os numeros da sua sequencia:");
        sequencia(input,n);
    }
    public static void sequencia(Scanner input,int n) {
        if(n==0)return;
        int numero = input.nextInt();
        sequencia(input,n-1);
        System.out.print(numero+ " ");
    }    
}