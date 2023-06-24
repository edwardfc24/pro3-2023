import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private static final Logger logger = LogManager.getLogger(Logs.class);

    public static void main(String[] args) {
        logger.info("Este es un registro de información");
        logger.debug("Esta información sirve para debuguear");
        logger.warn("Esta es una advertencia");
        logger.error("Este es un error");
    }
}
