
## Objectives

- Practice with lists of data
- Practice with adapter views
- Work with navigation in apps
- Use multiple activities
- Store small amounts of data on the device

## Background

For this app, you will create an social friends app that allows you to view people's profiles and some information about them. When the user first loads the app, it will show a list of available users. The user can click on each one to see a bigger photo and get more information about that user. On the screen is a way to rate the user. It could for example look something like this:

![App Example](friendsrimage0.png) ![App Example](friendsrimage1.gif) ![App Example](friendsrimage2.png)

Of course this app will be an incomplete experience: you don't need to allow people to create profiles, and you can just show a fixed set of people's profiles that never changes. It does not need to do everything that an app like Facebook can do. If you don't want to supply your own images you can download a set of Game of Thrones characters [here] TODO.

To create this app, we will make use of two *Activities* e.g. screens in our app, one that shows a list with an overview of all people available in the app, and another that is triggered when we click on one of these people which provides more details and a bigger profile picture.

The ratings we give to each of the app's profile's will be stored using `SharedPreferences` which allows the rating to persist, even when we leave the `Activity` or shut down our app (or phone!) altogether. 

## Getting started

1.  Create a new Android studio project called **Friendsr**, using these settings:
    - Choose API 24 (Nougat) unless your own phone has an older operating system
    - Start with an Empty Activity which is called `MainActivity`
    - Leave all other settings unchanged

2.  Create a new, empty repository on the Github website. Name your repository `Friendsr`.

3.  Now, add a git repository to the project on your computer. Go to Android Studio, and in the menu choose **VCS -> Enable Version Control Integration**. Choose **git** as the type and confirm. This will not change much, but sets us up for the next steps.

    Note: if you get a popup to ask whether you would like to add some file to the repository, answer "No" for now. If you answer "Yes", things may get complicated later on.

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin". The URL should look like this: <https://github.com/stgm/Friendsr.git> (you can find a link to your URL on the GitHub website where you just created a repository).

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github.
    - Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen.
    - There, you should see a long list of "unversioned files". Make sure all checkboxes are selected
    - Enter a commit message `Initial project`.
    - Turn off code analysis.
    - Finally, press the **commit** button.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github. If not, ask for help!


## First Activity: Creating the user interface

Let's create the basic UI that we should see when we open the app first: head to `activity_main.xml` in your project. As usual, we get a blank screen with a `ConstraintLayout`. This type of layout is not particularly ideal for our purposes. What we'll do is replace it with a `LinearLayout` and then use a `GridView` to show all of our users on a grid. 

![Layout Placeholder Example](layoutimage0.png)

- In the XML, change the `ConstraintLayout` with a `LinearLayout` (remember how?). Also, delete the text view that's already in there.
- In the designer, head for the Palette and choose **Containers**. There you should be able to select a `GridView` and add it to your layout. If done correctly, your design should now show an example grid of items, something like the image above.
- You can tweak the attributes of the `GridView` to show more or less items on a row or have more space between items. Take a look at `numColumns`, `stretchMode` (`spacingWidthUniform` seems like a nice and clean solution) and see if you can tweak it to look how you want. Feel free to deviate from the example. If 4 columns is the way to go: power to you!


## Modeling friends

Now that the user interfaces are all set, let's create a simple model class to contain data about our friends. This model class will contain the info about the friends that show up in the app. We do this so we can keep track of all of the information together, such as their name, picture, rating and information/bio. 

1. The Friend model will be held in its own Java class. First, select `MainActivity` in the browser on the left and then choose **File > New > Java Class**.

2. We will call the class `Friend`. In the dialog, also specify that you want to use the `Serializable` (or `java.io.Serializable`) interface. This will allow us to store `Friend` objects on the device more easily. You can leave all other settings unchanged.

    (If Android Studio offers to add the new file to the git repository, feel free to do so.)

3. You are now presented with your empty `Friend` class, so time to add some fields to it! Within your class, declare fields to store the name and bio of a user. These should probably of the type `String`. Also, we will need a `float` to keep track of the rating, because the `RatingBar` widget uses a float by default. Finally, we want to keep track of an id that points to a drawable, to be able to show an image. This id will be of type `int`. You should now have something like this:

        public class Friend implements Serializable {
            private String name, bio;
            private int drawableId;
            private float rating;
        }

    Note that the names of the fields are grey currently: this means that the fields aren't used anywhere useful, yet. But this will come soon!

5. Our class also needs a constructor, which we can now easily generate using **Alt+Insert** or **Cmd+N**. As our constructor fields, we want to set the `name`, `bio` and `drawableId`, but not the rating.

6. Although our fields are currently `private`, we should be able to read the values using a getter. Using the same shortcut as the previous step, add getters for all fields.

7. Finally, go to that menu once more, and add a setter for the `rating` field. We are going to allow the user to change the rating within the app, so we should be able to change the rating through this setter!


## Creating some sample friends

We'll need to create some friends to show in our app later. We are going to instantiate some `Friend` objects in `MainActivity`. But first, let's add some cute images with photos of our friends.

1. Just for a second, switch to the Project View using this dropdown:

    ![](project-view.png)

2. Navigate to the `app` > `src` > `main` > `res` > `drawable` folder. Drag the downloaded image files into that folder. Android Studio will offer to move/copy them, and then to add them to your local git repository. That's all fine.

3. Jump back to the Android View using the same dropdown as in step 1. You can now use the images in your app.

 
Let's make an `ArrayList` of sample friends in `MainActivity`. Since we are storing `Friend` objects, declare the list as follows:

    ArrayList<Friend> friends = new ArrayList<>();

Your task is to write code in the `onCreate()` for adding all friends. You can add items to the list using the `add()` method. This method requires a `Friend` object. Here's how to create a friend with a reference to its picture:

    new Friend("Tyrion", "Lord Tyrion Lannister is the younger brother of Cersei and Jaime Lannister.", R.drawable.tyrion)


## Adding a layout for the grid view

Because a `GridView` is just the container for our items, the layout for the items themselves will be defined elsewhere. Let's create a new layout file.

- Go to the `layout` folder, right click on it, and use **New > Layout resource file** to create a file called `grid_item.xml`.

- For the root element, specify `LinearLayout`. No need to change other options.

- We have some wishes as to what the items on our grid should look like. Ideally, we would want to show at least a picture and the name of our friend. Add those to the layout.

Tip: add some padding to your layout! Click "Show more attributes" if needed. Add padding to the root `LinearLayout`, something like 12dp (12 device pixels). You can also add padding to views within the layout, to make sure the views don't stick together too much.


## Creating an adapter

Now might be a good time to try building and running your app. If any errors pop up, try to solve those first and ask for help! Otherwise, the app is pretty boring! Even though we have a Grid View in the main layout, it doesn't show anything.

To fix this, we need a way to pair the list of `Friend` objects with the grid layout. The missing connection will be made through an **adapter**. The adapter will be responsible for providing layout items for the grid view, and filling those with data from the `ArrayList` of friends. Let's create an `ArrayAdapter`.

Because we have a custom `Friend` class, we will have to tell our `ArrayAdapter` how to treat each instance of `Friend` in order to render it correctly in the `GridView`. Remember the layout file we created before, `grid_item.xml`? This layout file will be used to tell the adapter what to render for each item in our list. Follow the steps below to create the adapter class.

- Make sure you have selected something in the Android browser, go to **File > New > Java Class** and create a class called `FriendsAdapter`. We will use `ArrayAdapter` as the superclass, which ensures that we don't have to write all adapter code ourselves.

Did you notice that Android classes always have a name that **ends** with the kind of class it is? `MainActivity` and `FriendsAdapter` are examples. However, the `Friend` class is special: it is not of any special Android kind, so it is simply called `Friend`.

- Change the declaration of the class to contain `ArrayAdapter<Friend>` like so: `                public class FriendsAdapter extends ArrayAdapter<Friend>`.

- Generate a constructor using `CTRL+O`: choose the constructor that takes context, a resource id of type integer and a list of items `List<T>` as its arguments.

- When you have generated your constructor, change the parameters to reflect the type of your list, which is an `ArrayList<Friend>`.

- Finally, hit `CTRL+O` one more time to override `getView()` (find it in the list), which is the method where we will determine what should be shown on the screen for each item in our list. 

Take a look at the `getView()` method that was just generated. This method is called for every item in your list (which, in our case, is an object of type `Friend`). The method gets three arguments, of which the first two are the most important. The first argument `position` indicates which item in the list we'd like to show. As usual, this position is zero-based.

We'd like to load a specific layout and show the data we're interested in. This is where that happens. For reasons of efficiency, the layouts in a list are recycled. As we scroll up, views from the top (that disappear) are moved to the bottom to show new data. As the grid is shown for the first time, however, we'll need to load the layout for each new grid item.

Replace the `return super.getView...` by the following code:

    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }
    return convertView;

Notice that convertView is inflated from `R.layout.list_item`, which represents our `list_item.xml`. Even better, we can gain access to the views in the layout we just loaded. You can call `convertView.findViewById()`, just like you would do in an activity.

Now, we have access to the appropriate views but still need to determine what to show in it. When the adapter is first instantiated, we get access to the list of friends (via the constructor). Better then, to create a `private` instance variable called `friends`, and in the constructor, save the reference to the list to that variable!

Then, as soon as `getView()` is called, we can access the `friends` variable to get the appropriate information from the list, using the `position`!

Finally, note that instead of returning the standard result of calling `super()`, we now return our altered `convertView`. What do you think would happen if we forgot to return `convertView` at the end and still returned the result of the `super()` call? And what would happen if we called `super()` first and then altered `convertView` after that?



## Connecting the adapter to the GridView and the list. 

Now that our adapter is (hopefully) set up correctly, we still need to link it to the GridView. Our adapter now contains the logic of transforming the list we feed to it into the right layout views, but right now it's not connected to anything.

1. First, instantiate your adapter in `MainActivity`, because this is where we want to show our list of friends on the grid. The contstructur will expect three arguments however (depicted by the dots). 
    
        FriendsAdapter myAdapter = new FriendsAdapter(..., ..., ...);

2. The `FriendsAdapter` class constructor takes in a `Context` object, which you can pass on as simply `this` or `getApplicationContext()`. 

3. Then, it needs a reference to the layout file it should use, which in our case probably is `R.layout.list_item`. 

4. Finally, the list of `Friend` objects itself needs to be passed to the constructor as well.

5. Now that you have instantiated your adapter, you can set it on your `GridView`. Use `findViewById` on your `GridView` as you would on any other view and call `setAdapter()` on it with your freshly made adapter! 


## Creating the ProfileActivity

Now that we have the first activity with the grid and friends set up, we still need to add content to the `ProfileActivity`. To create a second activity, make sure your mouse pointer is somewhere in the Android file structure on the left and go to *File > New > Activity > Empty Activity* and create `ProfileActivity`, which will contain the detailed view of our users. If everything went well, you should now also have a `activity_profile.xml` file in your layout directory. This is where we will design the layout of our second activity.

For this activity, we want to show the profile picture, a rating bar plus some `TextView` elements to show the name and information of our users. Change the root layout to `LinearLayout` again (this just fits with what we want to achieve much better) and add the widgets. 

Make sure the layout looks nice by fiddling with the `layout_gravity` parameter to for example make things center aligned. To determine how much space each view should take up on the screen, you can use the `layout_weight` attribute. This attribute allows you to give some views more importance in the sense that they should take up more space on the screen. This could be useful if we want to make the profile picture show up nice and big in comparison with the rest of the content. 

Additionally, because we are using the weight to determine the size relative to the rest of the layout, it works better on other phone sizes, as opposed to hard-coding values to determine the size of views. 

### Connecting the two Activities

Now that the `ProfileActivity` if finished look wise, we want to add functionality to it as well. But first we must think about how we are going to get there. We will somehow have to listen for click events on the `GridView` items in `MainActivity` and then go to the ProfileActivity, all while remembering which `Friend` was clicked, so we can show the appropriate data.

To add a listener for clicks on our `GridView`, we will create our own `OnItemClickListener` class (not to be confused with the `OnClickListener`, since we are really listening to clicks on the separate sub-_items_ here, not clicks on the layout view as a whole). 

1. Go to your `MainActivity` class and create a new private inner class called `MyOnItemClickListener`. Inner class means that the class will actually be inside your `MainActivity` class, not in a separate file:

        public class MainActivity extends AppCompatActivity {

            private class ThisIsAnInnerClass {
                // inner class content
            }
        }

2. Add the interface to the class by typing `implements OnItemClickListener` behind the name of your class. It will probably jump to show `AdapterView.OnItemClickListener` as you finish typing: this is okay. This will make red wriggly lines appear, because now your class made a promise, so to speak, to implement the functionality of an `OnItemClickListener`, but it does not do that just yet!

3. When inside your inner class, press `CTRL+I` to show the dialog of methods to implement. This should just show one method: `onItemClick()`. Hit enter and the red wriggly lines should now disappear as you are presented with your own override:

        private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // handle your clicks here
            }
        }


Now, you can handle clicks inside the `onItemClick` method, which will be called when an item on the `GridView` is clicked, as soon as the click listener is actually connected to the `GridView`. 

In `MainActivity`, find where you look up the GridView element with `findViewById()` and set the listener on the GridView by creating a new instance of your `MyOnItemClickListener` class and using `setOnItemClickListener()` with the class instance as its argument. 

Test your implementation by making the `OnItemClickListener` do something simple, like logging something to the console or making a toast appear. This should happen every time an item in your `GridView` is clicked.


### Extract what actually was clicked on
The whole idea of the OnItemClickListener was to recognize exactly which sub-item of our layout was clicked, but as of now that is not happening yet. However, all tools to do this are present. When taking a look at the `onItemClick()` method, notice that this method has 4 arguments that will be passed on to it when it's invoked.

We will make use of the `adapterView` argument, which holds a reference to the parent view with all the items, combined with the `int i`, which tells us the position. You can call the method `getItemAtPosition(i)` on the `adapterView`, which then will give you what item is present on that position in the parent layout behind the scenes. 

This is what we want, because we made a list of `Friend` objects that are now being rendered by our adapter. So if we call getItemAtPosition, we will get back a `Friend` object that we can the use to pass on to the second activity. 

        Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

Notice the (Friend)? This is called *casting* and is necessary because `getItemAtPosition()` does not actually return a `Friend` object yet, but a generic Java Object. So if we want to put it in a variable of type `Friend` it will need to be cast to that type first. When working with custom model class objects, this is something that is often needed, but luckily very simple to do. 


### Creating an Intent
Now that we have access to which `Friend` item was actually clicked, we want to pass this information to the next activity. To direct the user from one activity to another, Android makes use of the `Intent` class. An `Intent` typically looks something like this:

        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);

It specifies the context where we are coming from, in this case `MainActivity.this` and also tells the intent where to go next, which is the `ProfileActivity.class` bit. A special thing to pay attention to with an `Intent` is that you still need to fire it. We have now just created the intent on the first line, but this in itself does nothing yet in terms of starting another activity. 

For the intent to execute, you need to call `startActivity(intent)` as well. This is practical, because sometimes you might want to add some information to the intent that you want passed on between activities (like in this case which `Friend` was clicked) before you fire the intent. 

Remember that we made the `Friend` model class implement `Serializable`? This was done so that you can now easily pass `Friend` objects with intents. Adding something to an `Intent` is done with key-value pairs, with the key (which is just a `String`) allowing you to retrieve the value from the intent in the next activity. In our case, the intent might look something like this:

        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        intent.putExtra("clicked_friend_key", clickedFriend);
        startActivity(intent);

We now added the clicked `Friend` object to the intent, so it will be passed on `ProfileActivity` and we can extract it using the key *"clicked_friend_key"*. Extraction is very simple as well, in the `onCreate()` of the second activity, you can simply use `getIntent()` and then extract the value from the intent using the key you provided when you created the intent:

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend_key");

Of course, you will want to put the result of `getSerializableExtra()` in a variable so that you can do something with it (notice that we are casting it again?). Now that we have access to the `retrievedFriend` variable, we have access to all the information of that particular `Friend` object again, so their name, bio, photo and rating. You can use this information to render the correct things on the screen with the layout we created before. 


### Storing the rating data in SharedPreferences

Hmm, now that your app is up and running, you must have noticed something. The ratings are not being kept! Time to do something about that using Android's `SharedPreferences`. These are meant to store small amounts of data on the device and allow information to persist even when closing down the app or switching off your phone.

`SharedPreferences` also makes use of key-value pairs, again using a `String` as the key and then storing the value with the key as a label, so you can easily retrieve it later. You can access the `SharedPreferences` by calling:

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

You can have multiple `SharedPreferences` files, so you can give individual ones a name as well, we will just call ours `"settings"`, as per default. The `MODE_PRIVATE` bit refers to the access rights of the file: the default mode, where the created file can only be accessed by the calling application.

We can now add things to the `SharedPreferences` by calling methods on our variable `prefs`, to generate an `Editor`:

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

The `Editor` allows you to edit the file and store values in there. The two lines above can also be simplified to one line where we directly grab the editor:

        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

The `editor` variable now allows you to call various methods, like `putInt()`, `putString()` and `putFloat()`, all of which take two arguments, the key under which to store the value (think about what that should probably be in our case), and the value itself. When done adding values to the editor, don't forget to call `editor.apply()` or `editor.commit()` to save the changes. 

Now you need to determine when to store the rating. Chances are the `OnRatingBarChangeListener` will be quite useful, because it will fire the `onRatingChanged()` everytime someone touches the ratingbar. You can implement your own `OnRatingBarChangeListener` inner class the same way you did with the `OnItemClickListener`. The creation of inner classes for listeners is a design pattern that will be repeated many more times with listeners of various kinds, so if in doubt be sure to ask.

 
### Retrieving values from SharedPreferences
Just storing the data is something, but if we don't do anything with it to restore our rating's state, we might as well do nothing. Your `ProfileActivity` still needs to somehow check whether any rating should be restored, and if so extract it from `SharedPreferences`.

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String aStoredString = prefs.getString(..., ...);

You can access SharedPreferences the same way as when you write data to it. Then, you can use methods like `getString()` to retrieve the data you stored. These methods take two arguments. The first argument is the key under which `SharedPreferences` should look to see if the value is present. This should of course be the same key that you used to store the value. 

The second argument is for the case where there is nothing that belongs to that key: the default value. This allows you to easily check whether there is any saved data, because if getString() (or any of the other methods) returns that default value, it means there was no data in `SharedPreferences` for the supplied key.

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        String aStoredString = prefs.getString("example_key", null);
 
        if(aStoredString != null) {
            // we have something stored under "example_key"
        }
        else {
            // there is nothing stored under "example_key"
        }

It is entirely possible that there is no rating for some users: if the user opens the app for the first time, none of the users would be rated. So when restoring the rating from `SharedPreferences` this default value can help us check whether there is something to restore, or that the user has simply not been rated yet and the rating bar can stay blank.

## Finishing up

As always, consider this week's assessment criteria and make sure your app works well and the code looks nice. Think about the names of your variables and comments. Are the names clear and consistent, your comments useful and concise?

## Some ideas

Here are some ideas for improving on this project:

- Allow people to create or edit a profile, and change their bio or name (or perhaps both).
- Allow people to leave messages on profiles, and make sure they persist through rebooting the app or phone. 
- Let people like profiles and keep track of how many times a profile has been liked.
- Gracefully implement rotation of the device, adding a landscape variation and preserving data. 