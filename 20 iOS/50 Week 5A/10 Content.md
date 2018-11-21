# Week 5: Tables and Persistence

This week we'll use 'App Development With Swift' again. We will continue at Unit 4.


## Language exercises

This week we will learn how to use and create protocols, protocols are a essential while using UIKit. Feel free to skip some of the parts about the programming language, but make sure that you know *exactly* how to write correct Swift code!

1. Protocols


## iOS exercises

Next up are 8 lessons about the different building blocks you can use to create a good user interface. Feel free to skip some of the labs, but make sure that you know *exactly* how to user these views.

{:start="2"}
2. App Anatomy and Life Cycle
3. Model View Controller
4. Scroll Views
5. Table Views
6. Intermediate Table Views
7. Saving Data
8. System View Controllers
9. Building Complex Input Screens

## Project

Now you are ready to make your next app! At the end of the chapter, you'll find a Guided Project. This time you'll make a Todo-list app called 'List'.


### FAQs

#### Loading Sample ToDos
The book provides some code for loading in sample `ToDo`'s at page 735, however the sampleToDos also need to be stored in the `todos` variable just like the `savedToDos`.

~~~swift
override func viewDidLoad() {
    super.viewDidLoad()
 
    if let savedToDos = ToDo.loadToDos() {
        todos = savedToDos
    } else {
        todos = ToDo.loadSampleToDos()
    }
}
~~~

#### DatePicker show/hide

The book provides some code for hiding the DatePicker, however, the correct IndexPath for the DatePicker is `[1,0]`.

~~~swift
override func tableView(_ tableView: UITableView, didSelectRowAt
indexPath: IndexPath) {
    switch (indexPath) {
    case [1,0]:
        isEndDatePickerHidden = !isEndDatePickerHidden
 
        dueDateLabel.textColor =
        isEndDatePickerHidden ? .black : tableView.tintColor
 
        tableView.beginUpdates()
        tableView.endUpdates()
 
    default: break
    }
}
~~~

## Goals

Our main goal for this course is getting you some in-depth experience on important aspects of creating **good quality** apps. You'll practice with various techniques every week. For this week, make sure you try, as much as possible, to create an app that excels in these respects:

- layout, margins, compatibility with multiple phone sizes
- basic code quality such as comments, names, consistency and design
- easy to use, no odds and ends


## Adding to GitHub

[Here](/ios-reference/github) you'll find several instructions for adding your project's code to GitHub.


## Grading

*Before* the deadline, complete the exercises and put your finished project on GitHub. Ask for help if needed!

1. Submit the link to your project's GitHub repository at [Week 5](/submit/unit-5).

2. On (or before) the date of the deadline, show your finished exercises **and** the working app to one of the staff.

3. Next, acquire feedback on your app and improve on it. Improvements should be finished and synced with GitHub before the course's final deadline.
