package Atividade5;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda(200);
        int opcao;

        do {
            System.out.println("1.Adicionar contato");
            System.out.println("2.Remover contato");
            System.out.println("3.Buscar contato por nome");
            System.out.println("4.Buscar contato por email");
            System.out.println("5.Buscar contato por telefone");
            System.out.println("6.Consultar tamanho da agenda");
            System.out.println("7.Finalizar");
            System.out.println("Escolha umas das opções:");
            opcao = input.nextInt();
            input.nextLine();
            
            switch(opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Telefone: ");
                    int telefone = input.nextInt();

                    Contato novoContato = new Contato(nome, email, telefone);
                    agenda.adicionarContato(novoContato);
                    break;
                
                case 2:
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nomeRemover = input.nextLine();
                    break;
                    
                case 3:
                    System.out.print("Digite o nome do contato que deseja procurar: ");
                    String nomeProcura = input.nextLine();
                    Contato encontradoNome = agenda.buscarContatoPorNome(nomeProcura);
                    if(encontradoNome !=null) {
                        System.out.println("Este foi o contato encontrado: " + encontradoNome);
                    }else {
                        System.out.println("Este nome não foi encontrado como contato salvo:");
                    }    
                    break;

                case 4:
                    System.out.print("Digite o email do contato que deseja procurar: ");
                    String emailProcura = input.nextLine();
                    Contato encontradoEmail = agenda.buscarContatoPorEmail(emailProcura);
                    if(encontradoEmail !=null) {
                        System.out.println("Este foi o contato encontrado pelo email: " + encontradoEmail);
                    }else {
                        System.out.println("Este email não foi encontrado como contato salvo:");
                    }    
                    break;
                    
                case 5:
                    System.out.print("Digite o telefone do contato que deseja procurar: ");
                    int telefoneProcura = input.nextInt();
                    Contato encontradoTelefone = agenda.buscarContatoPorTelefone(telefoneProcura);
                    if(encontradoTelefone !=null) {
                        System.out.println("Este foi o contato encontrado pelo telefone: " + encontradoTelefone);
                    }else {
                        System.out.println("Este telefone não foi encontrado como contato salvo:");
                    }    
                    break;
                    
                case 6:
                    System.out.println("A agenta possui um tamanho igual a:" + agenda.getTamanho());
                    break;
                    
                case 7:
                    System.out.println("Processo encerrado.");
                    break;
                 
                default:
                    System.out.println("Opção incorreta.Digite um número de 1 a 7.");    
            }
        } while (opcao !=7);
    }
}
