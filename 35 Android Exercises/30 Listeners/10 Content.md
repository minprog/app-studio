# Listeners

For this exercise, we will take a look at the various ways we can use to implement an event listener in Android Studio. During this course, you will be asked to implement your listeners in such a way that they are not anonymous, but consist of their own class. This encourages understanding of what the listener actually does and makes it easier to read through your code. 

It also allows you to use the same listener multiple times when it has to perform similar tasks, as you can just call another instance of the listener class when needed. If you want to read more about listeners, take a look at the documentation [here](https://developer.android.com/guide/topics/ui/ui-events.html) or [here](http://tekeye.uk/android/examples/code-android-event-listeners). 

Your goal in this exercise is to implement a non-anonymous listener in your guided project of this week. This means that your listener needs to be declared in its own class, like so for example, if you were to implement a listener of the `onClick` type: 

```
public class myListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        // some other code
    }
}
```

Other activities can now instantiate this class and set the listener on for example, a button or other view in your activity. You can declare the listener class within your activity, or make a separate `.java` file for it.  Within the `onClick(View view)` method you can now decide what your app should do when the `View` is clicked. For more info on the inner class listener and the advantages it gives, you can check out [this](http://www.fredosaurus.com/notes-java/GUI/events/inner_class_listener.html) link. 