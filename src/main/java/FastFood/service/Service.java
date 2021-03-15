package FastFood.service;

import FastFood.model.Receipts;
import FastFood.state.Start;
import FastFood.state.State;
import FastFood.dao.doa;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("service")
public class Service {
    public void run() throws Exception {
        Scanner _scan = new Scanner(System.in);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        doa DB = context.getBean("DB", doa.class);
        DB.getBD();


        State state = new State(new Start());

        do {
            state.Step();
            state.nextState();
        }while (state.EndLoop());
        Receipts receipts = state.getReceipts();
        System.out.println("Enter id: " +" name: "+receipts.getName()+ " sum: "+ receipts.getSum());

        DB.AddToDB(_scan.nextInt(), receipts.getName(), receipts.getSum());
    }
}
