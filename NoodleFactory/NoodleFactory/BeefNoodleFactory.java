package NoodleFactory;
import NoodleBuilder.*;

public class BeefNoodleFactory extends AbstractFactoryNoodle{
    public Noodle makeNoodle(){
        Chef chef = new Chef(new BeefNoodle());
        chef.createNoodle();
        return chef.getNoodle();
    }




}
