package Class_3;

public class BoxWeight extends Box {
    double weight;

    public BoxWeight(long h, long d, double weight) {
        super(h, d);
        //this has to be called first and cannot be called after initializing this.weight
        //because the parent class or the superclass doesn't know what all are there in the child class

        this.weight = weight;
    }
}
