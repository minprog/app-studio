# Build Your Own!

*First deadline: Tuesday, 21 March, during class (2 points).*  
*Second deadline: Tuesday, 28 March, by appointment (1 point).*  
*Code quality deadline: Tuesday, 28 March, anytime.*

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

- The application concept may be based (but does not have to be) on a public API with open data. This should be a "live" API, where you can do requests from your app for more data; for example, using JSON.

## Requirements

This is the full set of requirements that we ask you to accommodate when designing and implementing your app:

- Firebase must be used to save user data.
- Firebase may be used to allow user logins, but data may also be shared between phones without requiring logins.
- Very small user data must be persisted on the phone, so as to provide a responsive app in case of network problems.
- Not all data from the API needs to be saved on the phone once retrieved, it may be requested more than once.
- Even if killed, the app should generally resume in the same state as before.
- Code should be organized well (keeping in mind the advice from Better Code Hub).
- Code should be documented well (comments as well as READMEs).

Discuss your app proposal with the TAs to ensure the scope is sufficient!

## APIs

Here are some suggestions for finding interesting APIs:

- <https://opendatanederland.org>
- <https://github.com/caesar0301/awesome-public-datasets>
- <http://www.programmableweb.com/apis/directory>

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
