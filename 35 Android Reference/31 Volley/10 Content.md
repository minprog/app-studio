# Volley

To set up a connection with an online API, you can use the [Volley Library](https://developer.android.com/training/volley/index.html). It can be used to send HTTP requests to a web server. Sending HTTP requests immediately presents us with a problem: the server might not respond immediately, and waiting for the response may make our app slow and unresponsive.

To understand this problem, consider the following pseudocode for an activity:

    class MainActivity
    {
        method onCreate
        {
            super.onCreate()
            
            ...<send http request>...
            
            button = findViewById(R.id.button);
            button.text = "Click Me";
        }
    }

Normally, if you perform actions in the `onCreate` method, the screen of the activity is not displayed correctly until everything is done. The HTTP request is waiting for a response, and only when it is received, the button is changed and finally, the activity becomes visible and the user can interact with it.

That's why Volley works **asynchronously**. This means that whenever you send a request to Volley, it will do this independently, while the rest of your code runs. For example, in the code above, when `onCreate` is run:

- the request will be sent off without waiting on a response;
- the button will get its new text;
- the activity will be displayed immediately.

## Configuration

To make everything work there are two things you need to configure.

- Add a dependency to your app's `build.gradle (Module: app)` file, which will allow you to use the Volley library:

        implementation 'com.android.volley:volley:1.1.0'

- In your `AndroidManifest.xml`, declare that you want to connect to the internet:

        <manifest xlmns:android...>
            ...
            <uses-permission android:name="android.permission.INTERNET" />
            <application ...
            ...
        </manifest>

## Request queue

Volley works with a request queue. You can add several requests to the same queue, which will all be handled.

    RequestQueue queue = Volley.newRequestQueue(this);
    queue.add(request1);
    queue.add(request2);
    queue.add(request3);

You can create the `RequestQueue` in the `OnCreate()` method of your Activity, and then add a request to it whenever needed, for example, when a user taps a button.

## Doing a request

The code for making a request is pretty complex. We'll show the full code first and then explain the parts.

    String url = "http://www.google.com";

    // Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            // Display the first 500 characters of the response string.
            mTextView.setText("Response is: "+ response.substring(0,500));
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            mTextView.setText("That didn't work!");
        }
    });
    // Add the request to the RequestQueue.
    queue.add(stringRequest);

## The basic request

Stripping the request from more complex parts gives us this:

    String url = "http://www.google.com";

    StringRequest stringRequest = new StringRequest(
        Request.Method.GET,
        url,
        ... response listener ...,
        ... error listener ...
    );

    queue.add(stringRequest);

As you can now see, the most important part of the code above is simply making a new instance of the `StringRequest` class while providing four arguments:

- `Request.Method.GET`: the HTTP request method, which usually is GET or POST, but may also be something else
- `url`: the actual address of the endpoint that you want to request information from
- The response listener is an object that will be used when the response from the server is actually received. The method `onResponse()` will run, where you can process the incoming data.
- The error listener is also an object, and will be used if an error is encountered, for example when the phone is offline (you can try this out!).

## Response listener

Let's have a look at the response listener:

    new Response.Listener<String>()
    {
        @Override
        public void onResponse(String response)
        {
            // Display the first 500 characters of the response string.
            mTextView.setText("Response is: "+ response.substring(0,500));
        }
    }

What this does is create a **new instance** of the `Response.Listener` class, and providing an implementation for the `onResponse` method. This method is called as soon as the data is received from the web server.

Mind you, the new instance is created, but it is not assigned to a variable. That's why this thing is called an **anonymous listener**. In Android, anonymous listeners are used very often. The thruth is that we don't like it much, because it makes code very confusing due to nesting. If you have time, try to de-anonymize your listeners as described in the text about [listeners](/android/listeners). But: make your code work first, and only then try to make it nice!


## Post request

Sometimes you want to perform a request that also sends something to the server, a POST or a PUT request. To include parameters that have to be included in the request. These parameters are supplied in the form of a key-value pair. To include the data, the request looks slightly different and it is most practical to create its own inner class for it within your helper class to keep the code legible:

* Create a private class that extends `StringRequest`
* Use CTRL+O to select the appropriate constructor (4 arguments)
* Use the same menu to override the method `getParams()` as well

```
        /*
            Inner class representing the String request of type POST. Notice the method
            getParams() that is overridden in this class.
        */
        private class PostRequest extends StringRequest  {

            // Constructor
            public PostRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
                super(method, url, listener, errorListener);
            }

            // Method to supply parameters to the request
            @Override
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<>();
                params.put("name", "Minor Programmeren");
                params.put("studentcount", "300");
                return params;
            }
        }
```

Inside the `getParams()` method, which returns a mapping of keys to values, you create a new hashmap and then add the values to it that you want to include in your post request. In this example, we chose to include the name of the program and the expected student count. This map should then be returned at the end of the method.

The creation and starting of the request itself is similar to that of the regular requests, you invoke the constructor you created for your custom class (in this case `PostRequest`) and supply the right parameters. The response and error listeners can be anonymous, but should probably be implemented by the encapsulating helper class (hence the `this`), to avoid clutter. 

        String url = "sampleurl.com/post";
        RequestQueue queue = Volley.newRequestQueue(context);
        PostRequest request = new PostRequest(Request.Method.POST, url, this, this);
        queue.add(request);

It goes without saying that `Request.Method.POST` can be replaced with `Request.Method.PUT` as well, in order to perform a PUT request.

## References

- [Official documentation](https://developer.android.com/training/volley/simple.html)
