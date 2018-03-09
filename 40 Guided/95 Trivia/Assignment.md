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

Firebase is a way of storing data online in a noSQL database. Since it's owned by Google, we can intergrate it into our Android studio project very easily. 

    1. 