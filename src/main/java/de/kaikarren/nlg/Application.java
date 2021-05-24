package de.kaikarren.nlg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args){

        String staticResponseFile = System.getenv("response_file");

        try {

            String jsonContent = readFileContentAsString(staticResponseFile);

            Map<String, String> responseNameToResponse = new ObjectMapper().readValue(jsonContent, new TypeReference<>() {
            });

            StaticResponseManager staticResponseManager = StaticResponseManager.getInstance();
            staticResponseManager.initializeResponses(responseNameToResponse);

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);

    }

    public static String readFileContentAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Path.of(filePath)));
    }

}
