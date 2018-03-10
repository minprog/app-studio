# Trivia


## Objectives

- Practice with Firebase to store data.
- Reuse lists to show data elegantly.
- Reuse Volley to retrieve data from an API.
- Reuse callback functionality to respond to events.
- Focus on code quality and readability.
- Create an elegant and user-friendly interface.

## Background

For this app, we will make use of elements that have been covered in previous guided projects, as well as one new element. Your task is to implement a quiz game that will ask the user trivia questions. When users answer these questions correctly, they should somehow earn points (the algorithm that you use to compute these points is up to you!). After the game has finished, a user should be presented with their earned points for that game round. These points should somehow be contained in a leaderboard, which is stored in an online database Firebase, so that all users can view these scores. Furthermore, a user of course needs to be able to restart the game, rotation of the user interface should be supported and the app should be well-polished.

## Architecture

To help you create this app, the architecture that the app should follow has already been created. This includes all activities and classes that (at least) be present in your app. 

[TODO INSERT ARCHITECTURE]


## Getting started

1.  Create a new Android studio project called **Trivia**, using these settings:
    - Choose API 24 (Nougat) unless your own phone has an older operating system
    - Start with an Empty Activity
    - Leave all other settings unchanged

2.  Create a new, empty repository on the Github website. Name your repository `Trivia`.

3.  Now, add a git repository to the project on your computer. Go to Android Studio, and in the menu choose **VCS -> Enable Version Control Integration**. Choose **git** as the type and confirm. This will not change much, but sets us up for the next steps.

    Note: if you get a popup to ask whether you would like to add some file to the repository, answer "No" for now. If you answer "Yes", things may get complicated later on.

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin".

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github. Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen. There, you should see a long list of "unversioned files". Make sure all checkboxes are selected, enter a commit message `Initial project` and then press the **commit** button. Turn off code analysis.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github. If not, ask for help!


## Getting our trivia questions

To get the questions (and answers) needed to build this app, we will make use of an API: [jservice.io](http://jservice.io/). This API allows you to request random questions, for example. 

Requesting data from the API can be done in the same manner as before, by using Android's `Volley` library to send requests and listen for the response. 

When you have the response from the API, chances are you will need to do some JSON formatting to make it useful to you. Be sure to implement the right callbacks to make sure that your parsed response is directed to the proper activity, so it can update the UI accordingly!

If unsure how to use `Volley` and implement the proper callback methods, refer to the [references](https://apps.mprog.nl/android-reference/volley) or take a look at [Restaurant](https://apps.mprog.nl/guided/restaurant)'s section on "Showing Categories" for assistance. 


## Setting up Firebase

Firebase's Database is a way of storing data online in a noSQL database that uses a JSON tree structure. It can easily store and retrieve custom objects and since it's owned and supported by Google, we can intergrate it into our Android studio project very easily as well. To connect your app to Firebase, you will need a Google account.  

1. With your project open in Android Studio, head to Tools > Firebase.

2. Firebase Assistant should now open up on the right of the screen. Firebase offers multiple functionalities, but since we are looking to implement a database, choose the *Realtime Database* entry and choose *Save and Retrieve Data*.

3. A new screen should now pop up, which will walk you through the steps of adding Firebase to your project. Follow the first step (you will need a Google account for this) and create a new Firebase project. Your app should now be connected to Firebase.

4. When you press the button *Add the realtime database to your app*, the correct dependencies should be added to your `build.gradle` files. Allow your project a moment to rebuild to integrate these changes.

5. You can now make use of the database functionality. Your database will need rules which determine who should be able to read/write your database. These rules can be configured in the [Firebase console](https://console.firebase.google.com/). For this project, we will simply set the database rules to public. This would not be advised for a real app, but for our purposes it suffices:

        {
            "rules": {
                ".read": true,
                ".write": true
            }
        }

6. When you have configured your database rules, you can start writing code to insert values into your database or to retrieve them.

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




