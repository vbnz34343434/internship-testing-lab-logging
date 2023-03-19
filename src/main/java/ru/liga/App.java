package ru.liga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.liga.controller.ConsoleController;
import ru.liga.repository.CountryRepository;
import ru.liga.service.CountryImportService;
import ru.liga.util.CsvParser;
import ru.liga.util.CsvReader;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Стартуем приложение...");
        App.start();
    }

    private static void start() {
        ConsoleController consoleController = new ConsoleController(
                new CountryImportService(
                        new CsvParser(new CsvReader()),
                        new CountryRepository()));
        consoleController.listen();
    }
}
