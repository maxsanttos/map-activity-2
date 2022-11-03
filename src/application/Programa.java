package application;

import model.entities.Paciente;
import model.entities.PacienteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Max Suel Santtos
 */
public class Programa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        List<Paciente>list = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println();
        System.out.println("INFORME AS INFORMAÇÕES DA ENFERMEIRA");
        System.out.print("CPF: ");
        String cpfenfermeira = sc.nextLine();
        System.out.print("NOME: ");
        String enfermeira = sc.nextLine();
        UI.clearScreen();

        // Mostrando o Menu
        System.out.printf("Enfermeira: %s CPF: %s%n",enfermeira.toUpperCase(),cpfenfermeira);
        UI.mostarMenu();
        int op = sc.nextInt();
        do{
            try {
                switch (op) {
                case 1:
                    //Limpando a tela
                    UI.clearScreen();

                    // pegando as informações do Paciente e adcionando na lista
                    System.out.print("Informar a quantidade de Pacientes: ");
                    int qtdPa = sc.nextInt();
                    for (int i = 1; i <= qtdPa ; i++) {
                        System.out.println("Paciente #"+i);
                        System.out.print("CPF: ");
                        sc.nextLine();
                        String cpfPa = sc.nextLine();
                        System.out.print("NOME: ");
                        String nomePa = sc.nextLine();
                        System.out.println("====== VACINAS =======");
                        System.out.print("Informe a data da primeira dose: ");
                        Date dose1 = sdf.parse(sc.next());
                        System.out.print("Informe a data da Segunda dose: ");
                        Date dose2 = sdf.parse(sc.next());
                        System.out.print("Informe a data da Terceira dose: ");
                        Date dose3 = sdf.parse(sc.next());
                        System.out.print("Informe a data da quarta dose: ");
                        Date dose4 = sdf.parse(sc.next());
                        list.add(new Paciente(cpfPa, nomePa.toUpperCase(), dose1, dose2, dose3, dose4));
                    }

                    // retornando para o menu
                    UI.mostarMenu();
                    op = sc.nextInt();
                    break;
                case 2:
                    // listando as informações dos pacientes cadastrandos e vacinandos
                    UI.clearScreen();
                    for (Paciente paciente : list) {
                        System.out.println(paciente);
                    }
                    UI.mostarMenu();
                    op = sc.nextInt();
                    break;
                default:
                    UI.clearScreen();
                    System.out.println("OPCAO INVALIDA");
                    UI.mostarMenu();
                    op = sc.nextInt();
                    break;
                }
            }catch (PacienteException e){
                System.out.println("Error: "+ e.getMessage());
            }catch(ParseException e ){
                System.out.println("Error: "+e.getMessage());
            }
        }while (op != 3);
        UI.clearScreen();
        System.out.println("===========================");
        System.out.println("FIM DO SYSTEMA!");
        System.out.println("===========================");
        System.out.println();
        sc.close();
    }  
}