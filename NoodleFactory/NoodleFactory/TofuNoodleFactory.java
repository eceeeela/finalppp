package NoodleFactory;

import NoodleBuilder.TofuNoodle;
import NoodleBuilder.Chef;
import NoodleBuilder.Noodle;

public class TofuNoodleFactory extends AbstractFactoryNoodle{
    public Noodle makeNoodle(){
        Chef chef = new Chef(new TofuNoodle());
        chef.createNoodle();
        return chef.getNoodle();
    }
}
