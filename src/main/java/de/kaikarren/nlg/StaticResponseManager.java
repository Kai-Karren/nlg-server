package de.kaikarren.nlg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StaticResponseManager {

    private static final Logger log = LoggerFactory.getLogger(StaticResponseManager.class);

    private Map<String, String> nameToResponseMapping;

    private static StaticResponseManager staticResponseManager = new StaticResponseManager();

    public void initializeResponses(Map<String, String> nameToResponseMapping){
        this.nameToResponseMapping = nameToResponseMapping;
        StringBuilder sb = new StringBuilder();
        for (String responseName : nameToResponseMapping.keySet()){
            sb.append(responseName);
            sb.append(" ");
        }
        log.debug("Responses with the following names have been loaded: {}", sb);
    }

    public String getResponse(String responseName){
        return nameToResponseMapping.get(responseName);
    }

    public static StaticResponseManager getInstance(){
        return staticResponseManager;
    }

}
