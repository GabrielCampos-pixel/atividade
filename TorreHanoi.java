import java.util.Scanner;

public class TorreHanoi {
        public static void resolverTorreHanoi(int n,char origem,char destino,char auxiliar) {
        if(n==1){
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
            return;
        }
        resolverTorreHanoi(n-1,origem,auxiliar,destino);
        System.out.println("Mover disco " + n + " de " + origem + " para " + destino);

        resolverTorreHanoi(n-1,auxiliar,destino,origem);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Digite o número de discos que tem sua torre de hanoi");
        n = input.nextInt();

        System.out.println("Torre de Hanói com " + n + " discos");

        resolverTorreHanoi(n, 'A', 'C', 'B');
    }
}    