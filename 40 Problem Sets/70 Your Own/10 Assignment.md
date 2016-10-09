# Build Your Own!

*Working App Due: Thursday night, 20 October, 2016*  
*Refactoring Due: Thursday night, 27 October, 2016*

## Objectives

- Understand how to use APIs to get structured open data.
- Practice with making your own app from scratch.

## Preparation

- On iOS: Read about [API's](/ios/apis).

## Assessment

Your work on this problem set will be evaluated along four axes primarily.

Scope
: To what extent does your code implement the features required by our specification?

Correctness
: To what extent is your code consistent with our specifications and free of bugs?

Design
: To what extent is your code written well (i.e., clearly, efficiently, elegantly, and/or logically)?

Style
: To what extent is your code readable (i.e., commented and indented with variables aptly named)?

All students must ordinarily submit this and all other problem sets to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## Assignment

So, this is the final assignment and your best chance to make something of your own! There are two important constraints, however:

- The application concept should be based on a public API with open data. It should also be a "live" API, where you can do requests from your app for more data; for example, using JSON.

- The application should use Firebase as a database backend to store one or more types of data. Firebase should be integrated in the app as intended by official documentation.

Some suggestions for finding interesting APIs:

- <https://opendatanederland.org>
- <https://github.com/caesar0301/awesome-public-datasets>
- <http://www.programmableweb.com/apis/directory>

## Requirements

- The app concept should be centered around a live open data API.
- External data should be retrieved using HTTP-requests.
- Some user data should be persisted on the phone (favorites, etc.).
- Firebase should be used to save user data.
- Not all external data needs to be saved on the phone once retrieved.
- Even if killed, the app should generally resume in the same state as before.
- Code should be organized well (keeping in mind a separation of concerns).
- Code should be documented well (comments as well as READMEs).

Discuss your app proposal with the TAs to ensure the scope is sufficient!

## Peer review

Although the app will be graded by the staff, you are required to perform a code review with one other student, in class, after the first deadline. The results of the review should be documented in a file called `REVIEW.md`. You are expected to use the results of this review to improve your code before submitting the final version.

## Getting started

1. Create an empty [GitHub](https://www.github.com/) repository to manage your code.

2. Create a new project, using this pattern as a name: `studentname-pset6`.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL in the textbox, below!
