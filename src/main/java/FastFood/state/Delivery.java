package FastFood.state;

public class Delivery  implements iState{
    @Override
    public void Step(State state) {

        System.out.println("Delivery Step");
    }
}
