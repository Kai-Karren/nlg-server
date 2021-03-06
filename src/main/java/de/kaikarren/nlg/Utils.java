package de.kaikarren.nlg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Utils {
    
    /**
     * Lists the files in the given directory
     * 
     * Based on https://www.baeldung.com/java-list-directory-files
     * @param dir The directory 
     * @return  A set of the files in the directory
     * @throws IOException
     */
    public static Set<String> listDirectoryContent(String dir) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
              .map(Path::getFileName)
              .map(Path::toString)
              .collect(Collectors.toSet());
        }
    }

    public static int randomNumber(int max){
        return (int) (Math.random() * max);
    }

}
