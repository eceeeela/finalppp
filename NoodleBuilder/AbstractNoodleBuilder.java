package NoodleBuilder;

public abstract class AbstractNoodleBuilder {
    protected Noodle noodle;

    public AbstractNoodleBuilder() {
        this.noodle=new Noodle();
    }

    public abstract void addNoodleName();

    public abstract void addPrice();

    public Noodle getNoodle() {
        return noodle;
    }}