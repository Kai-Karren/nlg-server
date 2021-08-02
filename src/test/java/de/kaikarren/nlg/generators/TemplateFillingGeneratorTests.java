package de.kaikarren.nlg.generators;

import de.kaikarren.nlg.api.request.Slots;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateFillingGeneratorTests {

    @Test
    void replaceTemplateSimple() {

        var response = "This is an example for {content} in a response";

        var slots = new Slots();
        slots.setAdditionalProperty("content", "slot template filling");

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("This is an example for slot template filling in a response", processedResponse);

    }

    @Test
    void replaceTemplateSimpleDollar() {

        var response = "This is an example for $content in a response";

        var slots = new Slots();
        slots.setAdditionalProperty("content", "slot template filling");

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("This is an example for slot template filling in a response", processedResponse);

    }

    @Test
    void doNotReplaceMoney() {

        var response = "This will cost you $45.";

        var slots = new Slots();

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("This will cost you $45.", processedResponse);

    }

    @Test
    void replaceTemplateComplex() {

        var response = "Hello {example} {number}. {test}. How are you {var2}?";

        var slots = new Slots();
        slots.setAdditionalProperty("example", "Kai");
        slots.setAdditionalProperty("number", "42");
        slots.setAdditionalProperty("test", "This is a test");
        slots.setAdditionalProperty("var2", "doing");

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("Hello Kai 42. This is a test. How are you doing?", processedResponse);

    }

    @Test
    void replaceTemplateComplexDollar() {

        var response = "Hello $example $number. $test. How are you $var2?";

        var slots = new Slots();
        slots.setAdditionalProperty("example", "Kai");
        slots.setAdditionalProperty("number", "42");
        slots.setAdditionalProperty("test", "This is a test");
        slots.setAdditionalProperty("var2", "doing");

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("Hello Kai 42. This is a test. How are you doing?", processedResponse);

    }

    @Test
    void replaceNothing() {

        var response = "Hello {example $45. {test$. How are you $?";

        var slots = new Slots();

        var processedResponse = TemplateFillingGenerator.replaceTemplate(response, slots);

        assertEquals("Hello {example $45. {test$. How are you $?", processedResponse);

    }
}