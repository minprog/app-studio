# Unit 4: Tables and Persistence

## Language exercises

Feel free to skip some of the parts about the programming language, but make sure that you know *exactly* how to write correct Swift code!

1. Protocols


## iOS exercises

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

There's only one project this week:

- **Guided project: List** takes you step-by-step through making an app. You'll probably choose this one if you haven't built applications on a platform before.

### FAQs

#### Loading Sample ToDos
The book provides some code for loading in sample todo's at page 735, however the sampleToDos also need to be stored in the `todos` variable.

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

## Getting credit

Make sure that you complete the language exercises and put your finished project on Github *before* the deadline. In the next class session, show your exercises and the working app to one of the staff.

Completing the exercises can earn you 1 point per week. The project will be checked for full completion of the assignment and consideration of all requirements. You can earn points according to the following scheme:

| pts | description                                                                          |  
| --: | ------------------------------------------------------------------------------------ |  
|   5 | Exceptional quality in use, layout and code. Probably something extra or unexpected. |  
|   4 | Solid quality in use, layout and code. Maybe some trivial error.                     |  
|   3 | Reasonable quality, but lots of room for improvement.                                |  
|   2 | The app mostly works but really lacks in quality.                                    |  
|   1 | Clearly, quite a bit of effort went into it, but it does not really work.            |  
|   0 | Not submitted or very incomplete.                                                    |  

This week, we will look at the following quality aspects:

- layout, margins, compatibility with multiple phone sizes
- basic code quality such as comments, names, consistency and design
- easy to use, no odds and ends
- level of separation between model classes and user interface code


## Submit

Submit at [Unit 4](/submit/unit-4).
