import utils.logger.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        logger.info("This is a info");
        logger.warning("This is a warning");
        logger.error("This is a error");
        logger.success("Succeeded");
    }
}