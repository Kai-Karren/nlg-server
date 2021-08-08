package de.kaikarren.nlg;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StaticResponseManagerTest {

    @Test
    void testSimpleResponse() {

        var responses = new HashMap<String, Object>();
        var expectedResponse = "Welcome, thank you for using our service. How can I help you?";

        responses.put("initial_message", expectedResponse);
        responses.put("bye", "Goodbye");

        var responseManager = StaticResponseManager.getInstance();

        responseManager.initializeResponses(responses);

        var response = responseManager.getResponse("initial_message");

        assertEquals(expectedResponse, response, "The response is not the the expected one!");

    }

    @Test
    void testResponseNotFound() {

        var responses = new HashMap<String, Object>();
        responses.put("bye", "Goodbye");

        var responseManager = StaticResponseManager.getInstance();

        responseManager.initializeResponses(responses);

        var response = responseManager.getResponse("initial_message");

        assertEquals("", response, "The response is not the the expected one!");

    }

    @Test
    void testRandomSelectFromMultipleResponses() {

        var responses = new HashMap<String, Object>();
        responses.put("bye", "Goodbye");

        var greet_variations = Arrays.asList("Hey", "Hi", "Hello");

        responses.put("greet", greet_variations);

        var responseManager = StaticResponseManager.getInstance();

        responseManager.initializeResponses(responses);

        var response = responseManager.getResponse("greet");

        assertTrue(greet_variations.contains(response));

    }
}