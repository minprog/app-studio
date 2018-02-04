# Singleton

A singleton class is a class of which only a single instance is permitted. In the case of working with a database, it's costly to open and close the database for every single operation. On the other hand, keeping the connection open only requires a very modest amount of memory. We can use a singleton class to make sure that once opened, the database can stay opened.

To create a singleton class, first of all, me must make the constructor `private`. Every class comes, by default, with a `public` constructor. With a public constructor, we can't control where and when instances are created. With a private constructor, in fact, no one can create an instance:

    public class SingletonClass {
        private SingletonClass() {
            // empty private constructor
        }
    }

Now, we obviously need to allow the creation of that single instance, otherwise the class would be pretty useless. First, let's create a static variable that can hold the instance:

    public class SingletonClass {
        private SingletonClass instance;
        
        private SingletonClass() {
            // empty private constructor
        }
    }

And here's the trick: we define a static `getInstance()` method which, if the instance is `null` (it does not exist yet), creates a new instance, and otherwise returns the single existing instance:

    public static SingletonClass getInstance() {
        if(instance == null) {
            // call the private constructor
            instance = SingletonClass();
        }
        return instance;
    }

This way, we can call the method in any activity, like this:

    SingletonClass s = SingletonClass.getInstance();

This line will always return an instance: either it had to be created or we just get the existing one. From the perspective of the activity, we can't know and we don't care, because it always works.

## Context

SQLite is a file-based database system, so it needs access to a place to write its databases. This is why the `SQLiteOpenHelper` constructor requires a `context`:

    public SQLiteOpenHelper(Context context, String name, CursorFactory factory, int version)

In Android, if you need a `Context`, you usually refer to the activity itself using `this`. That's perfectly fine. But in case of our database, especially as a singleton, the point is to have it open all the time. That's why we need to provide it with the **application context**, which can be retrieved from any activity using `getApplicationContext()`.
