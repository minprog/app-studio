# HTMLString

When working with JSON and other API's you'll sometimes find characters like `&amp;` or `quot;` these are HTML-encoded characters. To change them to the real characters you can use a library like [HTMLString](https://github.com/alexaubry/HTMLString).

## Installation

### CocoaPods

To install libraries and other dependencies in Swift it is recommended to use a *depencency manages* like [CoacoaPods](https://cocoapods.org).

Installation is very simple, open a terminal window and execute the following line of code:

    $ sudo gem install cocoapods

CocoaPods is now ready to use!

### Install the library

Now we are ready to add the library to our project using CocoaPods.

1. Close your project in Xcode
2. Open a terminal windows in the directory of you app
3. Execute `pod init` to tell CocoaPods you want to use CocoaPods for this project, this will create a `Podfile`
4. Open the `Podfile` in your favorite text editor and add the following line to your `Podfile`:

        pod 'HTMLString', '~> 4.0'
    

    Your `Podfile` should look a bit like this:

        # Uncomment the next line to define a global platform for your project
        # platform :ios, '9.0'

        target 'Trivia-quiz' do
            # Comment the next line if you're not using Swift and don't want to use dynamic frameworks
            use_frameworks!

            # Pods for Trivia-quiz-2018
            pod 'HTMLString', '~> 4.0'
        end

5. Save the `Podfile` and execute `pod install` in the terminal, this will take some time if this is first time you used CocoaPods
6. CocoaPods will say something like 'Pod installation complete! There is 1 dependency from the Podfile and 1 total pod installed.'

The libraries are now installed, from now on you should open your project with the (white) `.xcworkspace`-file instead of the (blue) `.xcodeproj`-file.

## Using HTMLString

You can import the library with `import HTMLString` on the top of your file press `⌘-B` to build the library.

To remove all the HTML entities from a String, use the `removingHTMLEntities` property.

#### Example

    import HTMLString

    let escapedEmoji = "My favorite emoji is &#x1F643;"
    let emoji = escapedEmoji.removingHTMLEntities // "My favorite emoji is 🙃"

    let escapedSnack = "Fish &amp; Chips"
    let snack = escapedSnack.removingHTMLEntities // "Fish & Chips"

More documentation of this library can be found [here](https://alexaubry.github.io/HTMLString/).
