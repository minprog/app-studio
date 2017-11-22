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

This week we will revisit the user interface and take a look at Android's *Fragments*. Fragments are a good way to contain functionality of your app so that the user can easily toggle between these functialities. To achieve this, we will start from scratch, but of course reuse a lot of code that you already created in the first iteration of the Restaurant app!


## Step 1: Getting started
- Create a new empty GitHub repository.
- Create a new Android studio project and link it to the repository.


## Step 2: Interface Design
- Create a `MainActivity`, but do not add any widgets to your layout yet, as these will be contained in our `Fragments`
- We will now create three fragments, one to hold the list of categories and menu items, one to hold the current order, and one to hold information about a specific dish
-
