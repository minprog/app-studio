# Listeners

Almost all controls on a screen can fire **events**. When a user taps a button, for example, it fires an `onClick` event. In your activities, you can handle some of these events in order to provide a fully functional app.

## Simple listeners

If all you're interested in is catching `onClick` events, then you can take the easy way out. In your layout, you might specify in the `onClick` property the name of a method in your activity that will be called when the object is clicked (tapped):

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="buttonClick"
        android:text="Button" />

In your class, add the **event handler** method:

    public void buttonClick(android.view.View sender) {
        Button b = (Button) sender;
        b.setText("Clicked!");
    }

## Listener classes

For anything but the simplest click events, you will need to create a separate listener class that handles events for one or more of the controls in your activity. Now most documentation and tutorials present you with the following code:

    // MainActivity.java - onCreate()
    
    Button button = (Button) findViewById(R.id.mybutton);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // code to run when the button gets clicked
        }
    });

We do not particularly like this style of creating **anonymous** listener classes. As you make more complex layouts with many controls, your `onCreate()` method will grow and grow, while containing code for handling all of these events. We would rather like to separate that code into their own classes. To do that, we create **private** listener classes inside our `Activity`:

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // ...
            Button b = (Button) findViewById(R.id.button);
            b.setOnClickListener(new GoButtonClickListener());
            // ...
        }

        private class GoButtonClickListener implements View.OnClickListener {
            @Override
            public void onClick(View view) {
                // code to run when the button gets clicked
            }
        }
    
    }

This way of structuring your code allows you to use the same listener multiple times when it has to perform similar tasks, as you can just add another instance of the listener class when needed.

## Further references

If you would like to read more about listeners, take a look at the documentation:

- <https://developer.android.com/guide/topics/ui/ui-events.html>
- <http://tekeye.uk/android/examples/code-android-event-listeners>
- <http://www.fredosaurus.com/notes-java/GUI/events/inner_class_listener.html>
