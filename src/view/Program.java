
package src.view;

import java.io.IOException;
import java.util.Scanner;

import src.util.Global;

public class Program
{   
    Scanner scan = new Scanner(System.in);
    String resp;
    String res;

    public static void main(String[] args) throws IOException
    {
        Global.clearConsole();
        Program app = new Program();
        app.home();
    }
    public void home() throws IOException
    {
        do
        {
            getLinha();
            System.out.println("Operações: \n[Press 1] - Área do Cliente\n[Press 2] - Área do Animal\n[Press 3] - Área do Funcionário\n[Press 4] - Área das Cirurgias\n[Press 5] - Para finalizar tarefa");
            getLinha();

            System.out.print("Digite a operação desejada: ");
            String res = scan.nextLine();
            
            if (Integer.parseInt(res) <= 0 || Integer.parseInt(res) > 5)
            { // fora do range == error
                System.out.println("Operação fora do range esperado! ;-;");
                res = "-1"; //reset no res
                home();
            }      
            
            switch (res)
            {
                case "1":
                    // área do cliente
                    ClienteView clienteView = new ClienteView();
                    getLinha();
                    Global.clearConsole();                    
                    clienteView.areaCliente();
                    break;
                case "2":
                    // área do animal
                    break;
                case "3":
                    // área do funcionário
                    break;
                case "4":
                    // área da cirurgia
                    break;
                case "5":
                    // finalizar
                    getLinha();
                    System.out.println("Programa Finalizado!! Boa Semana! ;D");
                    getLinha();
                    break;
            }
        }while (res != "5");
    }
    public static void areaAnimal()
    {

    }
    public static void areaFuncionario()
    {

    }
    public static void areaCirurgia()
    {

    }
    public static void getLinha()
    {
         System.out.println("=====================================================================");
    }
    public static void getHeaderAreaCliente()
    {
        getLinha();
        System.out.println("==================> [ ÁREA DO CLIENTE ] <=============================");
    }
    public static void getHeaderCadastroCliente()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO CLIENTE - CADASTRAR UM NOVO CLIENTE ] <=========");
        getLinha();
    }
    public static void getHeaderConsultaCliente()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO CLIENTE - CONSULTAR UM CLIENTE (PELO CPF)] <=========");
        getLinha();
    }
    public static void getHeaderAllClientes()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO CLIENTE - TODOS CLIENTES CADASTRADOS: ] <=========");
        getLinha();
    }
}