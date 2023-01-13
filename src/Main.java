import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.HashMap;
import practise.*;
public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000,2005,0,1 ,8,00, 00);

        System.out.println("Es werden drei Employees eingestellt: Karl, Dentist; Amy, Dentist Assistant; Alice, Receptionist");
        practise.getEmployeeHandler().hireEmployee("Alice", "Receptionist");
        practise.getEmployeeHandler().hireEmployee("Amy", "Dentist Assistant");
        practise.getEmployeeHandler().hireEmployee("Karl", "Dentist");

        System.out.println("Die Employees stempeln sich ein: Alice kommt; +1/2 Stunde; Amy kommt; +1/2 Stunde; Karl kommt;");
        practise.getEmployeeHandler().employeeCome(0);
        //TODO halbe stunde vergeht
        practise.getEmployeeHandler().employeeCome(1);
        //TODO halbe stunde vergeht
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

        practise.getCalendar().nextHour();

        System.out.println("Die Employees stempeln sich aus: Karl geht; +1/2 Stunde; Amy geht; +1/2 Stunde; Alice geht");
        practise.getEmployeeHandler().employeeGo(2);
        //TODO halbe stunde vergeht
        practise.getEmployeeHandler().employeeGo(1);
        //TODO halbe stunde vergeht
        practise.getEmployeeHandler().employeeGo(0);

        //muss am ende des Tages ausgeführt werden (speichert alle come and go Zeiten in eine Map)
        System.out.println("Alle Employee come and go Zeiten werden mit dem Datum als Key abgespeichert");
        practise.getEmployeeHandler().addEmployeeTimeStamp();
        System.out.println("come and go eines bestimmten Employee (Key Datum + Key Name) wird ausgelesen");
        System.out.println(practise.getEmployeeHandler().getComeAndGo("1.0.2005", practise.getEmployeeHandler().getEmployeeName(1)));
        System.out.println("come and go aller Employees (Key Datum) werden ausgegeben");
        practise.getEmployeeHandler().getComeAndGoAll("1.0.2005");
    }
}