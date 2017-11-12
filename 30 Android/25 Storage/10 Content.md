# Storage

Android can read and write files from two locations: internal and external. In both cases, the storage is persistent: data remains after your app stops or even after the device reboots.

Internal storage is available on every Android device, but it may be limited in space: a few gigabytes. Each app gets its own space on the internal storage, which cannot usually be accessed by other apps. If an app gets uninstalled, that app's files on internal storage will be wiped!

An activity has methods you can call to read or write files:

- `getFilesDir()` returns internal directory for your app
- `getCacheDir()` returns a "temp" directory for scrap files that might be removed at any time
- `getResources().openRawResource(R.raw.id)` opens an input file from `res/raw/`
- `openFileInput("name", mode)` opens a file for reading
- `openFileOutput("name", mode)` opens a file for writing

Many of these methods return standard `java.io.File` objects. Some return `java.io.InputStream` or `OutputStream` objects, which can be used with standard classes like `Scanner`, `BufferedReader`, and `PrintStream` to read and write files (see the Java API documentation).

## Example: reading from a read-only resource

    Scanner scan = new Scanner(getResources().openRawResource(R.raw.hello));
    String allText = "";
    // read entire file
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        allText += line;
    }
    myTextView.setText(allText);
    scan.close();

## Example: writing and reading a file

    // write a short text file to the internal storage
    PrintStream output = new PrintStream openFileOutput("out.txt", MODE_PRIVATE));
    output.println("Hello, world!");
    output.println("How are you?");
    output.close();

    // read the same file, and put its contents into a TextView
    Scanner scan = new Scanner( openFileInput("out.txt", MODE_PRIVATE));
    String allText = "";
    // read entire file
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        allText += line;
    }
    myTextView.setText(allText);
    scan.close();

## External storage

You can also use external storage, for example to save media like photos and music.
