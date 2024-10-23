package NoodleBuilder;

public class Chef {
    private final AbstractNoodleBuilder noodleBuilder;

    public Chef(AbstractNoodleBuilder noodleBuilder){
        this.noodleBuilder = noodleBuilder;
    }

    public void createNoodle(){
        noodleBuilder.addNoodleName();

     noodleBuilder.addPrice();
    }

    public Noodle getNoodle(){return noodleBuilder.getNoodle();}
}
