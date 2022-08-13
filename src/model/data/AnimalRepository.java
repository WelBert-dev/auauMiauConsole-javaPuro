package src.model.data;

import java.util.ArrayList;

import src.model.AnimalModel;

public class AnimalRepository
{
    private static ArrayList<AnimalModel> animais = new ArrayList<AnimalModel>();

    public AnimalModel getAnimal(int id)
    {
        try 
        {
            for (AnimalModel animal: animais)
            {
                if (animal.getId() == id)
                {
                    return animal;
                }
            }
            return null;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
    public boolean setAnimal(AnimalModel animal)
    {
        try 
        {
            animais.add(animal);
            return true;
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
            return animais;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}