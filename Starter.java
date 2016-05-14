public class Starter
{
    public static void main(String args[])
    {
        LogoEngine lE = new LogoEngine();//constructing new LogoEngine object and assigning it to the object
        //referenced by lE
        lE.createUI();//invoking mutator method createUI on the object referenced by lE    
    }
}
