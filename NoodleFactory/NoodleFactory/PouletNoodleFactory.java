package NoodleFactory;
import NoodleBuilder.*;

public class PouletNoodleFactory extends AbstractFactoryNoodle{
    public Noodle makeNoodle(){
        Chef chef = new Chef(new PouletNoodle());
        chef.createNoodle();
        return chef.getNoodle();
    }


}
