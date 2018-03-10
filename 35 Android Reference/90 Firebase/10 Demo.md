# Firebase

Firebase can be used for many things, but in our project we will mostly focus on using it as an authentication service: that means providing login functionality to your app, allowing users to create accounts or use accounts from existing platforms to log in. Firebase also allows you to easily link an online database to your app, which allows you to share information between the app's users and persist data in the cloud so that when the user changes device, it's still accessible. The guides below walk you through setting up Firebase as a database, and Firebase as an authentication service.

## Setting up Firebase Database

Firebase's Database is a way of storing data online in a noSQL database that uses a JSON tree structure. It can easily store and retrieve custom objects and since it's owned and supported by Google, we can intergrate it into our Android studio project very easily as well. 

To connect your app to Firebase, you will need a Google account. If you don't want to link your app/Firebase to your existing Google account, you can just create a new one and use that account to manage Firebase. Below is a video showcasing the setup (bear in mind that some things might have changed, as this video is slightly dated), but it's also written out step by step.

![embed](https://player.vimeo.com/video/208360983)

1. With your project open in Android Studio, head to *Tools > Firebase*.

2. Firebase Assistant should now open up on the right of the screen. Firebase offers multiple functionalities, but since we are looking to implement a database, choose the *Realtime Database* entry and choose *Save and Retrieve Data*.

3. A new screen should now pop up, which will walk you through the steps of adding Firebase to your project. Follow the first step (you will need a Google account for this) and create a new Firebase project. Your app should now be connected to Firebase.

4. When you press the button *Add the realtime database to your app*, the correct dependencies should be added to your `build.gradle` files. Allow your project a moment to rebuild to integrate these changes.

5. You can now make use of the database functionality. Your database will need rules which determine who should be able to read/write your database. These rules can be configured in the [Firebase console](https://console.firebase.google.com/). For testing purposes, you can make your database accept both reads and writes from everyone, as per the snippet below. However, when you have implemented more functionality, it's better to change this to only allow authenticated users to access the database, especially writing access. 

        {
            "rules": {
                ".read": true,
                ".write": true
            }
        }

6. When you have configured your database rules, you can start writing code to insert values into your database or to retrieve them. Testing code snippets can be found in the Firebase guide tab within Android Studio as well. 

7. To make debugging easier, we will first change the log level so that more error messages will be shown in Android Studio's error log. Paste the test snippet below into your `onCreate` to verify that writing to your database works. (You can check the contents of your database realtime in the Firebase console). If this does not work, ask for help! 

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setLogLevel(Logger.Level.DEBUG);

        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

8. Do the same for reading from the database. Reading from the database is not instant, just like calling the API, so a listener is attached to this action, so that when the data is retrieved from the database, we can do something with it. Of course, it's also important to notify the user when something went wrong. 

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

9. We have now covered the basics of writing data to Firebase and reading data from Firebase. Of course, these are just very simple examples. For more information on this refer to the [official documentation](https://firebase.google.com/docs/database/android/read-and-write).


## Setting up Firebase Authentication

Firebase can also be used to authenticate users. This means that you can either authenticate all users of your app to allows them access to your database, for example, make use of users' existing accounts on platforms such as Google and Facebook, or allow users to create accounts using email and password. To set up Firebase authentication, once again we can follow the guide provided by Android Studio. 

To connect your app to Firebase, you will need a Google account. If you don't want to link your app/Firebase to your existing Google account, you can just create a new one and use that account to manage Firebase. Below is a video showcasing the setup (bear in mind that some things might have changed, as this video is slightly dated), but it's also written out step by step.

![embed](https://player.vimeo.com/video/208276322)

1. With your project open in Android Studio, head to *Tools > Firebase*.

2. Firebase Assistant should now open up on the right of the screen. Firebase offers multiple functionalities, but since we are looking to implement a database, choose the *Authentication* entry and choose *Email and Password Authentication*.

3. A new screen should now pop up, which will walk you through the steps of adding Firebase to your project. Follow the first step (you will need a Google account for this) and create a new Firebase project. Your app should now be connected to Firebase.

4. When you press the button *Add Firebase authentication to your app*, the correct dependencies should be added to your `build.gradle` files. Allow your project a moment to rebuild to integrate these changes.

5. To use an authentication provider, you need to enable it in the [Firebase console](https://console.firebase.google.com/). In the console, first select your app, and then head to *Authentication* in the left menu and then choose *Sign-in Method* and enable the sign in methods of your choice.

6. We are now ready to add actual code to our app. The first part of the guide will help you set up this listener. It should be set up in your Activity's `onStart()` method, so that when starting the app for the first time or returning to the activity, the current authentication status of the user will be checked.

7. The second part of the guide helps you set up the necessary means to create a new account. Of course, you can try this code out with a hardcoded username and password, but if you want users to be able to create accounts, then you will need the input fields and a confirmation button, plus of course some verification of the input! Firebase requires that a user's password consists of at least 6 characters, for example.

8. 


