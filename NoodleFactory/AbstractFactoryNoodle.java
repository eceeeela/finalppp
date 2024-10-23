package NoodleFactory;
import NoodleBuilder.Noodle;

public abstract class AbstractFactoryNoodle {

    public static AbstractFactoryNoodle factoryNoodle(String type){
        AbstractFactoryNoodle factory = null;
        switch (type){
            case "FISH":
                factory = new TofuNoodleFactory();
                break;
            case "BEEF":
                factory = new BeefNoodleFactory();
                break;
            case "CHICKEN":
                factory = new PouletNoodleFactory();
                break;
            case "PORK":
                factory = new PorcNoodleFactory();
                break;
        }
        return factory;
    }
    public abstract Noodle makeNoodle();
}
