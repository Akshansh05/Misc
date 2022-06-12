package AdaptorPattern;

//This class is making ToyDuck adapt to Bird
public class BirdAdaptor implements ToyDuck {

    Bird bird;

    public BirdAdaptor(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}
