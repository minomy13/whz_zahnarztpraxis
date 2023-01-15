import practise.Practise;
import practise.stock.Item;
import utils.logger.Logger;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        Practise practise = new Practise(1000, 2022, 0, 1, 8, 00, 00);

        System.out.println(practise.getCalendar().getTime());

        System.out.println("\n\n");

        logger.info("Hiring new employees...");
        practise.getEmployeeHandler().hireEmployee("Alice", "Receptionist");
        practise.getEmployeeHandler().hireEmployee("Amy", "Dental Assistant");
        practise.getEmployeeHandler().hireEmployee("Karl", "Dentist");
        practise.getEmployeeHandler().viewEmployees();
        //dental hygienists, dental assistants, dental laboratory technicians, and receptionists

        System.out.println("\n --- \n");

        practise.getEmployeeHandler().employeeCome(0);
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeCome(1);
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeCome(2);
        logger.info("Employees arriving...\n" + practise.getEmployeeHandler().getEmployeeName(0) + " " + practise.getEmployeeHandler().getEmployeeCome(0) + "\n" +
                practise.getEmployeeHandler().getEmployeeName(1) + " " + practise.getEmployeeHandler().getEmployeeCome(1) + "\n" +
                practise.getEmployeeHandler().getEmployeeName(2) + " " + practise.getEmployeeHandler().getEmployeeCome(2));

        System.out.println("\n --- \n");

        logger.info("Buying new stock...");
        practise.getStockHandler().buy(Item.PLASTIC_CUP, 5, 0.02);
        practise.getStockHandler().buy(Item.COTTON_PAD, 15, 0.05);
        practise.getStockHandler().buy(Item.MOUTH_MIRROR, 23, 5.99);
        practise.getStockHandler().buy(Item.DENTAL_SYRINGE, 11, 1.3);
        practise.getStockHandler().buy(Item.DENTAL_PROBE, 18, 4.03);
        practise.getStockHandler().buy(Item.ANESTHETIC, 5, 23);
        practise.getStockHandler().buy(Item.WHITENING_STRIPS, 8, 11);

        try {
            logger.info("Stock is now: " + practise.getStockHandler().getAllStocks());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println("\n --- \n");

        logger.info("Adding treatment types and rooms...");
        try {
            practise.getPatientHandler().addTreatmentType("Check-Up", 25, Map.of(Item.MOUTH_MIRROR, 1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.addRoom(practise.getPatientHandler().getTreatmentType("Check-Up"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            practise.getPatientHandler().addTreatmentType("Cleaning", 78, Map.of(Item.MOUTH_MIRROR, 1, Item.DENTAL_PROBE, 2, Item.PLASTIC_CUP, 1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            practise.addRoom(practise.getPatientHandler().getTreatmentType("Cleaning"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            practise.getPatientHandler().addTreatmentType("Removal", 100, Map.of(Item.MOUTH_MIRROR, 1, Item.DENTAL_SYRINGE, 1, Item.ANESTHETIC, 1, Item.DENTAL_PROBE, 3, Item.COTTON_PAD, 4, Item.PLASTIC_CUP, 1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            practise.addRoom(practise.getPatientHandler().getTreatmentType("Removal"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getPatientHandler().addTreatmentType("Whitening", 164, Map.of(Item.MOUTH_MIRROR, 1, Item.DENTAL_PROBE, 3, Item.COTTON_PAD, 2, Item.WHITENING_STRIPS, 2, Item.PLASTIC_CUP, 1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            practise.addRoom(practise.getPatientHandler().getTreatmentType("Whitening"));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        practise.getPatientHandler().viewTreatmentTypes();
        System.out.println();
        practise.viewRoomHandler();

        System.out.println("\n --- \n");

        logger.info("Creating new patient files...");
        logger.info("Creating patient file for \"Bob\", born in 1996...");
        practise.getPatientHandler().getPatientFileHandler().create("Bob", 1996);
        try {
            practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1996)
                    .createReport("Due for regular Check-Up", practise.getPatientHandler().getTreatmentTypeIndex("Check-Up"));
            logger.success("Success!");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info("Creating patient file for \"Max\", born in 2001...");
        practise.getPatientHandler().getPatientFileHandler().create("Max", 2001);
        try {
            practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Max", 2001)
                    .createReport("Patient requested whitening", practise.getPatientHandler().getTreatmentTypeIndex("Whitening"));
            logger.success("Success!");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        logger.info("Creating patient file for \"Bob\", born in 1987...");
        practise.getPatientHandler().getPatientFileHandler().create("Bob", 1987);
        try {
            practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1987)
                    .createReport("Needs tooth removed", practise.getPatientHandler().getTreatmentTypeIndex("Removal"));
            logger.success("Success!");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println("\n --- \n");

        try {
            logger.info("Amount of mouth mirrors in stock is " + practise.getStockHandler().getStock(Item.MOUTH_MIRROR));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("Taking a mouth mirror from stock...");
        try {
            practise.getStockHandler().take(Item.MOUTH_MIRROR, 1);
            logger.success("Success! Amount of mouth mirrors in stock is now " +
                    practise.getStockHandler().getStock(Item.MOUTH_MIRROR));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        System.out.println("\n --- \n");

        logger.info("Adding appointments to calendar...");
        try {
            practise.getRoomHandler().get(0).getAppointmentCalendar().addAppointment(2022, 0, 1, 11, 20, 11, 40,
                    practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1996));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getRoomHandler().get(0).getAppointmentCalendar().addAppointment(2022, 0, 1, 11, 30, 12, 0,
                    practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Max", 2001));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        try {
            practise.getRoomHandler().get(0).getAppointmentCalendar().addAppointment(2022, 0, 1, 13, 0, 13, 20,
                    practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1987));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        if (practise.getRoomHandler().get(0).getAppointmentCalendar().getAppointmentMap().size() == 3)
            logger.success("Success!");

        System.out.println("\n --> advance time by 8h --> \n");
        try {
            practise.advanceTime(0, 8, 0);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getCalendar().getCurrentTime();

        logger.success("Appointments done!");

        System.out.println("\n --- \n");

        logger.info("Employees going home...");
        practise.getEmployeeHandler().employeeGo(2);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(2)));

        System.out.println("\n --> advance time by 30min --> \n");
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeGo(1);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(1)));

        System.out.println("\n --> advance time by 30min --> \n");
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeGo(0);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(0)));

        System.out.println("\n --- \n");

        logger.info("Summary of day 1:");
        practise.getEmployeeHandler().addEmployeeTimeStamp();
        //System.out.println(practise.getEmployeeHandler().getComeAndGo("1.0.2022", practise.getEmployeeHandler().getEmployeeName(0)));
        practise.getEmployeeHandler().getComeAndGoAll("1.0.2022");
        System.out.println();
        practise.getEmployeeHandler().getWorkTime();

        System.out.println("\n --- \n");
        try {
            practise.advanceTime(8, 16, 00);
        } catch(Exception e ) {
            logger.error(e.getMessage());
        }
        System.out.println("Skip to: " + practise.getCalendar().getTime());

        logger.info("Hiring new employee...");
        practise.getEmployeeHandler().hireEmployee("Paul", "dental hygenienist");
        practise.getEmployeeHandler().viewEmployees();

        System.out.println("\n --- \n");
        System.out.println("\n --- \n");

        try {
            practise.advanceTime(0, 0, 10);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeCome(0);
        try {
        practise.advanceTime(0, 0, 20);
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        practise.getEmployeeHandler().employeeCome(1);
        try {
        practise.advanceTime(0, 0, 30);
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        practise.getEmployeeHandler().employeeCome(2);
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeCome(3);

        logger.info("Employees arriving...\n" + practise.getEmployeeHandler().getEmployeeName(0) + " " + practise.getEmployeeHandler().getEmployeeCome(0) + "\n" +
            practise.getEmployeeHandler().getEmployeeName(1) + " " + practise.getEmployeeHandler().getEmployeeCome(1) + "\n" +
            practise.getEmployeeHandler().getEmployeeName(2) + " " + practise.getEmployeeHandler().getEmployeeCome(2) + "\n" +
            practise.getEmployeeHandler().getEmployeeName(3) + " " + practise.getEmployeeHandler().getEmployeeCome(3));

        System.out.println("\n --- \n");

        logger.info("Buying new stock...");
        practise.getStockHandler().buy(Item.PLASTIC_CUP, 27, 0.02);
        practise.getStockHandler().buy(Item.COTTON_PAD, 5, 0.05);
        practise.getStockHandler().buy(Item.MOUTH_MIRROR, 12, 5.99);
        practise.getStockHandler().buy(Item.DENTAL_SYRINGE, 6, 1.3);
        practise.getStockHandler().buy(Item.DENTAL_PROBE, 19, 4.03);
        practise.getStockHandler().buy(Item.ANESTHETIC, 14, 23);
        practise.getStockHandler().buy(Item.WHITENING_STRIPS, 5, 11);

        try {
        logger.info("Stock is now: " + practise.getStockHandler().getAllStocks());
    } catch (Exception e) {
        logger.error(e.getMessage());
    }

        System.out.println("\n --- \n");

        practise.getPatientHandler().viewTreatmentTypes();
        System.out.println();
        practise.viewRoomHandler();

        System.out.println("\n --- \n");

        logger.info("Creating new patient file...");
        logger.info("Creating patient file for \"Kathrine\", born in 1965...");
        practise.getPatientHandler().getPatientFileHandler().create("Kathrine", 1965);
        try {
        practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Kathrine", 1965)
                .createReport("Due for a Check-Up", practise.getPatientHandler().getTreatmentTypeIndex("Check-Up"));
        logger.success("Success!");
    } catch (Exception e) {
        logger.error(e.getMessage());
    }

        try {
        practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1996)
                .createReport("Has to have a tooth removed", practise.getPatientHandler().getTreatmentTypeIndex("Removal"));
        logger.success("Success!");
    } catch (Exception e) {
        logger.error(e.getMessage());
    }

        System.out.println("\n --- \n");

        try {
        logger.info("Amount of Cotton Pad in stock is " + practise.getStockHandler().getStock(Item.COTTON_PAD));
    } catch (Exception e) {
        logger.error(e.getMessage());
    } //TODO taken items and stock
        logger.info("Taking a mouth mirror from stock...");
        try {
        practise.getStockHandler().take(Item.MOUTH_MIRROR, 1);
        logger.success("Success! Amount of mouth mirrors in stock is now " +
                practise.getStockHandler().getStock(Item.MOUTH_MIRROR));
    } catch (Exception e) {
        logger.error(e.getMessage());
    }

        System.out.println("\n --- \n");

        logger.info("Adding appointments to calendar...");
        try {
        practise.getRoomHandler().get(0).getAppointmentCalendar().addAppointment(2022, 0, 10, 12, 10, 12, 30,
                practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Kathrine", 1965));
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        try {
        practise.getRoomHandler().get(0).getAppointmentCalendar().addAppointment(2022, 0, 10, 13, 30, 14, 10,
                practise.getPatientHandler().getPatientFileHandler().getFileByNameAndBirth("Bob", 1996));
    } catch (Exception e) {
        logger.error(e.getMessage());
    }

        if (practise.getRoomHandler().get(0).getAppointmentCalendar().getAppointmentMap().size() == 2)
            logger.success("Success!");

        System.out.println("\n --> advance time by 8h --> \n");
        try {
        practise.advanceTime(0, 8, 0);
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        practise.getCalendar().getCurrentTime();

        logger.success("Appointments done!");

        System.out.println("\n --- \n");

        logger.info("Employees going home...");
        practise.getEmployeeHandler().employeeGo(3);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(3)));

        System.out.println("\n --> advance time by 30min --> \n");
        try {
            practise.advanceTime(0, 0, 30);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        practise.getEmployeeHandler().employeeGo(2);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(2)));

        System.out.println("\n --> advance time by 30min --> \n");
        try {
        practise.advanceTime(0, 0, 30);
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        practise.getEmployeeHandler().employeeGo(1);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(1)));

        System.out.println("\n --> advance time by 30min --> \n");
        try {
        practise.advanceTime(0, 0, 30);
    } catch (Exception e) {
        logger.error(e.getMessage());
    }
        practise.getEmployeeHandler().employeeGo(0);
        logger.success(String.format("Employee %s went home", practise.getEmployeeHandler().getEmployeeName(0)));

        System.out.println("\n --- \n");

        logger.info("Summary of day 10:");
        practise.getEmployeeHandler().addEmployeeTimeStamp();
    //System.out.println(practise.getEmployeeHandler().getComeAndGo("10.0.2022", practise.getEmployeeHandler().getEmployeeName(0)));
        practise.getEmployeeHandler().getComeAndGoAll("10.0.2022");
        System.out.println();
        practise.getEmployeeHandler().getWorkTime();
}
}