package de.kaikarren.nlg.api;

import de.kaikarren.nlg.StaticResponseManager;
import de.kaikarren.nlg.api.request.NLGRequest;
import de.kaikarren.nlg.api.response.NLGResponse;
import de.kaikarren.nlg.generators.TemplateFillingGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NLGRestController {

    @PostMapping(path = "/nlg", consumes = "application/json", produces = "application/json")
    public NLGResponse handleRequest(@RequestBody NLGRequest request){

        var responseContent = StaticResponseManager.getInstance().getResponse(request.getResponse());

        responseContent = TemplateFillingGenerator.replaceTemplate(responseContent, request.getTracker().getSlots());

        NLGResponse nlgResponse = new NLGResponse();
        nlgResponse.setText(responseContent);

        return nlgResponse;

    }

}
