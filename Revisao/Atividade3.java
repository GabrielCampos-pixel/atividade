package Revisao;

import java.util.Scanner;

public class Atividade3 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[] janeiro = new int[1];
        int[] fevereiro = new int[1];
        int[] marco = new int[1];
        int[] abril = new int[1];
        int[] maio = new int[1];
        int[] junho = new int[1];
        int[] julho = new int[1];
        int[] agosto = new int[1];
        int[] setembro = new int[1];
        int[] outubro = new int[1];
        int[] novembro = new int[1];
        int[] dezembro = new int[1];
        System.out.println("Digite a temperatura média de cada mês dando espaço entre as temperaturas: ");
        janeiro[0] = input.nextInt();
        fevereiro[0] = input.nextInt();
        marco[0] = input.nextInt();
        abril[0] = input.nextInt();
        maio[0] = input.nextInt();
        junho[0] = input.nextInt();
        julho[0] = input.nextInt();
        agosto[0] = input.nextInt();
        setembro[0] = input.nextInt();
        outubro[0] = input.nextInt();
        novembro[0] = input.nextInt();
        dezembro[0] = input.nextInt();
        
        int[] temperaturas = {
            janeiro[0], fevereiro[0], marco[0], abril[0], maio[0], junho[0], julho[0], agosto[0], setembro[0], outubro[0], novembro[0], dezembro[0]
        };//criei este array para facilitar no loop e não precisar comparar cada mes escrevendo varias linhas
        String[] meses = {
            "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        };//mesma coisa da temperatura,para facilitar no encontro do mes com tal temperatura,identificar com mais facilidade no loop

        int maiorTemperatura = temperaturas[0];
        int menorTemperatura = temperaturas[0];
        String mesMaiorTemp = meses[0];
        String mesMenorTemp = meses[0];

        for(int i=1; i < temperaturas.length; i++) {
            if(temperaturas[i] > maiorTemperatura) {
                maiorTemperatura = temperaturas[i];
                mesMaiorTemp = meses[i];
            }else if(temperaturas[i] < menorTemperatura) {
                menorTemperatura = temperaturas[i];
                mesMenorTemp = meses[i];
            }
        }
        System.out.println("O mes de " + mesMaiorTemp + " teve maior media de temperatura com " + maiorTemperatura + "°C");
        System.out.println("O mes de " + mesMenorTemp + " teve menor meda de temperatura com " + menorTemperatura + "°C");
    }
}
