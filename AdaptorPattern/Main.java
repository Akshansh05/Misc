package AdaptorPattern;

public class Main {
    public static void main(String[] args) {

        Bird sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        //This class is making ToyDuck adapt to Bird
        BirdAdaptor birdAdaptor = new BirdAdaptor(sparrow);

        sparrow.fly();
        sparrow.makeSound();

        toyDuck.squeak();
        birdAdaptor.squeak();
    }
}
