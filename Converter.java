import java.util.Scanner;

public class Converter {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int decimal,binario;
        System.out.println("Digite um numero decimal:");
        decimal = input.nextInt();
        System.out.print("Binario: ");
        binario(decimal);
    }
    static void binario(int decimal) {
        if(decimal==0)return;
        binario(decimal/2);
        System.out.print(decimal%2);
    }
}