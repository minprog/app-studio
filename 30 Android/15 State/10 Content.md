# Activity state

Activities can be loaded and unloaded, but often we would like to restore the *state* of the screen whenever an activity is re-displayed. For example, when rotating an Android device, much of the current activity is reloaded. Some of the screen state is preserved automatically, but other state has to be preserved manually.

The current state of an activity is called the **instance state**. Most importantly, this comprises information about the on-screen controls, such as which checkboxes are on or off, the text that has been typed into text boxes. But the values of private fields in the activity are also considered to be part of the instance state.

There are several ways for the state to be **lost**:

- Going from one activity to the other, within the same app
- Launching another app and going back
- Rotating the device's screen to change orientation (landscape to portrait or vice versa)

## A quick hack

A quick way to retain your activity's GUI state on rotation is to set the [`configChanges`](https://developer.android.com/guide/topics/manifest/activity-element.html#config) attribute of the activity in `AndroidManifest.xml`. Mind that this does not solve other cases of state that goes lost!

    <activity android:name=".MainActivity"
        android:configChanges="orientation|screenSize"
    ...>

## Manually saving instance state

The `Activity` class defines two methods that you might **override**, which allow you to save and restore parts of the instance state that you're interested in. Usually, you will save any date that cannot be automatically recreated by the app (such as user input).

When you add an override to your activity, you get access to a `Bundle` object, that allows you to save a variety of data types. In this example, we save a hardcoded `true` value:

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("checkedBox", true);
    }

To restore those values, add another override:

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        boolean checkedBox = savedInstanceState.getBoolean("checkedBox");
    }

![embed](https://player.vimeo.com/video/206083320)

Note: In newer versions of Android Studio, other versions of `onSaveInstanceState` and `onRestoreInstanceState` exist, that take multiple arguments. Make sure that you use the exact declaration as shown above, or it will not work!

## Saving data from your own classes

Normally, you can only store standard data types into a `Bundle`. The `Bundle` class defines methods like `putBoolean`, `putInt`, `putString` etc. However, it is possible to make your own class **serializable**, which allows its data to be stored in a `Bundle`, too.

Say you have defined a `Date` class where you store date information that someone entered into you app. If you let it `implement` the `Serializable` class, it can automatically be saved into a `Bundle`.

    public class Date implements Serializable {
        ...
    }

    public class MainActivity extends Activity {
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            Date d = new Date(2015, 1, 25);
            outState.putSerializable("today", d);
        }
    }

## Tutorials to get you along

Handling the Activity Lifecycle is a very important part in the development process. Therefore it is vital you have a solid understanding of how it works. Here is an extensive explanation of the Activity Life Cycle, which contains [a very handy walkthrough to apply the theoretical stuff](http://www.vogella.com/tutorials/AndroidLifeCycle/article.html).

![Basic Lifecycle](https://developer.android.com/images/training/basics/basic-lifecycle-savestate.png)

If everything still seems vague, you can turn to [this](https://developer.xamarin.com/guides/android/application_fundamentals/activity_lifecycle/) tutorial. Do note that this one is very similar to the one above.

A short [explanation](http://www.quicktips.in/handling-activity-state-using-saved-instance-state-bundle/) on SavedInstanceState should get you started on Bundles.
