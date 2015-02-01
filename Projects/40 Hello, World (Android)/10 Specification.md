## Ingredients.

* Android Development Tools Plugin for Eclipse
* Android Software Development Kit
* Eclipse (or Android Studio)
* Java

## Academic Honesty.

All work that you do toward fulfillment of this course's expectations must be your own unless collaboration is explicitly allowed by some project. Viewing, requesting, or copying another individual's work or lifting material from a book, magazine, website, or other source—even in part—and presenting it as your own constitutes academic dishonesty, as does showing or giving your work, even in part, to another student.

Similarly is dual submission academic dishonesty: you may not submit the same or similar work to this course that you have submitted or will submit to another. Nor may you provide or make available your or other students' solutions to projects to individuals who take or may take this course in the future.

You are welcome to discuss the course's material with others in order to better understand it. You may even discuss problem sets with classmates, but you may not share code. You may also turn to the Web for instruction beyond the course's lectures and sections, for references, and for solutions to technical difficulties, but not for outright solutions to problems on projects. However, failure to cite (as with comments) the origin of any code or technique that you do discover outside of the course's lectures and sections (even while respecting these constraints) and then integrate into your own work may be considered academic dishonesty.

If in doubt as to the appropriateness of some discussion or action, contact the staff. All forms of academic dishonesty are dealt with harshly.

## Grades.

Your work on this project will be evaluated along one primary axis.

*Correctness.* To what extent is your code consistent with our specifications and free of bugs?

## Installing and Preparing the Android SDK.

*   The Android software development kit (SDK) is a collection of tools that allow a developer to write, test, and deploy native Android applications written in Java. Though, really, when you download the SDK, it's just a basic collection of tools; it does not even include the utilities required to build an application! The SDK by itself also does not have a built-in integrated development environment (IDE), which would provide a GUI-based application to help develop your application. For this reason, installing the SDK is a multi-step process in which you download an IDE, the SDK itself, a plugin that acts as an interface between the IDE and the SDK, platform tools that allow you to build native Android applications, and finally create some Android Virtual Devices to use the emulator.

    One website that you will find quite useful while developing Android applications is the Android Developer site at <http://developer.android.com/>.

    We have some things to install, so let's get started!

*   We're ready for the Android SDK! To download the development kit, visit <http://developer.android.com/sdk/index.html> and download the SDK appropriate for your platform. If you downloaded a ZIP or TGZ, uncompress the downloaded file.

*   Follow the directions from "Adding SDK Packages" to so that Eclipse can find the right SDKs:

	<http://developer.android.com/sdk/installing/adding-packages.html>

*   Open Eclipse, select the Window menu and open the Android SDK Manager. From there, sort by repository and check all available components from Google's repositories. If you're unsure, simply install all available components from the "Android 4.4.2 (API 19)" platform. Finally, click the Install Packages button.

    Installing older versions in addition to the newest ones will allow you to build Android applications for the oldest version of Android your code can support, which will be useful to create applications that are compatible with as many devices as possible.

*   Almost there! Everything is installed, but you can't quite open up an Android emulator quite yet. For that, we need to create an Android Virtual Device, or AVD. To do this, open the Android AVD Manager via the Window menu and select the *New...* button. Give your virtual device a name; we recommend that you give it a name that reflects the version of Android and any features you've selected for the AVD. In the Target pull-down, select "Android 4.4.2 - API Level 19", which reflects the most recent version publicly available on devices. Note that installing the SDK components from the previous step provided all available targets in that pull-down. If you don't see the Android 4.4.2 in the target pull down, you should double-check that you've installed all components.

    The remainder of the options in the *Create new Android Virtual Device (AVD)* window defines additional properties of the emulated device, such as an (emulated) SD card or any special hardware or features, but leaving the defaults is fine for now. When done, click the *Create AVD* button. You should see your new AVD in the Android SDK and AVD Manager window, where you can click on your new AVD and click *Start...* to load the emulator and the AVD. If the resolution on your screen is low and you find the emulated screen is too large to fit on your display, you might need to select the "Scale display to real size" checkbox and change the DPI to reflect that of your own display in the Launch Options window that appears when starting an AVD. If this is the case, click on the **?** button next to the *Monitor dpi* field to help you calculate your screen's DPI.

*   Now create another AVD but use a target of "Android 2.1 – API Level 7", and be sure to give yourself some time to play with both AVDs to get a feel for how Android has matured over time.

*   Whew, you've done it! You've installed all of the SDK components and prepared yourself for native Android application development. Let's just recap quickly to make sure we're on the same page. You should have done the following:

	* Installed Eclipse Standard and the Android SDK.
	* Downloaded and configured the ADT Plugin to make Eclipse aware of the Android SDK.
	* Installed all of the available SDK components.
	* Created an AVD for Android 2.1 and Android 4.0.3 and played with both.
	* Take a break, grab a sandwich and make some tea. Or perhaps you'd prefer an ice cream sandwich[^1].

[^1]: <http://en.wikipedia.org/wiki/Android_OS#Version_history>

## Looking Ahead: Student's Choice.

*   In a few weeks we will be releasing the "Android: Student's Choice" project. This project is meant as an opportunity for you to develop a native application using Eclipse and the Android SDK that you would like to see on the Android platform, but you will need to first get an idea approved by your Teaching Fellow before starting on that project. As part of your submission for this Android Setup project you'll propose an idea (or two) that you'd like to implement for the Student Choice project. Since we haven't done much work yet with the SDK itself it might be tough for you to know what sort of features you could implement, but that is precisely the purpose of the proposal: your TF will provide feedback to you about how realistic it will be to complete your proposed project in the two week time frame.

    It's fine if your idea is intended for a project you'd like to continue working on outside of the scope of class, and it's also fine if you intend to use the same idea for the "iOS: Student's Choice" project. Just be sure that this is a new project and not one that you have previously written code. This proposal is also not binding and you can change it if you'd like; just be sure to let your TF know and get the new idea approved before you start working.

    Submit your proposal before this project's due time at:

## Hello, world.

*   Now that you've installed all of the necessary components to do native application development for the Android platform, it's time to make your first application! This app isn't intended to be difficult but rather to familiarize you with the tools and the development environment. For that purpose, your first Android application should be a Hello, World[^2] application.

	**Implementation Details.**
	
	* This is meant to be the most basic of native Android applications. Your application should compile without errors and open in an Android device or the emulator and say, simply, "Hello, Android!" in legible text. The remainder of the app's aesthetics is left up to you.
	* The project should be targeted to work on Android version 2.1 and later.
	* Be sure the project and application name are both Hello########, where ######## is your student ID.
	* Your project's package name should be: nl.mprog.setup.Hello########
	* You must include your name, email, and HUID in a comment atop every Java source file in the project.
	* Psst, want a hint? You might find a helpful tutorial on the Android Developer site.

[^2]: <http://en.wikipedia.org/wiki/Hello_world_program>

## How to Submit.

*   Before the project's due date, link your project in Eclipse to a fresh GitHub repository. Then, submit the GitHub clone URL in the submit tab on this very webpage. Be sure not to commit any changes after this project's deadline.
