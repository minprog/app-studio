
## Objectives

- Practice with lists of data
- Practice with adapter views
- Work with navigation in apps
- Use multiple activities
- Store small data on the device

## Background

For this app, you will create an social friends/dating app that allows you to view people's profiles and some information about them. When the user first loads the app, it will show a list of available users.  The user can click on each one to see a bigger photo and get more information about that user. On the screen is a way to rate the user. It could for example look something like this:

![App Example](friendsrimage0.png) ![App Example](friendsrimage1.gif) ![App Example](friendsrimage2.png)

Of course this app will be an incomplete experience: you don't need to allow people to create profiles, and you can just show a fixed set of people's profiles that never changes. It does not need to do everything that an app like Facebook or Tinder can do.

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

Now that the `ProfileActivity` if finished look wise, we want to add functionality to it as well. But first we must think about 

### Storing the rating data in SharedPreferences

TBA



## Finishing up

As always, consider this week's assessment criteria and make sure your app works well and the code looks nice. Think about the names of your variables and comments. Are the names clear and consistent, your comments useful and concise?


## Some ideas

Here are some ideas for improving on this project:

- Allow people to create or edit a profile, and change their bio or name (or perhaps both).
- Allow people to leave messages on profiles, and make sure they persist through rebooting the app or phone. 
- Let people like profiles and keep track of how many times a profile has been liked.



