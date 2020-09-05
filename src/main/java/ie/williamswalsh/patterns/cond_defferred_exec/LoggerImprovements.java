package ie.williamswalsh.patterns.cond_defferred_exec;

import ie.williamswalsh.logs.DiagnosisMessages;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerImprovements {


    public static void main(String[] args) {
        Logger logger = Logger.getLogger("ie.williamswalsh.patterns");
        System.out.println(logger.getLevel());          // null

        if (logger.isLoggable(Level.FINEST)){
            logger.finest("This is a finest log level message.");
        }

        // This method is called even when the log level shouldn't be printed
        logger.log(Level.FINER, DiagnosisMessages.systemHealthStatus());

        // The method systemHealthStatus will only execute when the log level should be printed
        logger.log(Level.FINEST, DiagnosisMessages::systemHealthStatus);

    }
}
