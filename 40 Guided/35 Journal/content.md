# Journal

## Objectives

- Practice with SQLite as a database
- Create nice and intuitive layouts
- Use the Floating Action Button


## Background

For this project, you will create an app that represents a journal. In this app, you should be able to view a list of your journal entries, and of course also add new ones. A journal entry should typically consist of at least a few fields, such as the date/timestamp of the entry, the entry contents and some addition, such as an emoji reprenting your mood at the time of the entry. 

For this app, we will make use of the [Floating Action Button](https://material.io/guidelines/components/buttons-floating-action-button.html), which is in accordance with [Material Design](https://material.io/) standards for the Android Platform. The app will consist of three activities, one that holds a list with a possibility to add a new entry. Upon clicking the Floating Action button, the user should be directed to a second activity containing fields that will allow them to add a new journal entry. Finally, a third activity will show details of the selected journal entry, 


## Getting started

1.  Create a new Android studio project called **Journal**, using these settings:
    - Choose API 24 (Nougat) unless your own phone has an older operating system
    - Start with an Empty Activity which is called `MainActivity`
    - Leave all other settings unchanged

2.  Create a new, empty repository on the Github website. Name your repository `Journal`.

3.  Now, add a git repository to the project on your computer. Go to Android Studio, and in the menu choose **VCS -> Enable Version Control Integration**. Choose **git** as the type and confirm. This will not change much, but sets us up for the next steps.

    Note: if you get a popup to ask whether you would like to add some file to the repository, answer "No" for now. If you answer "Yes", things may get complicated later on.

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin".

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github. Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen. There, you should see a long list of "unversioned files". Make sure all checkboxes are selected, enter a commit message `Initial project` and then press the **commit** button. Turn off code analysis.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github. If not, ask for help!

## Architecture

Here's a general overview of the app architecture. There will be three activities, as well as a couple of classes that handle database access. Specifically, there's a model class, which represents the core concept of this app: a **journal entry**.

![](journal.png)


## Creating the user interface

First, we will focus on our `MainActivity` which will contain the list of items and a Floating Action Button. Change the root layout of the `activity_main.xml` file to a `CoordinatorLayout` as this better fits our needs: we only want one container view with the Floating Action Button hovering over it. 

Our journal entries will be contained in a list, so we wil need to add a `ListView`, which can be found under the * Container* tab. Then, add a Floating Action Button which is listed under the *Design* tab. Since the Floating Action Button is now (most probably) hovering in the upper left corner, we still need to add some parameters to snap it to the right position. Use the `layout_gravity` parameter combined with `bottom|end` to attach it to the bottom right corner.

The second activity should allow the user to input the contents of the journal entry, so you will need several `EditText` elements and probably a button to allow for submission of the entry. 

Since we also need to show items in our `ListView`, create a new layout resource file (remember how?) called `entry_row.xml` and add the views that will need to be shown for each journal entry. Think about what your list should show. Probably at least the title of the journal entry, paired with the image/emoji representing your mood at the time of creating the entry, and of course a timestamp. For showing the contents of the journal entry, we will use a separate activity. 

Finally, our third activity should show the full contents of a journal entry in a visually pleasing way. You can build the layout as you want, but all attributes of the entry should be represented.


## Handling user-interaction
To handle our user's interactions, we will need to add various listeners to our app. First, add a regular `onClick` listener to the Floating Action Button. Make sure that your listener is not anonymous, but uses its own subclass or is declared via the XML `onClick` attribute. Direct the user to the activity to create a journal entry upon clicking the button.

Create another listener for the confirmation button in this activity, but leave its body empty for now as we do not have our database implemented yet. 

Finally, add an `OnItemClickListener` to the `ListView`, as well as an `OnItemLongClickListener` by creating private inner classes (remember how?). Again you can leave the actual functionality of the listeners for now, as we will implement this later on, when our database is all set up!


## Create the Entry model class

To hold the data of our journal entries, we will create a new class that represents them. This class will be called `JournalEntry` and should have the following fields:

- `title`
- `content`
- `mood`
- `timestamp`

Also generate a constructor, getters and setters for your class using **Cmd+N**/**Alt+Ins**. (For more detailed instructions, have a look at "Modeling friends" in the [Friendsr](https://apps.mprog.nl/guided/friendsr) project.)


## Adding our database

To store our journal entries, we will make use of a SQLite Database. Luckily, support for SQLite is built into Android Studio. To make use of this functionality we will first need to create our own database class:

- Create a new java class and name the class `EntryDatabase` and fill in the superclass `android.database.sqlite.SQLiteOpenHelper`. Press OK to create the file.
- The file can't compile at this moment, because we haven't provided implementations for the required methods. Press **CTRL-I** to open up the **Implement Methods** dialog. Two methods are already selected: press OK.
- Finally, we need to create the right constructor for our class. Then press **CTRL-O** to open up the **Override Methods** dialog. Choose the simplest constructor (the topmost) and press OK.

We now have the very basic functionality of our database class, but we still need to define what `onCreate()` will do. Since we are going to store our `Entry` objects in the database, we need a table that represents these fields accurately. Our table should look like the example below, with columns that represent each field of our `Entry` model.

| _id | title | content | mood | timestamp |
|-----|-------|---------|------|-----------|
| 1   | ...   | ...     | ...  | ...       |
| 2   | ...   | ...     | ...  | ...       |
| 3   | ...   | ...     | ...  | ...       |

Now that we know what our database structure should look like, we can create the appropriate SQL query to generate the table. A proper SQL query to create a table should contain the name of the table and the names and [data types](https://www.sqlite.org/datatype3.html) of the columns in the table. 

        create table TABLE_NAME (COLUMN1_NAME COLUMN1_TYPE, COLUMN2_NAME COLUMN2_TYPE, COLUMN3_NAME COLUMN3_TYPE);

Since we want to keep track of a timestamp, it's practical to make our table automatically generate a timestamp for each journal entry when it's inserted into the database. It should also auto-increment the entry `_id`, since each row should have a unique identifier to be able to retrieve it. 

> Note that due to the structure of the query, you should avoid spaces in your column names. Protected words that denote data types or SQL keywords (such as JOIN, ADD, ACTION, CROSS) should also be avoided as column names, as these might cause your query to be wrongly interpreted. 

If you are unsure about your query, you can verify it using services like [sqlfiddle](http://sqlfiddle.com/#!5) which allows you to check whether your query is syntactically correct. 

- Implement `onCreate()`: write code that creates a table called `entries` with columns `title`, `content`, `mood` and `timestamp`. Also add an `_id` column of type `INTEGER PRIMARY KEY`. You can create a variable of type `String` that holds your SQL query and then execute the SQL query using the `sqliteDatabase.execSQL()` method.

- Implement `onUpgrade()`: write code that drops the entries table (if it exists) and recreates it by calling `onCreate()`. This is so we can start with a clean slate in case we want to, or if we want to change the schema (table structure) of our database later on. 

- Finally, to your `onCreate()`, add some code that creates sample items, so that we can use these to test. 

## Transform our database into a singleton

We'll now convert the `EntryDatabase` class into a Singleton. This means that only one instance of the class can exist at the same time: there can never be multiple instances of the `EntryDatabase` class. Instead of calling the constructor directly, we ask whether there is currently an instance of `EntryDatabase` that exists. If so, this instance will be returned to us. Only if it does not exist yet, it will be created. 

- First, make the constructor `private` instead of `public`.
- Then, add a private **static** variable called `instance` of type `EntryDatabase`. This is where the unique instance of the class is stored, once made.
- Then, add a public **static** method called `getInstance()` which should accept a parameter of type `Context`. This method should return the value of `instance` if available, and otherwise call the constructor that is now private, providing the right parameters (see [SQLite](https://apps.mprog.nl/android/sqlite)), and storing that in `instance`.
- To ensure that everything is in order, place the following line at the bottom of your `MainActivity`'s `onCreate()` method:

~~~ java
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
~~~

You project should now compile and run successfully, though data is not yet displayed.

##  Write the select method

- Write a method called `selectAll()` in `EntryDatabase`. First, use `getWritableDatabase()` to open up the connection with the database. Use the method `rawQuery` from that object to run a `SELECT * FROM todos` query and `return` the `Cursor`.
- Use your custom `entry_row.xml` and create a new class `EntryAdapter` inheriting from `ResourceCursorAdapter`. Implement a constructor `public EntryAdapter(Context context, Cursor cursor)`. Call `super` and pass on the `context` and the `cursor`, and also the `id` of the layout that you just made. Tip: layout IDs start with `R.layout` and not `R.id`!
- Implement the abstract method `bindView()`, which takes a `View` and fills the right elements with data from the cursor.
     - Use `Cursor.getInt(columnIndex)` to retrieve the value of one column as an integer.
     - Use `Cursor.getColumnIndex(name)` to get the column index for a column named `name`.
     - Call `view.findViewById()` to get references to the controls in the row layout.
- In the `onCreate()` of the `MainActivity`, use the `EntryDatabase` to get all records from the database, make a new `EntryAdapter` and link the `ListView` to the adapter.

The app should now display all example entries from the database!

## Write the insert method

- First, link the confirmation button in the `EntryActivity` to a new method called `addEntry` through its onClick attribute. 
- In the database class, add a public method `insert()` which accepts a title and the completed status for a single to-do item.
- In that method, open a connection to the database (see the instructions for select all), and create a new `ContentValues` object. Use the `put` method to add values for `title`, `content` and `mood`. Then, call `insert` on the database connection, passing in the right parameters (`nullColumnHack` may simply be `null`). 
- Now go back to the activity, use `EntryDatabase.getInstance()` to get to the database object, and call the `insert` method that we just defined.

## Make sure the user interface keeps updated
TODO: omdat we vanuit een andere activity entries aanmaken, wordt onCreate sowieso opnieuw gecalld en is deze interface update waarschijnlijk overbodig.

To make sure that the list view always displays the most up-to-date information from the database, we are going to update it every time we change something.

- In your activity, create a `private` method called `updateData()`.
- You will need access to the database, as well as to the adapter. Add private instance variables to your class: `EntryDatabase db` and `EntryAdapter adapter`.
- In your `onCreate()` you already create an instance of the `EntryDatabase` and of the `EntryAdapter`. Change the code to save these instances to the instance variables that we just created.

> When determining the scope of your variables, always ask yourself if the scope in which they are available matches the scope in which they are needed. While sometimes it's efficient to declare a variable for the whole class to use, it's certainly not always necessary.

- Now we can write the body for the method `updateData()`. You can use the method `swapCursor()` on the adapter to put in a new cursor for the updated data. Where do you get that new cursor? Just call `selectAll()` on the database again, as you dit in `onCreate()`.
- Call your new method right after calling `insert()` from the button `onClick` handler, and every time you add a new item, it should be displayed immediately!

## Write the update method
TODO: we doen nu niet echt iets met update. Moeten mensen in staat zijn om hun entries te veranderen?

- Add an `OnItemClickListener` private subclass to your `MainActivity` (see the explanation on [private listener classes](https://apps.mprog.nl/android/listeners)).
- In `onCreate()`, add a new instance of your subclass to the `ListView` via `setOnItemClickListener()`.
- In the database class, add a public method `update()` which accepts a `long id` and an updated completed status for some item.
- In the `update()` method, get a reference to the writable database. Create a `ContentValues` object that contains the new value for `completed`. Then call `update()` on the database. Tip: use the `whereClause` to specify which record you want to update: `"_id = " + id`.
- In your `ItemClickListener`, call your new `update()` method.







## Finishing up

As always, consider this week's assessment criteria and make sure your app works well and the code looks nice.


## Some ideas
- Make sure the app remembers at which point the user was in the listview, so they don't have to rescroll upon rotation or coming back to the list.
- Allow the user to mark certain entries as 'favorites'.
