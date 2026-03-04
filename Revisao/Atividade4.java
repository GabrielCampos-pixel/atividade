package Revisao;

import java.util.Scanner;

public class Atividade4 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Quantos numeros o vetor x terá?");
        int m = input.nextInt();
        int[] x = new int[m];
        System.out.println("Digite os numeros do vetor x:");
        for(int i=0; i < m; i++) {
            x[i] = input.nextInt();
        }

        System.out.println("Quantos numeros o vetor y terá?");
        int n = input.nextInt();
        int[] y = new int[n];
        System.out.println("Digite os numeros do vetor y:");
        for(int i=0; i < n; i++) {
            y[i] = input.nextInt();
        }

        int[] z = new int[m + n];
        int tamanhoZ =0;
        for(int i=0; i < m; i++) {
            boolean jaPossui = false;
            for(int j=0; j < tamanhoZ;j++) {
                if(z[j] == x[i]) {
                    jaPossui = true;
                    break;
                }
            }
            if(!jaPossui) {
                z[tamanhoZ] = x[i];
                tamanhoZ++;
            }    
        }
    
        for(int i=0; i < n; i++) {
            boolean jaPossui = false;
            for(int j=0;j < tamanhoZ;j++) {
                if(z[j] == y[i]) {
                    jaPossui = true;
                    break;
                }
            }
            if(!jaPossui) {
                z[tamanhoZ] = y[i];
                tamanhoZ++;
            }
        }
        System.out.println("Vetor união:");
        for (int i = 0; i < z.length; i++) {
            System.out.print(z[i] + " ");
        }
    }
}
