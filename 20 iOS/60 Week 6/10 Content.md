# Unit 5: Working with the Web

This week you will learn how to get content from the web and make use of API's.

## Language exercises

1. Closures
2. Extensions


## iOS exercises

{:start="3"}
3. Practical Animation
4. Working with the Web: HTTP and URL Session
5. Working with the Web: JSON Serialization
6. Working with the Web: Concurrency


## Project

There’s only one project this week:

- **Guided project: Restaurant** takes you step-by-step through making an app. You'll probably choose this one if you haven't built applications on a platform before.

**Note:** Instead of the local server you can use `https://resto.mprog.nl/`.

- In step 1 you can skip the 'Run the Server'.
- In step 3 you can skip the 'Project Setup' part because the server uses a HTTPS connection.
- In step 4 the `baseURL` will be:

~~~swift
class MenuController {
    let baseURL = URL(string: "https://resto.mprog.nl/")!”
}
~~~

## FAQs

- On page 915 in 'Parse the Responses', the second code block starts with `fetchCategories` however is this the code block for `fetchMenuItems`. The first line should be:

~~~swift
let task = URLSession.shared.dataTask(with: menuURL)
~~~

- The 'gray image' from page 926 can be downloaded [here](Solid_gray.png).
- In the `submitOrder` method, make sure to declare the variable `data` with the following type:

~~~swift
let data: [String: [Int]] = ...
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

Submit at [Unit 5](/submit/unit-5).
