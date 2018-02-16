
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

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin".

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github. Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen. There, you should see a long list of "unversioned files". Make sure all checkboxes are selected, enter a commit message `Initial project` and then press the **commit** button. Turn off code analysis.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github. If not, ask for help!


## First Activity: Creating the user interface

### The overview screen
Let's create the basic UI that we should see when we open the app first: head to `activity_main.xml` in your project. As usual, we get a blank screen with a `ConstraintLayout`. This type of layout is not particularly ideal for our purposes. What we'll do is replace it with a `LinearLayout` (remember how?) and then use a `GridView` to show all of our users on a grid. 

Views like `GridView` and `ListView` are designed as containers for *lists* of items. So in our `activity_main.xml` Design tab, head for the Palette and choose *Containers*. There you should be able to select a `GridView` and add it to your layout. If done correctly, your design should now show an example grid of items, something like the image below. You can tweak the attributes of the `GridView` to show more or less items on a row or have more space between items. Take a look at `numColumns`, `stretchMode` (`spacingWidthUniform` seems like a nice and clean solution) and see if you can tweak it to look how you want. You are not forced to copy the example, so if you feel like 4 columns is the way to go: power to you!

![Layout Placeholder Example](layoutimage0.png)



### Designing our grid items

Of course we have some wishes as to what the items on our grid should look like. Ideally, we would want at least the picture of the person concerned and their name to be shown. Because a `GridView` is just the container for our items, the layout for the items themselves will be defined elsewhere. For this, we will create a new layout file. Go to the `layout` folder and use *right click > New > Layout resource file* to create a file called `grid_item.xml`. Change the root element to `LinearLayout` and leave everything else unchanged. 

### Modeling friends

Now that the user interfaces are all set, let's create a simple model class to contain data about our friends. This model class will contain the info about the friends that show up in the app. We do this so we can keep track of all of the information together, such as their name, picture, rating and information/bio. 

1. The Friend model will be held in its own Java class, so we are going to create a new Java file. Make sure your mouse pointer is somewhere in the file tree on the left and use *File > New > Java Class*. We will call this class `Friend`. 

2. In the dialog, specify that you want to use `Serializable` (or `java.io.Serializable`) as an interface. This will later allow us to store objects of the `Friend` type on our device more easily. You can leave all other settings unchanged. 

3. You are now presented with your empty `Friend` class, so time to add some fields to it! Within your class, declare fields to store the name and bio of a user. These should probably of the type `String`. Also, we will need a `float` to keep track of the rating, because the `RatingBar` widget uses a float by default. Finally, we want to keep track of an id that points to a drawable, to be able to show an image. This id will be of type `int`. You should now have something like this:

        public class Friend implements Serializable {
            String name, bio;
            int drawableId;
            float rating;
        }

5. Our class also needs a constructor, which we can now easily generate using `Alt + Insert`. As our constructor fields, we want to set the `name`, `bio` and `drawableId`, but not the rating. Using the same shortcut, we can also generate getters and setters for all of our fields. 


### Creating some sample friends

Of course, we will now need to create some friends to show in our app later. In `MainActivity`, we will declare our objects of type `Friend` using the model class and constructor we just made. 

In order to do this, we will need to locate the drawable image files that we are going to use as well. 

1. Just for a second, switch to the Project View using this dropdown:

    ![](project-view.png)

2. Navigate to *app > src > main > res > drawable*. Now, drag the downloaded image files into that `drawable` folder. Android Studio will offer to move/copy them, and then to add them to your local git repository. That's all fine.

3. Jump back to the Android View using the same dropdown as in step 1. You can now use the images in your app.

Since the constructor takes the drawable's ID, not an ImageView itself, we need to do some extra magic, as just passing `R.id.drawable_name` will not work. The following line of code will return the correct ID in the shape of an `int`. Of course, substitute "drawable_name" for the name of your image. You can leave everything else unchanged. 

        getResources().getIdentifier("drawable_name", "drawable", getPackageName())

Using this format, you can instantiate as many `Friend` objects as you would like. However, to show them efficiently, we need to add them to an `ArrayList` as well. Since we are storing `Friend` objects, you can instantiate a list that is suitable to hold these kind of objects using:

        ArrayList<Friend> aListName = new ArrayList<>();

You can now easily add items to your list using `aListName.add()`. Of course, there are other ways to instantiate a list that holds `Friend` objects instead of adding them after creation. Up to you to choose and find out. 

## Creating an adapter
Now that we have our list, we need a way to pair the list of `Friend` objects with the UI that we created in step one. The missing connection will be made through an adapter. The adapter will connect the list of data to the `GridView` in which we want to show the data. To do this, we will create our very own `ArrayAdapter`. 

Because we have a custom `Friend` class, we will have to tell our `ArrayAdapter` how to treat each instance of `Friend` in order to render it correctly in the `GridView`. Remember the layout file we created before, `grid_item.xml`? This layout file will be used to tell the adapter what to render for each item in our list. Follow the steps below to create the adapter class.

1. Once again, make sure you are somewhere in the Android file tree and go to *File > New > Java Class* and create a class called *FriendsAdapter*.

2. Choose ArrayAdapter as the superclass, this will make sure we have all the methods and functionality needed.

3. Change the declaration of the class to contain `ArrayAdapter<Friend>` like so: `                public class FriendsAdapter extends ArrayAdapter<Friend>`.

4. Generate the appropriate constructor using `CTRL+O` and choose the constructor that takes the context, a resource id of type integer and a list of items as its arguments. 

5. When you have generated your constructor, edit the parameters to reflect the type of your list, which is an `ArrayList<Friend>`.

6. Finally, hit `CTRL+O` one more time to override the method `getView()` which is where we will determine what should be shown on the screen for each item in our list. 

### Populating the views                
In our `getView()` method, we will populate each `View` element (as declared in `grid_item.xml`) to show the appropriate data. We probably want to show at least the name and picture in our grid, so first we need to find the appropriate `ImageView` and `TextView` to do so.

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

Take a look at the `getView()` method above. This method is called for every item in your list (which in our case is an instance of type `Friend`). In this method, we define what should happen for each list item layout wise. The method gets three arguments, of which the first two are the most important. The first argument `int position` indicates which item in the list is currently being processed by `getView()`. So for the first item this would be 0, the second 1, you get it.

The super method for now just returns the unaltered `convertView`, but we of course want to alter it to show the appropriate data. We will do so by inflating a new `View` if none exists, and otherwise alter the existing one. This will make our code look something like this:

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // do something with the views in convertView. 

        return convertView;
    }

Notice how convertView is inflated from `R.layout.list_item`, which represents our `list_item.xml`? Now you can access the views in `convertView`, like your `ImageView` and `TextView` by using `findViewById()`, just like you would do in any other place. 

Bear in mind though that you first have to 'index' into `convertView` to access the views in your `list_item.xml`, so to speak, so call `convertView.findViewById()` to access the views. This is needed because the reference to the layout is stored in the `convertView` variable. 

Now, we have access to the appropriate views but still need to determine what to show in it. Since the list of friends is passed to the adapter through the constructor, and we have access to the the current item that is being rendered by `getView()` through its `position` parameter, we can combine these two to get the info that we need!

Finally, note that instead of returning the standard result of calling `super()`, we now return our altered `convertView`. What do you think would happen if we forgot to return `convertView` at the end and still returned the result of the `super()` call? And what would happen if we called `super()` first and then altered `convertView` after that?



### Connecting the adapter to the GridView and the list. 

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