# Restaurant Revisited


## Objectives

- Practice with user interface design.
- Practice with presenting information in fragments.
- Practice with online APIs with JSON.
- Practice with storing more complex data in SQLite.

## Preparation

Guides available from the first implementation of Restaurant:
- Learn about [Listeners](/android/listeners).
- Learn about [Lists](/android/lists).
- Learn about [Volley](/android/volley).
- Learn about [Persistence](/android/persistence).

Guides specifically for Restaurant Revisited:
- Learn about [Models](/android/models)
- Learn about [SQLite](/android/sqlite)
- Learn about [Interface Design](/android/todo).
- Learn about [Action Bar](/android/todo).
- Learn about [Fragments](/android/todo).

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.


## What to do

Create an app that will help users look at a restaurant's menu and compose an order of items, as well as allow them to "submit" the order and receive an estimated waiting time for this order. Of course, they must be able to view the price of items, the total price of the order and be able to remove items from the order as well! All of this should be done using an elegant and simple user interface.

This week we will revisit the user interface and take a look at Android's *Fragments*. Fragments are a good way to contain functionality of your app so that the user can easily toggle between these functialities.



## Step XX: Creating the database classes

To store our user's order, we will use a SQLite table. This allows us to easily store all data: the product id, name, price and amount ordered.

- Create a class `RestoDatabase` inheriting from `android.database.sqlite.SQLiteOpenHelper`.
- Use **CTRL-I** to add `onCreate()` and `onUpgrade()`. Add code to create the `order_items` table (in `onCreate`) and to drop it (in `onUpgrade`).
- Use **CTRL-O** to add the constructor.
- Make the class into a singleton (following instructions from [To-Do List step 3](https://apps.mprog.nl/projects/to-do-list) if needed).
- Add a `selectAll()` method that returns a `Cursor` for all `order_items`.
- Add an `addItem()` method which accepts `id`, `name`, `price` and adds the item to the database with `amount` set to 1. If there is already a record for the menu item, it should not add a new record, but instead update the existing record, incrementing the `amount`.
- Add a `clear()` method which removes all lines from the order.

