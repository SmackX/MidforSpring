package FastFood.state;

import java.util.Scanner;

public class Basket  implements iState{
    @Override
    public void Step(State state) {
        Scanner _scan = new Scanner(System.in);
        System.out.println("Basket Step");
        state.setThisState(_scan.next());
    }
}
