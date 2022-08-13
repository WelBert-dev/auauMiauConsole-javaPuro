package src.model.data;

import java.util.ArrayList;

import src.model.ClienteModel;

public class ClienteRepository
{
    private static ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();

    public ClienteModel getCliente(String cpf)
    {
        try 
        {
            for (ClienteModel cliente: clientes)
            {
                if (cliente.getCpf().equals(cpf))
                {
                    return cliente;
                }
            }
            return null;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public boolean setCliente(ClienteModel cliente)
    {
        try 
        {
            clientes.add(cliente);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    public ArrayList<ClienteModel> getClientes()
    {
        try 
        {
            return clientes;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public boolean atCliente(String cpf, ClienteModel cliente)
    {
        try 
        {
            for (int i = 0; i < (clientes.size()); i++)
            {
                if (clientes.get(i).getCpf().equals(cpf))
                {
                    clientes.set(i, cliente);
                    return true;
                }
            }
            return false;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
    public boolean delCliente(String cpf)
    {
        try 
        {
            for (int i = 0; i < (clientes.size()); i++)
            {
                if (clientes.get(i).getCpf().equals(cpf))
                {
                    clientes.remove(clientes.get(i));
                    return true;
                }
            }
            return false;
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}