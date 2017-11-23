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
<!-- - Learn about [Interface Design](/android/todo).
- Learn about [Action Bar](/android/todo).
- Learn about [Fragments](/android/todo). -->

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.


## What to do

Create an app that will help users look at a restaurant's menu and compose an order of items, as well as allow them to "submit" the order and receive an estimated waiting time for this order. Of course, they must be able to view the price of items, the total price of the order and be able to remove items from the order as well! All of this should be done using an elegant and simple user interface.


## Step 1: Getting started
- Create a new empty GitHub repository.
- Create a new Android studio project and link it to the repository.


## Step 2: Creating Fragments
- If you haven't read the guide on `Fragments` yet, you can find it [here](android/fragments).
- Create a `MainActivity`, but do not add any widgets such as buttons, views etc. to your layout yet, as these will be contained in our fragments.
- We will now create three fragments, one to hold the list of categories and menu items, one to hold the current order, and one to hold information about a specific dish
- To create a fragment, go to **New > Fragment > Fragment (Blank)** and uncheck the boxes for "Include fragment factory methods", we don't use those for now.
- Take a look at your newly generated code and read through the comments to get some idea of what you still have to do. You should have a `Fragment` class which holds amongst other things an `OnFragmentInteractionListener` and various methods.
- Do this for the other two fragments as well.

## Step 3: Designing our Fragments' User Interface
- Determine what content should be shown in each `Fragment` of your app.
- Add the appropriate layout elements to your fragments' `fragment_name.xml` files, such as a `ListView` for the one that will hold our list of available dishes.
- Make sure that the

## Step 4: Connect a Fragment to your Activity
- Your `MainActivity` will need a layout to hold a `Fragment`. Add a `FrameLayout` within your parent layout in `activity_main.xml`. This is the container layout that we will use to display our fragments. Make sure to give this layout an `android:id` property, for example `fragment_container`, because we will need this later!
- In your `MainActivity`'s `onCreate()` method, we will now attach our `Fragment` to the activity. We will do so using a few steps.
- First, we want to guarantee that the container layout we added in `activity_main.xml` that we try to put our `Fragment` in exists, so we perform a check using an `if` statement, like so:
        if (findViewById(R.id.fragment_container) != null) {
            // some more code will follow soon...
        }
- Now that we know the container layout for our `Fragment` exists, we can attach it to our activity using the `FragmentManager` class. This fragmentmanager allows you to add and replace fragments easily and keep track of which fragments you have added to your activity using a String as a tag/label.

        FragmentManager fm = getFragmentManager();
        YourFragmentClass fragment = new YourFragmentClass();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, "ATagForYourFragment");
        ft.commit();

- Pick a `Fragment` to attach that has a widget in it that you can see (ie not an empty `ListView`), so that we can verify that it shows up in your app when you run it. You can also temporarily add something to your fragment's layout xml for testing purposes.
- Go to your `Fragment` class, comment out all code within the class except the `onViewCreated` and the constructor, and verify that your code compiles and doesn't crash (Tip, you can comment out multiple lines of code using `CTRL + /`).

## Step 5: Managing multiple Fragments
- Coming Soon

## Step 6: Showing Data in our Fragment
- Coming Soon

## Step 7: Communication between your Fragments and Activity
- Coming Soon

## Step XX: Creating the database classes
To store our user's order, we will use a SQLite table. This allows us to easily store all data: the product id, name, price and amount ordered.

- Create a class `RestoDatabase` inheriting from `android.database.sqlite.SQLiteOpenHelper`.
- Use **CTRL-I** to add `onCreate()` and `onUpgrade()`. Add code to create the `order_items` table (in `onCreate`) and to drop it (in `onUpgrade`).
- Use **CTRL-O** to add the constructor.
- Make the class into a singleton (following instructions from [To-Do List step 3](https://apps.mprog.nl/projects/to-do-list) if needed).
- Add a `selectAll()` method that returns a `Cursor` for all `order_items`.
- Add an `addItem()` method which accepts `id`, `name`, `price` and adds the item to the database with `amount` set to 1. If there is already a record for the menu item, it should not add a new record, but instead update the existing record, incrementing the `amount`.
- Add a `clear()` method which removes all lines from the order.
