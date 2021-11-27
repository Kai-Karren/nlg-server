# NLG Server

NLG Server is an example for a simple, Rasa-compatible NLG Server that exposes static responses loaded from a JSON file through a REST API.

Because it does not perform Natural Language Generation itself, its purpose is currently limited to separating the
responses from your Rasa model to allow changes of the responses without having to retrain and upload a new model.

The exposed API follows the format defined by Rasa. See [Rasa NLG Servers](https://rasa.com/docs/rasa/nlg/)

## Usage
The NLG server loads the responses from a given JSON file or from a directory consisting of multiple response JSON files.
Using further nested directories is also supported.

## Features

- Load static response JSON files (single files or from a directory)
- Use templates in your responses in the form {slotName} or $slotName (see examples section)
- Randomly chose a response from a set of given response variations
- Can be used with [Rasa](https://rasa.com/)

### Environment Variable

```
reponses=<path to our json response file or to a directory of multiple response files>
```

## Response File
The responses have to be defined as JSON in the following format
```
{
  "response_name": "This is an example response.",
  "example_response": "Test 1 2 3.",
  "response_with_variations": [
    "first_variation", 
    "second_variation"
  ]
}
```

## Endpoint

address:port/nlg

The default port is 8080

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

# Examples

## Slot Template Filling Example

### Response JSON file

```
{
  "example": "This is an example response.",
  "test": "Test 1 2 3.",
  "utter_template": "Your number is {number}."
}
```

### Request

```
{
    "response": "utter_template",
    "tracker": {
        "sender_id": "user_42",
        "slots": {
            "number": "80"
        }
    }
}

```

### Response

```
{
    "text": "Your number is 80."
}
```

## Docker

### Build an Image
To build the NLG server as a docker container you can use the provided dockerfile as an example

Replace the responses folder with your folder name

```
docker build -t nlg-server .
```

### Run the container

Your build container can be run (exposed over port 8082) with the following command or your add it to a docker-compose file.

```
docker run -p 8082:8080 nlg-server
```


### Resources
The POJOs for the Rasa Request and Responses have been generated with https://www.jsonschema2pojo.org/
