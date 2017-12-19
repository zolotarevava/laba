package sort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SortConfigurator {

    public static final String pathToProperty = "C:/Users/Home/IdeaProjects/laba1/src/main/resources/config.properties";

    private static Logger log = LogManager.getLogger();


    private static SortConfigurator myInstance = new SortConfigurator();

    public IMySort getSorter() throws IOException {
        log.info("Setting sort configuration");

        Properties properties = new Properties();

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(pathToProperty);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.catching(e);
        }

        properties.load(inputStream);


        String property = properties.getProperty("sorter");

        if (property.equals("BubbleSort")) {
            log.info("set BubbleSort sorting");
            return new BubbleSort();
        }
        else if (property.equals("InsertSort")){
            log.info("set InsertSort sorting");
            return new InsertSort();
        }

        else {
            log.info("set BubbleSort sorting");
            return new BubbleSort();
        }
    }

    public static SortConfigurator getInstance() {
        return myInstance;
    }

    private SortConfigurator() {
    }
}

