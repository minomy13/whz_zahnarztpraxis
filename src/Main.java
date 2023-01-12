import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.HashMap;
import practise.*;
public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000,2005,0,1 ,8,00, 00);

        practise.getEmployeeHandler().hireEmployee("Karl", "Dentist");
        practise.getEmployeeHandler().hireEmployee("Amy", "Dentist Assistant");
        practise.getEmployeeHandler().hireEmployee("ALice", "Receptionist");

        practise.getEmployeeHandler().employeeCome(0);
        //halbe stunde vergeht
        practise.getEmployeeHandler().employeeCome(1);
        //halbe stunde vergeht
        practise.getEmployeeHandler().employeeCome(2);

        practise.getPatientHandler().getPatientFileHandler().create("Bob");
        //TODO create more Patients & their Reports

        HashMap<Item, Integer> n = new HashMap<>();
        n.put(Item.COTTON_PAD, 15);
        logger.info(practise.getBudget());

        practise.getStockHandler().buy(Item.COTTON_PAD, 15, .36);
        //TODO enter more items

        try {
            logger.info(practise.getStockHandler().getStock(Item.COTTON_PAD));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info(practise.getBudget());
        System.out.println(practise.getCalendar().getTime());
        //TODO calendar, termine, etc.

        //muss am ende des tages ausgeführt werden(speichert alle come and go zeiten in eine liste
        practise.getEmployeeHandler().addEmployeesComeAndGo();
    }
}