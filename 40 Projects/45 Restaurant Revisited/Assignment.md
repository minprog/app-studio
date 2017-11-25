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

Guides specifically for Restaurant Revisited:
- Learn about [Models](/android/models)
- Learn about [SQLite](/android/sqlite)
- Learn about [Fragments](/android/fragments)

## Assessment

Your work on this problem set will be checked for full completion of the assignment and consideration of all requirements. Demo your application during office hours.

All students must ordinarily submit this and all other projects to be eligible for a satisfactory grade unless granted an exception in writing by the course's heads.


## What to do

Create an app that will help users look at a restaurant's menu and compose an order of items, as well as allow them to "submit" the order and receive an estimated waiting time for this order. Of course, they must be able to view the price of items, the total price of the order and be able to remove items from the order as well! All of this should be done using an elegant and simple user interface.

![](app.png)

1. New project with Blank Activity
2. Add CategoriesFragment based on ListFragment.
3. Use Volley to load categories from website, connect to list with `this.setListAdapter()`.
4. Prepare `MainActivity` for first fragment:

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new CategoriesFragment())
                .commit();
5. Create MenuFragment based on ListFragement for showing menu based on category.
6. Override onListItemClick for CategoriesFragment to go to MenuFragment:

        MenuFragment menuFragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("category", s);
        menuFragment.setArguments(args);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .addToBackStack(null)
                .commit();
7. Use Volley to load menu from website.
8. Add `OrderFragment` inheriting from `DialogFragment` for showing order.
9. Add OptionsMenu to the `MainActivity`:

        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actions, menu);
            return super.onCreateOptionsMenu(menu);
        }
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.place_order:
                    ...
            }
        }
10. Handle clicking **cancel** in `OrderFragment`:

        Button b = (Button) v.findViewById(R.id.cancel_button);
        b.setOnClickListener(this);

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                ...
            }
        }
4. Add OrderDatabase and OrderAdapter like in the TodoApp.
5. Allow adding items to order in MenuFragment.
6. Allow placing order and clearing db in OrderFragment.



## Step 1: Getting started
- Create a new empty GitHub repository.
- Create a new Android studio project and link it to the repository.
- Keep your previous code of Restaurant close, if you have it! You are allowed to reuse your previously implemented functionality.

## Step 2: Creating our MainActivity

- Create a `MainActivity`, but do not add any widgets such as buttons, views etc. to your layout yet, as these will be contained in our fragments.
- We will now create three fragments, one to hold the list of categories, one for our menu items and one to hold the current order and "submit order" functionality.

## Step 3: Creating our Fragments
- The three fragments we will create are: `CategoriesFragment`, `MenuFragment` and `OrderFragment`.
- If you haven't read the guide on `Fragments` yet, you can find it [here](/android/fragments).
- For our app, we will make use of lists. Luckily there are fragments with list functionality built in available.
- We will now slowly add the needed functionality ourselves, so that we don't end up with mountains of pre-generated but hard to understand code.
- To create such a `ListFragment`, go to **New > Fragment > Fragment (Blank)** and uncheck the boxes for "Include fragment factory methods" and "Interface Callbacks".
- Take a quick look at your newly generated code and read through the comments to get some idea of what you still have to do.
- You should have a `Fragment` class with a constructor and `onCreateView()`, and also a layout XML file associated with your newly created fragment.

## Step 4: Adding the ListFragment functionality
- What we are now going to do is change it to a `ListFragment`. Do this by changing `extends Fragment` to `extends ListFragment` in Fragment class declaration.
- Add the appropriate layout elements to your fragment's `fragment_name.xml` files. The `ListFragment` of course needs a `ListView` to work properly.
- Make sure to give this `ListView` the identifier property `android:id="@+id/android:list"`, this is required for the fragment to work.
- We will now override the `onItemClick` method that comes with the `ListFragment` to add our own functionality later using `CTRL+O`.
- You can also override `onCreate()`, because chances are you will want to use this method as well later on, for example to start a method to get data from the API.
- Repeat these steps to create another fragment that will hold the code for our menu items, instead of the categories.


## Step 5: Connecting our first fragment to MainActivity
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


## Step 6: Functinalities of CategoriesFragment
- Make sure that your `MainActivity` attaches this fragment on startup.
- In the `CategoriesFragment`, use [Volley](/android/volley) to load categories from the API, and store these in a list.
- You can connect your list to your `ListView` in the fragment by simply using `this.setListAdapter()` because the whole fragment counts as a list.
- Override the onclick method for `CategoriesFragment` to go to `MenuFragment`, and pass on the category that was clicked:

        MenuFragment menuFragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString("category", s);
        menuFragment.setArguments(args);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .addToBackStack(null)
                .commit();


## Step 7: Functionalities of MenuFragment
- Extract the category that was clicked on. You can use the `Bundle` item that the `onCreate()` in the `MenuFragment` receives to do so.
- In the fragment, once again use [Volley](/android/volley) to download the menu data from the API.
- Using our onclick method, extract the data necessary to store the item clicked in an order, as clicking the items in the `MenuFragment` should add them to the order. The adding of items itself will be handled later, using our database which we implement further down the road.

## Step 8: Creating our OrderFragment TODO
- Add `OrderFragment` inheriting from `DialogFragment` for showing order.
- Add OptionsMenu to the `MainActivity`:

        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actions, menu);
            return super.onCreateOptionsMenu(menu);
        }
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.place_order:
                    ...
            }
        }
- Handle clicking **cancel** in `OrderFragment`:

        Button b = (Button) v.findViewById(R.id.cancel_button);
        b.setOnClickListener(this);

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                ...
            }
        }

## Step 9: Connecting OrderFragment to our activity
- TODO

## Step 10: Creating the database classes
To store our user's order, we will use a [SQLite][/android/sqlite] table. This allows us to easily store all data: the product id, name, price and amount ordered.

- Create a class `RestoDatabase` inheriting from `android.database.sqlite.SQLiteOpenHelper`.
- Use **CTRL-I** to add `onCreate()` and `onUpgrade()`. Add code to create the `order_items` table (in `onCreate`) and to drop it (in `onUpgrade`).
- Use **CTRL-O** to add the constructor.
- Make the class into a singleton (following instructions from [To-Do List step 3](https://apps.mprog.nl/projects/to-do-list) if needed).
- Add a `selectAll()` method that returns a `Cursor` for all `order_items`.
- Add an `addItem()` method which accepts `id`, `name`, `price` and adds the item to the database with `amount` set to 1. If there is already a record for the menu item, it should not add a new record, but instead update the existing record, incrementing the `amount`.
- Add a `clear()` method which removes all lines from the order.
