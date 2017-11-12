# Persistence

There are several ways to store information from your app. We've already seen the [instance state](/android/state) API, which allows us to quickly restore information when a particular screen was unloaded and then loaded again. However, that information will only be retained while the app is running.

Usually, there is some data is important to save for later; for example, settings, usernames and other configuration. This is called **persisting** data. For this, you can use the `SharedPreferences` API. The shared preferences are managed by the Android platform. You can get access to the storage by called one of two methods in your `Activity`:

- Per-activity: `getPreferences()`
- Per-app: `getSharedPreferences()`

Use `getPreferences()` for storing information that is specific to one single `Activity`. The other one, `getSharedPreferences()` is used to store information that might be used in multiple activities. For example, a *user id* may be needed in many activities to request user information from a server.

To save preferences, you'll need to open an `Editor` object:

    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
    SharedPreferences.Editor prefsEditor = prefs.edit();
    prefsEditor.putInt("name", value);
    prefsEditor.putString("name", value);
    ...
    prefsEditor.apply();

To load preferences, you only need a reference to the `Preferences` object:

    SharedPreferences prefs = getPreferences(MODE_PRIVATE);
    int i = prefs.getInt("name", defaultValue);
    String s = prefs.getString("name", "defaultValue");
    ...

<iframe src="https://player.vimeo.com/video/206083045?portrait=0" width="400" height="225" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>

## Multiple preferences files

If you'd like to have multiple preferences files, you may specify the filename for storing and loading them:

    SharedPreferences prefs = getSharedPreferences("filename", MODE_PRIVATE);
    SharedPreferences.Editor prefsEditor = prefs.edit();
    prefsEditor.putInt("name", value);
    prefsEditor.putString("name", value);
    ...
    prefsEditor.commit();

## References

- SharedPreferences [documentation](https://developer.android.com/training/basics/data-storage/shared-preferences.html)

- Derek Banas, [Saving Data](https://youtu.be/1DOeLy26hOE)
