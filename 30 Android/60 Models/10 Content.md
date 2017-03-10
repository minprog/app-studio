# Model classes

## Business objects

You can define a couple of *business object* classes in your app, which define some of ideas from your app's domain. For example, in a student grade database, you would probably need **Student** and **Grade** classes.

- What are [business objects](https://en.wikipedia.org/wiki/Business_object)?

- Creating model classes [efficiently](http://stackoverflow.com/questions/14206434/android-do-we-have-to-manually-create-model-classes) in Android Studio.

![embed](https://player.vimeo.com/video/207789065)

## Creating a database helper class

Creating a separate class for handling the database connection can make it easier to change the design of the application later on; for example, you could change from SQLite to an online database provider by changing only the helper class.

- First: creating a singleton:

![embed](https://player.vimeo.com/video/207305975)

- Why creating a database helper singleton helps remedy [memory leaks](http://www.androiddesignpatterns.com/2012/05/correctly-managing-your-sqlite-database.html).

- Tutorial: how to implement a [database helper](http://guides.codepath.com/android/local-databases-with-sqliteopenhelper).

## Background

To refresh your memory, [here](http://www.journaldev.com/9383/android-internal-storage-example-tutorial) is a short tutorial on how to save data to the internal memory of your phone (as you will implement in this week's app).

If you still feel a bit overwhelmed by OOP (*Object Oriented Programming*), read [this](http://www.vogella.com/tutorials/JavaIntroduction/article.html) guide on Java Programming. For this week's assignment you can skip to part 4: *Java language structure*, which explains how classes work. However, parts 6 and 7 also contain a lot of useful information.
