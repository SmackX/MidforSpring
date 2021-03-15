package FastFood.state;

import java.util.Scanner;

public class Select implements iState{
    @Override
    public void Step(State state) {
        Scanner _scan = new Scanner(System.in);
        System.out.println("Select Step");
        System.out.println("Your name?");
        String tmp = _scan.next();
        state.setThisState(tmp);
    }
}
