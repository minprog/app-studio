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


## Getting our trivia questions

To get the questions (and answers) needed to build this app, we will make use of an API: [jservice.io](http://jservice.io/). This API allows you to request random questions, for example.

Requesting data from the API can be done in the same manner as before, by using Android's `Volley` library to send requests and listen for the response. Be sure to implement the right callbacks to make sure that your response is directed to the proper activity!



## Setting up Firebase

Firebase is a way of storing data online in a noSQL database. Since it's owned by Google, we can intergrate it into our Android studio project very easily. 

    1. 