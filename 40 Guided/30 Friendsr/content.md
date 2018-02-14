
## Objectives

- Practice with lists of data
- Practice with adapter views
- Work with navigation in apps
- Use multiple activities
- Store small data on the device

## Background

For this app, you will create an social friends/dating app that allows you to view people's profiles and some information about them. When the user first loads the app, it will show a list of available users.  The user can click on each one to see a biggerphoto and get more information about that user. On the screen is a way to rate the user, either some kind of "star"rating system or a "yes/no" vote like what Tinder uses. It could for example look something like this:

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


## Second Activity: Creating the user interface

To create a second activity, make sure your mouse pointer is somewhere in the Android file structure on the left and go to *File > New > Activity > Empty Activity* and create `ProfileActivity`, which will contain the detailed view of our users. If everything went well, you should now also have a `activity_profile.xml` file in your layout directory. This is where we will design the layout of our second activity.

For this activity, we want to show the profile picture, a rating bar plus some `TextView` elements to show the name and information of our users. Change the root layout to `LinearLayout` again (this just fits with what we want to achieve much better) and add the widgets. 

Make sure the layout looks nice by fiddling with the `layout_gravity` parameter to for example make things center aligned. To determine how much space each view should take up on the screen, you can use the `layout_weight` attribute. This attribute allows you to give some views more importance in the sense that they should take up more space on the screen. This could be useful if we want to make the profile picture show up nice and big in comparison with the rest of the content. 

Additionally, because we are using the weight to determine the size relative to the rest of the layout, it works better on other phone sizes, as opposed to hard-coding values to determine the size of views. 


## Modeling friends

Now that the user interfaces are all set, let's create a simple model class to contain data about our friends. This model class will contain the info about the friends that show up in the app. We do this so we can keep track of all of the information together, such as their name, picture, rating and information/bio. 

The Friend model will be held in its own Java class, so wel are going to create a new Java file using *File > New > Java Class*. We will call this class `Friend`. In the dialog, specify that you want to use `Serializable` (or `java.io.Serializable`) as an interface. This will later allow us to store objects of the `Friend` type on our device more easily. You can leave all other settings unchanged. 

You are not presented with your empty `Friend` class, so time to add some fields to it!

- class Friend
- maken met File > New > Java Class, specificeer interface Serializable
- dan fields maken
- dan CTRL-N/Alt-Ins om de constructor te maken (selecteer alle fields behalve rating?)
- dan zelfde om de getters en setters te maken (selecteer alles)
- open vraag: heeft name een setter nodig? in deze app niet denk ik!

## Creating some sample friends

- resources/plaatjes
- instantiëren van een aantal mensen in de mainactivity


## Creating an adapter

- File > New > Java Class
- public class GridListAdapter extends ArrayAdapter
- dan ArrayAdapter<User> van maken
- ctrl-N constructor, degene waar je een list aan kunt meegeven
- Ctrl-O override tik "getview" en ENTER

## Connecting the adapter to the gridview

TBA

## Creating the profile activity

TBA

## Finishing up

As always, consider this week's assessment criteria and make sure your app works well and the code looks nice.


## Some ideas

Here are some ideas for improving on this project:

