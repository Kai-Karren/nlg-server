package de.kaikarren.nlg.generators;

import de.kaikarren.nlg.api.request.Slots;

public class TemplateFillingGenerator {

    private static final String[] punctuation = {".", ",", "?", "!", ":", ";", "'"};

    public static String replaceTemplate(String response, Slots slots){

        // do not perform the complete processing when it can be negated that there is
        // a template in the response
        if(!containsPotentialTemplate(response)){
            return response;
        }

        var temp = response;

        // replace punctuations with a whitespace so that also inputs of form
        // "{name}? Is that correct?" or "$name? Is that correct?" work.
        temp = replacePunctuation(temp);

        String[] words = temp.split(" ");

        var toReturn = response;

        for (String word : words) {

            // if a word is a single character, no further checks are needed, cannot be a template
            if (word.length() <= 1) {
                continue;
            }

            if (word.startsWith("{") && word.endsWith("}")) {

                word = word.replace("{", "");
                word = word.replace("}", "");

                var slotValue = slots.getSlot(word);

                if (slotValue == null) {
                    continue;
                }

                // replace the template with the value of possible value.
                toReturn = toReturn.replace("{" + word + "}", slotValue);

            } else if (word.startsWith("$")) {

                word = word.replace("$", "");

                // if the first character of the word after $ is a digit, then
                // the word is no template because templates cannot start with a digit by definition
                var firstChar = word.charAt(0);
                if(Character.isDigit(firstChar)){
                    continue;
                }

                var slotValue = slots.getSlot(word);

                if (slotValue == null) {
                    continue;
                }

                // replace the template with the value of possible value.
                toReturn = toReturn.replace("$" + word, slotValue);
            }

        }
        return toReturn;

    }

    /**
     * Replaces the punctuation that could be part of the response
     * to prevent punctuation to break the slot template filling.
     * @param response
     * @return
     */
    private static String replacePunctuation(String response){

        for(var punctuation : punctuation){
            response = response.replace(punctuation, "");
        }

        return response;

    }

    private static boolean containsPotentialTemplate(String response){

        return response.contains("{") && response.contains("}") || response.contains("$");

    }

}
