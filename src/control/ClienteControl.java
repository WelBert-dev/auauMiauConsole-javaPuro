package src.control;

import java.util.ArrayList;

import src.model.ClienteModel;
import src.model.data.ClienteRepository;

public class ClienteControl 
{
    public ClienteModel getCliente(String cpf)
    {
        try 
        {
            return new ClienteRepository().getCliente(cpf);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    public boolean setCliente(ClienteModel cliente)
    {
        try 
        {
            return new ClienteRepository().setCliente(cliente);
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
            return new ClienteRepository().getClientes();
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
            return new ClienteRepository().atCliente(cpf, cliente);
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
           return new ClienteRepository().delCliente(cpf);
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
