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
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) {

        var path = System.getenv("responses");

        StaticResponseManager staticResponseManager = StaticResponseManager.getInstance();
        
        try {
            var nameToResponse = load(path);

            staticResponseManager.initializeResponses(nameToResponse);

        } catch (Exception e){
            log.error(e.getMessage());
        }

        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);

    }

    public static Map<String, String> load(String path) throws IOException{

        // check if the path is a file or a directory

        Map<String, String> nameToResponse = new HashMap<>();

        if(Files.isDirectory(Path.of(path))){

            var fileNames = Utils.listDirectoryContent(path);
        
            for(var fileName : fileNames){

                // recursively call load to allow also further nested directories
                nameToResponse.putAll(load(path + "/" + fileName));

            }

            return nameToResponse;
        
        
        } else {

            // the path points to a file
            return loadFile(path);

        }

    }

    /**
     * Loads the content from a single JSON file with a ObjectMapper into a Map
     * @param fileName The name of the JSON file that should be converted into a Map
     * @return The content of the JSON file as Map<String, String>
     */
    public static Map<String, String> loadFile(String fileName) {

        try {

            String jsonContent = readFileContentAsString(fileName);

            return new ObjectMapper().readValue(jsonContent,
                    new TypeReference<>() {
                    });

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return new HashMap<>();

    }

    public static String readFileContentAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Path.of(filePath)));
    }

}
