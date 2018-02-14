# Friendsr

## Objectives

- Practice with adapter views.
- Work with navigation in apps.

## Background




## Getting started

1.  Create a new Android studio project called **TicTacToe**, using these settings:
    - Choose API 24 (Nougat) unless your own phone has an older operating system
    - Start with an Empty Activity which is called `MainActivity`
    - Leave all other settings unchanged

2.  Create a new, empty repository on the Github website. Name your repository `Mr Potatohead`.

3.  Now, add a git repository to the project on your computer. Go to Android Studio, and in the menu choose **VCS -> Enable Version Control Integration**. Choose **git** as the type and confirm. This will not change much, but sets us up for the next steps.

    Note: if you get a popup to ask whether you would like to add some file to the repository, answer "No" for now. If you answer "Yes", things may get complicated later on.

4.  Link the local repository to your Github project. Choose **VCS -> Git -> Remotes...**. Add a remote with name "origin".

5.  Android Studio has generated quite a few files for your project already. To add these, let's **commit** and **push** those files to Github. Press **Cmd-K** or **Ctrl-K** to show the Commit Changes screen. There, you should see a long list of "unversioned files". Make sure all checkboxes are selected, enter a commit message `Initial project` and then press the **commit** button. Turn off code analysis.

6.  Press **Cmd-Shift-K** or **Ctrl-Shift-K** to show the Push Commits dialog. Press the **Push** button to send everything to Github.

Your project files should now be visible on Github. If not, ask for help!


## Creating the user interface

Let's create the basic UI first: head to `activity_main.xml` in your project. As usual, we get a blank screen with a `ConstraintLayout`. This type of layout is not particularly ideal for our purposes. What we'll do is replace it with a `LinearLayout` and then use a `GridLayout` for the button grid.

- mainactivity: aanpassen naar linearlayout (remember how?)
- daarin een gridview met juiste specs
- dan maak File > New > Activity > Empty Activity: "ProfileActivity"
- layout naar linearlayout en daarin vier elementen
    - ImageView
    - RatingBar
    - TextView
    - TextView
- set weight for linearlayout

This finalizes the user interface.

## Modeling friends

Let's create a simple model class to contain data about our friends.

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

