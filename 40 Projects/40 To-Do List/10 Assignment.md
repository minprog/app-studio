# To-do List

## Objectives

- Save app data between sessions.
- Make sure that your app returns to the previous screen, no matter what.
- Use SQLite.
- Clean up your code.

## Preparation

- [Models](/android/models)
- [SQLite](/android/sqlite)
- [Better Code Hub](/guides/better-code-hub)

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.

## The things I really ought to do

This week you will write a simple to-do list app that has a list of tasks that the user needs to complete. Initially the app contains three sample to-do items that explain how the app works. If the user types text into a bottom input field and clicks an *Add* button, the new item will be added to the top or bottom of the list. Of course, users must be able to mark items as "done", and delete them as well!

## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- Your app should properly display on devices of various dimensions.

- Your app should properly support rotation of the user interface (no data loss).

- Your app's back navigation should always be simple.

- To-dos must be represented in your code by a model class. 

- Every to-do item needs to have *at least* `title` and `completed` fields, additional fields may be implemented as well.

- The user interface should clearly represent whether a todo item has been marked as "done".

- To-dos must be saved in a SQLite database so as to ensure that to-do items survive when the app is killed or the phone rebooted.

- Users must be able to mark items as complete and delete them.

- Your app should properly return to the last screen viewed, even if killed for some reason.

- Your app's readme should show the [Better Code Hub](/guides/better-code-hub) badge. No need to refactor your code, though!

## Getting started

1. Create a new empty GitHub repository.

2. Create a new project, using this pattern as a name: `studentname-pset4`.

## Tips

Most likely, much of your important code now resides in one or more controllers (Activities). However, if we move some of this code into separate classes, the whole codebase can become more understandable. This is the principle of *separation of concerns*. The "ideal" of this principle is to have each class be responsible for one single thing. In practice, we usually don't take it that far.

- `TodoItem`

    Stores data for a single todo item. This class is very simple and looks a little bit like a `struct` in C. The class variables (such as `title`) should not be `public`, but `private`. Where needed, you can expose the variables through getters and setters.

- `TodoList`

    Stores data for a single todo list. That means that each instance of this class contains many `TodoItem`s! The class variables (such as `title`) should not be `public`, but `private`. Where needed, you can expose the variables through getters and setters.

- `TodoManager`

    A class that groups some common functionality. It contains the list of `TodoList`s for your application, and it handles all communication with the database.

On Android, use the approach from this [blog post](http://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html) to create your TodoManager.

## Tips

- The to-dos should be displayed as a `ListView` of tasks that the user needs to complete.

- To-do items should be displayed in the list view as custom views. Design these to be able to display an item text as well as a check mark.

- Allow marking of items as done by responding to a simple tap on the item itself.

- Allow deletion of items through a "long click" (pressing and holding on an item). Use the `setOnItemLongClickListener` method of your list. However, do not use anonymous listeners!

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL below, in the textbox!
