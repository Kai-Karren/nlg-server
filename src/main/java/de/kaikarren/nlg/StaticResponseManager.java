package de.kaikarren.nlg;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class StaticResponseManager {

    private static final Logger log = LoggerFactory.getLogger(StaticResponseManager.class);

    private Map<String, Object> nameToResponseMapping;

    private static final StaticResponseManager staticResponseManager = new StaticResponseManager();

    public void initializeResponses(Map<String, Object> nameToResponseMapping){
        this.nameToResponseMapping = nameToResponseMapping;
        var sb = new StringBuilder();
        for (String responseName : nameToResponseMapping.keySet()){
            sb.append(responseName);
            sb.append(" ");
        }
        log.debug("Responses with the following names have been loaded: {}", sb);
    }

    public String getResponse(String responseName){

        var responseObject = nameToResponseMapping.get(responseName);

        if(responseObject == null){
            log.error("No response has been been found for responseName {}", StringEscapeUtils.escapeJava(responseName));
            return "";
        }

        if(isSingleResponse(responseObject)){
            return nameToResponseMapping.get(responseName).toString();
        } else {
            return getRandomResponse(responseObject);
        }

    }

    public static StaticResponseManager getInstance(){
        return staticResponseManager;
    }

    private boolean isSingleResponse(Object responseObject){
        return responseObject instanceof String;
    }

    private String getRandomResponse(Object responseObject){

        if(responseObject instanceof List){
            @SuppressWarnings("unchecked")
            var responseList = (List<String>) responseObject;

            return responseList.get(Utils.randomNumber(responseList.size()));

        } else {
            log.error("Invalid response type {}", responseObject.getClass());
            return "";
        }

    }

}
