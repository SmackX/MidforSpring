package FastFood.state;


import FastFood.model.Receipts;
import FastFood.state.*;
import org.springframework.stereotype.Component;

@Component("state")
public class State {
    Receipts receipts = new Receipts();
    iState state;
    String thisState;

    public State(iState state){
        this.state = state;
    }

    public Receipts getReceipts() {
        return receipts;
    }

    public iState getState() {
        return state;
    }

    public void setState(iState state) {
        this.state = state;
    }
    public void nextState() {
        if (state instanceof Start) {
            setState(new Select());
        } else if (state instanceof Select) {
            receipts.setName(getThisState());
            setState(new Count());
        } else if (state instanceof Count) {
            receipts.setSum(Integer.parseInt(getThisState()));
            setState(new Basket());
        } else if (state instanceof Basket){
            setState(new Delivery());
        }else if (state instanceof Delivery){
            endStep = false;
        }
    }

    public String getThisState() {
        return thisState;
    }

    public void setThisState(String thisState) {
        this.thisState = thisState;
    }
    public void Step() throws Exception {
        state.Step(this);
    }
    private boolean endStep = true;
    public boolean EndLoop(){
        return endStep;
    }
}
