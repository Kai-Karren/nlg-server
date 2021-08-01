# NLG Server

NLG Server is an example for a very simple, Rasa-compatible NLG Server that exposes static responses loaded from a JSON file through a REST API.

Because it does not perform Natural Language Generation itself, its purpose is currently limited to separating the
responses from your Rasa model to allow changes of the responses without having to retrain and upload a new model.

The exposed API follows the format defined by Rasa. See [Rasa NLG Servers](https://rasa.com/docs/rasa/nlg/)

## Usage
The NLG server loads the responses from a given JSON file or from a directory consisting of multiple response JSON files.
Using further nested directories is also supported.

### Environment Variable

```
reponses=<path to our json response file or to a directory of multiple response files>
```

## Response File
The responses have to be defined as JSON in the following format
```
{
  "response_name": "This is an example response.",
  "example_response": "Test 1 2 3."
}
```

## Endpoint

address:port/nlg

## Request Format
```
{
  "response":"example2",
  "arguments":{
    
  },
  "tracker":{
  }
} 
```

## Response Format

```
{
    "text": "Some text",
}
```

### Resources
The POJOs for the Rasa Request and Responses have been generated with https://www.jsonschema2pojo.org/