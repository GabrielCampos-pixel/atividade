package Revisao;

import java.util.Scanner;

public class Atividade1 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um numero");
        int num = input.nextInt();
        int fatorial= 1;

        if(num>=0) {
            for(int i=1;i<=num;i++)
            fatorial = fatorial*i;
            System.out.println("O fatorial do num é :" + fatorial);
        }
        else {
            System.out.println("Numero invalido");
        }
    }
}