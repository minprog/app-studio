# To-do List

*First deadline: Tuesday, 7 March, during class (2 points).*  
*Second deadline: Tuesday, 14 March, during class (1 point).*

## Objectives

- Save app data between sessions.
- Make sure that your app returns to the previous screen, no matter what.
- Use SQLite.
- Clean up your code.

## Preparation

- On Android: read about [SQLite](/android/sqlite), the [activity life cycle](/android/state) and [Better Code Hub](/guides/better-code-hub).
- On iOS: watch the demo about [SQLite](/ios/sqlite), [state restoration](/ios/state) and [Better Code Hub](/guides/better-code-hub).

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

- To-dos must be saved in a SQLite database so as to ensure that to-do items survive when the app is killed or the phone rebooted.

- Your app should properly return to the last screen viewed, even if killed for some reason.

- Your app's readme should show the [Better Code Hub](/guides/better-code-hub) badge. No need to refactor your code, though!

## Getting started

1. Create a new empty GitHub repository.

2. Create a new project, using this pattern as a name: `studentname-pset4`.

## Tips (Android)

- The to-dos should be displayed as a `ListView` of tasks that the user needs to complete.

- To-do items should be displayed in the list view as custom views. Design these to be able to display an item text as well as a check mark.

- Allow deletion of items through a "long click" (pressing and holding on an item). Use the `setOnItemLongClickListener` method of your list. However, do not use anonymous listeners!

## Tips (iOS)

- The to-dos should be displayed as a `Table View` of tasks that the user needs to complete.

- To-do items should be displayed in the table view as custom (prototype) cells. Design these to be able to display an item text as well as a check mark.

- Allow deletion of items with the [`commitEditingStyle`](https://www.ioscreator.com/tutorials/delete-rows-table-view-ios8-swift) delegate function.

## How to submit

1. Add a `README.md` with screenshot and a brief description. Use Markdown to format your README, as supported by GitHub. The screenshot must be uploaded to your GitHub repository first! Do that nice and clean in a separate folder called `doc`.

2. Commit and push one last time (hopefully!).

3. Check if your project actually works for other developers! Go to the GitHub webpage for your repository and use the "Download zip" button. Unpack that zip somewhere unusual (your Desktop maybe?) and try to open and run the project.

4. When all is set, paste the GitHub repo URL below, in the textbox!
