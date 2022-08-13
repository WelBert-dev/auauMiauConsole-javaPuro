package src.view;

import java.util.Scanner;

import src.control.ClienteControl;
import src.model.ClienteModel;
import src.model.MoradiaModel;
import src.util.Cor;
import src.util.Global;

public class ClienteView
{
    ClienteControl ctrl = new ClienteControl();
    Scanner scan = new Scanner(System.in);;
    String resposta;
    String option = "-1";
    boolean flag = true;

    public void areaCliente()
    {
        do // 4 == retorna para home
        {
            getHeaderAreaCliente();
            getLinha();

            System.out.println("Operações: \n[Press 1] - Cadastrar novo cliente\n[Press 2] - Consultar um cliente (É Necessário um CPF válido)\n[Press 3] - Retornar todos os clientes cadastrados\n[Press 4] - Atualizar um cliente\n[Press 5] - Deletar um cliente\n[Press 6] - Retornar para a Home");
            
            getLinha();

            System.out.print("Digite a operação desejada: ");
            option = scan.nextLine();
            
            if (Integer.parseInt(option) <= 0 || Integer.parseInt(option) > 6)
            { // fora do range == error
                System.out.println("Operação fora do range esperado! ;-;");
                option = "-1"; // reseta a option
                areaCliente();
            }     

            switch (option)
            {
                case "1":
                    // cadastrar novo cliente
                    cadastrarNovoCliente();
                    break;
                case "2": 
                    // consultar um cliente pelo cpf
                    consultarClientePeloCpf();
                    break;
                case "3":
                    // retornar todos clientes cadastrados
                    retornarTodosClientes();
                    break;
                case "4":
                    // Atualizar um cliente
                    atualizarCliente();
                    break;
                case "5":
                    // Deletar um cliente
                    deletarCliente();
                    break;
                case "6":
                    // Retornar para a home
                    getLinha();
                    System.out.println("Retornando para a home...");    
                    try 
                    {
                        Thread.sleep(1000);
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Excessão: " + ex.getMessage());                            
                    }
      
                    Global.clearConsole();       
                    break;
            }
        }while (!option.equals("6"));  
    }

    public void cadastrarNovoCliente()
    {
        Global.clearConsole();
        getHeaderCadastroCliente();

        ClienteModel cliente = new ClienteModel();
        MoradiaModel moradia = new MoradiaModel();

        System.out.print("Dígite o NOME COMPLETO do cliente: ");
        resposta = scan.nextLine();

        while (resposta.equals(""))
        {
            System.out.print("* Dígite o NOME COMPLETO do cliente: ");
            resposta = scan.nextLine();
        }
        cliente.setNome(resposta);

        String nome = resposta;
        System.out.print("Dígite o CPF do "+resposta+": ");
        resposta = scan.nextLine();
        while (resposta.equals(""))
        {
            System.out.print("* Dígite o CPF do "+nome+": ");
            resposta = scan.nextLine();
        }
        cliente.setCpf(resposta);

        System.out.print("Dígite a DATA DE NASCIMENTO do "+nome+": ");
        resposta = scan.nextLine();
        while (resposta.equals(""))
        {
            System.out.print("* Dígite a DATA DE NASCIMENTO do "+nome+": ");
            resposta = scan.nextLine();
        }
        cliente.setDtNasc(resposta);

        System.out.print("Dígite o Endereço do(a) "+nome+": ");
        resposta = scan.nextLine();
        while (resposta.isEmpty())
        {
            System.out.print("* Dígite o Endereço do(a) "+nome+": ");
            resposta = scan.nextLine();
        }
        moradia.setEndereco(resposta);
        cliente.setMoradia(moradia);


        // apos todos campos preenchidos:
        ctrl.setCliente(cliente);
        getLinha();
        System.out.println(Cor.getVerde() + "CLIENTE CADASTRADO COM SUCESSO! ;D" + Cor.getReset());
        getLinha();
    }
    public void consultarClientePeloCpf()
    {
        Global.clearConsole();
        getHeaderConsultaCliente();

        if (ctrl.getClientes().isEmpty())
        {
            System.out.println(Cor.getVermelho() + "Nenhum cliente CADASTRADO!! ;-;" + Cor.getReset());
            return;
        }
        System.out.print(Cor.getAmarelo() + "Dígite o CPF do cliente que deseja verificar: " + Cor.getReset());
        resposta = scan.nextLine();

        while (resposta.isEmpty() || ctrl.getCliente(resposta) == null)
        {
            if (ctrl.getCliente(resposta) == null)
            {
                System.out.print(Cor.getVermelho() + "* Ocorrência de CPF não encontrada!! tente outro: " + Cor.getReset());
            }
            else
            {
                System.out.print(Cor.getVermelho() + "* Dígite o CPF do cliente que deseja verificar: " + Cor.getReset());
            }

            resposta = scan.nextLine();
        }
        if (ctrl.getCliente(resposta) != null)
        {
            ClienteModel cliente = ctrl.getCliente(resposta);
            System.out.println("\nNome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Data de nascimento: " + cliente.getDtNasc());
            System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());
        }
    }
    public void retornarTodosClientes()
    {
        Global.clearConsole();
        getHeaderAllClientes();

        if (ctrl.getClientes().isEmpty())
        {
            System.out.println(Cor.getVermelho() + "Nenhum cliente CADASTRADO!! ;-;" + Cor.getReset());
            return;
        }
        int cont = 1;
        for (ClienteModel cli: ctrl.getClientes())
        {
            System.out.println("=========================== " + Cor.getCiano() + "[ Cliente "+ cont +" ] " + Cor.getReset() + "===========================" );
            System.out.println("Nome: " + cli.getNome());
            System.out.println("CPF: " + cli.getCpf());
            System.out.println("Data de nascimento: " + cli.getDtNasc());
            System.out.println("\n[Moradia] Endereço: " + cli.getMoradia().getEndereco());
            getLinha();
            cont ++;
        }
    }
    public void atualizarCliente()
    {
        Global.clearConsole();
        getHeaderAtualizarCliente();

        String cpfCli;

        if (ctrl.getClientes().isEmpty())
        {
            System.out.println(Cor.getVermelho() + "Nenhum registro de cliente para poder ATUALIZAR!! ;-;" + Cor.getReset());
            return;
        }     

        System.out.print(Cor.getAmarelo() + "Dígite o CPF do cliente que deseja fazer alterações: " + Cor.getReset());
        resposta = scan.nextLine();
        while (resposta.equals(""))
        {
            System.out.print(Cor.getVermelho() + "* Dígite o CPF do cliente que deseja fazer alterações: " + Cor.getReset());
            resposta = scan.nextLine();
        }
    
        if (ctrl.getCliente(resposta) != null)
        {   
            cpfCli = resposta;
            ClienteModel cliente = new ClienteModel();
            MoradiaModel moradia = new MoradiaModel();

            System.out.println("=======================" + Cor.getCiano() + "[Cliente " + ctrl.getCliente(cpfCli).getNome() +"] " + Cor.getReset() + "================================");
            System.out.println("[PRESS 1] - Nome atual: " + ctrl.getCliente(cpfCli).getNome());
            System.out.println("[PRESS 2] - CPF atual: " + ctrl.getCliente(cpfCli).getCpf());
            System.out.println("[PRESS 3] - Data de nascimento atual: " + ctrl.getCliente(cpfCli).getDtNasc());
            System.out.println("[PRESS 4] - [Moradia] Endereço atual: " + ctrl.getCliente(cpfCli).getMoradia().getEndereco());            
            System.out.println("[PRESS 5] - Para alterar o registro completo!");

            System.out.print("\n[Precione] a tecla indicada para alterar o campo desejado: ");
            resposta = scan.nextLine();
            while (resposta.isEmpty() || Integer.parseInt(resposta) <= 0 || Integer.parseInt(resposta) > 5)
            {
                System.out.print(Cor.getVermelho() + "* [Precione] a tecla indicada para alterar o campo desejado: " + Cor.getReset());
                resposta = scan.nextLine();
            }

            switch(resposta)
            {
                case "1":
                    // alteração de nome

                    System.out.print("Dígite o novo Nome: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo Nome: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setNome(resposta);
                    cliente.setCpf(ctrl.getCliente(cpfCli).getCpf());
                    cliente.setDtNasc(ctrl.getCliente(cpfCli).getDtNasc());
                    cliente.setMoradia(ctrl.getCliente(cpfCli).getMoradia());

                    System.out.print(Cor.getAmarelo() + "\nDigite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                    resposta = scan.nextLine();
                    while (resposta.isEmpty() || !resposta.contains("Y") && !resposta.contains("N"))
                    {
                        System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                        resposta = scan.nextLine();
                    }   

                    if (resposta.equals("Y"))
                    {
                        if (ctrl.atCliente(cpfCli, cliente))
                        { // cliente atualizado
                            getLinha();
                            System.out.println(Cor.getVerde() + "Cliente ATUALIZADO com SUCESSO!! ;D" + Cor.getReset());
                            getLinha();
        
                            int cont = 1;
                            for (ClienteModel cli: ctrl.getClientes())
                            {
                                System.out.println("============================" + Cor.getCiano() + "[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                                System.out.println("Nome: " + cli.getNome());
                                System.out.println("CPF: " + cli.getCpf());
                                System.out.println("Data de nascimento: " + cli.getDtNasc());
                                System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());
                                getLinha();
                                cont ++;
                            }                    
                        }
                        else 
                        {
                            getLinha();
                            System.out.println(Cor.getVermelho() + "Erro ao ATUALIZAR!! tente novamente ;-;" + Cor.getReset());
                            getLinha();
                        }
                    }
                    else if (resposta.equals("N")) 
                    {
                        System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..." + Cor.getReset());
                        areaCliente();
                    }
                
                    break;
                case "2":
                    // alteração de cpf

                    System.out.print("Dígite o novo CPF: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo CPF: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setNome(ctrl.getCliente(cpfCli).getNome());
                    cliente.setCpf(resposta);
                    cliente.setDtNasc(ctrl.getCliente(cpfCli).getDtNasc());
                    cliente.setMoradia(ctrl.getCliente(cpfCli).getMoradia());

                    System.out.print(Cor.getAmarelo() + "\nDigite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                    resposta = scan.nextLine();
                    while (resposta.isEmpty() || !resposta.contains("Y") && !resposta.contains("N"))
                    {
                        System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                        resposta = scan.nextLine();
                    }   

                    if (resposta.equals("Y"))
                    {
                        if (ctrl.atCliente(cpfCli, cliente))
                        { // cliente atualizado

                            getLinha();
                            System.out.println(Cor.getVerde() + "Cliente ATUALIZADO com SUCESSO!! ;D" + Cor.getReset());
                            getLinha();
        
                            int cont = 1;
                            for (ClienteModel cli: ctrl.getClientes())
                            {
                                System.out.println("============================" + Cor.getCiano() + "[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                                System.out.println("Nome: " + cli.getNome());
                                System.out.println("CPF: " + cli.getCpf());
                                System.out.println("Data de nascimento: " + cli.getDtNasc());
                                System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());
                                getLinha();
                                cont ++;
                            }                    
                        }
                        else 
                        {
                            getLinha();
                            System.out.println(Cor.getVermelho() + "Erro ao ATUALIZAR!! tente novamente ;-;" + Cor.getReset());
                            getLinha();
                        }
                    }
                    else if (resposta.equals("N")) 
                    {
                        System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..." + Cor.getReset());
                        areaCliente();
                    }
                    break;
                case "3":
                    // alteração de Data nasc

                    System.out.print("Dígite a nova Data de Nascimento: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite a nova Data de Nascimento: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setNome(ctrl.getCliente(cpfCli).getNome());
                    cliente.setCpf(ctrl.getCliente(cpfCli).getCpf());
                    cliente.setDtNasc(resposta);
                    cliente.setMoradia(ctrl.getCliente(cpfCli).getMoradia());

                    System.out.print(Cor.getAmarelo() + "\nDigite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                    resposta = scan.nextLine();
                    while (resposta.isEmpty() || !resposta.contains("Y") && !resposta.contains("N"))
                    {
                        System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                        resposta = scan.nextLine();
                    }   

                    if (resposta.equals("Y"))
                    {
                        if (ctrl.atCliente(cpfCli, cliente))
                        { // cliente atualizado
                            getLinha();
                            System.out.println(Cor.getVerde() + "Cliente ATUALIZADO com SUCESSO!! ;D" + Cor.getReset());
                            getLinha();
        
                            int cont = 1;
                            for (ClienteModel cli: ctrl.getClientes())
                            {
                                System.out.println("============================" + Cor.getCiano() + "[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                                System.out.println("Nome: " + cli.getNome());
                                System.out.println("CPF: " + cli.getCpf());
                                System.out.println("Data de nascimento: " + cli.getDtNasc());
                                System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());
                                getLinha();
                                cont ++;
                            }                    
                        }
                        else 
                        {
                            getLinha();
                            System.out.println(Cor.getVermelho() + "Erro ao ATUALIZAR!! tente novamente ;-;" + Cor.getReset());
                            getLinha();
                        }
                    }
                    else if (resposta.equals("N")) 
                    {
                        System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..." + Cor.getReset());
                        areaCliente();
                    }
                    break;
                case "4":
                    // alteração do endereço

                    System.out.print("Dígite o novo Endereço: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo Endereço: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setNome(ctrl.getCliente(cpfCli).getNome());
                    cliente.setCpf(ctrl.getCliente(cpfCli).getCpf());
                    cliente.setDtNasc(ctrl.getCliente(cpfCli).getDtNasc());
                    moradia.setEndereco(resposta);
                    cliente.setMoradia(moradia);

                    System.out.print(Cor.getAmarelo() + "\nDigite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                    resposta = scan.nextLine();
                    while (resposta.isEmpty() || !resposta.contains("Y") && !resposta.contains("N"))
                    {
                        System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                        resposta = scan.nextLine();
                    }   

                    if (resposta.equals("Y"))
                    {
                        if (ctrl.atCliente(cpfCli, cliente))
                        { // cliente atualizado
                            getLinha();
                            System.out.println(Cor.getVerde() + "Cliente ATUALIZADO com SUCESSO!! ;D" + Cor.getReset());
                            getLinha();
        
                            int cont = 1;
                            for (ClienteModel cli: ctrl.getClientes())
                            {
                                System.out.println("============================" + Cor.getCiano() + "[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                                System.out.println("Nome: " + cli.getNome());
                                System.out.println("CPF: " + cli.getCpf());
                                System.out.println("Data de nascimento: " + cli.getDtNasc());
                                System.out.println("\n[Moradia] Endereço: " + cli.getMoradia().getEndereco());                                
                                getLinha();
                                cont ++;
                            }                    
                        }
                        else 
                        {
                            getLinha();
                            System.out.println(Cor.getVermelho() + "Erro ao ATUALIZAR!! tente novamente ;-;" + Cor.getReset());
                            getLinha();
                        }
                    }
                    else if (resposta.equals("N")) 
                    {
                        System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..." + Cor.getReset());
                        areaCliente();
                    }                    
                    break;
                case "5":
                    // alteração completa
                    
                    System.out.print("Dígite o novo Nome: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo Nome: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setNome(resposta);
        
                    System.out.print("Dígite o novo CPF: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo CPF: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setCpf(resposta);

                    System.out.print("Dígite a nova Data de nascimento: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite a nova Data de nascimento: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }       
                    cliente.setDtNasc(resposta);
        
                    System.out.print("Dígite o novo Endereço: ");
                    resposta = scan.nextLine();
                    while (resposta.isEmpty())
                    {
                        System.out.print(Cor.getVermelho() + "* Dígite o novo Endereço: " + Cor.getReset());
                        resposta = scan.nextLine();
                    }    
                    moradia.setEndereco(resposta);   
                    cliente.setMoradia(moradia);

                    System.out.println(Cor.getAmarelo() + "\nVocê realmente deseja alterar o registro do(a) "+ ctrl.getCliente(cpfCli).getNome() +" com as seguintes informações:" + Cor.getReset());
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("CPF: " + cliente.getCpf());
                    System.out.println("Data de nascimento: " + cliente.getDtNasc());
                    System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());                    
                    getLinha();
                    System.out.print(Cor.getAmarelo() + "Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                    resposta = scan.nextLine();
                    while (resposta.isEmpty() || !resposta.contains("Y") && !resposta.contains("N"))
                    {
                        System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar!" + Cor.getReset());
                        resposta = scan.nextLine();
                    }   
                    if (resposta.equals("Y"))
                    {
                        if (ctrl.atCliente(cpfCli, cliente))
                        { // cliente atualizado
                            
                            getLinha();
                            System.out.println(Cor.getVerde() + "Cliente ATUALIZADO com SUCESSO!! ;D" + Cor.getReset());
                            getLinha();
        
                            int cont = 1;
                            for (ClienteModel cli: ctrl.getClientes())
                            {
                                System.out.println("============================" + Cor.getCiano() + "[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                                System.out.println("Nome: " + cli.getNome());
                                System.out.println("CPF: " + cli.getCpf());
                                System.out.println("Data de nascimento: " + cli.getDtNasc());
                                System.out.println("\n[Moradia] Endereço: " + cliente.getMoradia().getEndereco());
                                getLinha();
                                cont ++;
                            }                    
                        }
                        else 
                        {
                            getLinha();
                            System.out.println(Cor.getVermelho() + "Erro ao ATUALIZAR!! tente novamente ;-;" + Cor.getReset());
                            getLinha();
                        }
                    }
                    else if (resposta.equals("N")) 
                    {
                        System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..." + Cor.getReset());
                        areaCliente();
                    }
                    break;
            }
        }
        else
        {
            getLinha();
            System.out.println(Cor.getVermelho() + "Nenhum cliente cadastrado contém esse CPF: " + resposta + Cor.getReset());
        }
    }
    private void deletarCliente() 
    {
        Global.clearConsole();
        getHeaderDeletarCliente();

        String cpfCli;

        if (ctrl.getClientes().isEmpty())
        {
            System.out.println(Cor.getVermelho() + "Nenhum registro de cliente para poder DELETAR!! ;-;" + Cor.getReset());
            return;
        } 

        System.out.print(Cor.getAmarelo() + "Dígite o CPF do cliente que deseja DELETAR: " + Cor.getReset());
        resposta = scan.nextLine();
        while (resposta.isEmpty() || ctrl.getCliente(resposta) == null)
        {
            if (ctrl.getCliente(resposta) == null)
            {
                System.out.print(Cor.getVermelho() + "* Ocorrência de CPF não encontrada!! tente outro: " + Cor.getReset());
            }
            else 
            {
                System.out.print(Cor.getVermelho() + "* Dígite o CPF do cliente que deseja DELETAR: " + Cor.getReset());
            }
            resposta = scan.nextLine();
        }

        if (ctrl.getCliente(resposta) != null)
        {   
            cpfCli = resposta;
            System.out.println(Cor.getAmarelo() + "\nEsse cpf pertence ao cliente: "+ ctrl.getCliente(resposta).getNome());
            System.out.println("Realmente deseja DELETAR ele?" + Cor.getReset());
            System.out.print(Cor.getVermelho() + "Digite [Y] para confirmar, ou [N] para cancelar: " + Cor.getReset());
            resposta = scan.nextLine();
            while (resposta.equals("") || !resposta.contains("Y") && !resposta.contains("N"))
            {
                System.out.print(Cor.getVermelho() + "* Digite [Y] para confirmar, ou [N] para cancelar: " + Cor.getReset());
                resposta = scan.nextLine();
            }   
            if (resposta.equals("Y"))
            {
               ctrl.delCliente(cpfCli);
               getLinha();
               System.out.println(Cor.getVerde() + "Cliente DELETADO com SUCESSO!! ;D" + Cor.getReset());
               getLinha();

               int cont = 1;
               for (ClienteModel cli: ctrl.getClientes())
               {
                   System.out.println("============================" + Cor.getCiano() +"[ Cliente "+ cont +" ]"+Cor.getReset()+"============================" );
                   System.out.println("Nome: " + cli.getNome());
                   System.out.println("CPF: " + cli.getCpf());
                   System.out.println("Data de nascimento: " + cli.getDtNasc());
                   getLinha();
                   cont ++;
               }                 
            }
            else if (resposta.equals("N")) 
            {
                System.out.println(Cor.getAmarelo() + "Operação sendo cancelada! retornando para a Área do Cliente..."  + Cor.getReset());
                areaCliente();
            }
        }
    }
    public static void getLinha()
    {
         System.out.println("=====================================================================");
    }
    public static void getHeaderAreaCliente()
    {
        getLinha();
        System.out.println("==================>" + Cor.getAzul() + " [ ÁREA DO CLIENTE ] " + Cor.getReset() + "<============================");
    }
    public static void getHeaderCadastroCliente()
    {
        getLinha();
        System.out.println("=========>" + Cor.getAzul() + " [ ÁREA DO CLIENTE - CADASTRAR UM NOVO CLIENTE ]" + Cor.getReset() + " <=========");
        getLinha();
    }
    public static void getHeaderConsultaCliente()
    {
        getLinha();
        System.out.println("======> " + Cor.getAzul() + "[ ÁREA DO CLIENTE - CONSULTAR UM CLIENTE (PELO CPF)] " + Cor.getReset() +"<=======");
        getLinha();
    }
    public static void getHeaderAllClientes()
    {
        getLinha();
        System.out.println("========> " + Cor.getAzul() + "[ ÁREA DO CLIENTE - TODOS CLIENTES CADASTRADOS: ] " + Cor.getReset() +"<========");
        getLinha();
    }
    private void getHeaderAtualizarCliente() 
    {
        getLinha();
        System.out.println("===========>" + Cor.getAzul() +" [ ÁREA DO CLIENTE - ATUALIZAR UM CLIENTE: ] " + Cor.getReset() +"<===========");
        getLinha();
    }
    private void getHeaderDeletarCliente() 
    {
        getLinha();
        System.out.println("============> " + Cor.getAzul() + "[ ÁREA DO CLIENTE - DELETAR UM CLIENTE: ] " + Cor.getReset() +"<============");
        getLinha();
    }
}