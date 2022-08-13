package src.view;

import java.util.Scanner;

import src.control.AnimalControl;
import src.control.ClienteControl;
import src.model.AnimalModel;
import src.util.Global;

public class AnimalView
{
    AnimalControl ctrl = new AnimalControl();
    Scanner scan = new Scanner(System.in);;
    String resposta;
    String option = "-1";
    boolean flag = true;

    public void areaAnimal()
    {
        do // 4 == retorna para home
        {
            Global.clearConsole();
            getHeaderAreaAnimal();

            System.out.println("Operações: \n[Press 1] - Cadastrar novo animal\n[Press 2] - Consultar um animal (É Necessário um ID válido)\n[Press 3] - Retornar todos os animais cadastrados\n[Press 4] - Para retornar a Home\n[Press 5] - Para finalizar tarefa");
            
            getLinha();

            System.out.print("Digite a operação desejada: ");
            option = scan.nextLine();
            
            if (Integer.parseInt(option) <= 0 || Integer.parseInt(option) > 5)
            { // fora do range == error
                System.out.println("Operação fora do range esperado! ;-;");
                option = "-1"; // reseta a option
                areaAnimal();
            }      
            
            switch (option)
            {
                case "1":
                    // cadastrar novo animal
                    getHeaderCadastroAnimal();
                    cadastrarNovoAnimal();
                    areaAnimal();
                    break;
                case "2": 
                    // consultar um animal pelo id
                    getHeaderConsultaCliente();
                    consultarClientePeloCpf();
                    areaCliente();
                    break;
                case "3":
                    // retornar todos animais cadastrados
                    getHeaderAllClientes();
                    getLinha();
                    retornarTodosClientes();
                    areaCliente();
                    break;
                case "4":
                    // retorna para a home 
                    getLinha();
                    System.out.println("Retornando para home..." + option);
                    option = "4";
                    getLinha();
                    break;
                case "5":
                    // finaliza tarefa
                    getLinha();
                    System.out.println("Programa Finalizado!! Boa Semana! ;D");
                    getLinha();
                    break;
            }
        }while (option != "4");  
    }
    public void cadastrarNovoAnimal()
    {
        AnimalModel animal = new AnimalModel();
        ClienteControl clienteCtrl = new ClienteControl();

        System.out.print("Dígite o NOME do ANIMAL: ");
        resposta = scan.nextLine();
        while (resposta == "")
        {
            System.out.print("* Dígite o NOME do ANIMAL: ");
            resposta = scan.nextLine();
        }
        animal.setNomeAnimal(resposta);

        String nome = resposta;
        System.out.print("Dígite um número de Identificação (ID) para o pet "+resposta+": ");
        resposta = scan.nextLine();
        while (resposta == "")
        {
            System.out.print("* Dígite um número de Identificação (ID) para o pet "+nome+": ");
            resposta = scan.nextLine();
        }
        animal.setId(Integer.parseInt(resposta));



        
        // apos todos campos preenchidos:
        ctrl.setAnimal(animal);
        getLinha();
        System.out.println("ANIMAL CADASTRADO COM SUCESSO! ;D");
        getLinha();
    }
    public void consultarClientePeloCpf()
    {
        System.out.print("Dígite o CPF do cliente que deseja verificar: ");
        resposta = scan.nextLine();

        while (resposta == "")
        {
            System.out.println("* Dígite o CPF do cliente que deseja verificar: ");
            resposta = scan.nextLine();
        }
        if (ctrl.getCliente(Integer.parseInt(resposta)) != null)
        {
            ClienteModel cliente = ctrl.getCliente(Integer.parseInt(resposta));
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Data de nascimento: " + cliente.getDtNasc());
        }
        else
        {
            getLinha();
            System.out.println("Nenhum cliente cadastrado contém esse CPF: " + resposta);
        }
    }
    public void retornarTodosClientes()
    {
        if (ctrl.getClientes().isEmpty())
        {
            System.out.println("Nenhum cliente cadastrado!! ;-;");
            return;
        }
        int cont = 1;
        for (ClienteModel cli: ctrl.getClientes())
        {
            System.out.println("============================[ Cliente "+ cont +" ]============================" );
            System.out.println("Nome: " + cli.getNome());
            System.out.println("CPF: " + cli.getCpf());
            System.out.println("Data de nascimento: " + cli.getDtNasc());
            getLinha();
            cont ++;
        }
    }
    public static void getLinha()
    {
         System.out.println("=====================================================================");
    }
    public static void getHeaderAreaAnimal()
    {
        getLinha();
        System.out.println("==================> [ ÁREA DO ANIMAL ] <=============================");
    }
    public static void getHeaderCadastroAnimal()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO ANIMAL - CADASTRAR UM NOVO ANIMAL ] <=========");
        getLinha();
    }
    public static void getHeaderConsultaAnimal()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO ANIMAL - CONSULTAR UM ANIMAL (PELO ID)] <=========");
        getLinha();
    }
    public static void getHeaderAllAnimais()
    {
        getLinha();
        System.out.println("=========> [ ÁREA DO ANIMAL- TODOS ANIMAIS CADASTRADOS: ] <=========");
        getLinha();
    }
}