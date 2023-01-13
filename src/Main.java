import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.Calendar;
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
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeCome(1);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeCome(2);

        practise.getPatientHandler().getPatientFileHandler().create("Bob");
        //TODO create more Patients & their Reports

        HashMap<Item, Integer> stock = new HashMap<>();
        stock.put(Item.BEAKER, 4);
        stock.put(Item.COTTON_PAD, 15);
        stock.put(Item.MOUTH_MIRROR, 23);
        stock.put(Item.DENTAL_SYRINGE, 11);
        stock.put(Item.DENTAL_PROBE, 18);

        HashMap<Item, Integer> needs1 = new HashMap<>();
        needs1.put(Item.MOUTH_MIRROR, 1);
        //TreatmentType(String name, double cost, HashMap<Item, Integer> needs)
        //Treatment(TreatmentType treatmentType, Patient patient)

        practise.getPatientHandler().addTreatmentType("Check-Up", 25, needs1);
        practise.addTreatment(practise.getPatientHandler().getTreatmenType(),);
        practise.getStockHandler().take(Item.MOUTH_MIRROR, 1);
        logger.info(practise.getBudget());

        practise.getStockHandler().buy(Item.COTTON_PAD, 15, .36);

        try {
            logger.info(practise.getStockHandler().getStock(Item.COTTON_PAD));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info(practise.getBudget());
        System.out.println(practise.getCalendar().getTime());
        //TODO calendar, termine, etc.

        practise.getEmployeeHandler().employeeGo(2);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeGo(1);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeGo(0);

        //muss am ende des tages ausgeführt werden (speichert alle come and go zeiten in eine liste)
        practise.getEmployeeHandler().addEmployeesComeAndGo();
        //gibt come and go von einem eployee(index) aus
        System.out.println(practise.getEmployeeHandler().getEmployee(1) + ": " + practise.getEmployeeHandler().getComeAndGo("1.0.5", practise.getEmployeeHandler().getEmployee(1)));
        System.out.println(practise.getEmployeeHandler().getComeAndGoAll("1.0.5"));
    }
}