# To-Do List App

*Due: Sunday night, May 8, 2016.*

## Objectives

- Display lists.
- SQLite databases.

## Preparation

- On Android: read about [Lists and Fragments](/android/lists-and-fragments)
- On iOS: watch the demo about [Table Views](/ios/table-views)

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

All students must ordinarily submit this and all other problem sets to be eligible for a satisfactory grade unless granted an exception in writing by the course’s heads.

## To-Do List

This week you will write a simple to-do list app that has a list of tasks that the user needs to complete. Initially the app is empty and has nothing in the to-do list. But if the user types text into a bottom input field and clicks an Add button, the new item will be added to the top or bottom of the list.

If you want to add text-to-speech to this app, such as making it read the to-do list aloud, please feel free to do so (optional).

## Requirements

Your task is to build an app according to the description above. On top of that, there are some specific requirements to take into account:

- The user should be able to remove items from the list. There are various methods to achieve this.

- You must make the app as robust as possible, so make it save the to-do list to an SQLite database so that it will survive a reboot.

- Your app should support rotation of the user interface, just like the weeks before.

## Getting started

1. Create a new empty GitHub repository.

2. Create a new project, using this pattern as a name: `studentname-pset2`.

## Implementation details (Android)

The to-dos will be displayed as a `ListView` of tasks that the user needs to complete. If the user types text into a bottom `EditText` and clicks an Add button, the new item will be added.

It's also good to have a way to remove items from the list. You could achieve this by attaching a listener to the list that removes an item when that item is clicked on by the user. Or if you want to try something slightly different, try making it remove an item when the user performs a "long click" (pressing and holding the mouse on an item). You can do this by calling the `setOnItemLongClickListener` method of your list and passing an anonymous `AdapterView.OnItemLongClickListener` class. Android Studio can help you auto-generate the skeletons of these anonymous listener classes if you press *Ctrl-Space* in the editor at the right place in the code.

![Screenshot from Android](todo.png)

Figure: User long-clicking on second list item to delete it

If the items in your to-do list are stored into an `ArrayList`, by default the app's GUI won't notice when you add or remove an item from the list. That is, you'll modify the `ArrayList` state but the graphical list on the screen won't update to match.

To fix this, you have to call the method `notifyDataSetChanged()` on your `ArrayAdapter` to tell it that the underlying array list has changed. To be able to do this, of course, you'll have to save your `ArrayList` and your `ArrayAdapter` as private fields inside your activity.

Use a `Bundle` to save the list's data during rotation.

## Implementation details (iOS)

The to-dos will be displayed as a `Table View` of tasks that the user needs to complete. If the user types text into a bottom `Text Field` and clicks an Add button, the new item will be added.

It's also good to have a way to remove items from the list. You could achieve this with the `commitEditingStyle` delegate function.

![Screenshot from iOS](todo_ios.png)

Figure: User swiping on the third list item to delete it.

Make sure you connect your table view with the datasource and delegate from the Storyboard to your Swift-file.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL below, in the textbox!
