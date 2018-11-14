# Week 7: Firebase

In this unit, you'll learn about using Firebase, which is an online database from Google. It allows you to make apps that help people communicate, share information or simply chat.


## Language exercises

Nothing new!


## iOS explanation

The following video may help you (now and in the future) to design your apps with people in mind. The presentation shows some essential ideas on making systems simple and easy to use.

- [Essential design principles](https://developer.apple.com/videos/play/design/802/)

Also read through the final chapter of the book!


## Project: Trivia

For this app, we will make use of elements that have been covered in previous guided projects, as well as one new element. Your task is to implement a quiz game that will ask the user trivia questions. When users answer these questions correctly, they should somehow earn points (the algorithm that you use to compute these points is up to you!). After the game has finished, a user should be presented with their earned points for that game round. These points should somehow be contained in a leaderboard, which is stored on Firebase, so that all users can view these scores. Furthermore, a user needs to be able to restart the game, rotation of the user interface should be supported and the app should be well-polished.

To get the questions (and answers) needed to build this app, we will make use of an API: [jservice.io](http://jservice.io/). This API allows you to request random questions, for example. Use code from the Restaurant app to get your questions!

## FAQ

If you want to use an HTTP API (non HTTPS) your iOS app needs explicit permission to allow this type of connection.
Instructions how to set this up can be found on page 902 in the iOS book at "Guided Project: Restaurant - part 3 - Project Setup".

## Getting credit

There are a couple of minimum requirements for submitting your project:

- all project code must be available on a GitHub repository
- in the root of the GitHub repository, there must be a README.md containing the app description, your name and a screenshot

Make sure that you complete the exercises and put your finished project on Github *before* the deadline. In the next class session, show your exercises and the working app to one of the staff.

Completing the exercises can earn you 1 point per week. The project will be checked for full completion of the assignment and consideration of all requirements. You can earn points according to the following scheme:

| pts | description                                                                          |  
| --: | ------------------------------------------------------------------------------------ |  
|   5 | Exceptional quality in use, layout and code. Probably something extra or unexpected. |  
|   4 | Solid quality in use, layout and code. Maybe some trivial error.                     |  
|   3 | Reasonable quality, but lots of room for improvement.                                |  
|   2 | The app mostly works but really lacks in quality.                                    |  
|   1 | Clearly, quite a bit of effort went into it, but it does not really work.            |  
|   0 | Not submitted or very incomplete.                                                    |  

We will look at the following quality aspects:

- easy to use, no odds and ends
- layout, margins, compatibility with multiple phone sizes
- basic code quality such as comments, names, consistency
- more advanced code quality such as the structure of your project, separation of concerns


## Some ideas for extra credit

- Create a multiplayer version.

- Allow logging in via Firebase and personalize highscores.


## Submit

Submit at [Unit 6](/submit/unit-6).
