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

## Making requests

In your assignments, you'll find instructions on how to make requests.


## Post request

To send information to a server, you'll usually use a POST or PUT request. These "methods" signal the web server that we'd like to send information, which the server can then store or use to perform a search.

The information that we send can take the form of key-value pairs, the POST parameters. To provide these parameters, you'll need to **subclass** a `StringRequest`. To do this, make a new class in your project that looks like this:

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


That `getParams()` method will be called as soon as the request is ready to submit to the server. Your task is to create a `HashMap` with the parameters that you would like to send to the server and `return` these.

## Creating the POST request

Creating and starting the request works exactly like other requests.

    String url = "sampleurl.com/post";
    RequestQueue queue = Volley.newRequestQueue(context);
    PostRequest request = new PostRequest(Request.Method.POST, url, this, this);
    queue.add(request);

If needed, you may use `Request.Method.PUT` instead of `POST`.
