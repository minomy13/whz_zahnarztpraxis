import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000, 2005, 0, 1, 8, 00, 00);

        practise.getEmployeeHandler().hireEmployee("Alice", "Receptionist");
        practise.getEmployeeHandler().hireEmployee("Amy", "Dentist Assistant");
        practise.getEmployeeHandler().hireEmployee("Karl", "Dentist");
        practise.getEmployeeHandler().viewEmployees();
        //dental hygienists, dental assistants, dental laboratory technicians, and receptionists

        practise.getEmployeeHandler().employeeCome(0);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeCome(1);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeCome(2);
        System.out.println (practise.getEmployeeHandler().getEmployeeName(0) + " " + practise.getEmployeeHandler().getEmployeeCome(0) + "\n"
                            practise.getEmployeeHandler().getEmployeeName(1) + " " + practise.getEmployeeHandler().getEmployeeCome(1) + "\n"
                            practise.getEmployeeHandler().getEmployeeName(2) + " " + practise.getEmployeeHandler().getEmployeeCome(2));

        practise.getPatientHandler().getPatientFileHandler().create("Bob");
        //TODO create more Patients & their Reports

        HashMap<Item, Integer> stock = new HashMap<>();
        stock.put(Item.BEAKER, 5);
        stock.put(Item.COTTON_PAD, 15);
        stock.put(Item.MOUTH_MIRROR, 23);
        stock.put(Item.DENTAL_SYRINGE, 11);
        stock.put(Item.DENTAL_PROBE, 18);
        stock.put(Item.ANESTHETIC, 5);
        stock.put(Item.WHITENING_STRIPS, 8);

        try{System.out.println(practise.getStockHandler().getAllStocks());
        } catch (Exception e) {
            logger.error(e.getMessage());}

        //TreatmentType(String name, double cost, HashMap<Item, Integer> needs)
        //Treatment(TreatmentType treatmentType, Patient patient)

        try {
            practise.getPatientHandler().addTreatmentType("Check-Up", 25, Map.of(Item.MOUTH_MIRROR, 1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getPatientHandler().addTreatmentType("Cleaning", 78, Map.of(Item.MOUTH_MIRROR, 1,Item.DENTAL_PROBE, 2));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getPatientHandler().addTreatmentType("Removal", 100, Map.of(Item.MOUTH_MIRROR, 1,Item.DENTAL_SYRINGE,1,Item.ANESTHETIC,1,Item.DENTAL_PROBE, 3,Item.COTTON_PAD, 4));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getPatientHandler().addTreatmentType("Whitening", 164, Map.of(Item.MOUTH_MIRROR, 1,Item.DENTAL_PROBE, 3,Item.COTTON_PAD, 2, Item.WHITENING_STRIPS, 2));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }


        try {
            practise.addTreatment(practise.getPatientHandler().getTreatmentType("CHECK-UP"),
                    practise.getPatientHandler().getPatientFileHandler().getFiles().get(0));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.addTreatment(practise.getPatientHandler().getTreatmentType("Whitening"),
                    practise.getPatientHandler().getPatientFileHandler().getFiles().get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.addTreatment(practise.getPatientHandler().getTreatmentType("CHECK-UP"),
                    practise.getPatientHandler().getPatientFileHandler().getFiles().get(2));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.addTreatment(practise.getPatientHandler().getTreatmentType("Removal"),
                    practise.getPatientHandler().getPatientFileHandler().getFiles().get(3));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println(practise.getPatientHandler().getTreatmentTypes());
        try {
            practise.getStockHandler().take(Item.MOUTH_MIRROR, 1);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
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

        practise.getCalendar().nextHour();

        practise.getEmployeeHandler().employeeGo(2);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeGo(1);
        practise.getCalendar().addMinutes(30);
        practise.getEmployeeHandler().employeeGo(0);
        System.out.println (practise.getEmployeeHandler().getEmployeeName(0) + " " + practise.getEmployeeHandler().getEmployeeGo(0) + "\n"
                            practise.getEmployeeHandler().getEmployeeName(1) + " " + practise.getEmployeeHandler().getEmployeeGo(1) + "\n"
                            practise.getEmployeeHandler().getEmployeeName(2) + " " + practise.getEmployeeHandler().getEmployeeGo(2));

        //muss am ende des Tages ausgeführt werden (speichert alle come and go Zeiten in eine Map)
        System.out.println("Alle Employee come and go Zeiten werden, mit dem Datum als Key, abgespeichert");
        practise.getEmployeeHandler().addEmployeeTimeStamp();
        System.out.println("come and go eines bestimmten Employee (Key = Datum + Key = Name) wird ausgelesen");
        System.out.println(practise.getEmployeeHandler().getComeAndGo("1.0.2005", practise.getEmployeeHandler().getEmployeeName(1)));
        System.out.println("come and go aller Employees (Key = Datum) werden ausgegeben");
        practise.getEmployeeHandler().getComeAndGoAll("1.0.2005");
    }
}