/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package money.manager;

import money.manager.configuration.WebserverConfiguration;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        LOG.info("Starting money.manager...");
        SpringApplication.run(WebserverConfiguration.class, args);
        LOG.info("Ending money.manager...");


    }
}
