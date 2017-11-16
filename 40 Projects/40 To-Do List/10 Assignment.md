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

![Screen shot of the to-do list app](todo.png)

## Functional requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- Your app should properly display on devices of various dimensions.

- Your app should properly support rotation of the user interface (no data loss).

- Every to-do item needs to have *at least* `title` and `completed` fields, additional fields may be implemented as well.

- The user interface should clearly represent whether a todo item has been marked as "done" (using a custom list view layout).

- Users must be able to mark items as complete and delete them.

- Allow marking of items as done by responding to a simple tap on the item itself.

- Allow deletion of items through a "long click" (pressing and holding on an item). Use the `setOnItemLongClickListener` method of your list. However, do not use anonymous listeners!

## Technical requirements

- The to-dos should be displayed as a `ListView` of tasks that the user needs to complete.

- To-dos must be represented in your code by a model class. 

- To-dos must be saved in a SQLite database so as to ensure that to-do items survive when the app is killed or the phone rebooted.

- Your app's readme should show the [Better Code Hub](/guides/better-code-hub) badge. No need to refactor your code, though!

## Step 1: Getting started

- Create a new empty GitHub repository.
- Create a new Android studio project and link it to the repository.
- Design the `MainActivity`, adding a `ListView`, and a `EditText` with a `Button`.
- Make sure the layout works for small and large phones.

## Step 2: Create a model class

We're going to create a business object class called `TodoItem` to represent the items on the to-do list.

- Go to **File** > **New** > **Java Class**.
- Name your class `TodoItem`. You do not need to change the other options.
- Now add `private` instance variables called `title` and `completed`, using appropriate types (discuss with your neighbors what the best type would be for each field).
- Create a constructor and getter methods, like in the [readings](/android/models).

## Step 3: Create the database class

- `TodoDatabase` << SQLiteOpenHelper
- `onCreate()` -> 3 sample todo items for testing
- `onUpdate()` -> drop it

## Step 4: Make it a singleton

- Singleton
- `getApplicationContext()` when calling, because always the same context

## Step 5: Write the select method

- Create layout for list item with checkbox, label
- TodoDatabase.select -> Cursor
- https://thinkandroid.wordpress.com/2010/01/09/simplecursoradapters-and-listviews/

## Step 6: Write the insert method

- TodoDatabase.insert(TodoItem)

## Step 7: Write the update method

- TodoDatabase.update(position, TodoItem)

## Step 8: Write the delete method

- TodoDatabase.delete(position)

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL below, in the textbox!
