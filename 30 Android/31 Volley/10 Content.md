# Volley

To set up a connection with an online API, you can use the [Volley Library](https://developer.android.com/training/volley/index.html).

To make this work you will need to add a dependency to your app's `build.gradle` file:

    compile 'com.android.volley:volley:1.0.0'

This will allow you to use the library's functionality in your app. You can follow the guide and example code on using a `newRequestQueue` on [this page](https://developer.android.com/training/volley/simple.html) in order to set up your connection with the API. If everything goes well, you can now do something useful with your API response in the `onResponse` method!
