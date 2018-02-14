# Many To-Do Lists

## Objectives

- Making your app more complex by introducing multiple lists
- Separate concerns
- Implement a *singleton*
- Use [Better Code Hub](/guides/better-code-hub) to ensure that your code is clean and well!

## Preparation

- Read about [Models](/android/models) and, if needed, [SQLite](/android/sqlite).


## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.


## Background

This week's project builds on what you created last week. You already have an application where a user can manage todo items. The structure is still fairly simple, and now it's time to create a 2.0 version. There will be one big new feature: having multiple separate lists of todo items. And this time, we are going to make the code design more object-oriented.


## Requirements

Your task is to build an app according to the description above. In addition, there are some specific requirements that you must take into account:

- You will need to add a new screen for showing the different lists that are in the app, as well as an option for adding a new list. 

- The user must be able to delete single items, as well as whole lists.

- Users must be able to mark items as complete and delete them, but also edit their contents!

- Make sure that the app will always start *exactly* where the user left off in the app (state restoration).

- Your app should support, in a user-friendly way, rotation of the device.

- You must implement a singleton for managing the lists (see below).


## Getting started

1. Create a new empty GitHub repository.

2. Create a new project, using this pattern as a name: `studentname-pset5`.

3. Copy any code that you need from your old project.
