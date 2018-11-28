# Week 6: Working with the Web

This week you will learn how to get content from the web and make use of API's.

## Language exercises

This week we will learn how to create code blocks that can run asynchronous. Feel free to skip some of the parts about the programming language, but make sure that you know *exactly* how to write correct Swift code!

1. Closures
2. Extensions


## iOS exercises

Next up are 4 lessons about animation and working with the web. Feel free to skip some of the labs, but make sure that you know *exactly* how to user these views.

{:start="3"}
3. Practical Animation
4. Working with the Web: HTTP and URL Session
5. Working with the Web: JSON Serialization
6. Working with the Web: Concurrency


## Project

Now you are ready to make your next app! At the end of the chapter, you'll find a Guided Project. This time you'll make an app which can be user to order food.

**Note:** Instead of the local server you can use `https://resto.mprog.nl/`.

- In step 1 you can skip the 'Run the Server'.
- In step 3 you can skip the 'Project Setup' part because the server uses a HTTPS connection.
- In step 4 the `baseURL` will be:

~~~swift
class MenuController {
    let baseURL = URL(string: "https://resto.mprog.nl/")!”
}
~~~

## Goals

Our main goal for this course is getting you some in-depth experience on important aspects of creating **good quality** apps. You'll practice with various techniques every week. For this week, make sure you try, as much as possible, to create an app that excels in these respects:

- layout, margins, compatibility with multiple phone sizes
- basic code quality such as comments, names, consistency and design
- easy to use, no odds and ends


## Adding to GitHub

[Here](/ios-reference/github) you'll find several instructions for adding your project's code to GitHub.


## Grading

*Before* the deadline, complete the exercises and put your finished project on GitHub. Ask for help if needed!

1. Submit the link to your project's GitHub repository at [Week 6](/submit/unit-6).

2. On (or before) the date of the deadline, show your finished exercises **and** the working app to one of the staff.

3. Next, acquire feedback on your app and improve on it. Improvements should be finished and synced with GitHub before the course's final deadline.
