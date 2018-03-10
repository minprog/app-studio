# Build Your Own!

## Objectives

- Understand how to use APIs to get structured open data.
- Practice with making your own app from scratch.

## Preparation

- On Android: Read about [Firebase](/android/firebase).
- On iOS: Read about [Firebase](/ios/firebase).

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## Code quality assessment

Aside from this, your work on this problem set will be evaluated on code quality. Use [Better Code Hub](/guides/better-code-hub) to ensure that your code is clean and well! Don't forget to include in your repository an audit report, as specified on the aforelinked page.

**But, it's only a tool.** Keep in mind that assessment will happen on these criteria:

Design
: To what extent is your code written well (i.e., clearly, efficiently, elegantly, and/or logically)?

Style
: To what extent is your code readable (i.e., commented and indented with variables aptly named)?

## Assignment

So, this is the final assignment and your best chance to make something of your own! There are two important constraints, however:

- The application must use [Firebase](https://firebase.google.com/) as a database backend to store one or more types of data. Firebase should be integrated in the app as intended by official documentation.
- The application is a variation of one of these two concepts:
    - App allows showing items from an API, including details. Users can "favorite" certain items, and favorites lists are shared between users of the app.
    - App offers quiz/trivia questions from an API. Users can answer questions and earn karma. Scores are shared between different users of the app

## Requirements

This is the full set of requirements that we ask you to accommodate when designing and implementing your app:

- Firebase must be used to save user data.
- Firebase must be used to allow user logins, but data may also be shared between phones without requiring logins.
- If practical, very small user data must be persisted on the phone, so as to provide a responsive app in case of network problems.
- Not all data from the API needs to be saved on the phone once retrieved, it may be requested more than once (mind limits set by the API provider!).
- Even if killed, the app should generally resume in the same state as before.
- Code should be organised well (keeping in mind the advice from Better Code Hub).
- Code should be documented well (comments, variable names, as well as READMEs).

Check your app proposal with the TAs to ensure the scope is sufficient!

## APIs

Here are some suggestions for finding interesting APIs:

- <https://opendatanederland.org>
- <https://github.com/caesar0301/awesome-public-datasets>
- <http://www.programmableweb.com/apis/directory>
- ... or search for trivia/quiz APIs using your favorite engine.

## Peer review

Although the app will be graded by the staff, you are required to perform a code review with one other student. The results of the review should be documented in a file called `REVIEW.md`. You are expected to use the results of this review to improve your code before submitting the final version.

## Getting started

1. Create an empty [GitHub](https://www.github.com/) repository to manage your code.

2. Create a new project.

3. You're on your own now!
