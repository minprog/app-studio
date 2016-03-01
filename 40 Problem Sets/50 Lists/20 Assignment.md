## Android

Write a simple to-do list app that has a `ListView` of tasks that the user needs to complete. Initially the app is empty and has nothing in the to-do list. But if the user types text into a bottom `EditText` and clicks an Add button, the new item will be added to the top or bottom of the list.

It's also good to have a way to remove items from the list. You could achieve this by attaching a listener to the list that removes an item when that item is clicked on by the user. Or if you want to try something slightly different, try making it remove an item when the user performs a "long click" (pressing and holding the mouse on an item). You can do this by calling the `setOnItemLongClickListener` method of your list and passing an anonymous `AdapterView.OnItemLongClickListener` class. Android Studio can help you auto-generate the skeletons of these anonymous listener classes if you press *Ctrl-Space* in the editor at the right place in the code.

![](todo.png)

Figure: User long-clicking on second list item to delete it

If the items in your to-do list are stored into an `ArrayList`, by default the app's GUI won't notice when you add or remove an item from the list. That is, you'll modify the `ArrayList` state but the graphical list on the screen won't update to match.

To fix this, you have to call the method `notifyDataSetChanged()` on your `ArrayAdapter` to tell it that the underlying array list has changed. To be able to do this, of course, you'll have to save your `ArrayList` and your `ArrayAdapter` as private fields inside your activity.

Make sure that the app doesn't forget your to-do items when you rotate the screen back and forth from portrait to landscape mode. Use a `Bundle` to save the list's data. To make a more robust app, you'll want to make it also save the to-do list to the device's storage so that it will survive a reboot. To do this, you'd need to write code that reads/writes files to the system's internal storage:

    // write to a file
    PrintStream out = new PrintStream(openFileOutput("filename.txt", MODE_PRIVATE));
    out.println(text);
    out.close();
    
    // read a file
    Scanner scan = new Scanner(openFileInput("filename.txt"));
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        do something with line;
    }

If you want to add text-to-speech to this app, such as making it read the to-do list aloud, please feel free to do so.
