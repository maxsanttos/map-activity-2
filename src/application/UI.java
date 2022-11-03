package application;

public class UI {

    // https://stackoverflow.com/question/2979383/java-clear-the-console
    public static void clearScreen(){
        System.out.println();
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    // Menu
    public static void mostarMenu(){
        System.out.println();
        System.out.println("=======================================");
        System.out.println("BEM-VINDA(O) AO SISTEMA");
        System.out.println("=======================================");
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("1 - Vacinar Cidadão");
        System.out.println("2 - Listar CIdadão ");
        System.out.println("3 - Sair");
        System.out.println("--------------------------------------------");
    }
}
