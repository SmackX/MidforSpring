package FastFood.state;

public class Start implements iState{
    @Override
    public void Step(State state) {
        System.out.println("Welcome!");
    }
}
