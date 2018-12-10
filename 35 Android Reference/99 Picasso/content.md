# Picasso

Loading images from internet into simple Android ImageViews.

## Getting Started

- In your `AndroidManifest.xml`, add permissions for internet access using this line:

        <uses-permission android:name="android.permission.INTERNET" />

- In your `build.gradle` (for the `app`), add the following dependency:

        implementation 'com.squareup.picasso:picasso:2.5.2'

    Android Studio will then prompt you to "sync" your project. This must be done before continuing!

## Loading images

If everything is installed correctly, you should be able to load images using a few lines of code. To load an image, you need three things:

- context, which will allow your to connect to the internet from your app
- a URL like https://media.giphy.com/media/Xmz6AD5s92Re8/giphy.gif
- an `ImageView` in your layout, to define where the image will be displayed

The following sample code should help you out:

    String imageUri = "https://media.giphy.com/media/Xmz6AD5s92Re8/giphy.gif";
    ImageView imageView = findViewById(R.id.image1);
    Picasso.with(context).load(imageUri).into(imageView);
