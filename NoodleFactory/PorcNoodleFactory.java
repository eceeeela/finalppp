package NoodleFactory;

import NoodleBuilder.PorcNoodle;
import NoodleBuilder.Chef;
import NoodleBuilder.Noodle;

public class PorcNoodleFactory extends AbstractFactoryNoodle{
    public Noodle makeNoodle(){
        Chef chef = new Chef(new PorcNoodle());
        chef.createNoodle();
        return chef.getNoodle();
    }
}
