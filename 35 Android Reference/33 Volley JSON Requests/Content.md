# Volley - Json Requests

## JsonObjectRequest
You can use `Volley` to create different kinds of requests. In this example, we will take a look at the `JsonObjectRequest` variant, which as the name already gives away, is a request tailored to retrieve a JSON object of some kind. If unfamiliar with JSON, have a look at the [guide on parsing JSON](https://apps.mprog.nl/android-reference/parsing-json) before you continue!

A `JsonobjectRequest` is constructed similarly to the standard string request outlined in the [basic `Volley` guide](https://apps.mprog.nl/android-reference/volley). We create a requestqueue and add the request to it. 

        String url = "https://opentdb.com/api.php?amount=10&difficulty=medium&type=multiple";
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, Response.Listener, Response.ErrorListener);
        queue.add(jsonObjectRequest);

The constructor of the `JsonObjectRequest` takes 4 arguments:
* the url that the request should be submitted to 
* data that should be sent with the API call (in this case nothing, so null)
* and two references to listeners that will handle the response

In the regular string request, it was necessary to specify the request method (GET, POST, PUT), which is not necessary with the `JsonObjectRequest`. Since the second argument is the `JsonObject` you might want to include in your request it can be used to derive whether you are posting or getting data. If you are only retrieving data, it can thus be `null` and the request will be treated as GET. 

Finally, it once again takes a regular response listener and an errorlistener as arguments as well. 

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(url, null, 
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    // response was succesful
                }
            }, 
            new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    
                }
            }
        );

To avoid anonymous listeners like in the snippet above, it is more elegant to use the implements clause and let the class handle the functionality instead. Often, the same class will handle the responses, so we can use the keyword `this` in the constructor to signify that the class will implement the response methods. 

To make sure that the class can handle the responses, implement the required interfaces:

    public class YourClassName implements Response.Listener<JSONObject>, Response.ErrorListener

Now use CTRL+I to generate the appropriate methods: `onErrorResponse()` and `onResponse()`. They should appear in your class:

    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, this, this);
    queue.add(jsonObjectRequest);
        
    @Override
    public void onErrorResponse(VolleyError error) {
        error.printStackTrace();
    }

    @Override
    public void onResponse(JSONObject response) {
        // response
    }


## JsonArrayRequest
The `JsonArrayRequest` is constructed in a similar fashion, but its constructor takes only three argument. You cannot include an array with it.

* the url that the request should be submitted to 
* and two references to listeners that will handle the response

```
    String url = "https://opentdb.com/api.php?amount=10&difficulty=medium&type=multiple";
    RequestQueue queue  = Volley.newRequestQueue(context);
    JsonArrayRequest request = new JsonArrayRequest(url, this, this);
```

Again, you can use the class to implement the appropriate listeners:

    public class YourClassName implements Response.Listener<JSONArray>, Response.ErrorListener

Once again, use use CTRL+I to generate the appropriate methods: `onErrorResponse()` and `onResponse()`.


## References

[Documentation JSONObjectRequest](https://afzaln.com/volley/index.html?com/android/volley/toolbox/JsonObjectRequest.html)
[Documentation JSONArrayRequest](https://afzaln.com/volley/index.html?com/android/volley/toolbox/JsonArrayRequest.html)

