package FastFood.state;

import java.util.Scanner;

public class Count  implements iState{

    @Override
    public void Step(State state) {
        Scanner _scan = new Scanner(System.in);
        System.out.println("Count Step");
        System.out.println("sum");
        String tmp = _scan.next();
        state.setThisState(tmp);
    }
}
