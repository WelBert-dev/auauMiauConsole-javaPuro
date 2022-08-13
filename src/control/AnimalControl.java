package src.control;

import java.util.ArrayList;

import src.model.AnimalModel;
import src.model.data.AnimalRepository;

public class AnimalControl 
{
    public AnimalModel getAnimal(int id)
    {
        try 
        {
            return new AnimalRepository().getAnimal(id);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    public boolean setAnimal(AnimalModel animal)
    {
        try 
        {
            return new AnimalRepository().setAnimal(animal);
        }
        catch (Exception ex) 
        {
            return false;
        }
    }
    public ArrayList<AnimalModel> getAnimais()
    {
        try 
        {
            return new AnimalRepository().getAnimais();
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
