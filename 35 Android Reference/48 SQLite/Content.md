# SQLite

Android SQLite is a lightweight database that you can use to store data on your Android Device. SQL stands for structured query language and is a way to communicate with databases. The SQLite database is a relational database and makes use of tables with rows and columns. To store our data, we will create our own table structure. A table could for example contain "books", with columns referring to each book's ISBN, title, author etc. The contents of this table could then be rendered into a ListView or displayed in some other way.


To communicate with our database on the Android platform, we will make use of various methods that perform classic operations such as creating, reading, updating and deleting database entries. To keep things readable and all functionality centralized, this code will be contained in a *helper class*.

## DataBaseHelper
This is the class that we will use to help us manage our database. We will construct our own subclass that extends `SQLiteOpenHelper` so that we have access to all of its functionality. This subclass will have to contain at least these three methods: a constructor, an `onCreate` and an `onUpgrade`.

    public class DatabaseHelper extends SQLiteOpenHelper {
        // room for plenty of code...    
    }

### Constructor
The constructor is used to create a new instance of our subclass. In the constructor, we set the context (usually an `Activity`),  the name of our database, optionally the cursor factory (this is not needed for now), and the database version.

The database version is important because sometimes you will want to change your database schema, because you added a column or a table. When doing so you need to somehow notify your database that something has changed. The version number is used to keep track of this and typically starts at 1.

 Our constructor looks like this:

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

### onCreate
This method is called when there is no database yet, for example when the app is started for the first time, and we need to have one created. The `onCreate` method received a `SQLiteDataBase` object, in this case called `db`, that we can now use.

    public void onCreate(SQLiteDatabase db) {
        // now we can use the db object to do stuff
    }

By itself, this method does not do much yet, aside from giving us the database object. However, this object does not contain any database schema yet, so there are no tables and no data. For that, we first need to tell the database how it should be structured, that is which tables should contain and which columns should be present in those tables.


Because we now have the database object available, we can perform SQL queries! Queries can be executed by calling `execSQL()` on our database reference and passing the query as an argument. Structuring your queries well is important, as mistakes can produce errors and weird behaviour. If unsure, you can use an [online query validator](http://sqlfiddle.com/) to check your queries for common mistakes (make sure to specify SQLite, as regular SQL queries look somewhat different).


If we were to create a table containing three columns, one for an id, one for a name and one for a phone number, our initial query to construct this table could look like this:


    create table myContacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phoneNumber INTEGER);


Let's break it down into smaller pieces. First, we tell the system that we want to create a table by saying `create table`. All good so far, right? Then, we specify the name of the table. In this case we called our table `myContacts`. Then, between parentheses we specify what the columns of our table should look like.


In this case, we create a column called `id`. When creating a column, you need to specify the type of variable that this column should hold as well. Ids are generally numbers, so we specify that it should be an `INTEGER`. Because we want our ids to be unique (each entry into the database should get it's own proper id, no duplicates allowed!), we specify that it should be a `PRIMARY KEY`.


We also want our database to increment this value automatically, that is, every new entry should automatically get a value for `id` that is one higher than the entry that was added before. This is practical because now we can just insert new contacts into our table without having to think of which id we should give them, the database handles this for us!


Finally, we also add the columns `name` and `phoneNumber`, which are of the types `TEXT` and `INTEGER` respectively. A query to create a table can contain many more columns, of various types, but integers and text values are most commonly used.

Our `onCreate()` then could look something like the snippet below. We take our `SQLiteDataBase` object that is passed to us as `db` and call `execSQL()` to execute the query we have constructed. If you want to create multiple tables, you can make multiple calls to `execSQL()`.

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table myContacts (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phoneNumber INTEGER);");
    }

### onUpgrade
We call this method when we made a new database schema and the old version of the database does not match this new schema. This could for example be the case when we added a whole new table, added a column, changed the value type of a column or changed a table or column's name. Basically, any change to the table and column structure of the database means a change in the schema and warrants a call to `onUpgrade()`. Usually when we do this, we also want to delete all data previously in the database, because with the changed structure the old data no longer "fits".

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "contacts");
        onCreate(db);
    }

As you can see in the snippet above, the `onUpgrade()` method takes three arguments: the database we are updating, and the version numbers. The version numbers help us keep track of what version of the database we are currently using. The version of the database is stored within the database object and we can retrieve the current version of the database by calling `getVersion()` on our database object. This version number is updated to the value of `int newVersion` that is passed to the `onUpgrade()` method.

As mentioned before, when upgrading our database it's a good idea to remove all the old data so that we start with a clean slate, so to speak. In our example with the contacts table, this is done by executing the SQL query `DROP TABLE IF EXISTS contacts`. By executing this query, we simply tell our database to delete the table that goes by the name `contacts`(if it exists). Obviously, if you have multiple tables in your database, it's a good idea to delete all of them by executing multiple queries.

Now, if we are upgrading our database to a new schema, your `onCreate()` and the queries you execute in it should also have been changed to reflect this change. Thus, after deleting our old tables, we want to call `onCreate()` ourselves to recreate our database with the new schema we specified.
