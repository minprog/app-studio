## Assignment

![](todo.png)

You now have an application where a user can manage todo items: they can add items and remove them. The structure is still fairly simple, and now it's time to create a 2.0 version of your app. There will be one big new feature: having multiple separate lists of todo items. There are a few challenges to go through:

- You will need to add a new screen for showing the different lists that are in the app, as well as a screen for adding a new list (it needs a name, of course!).

- You will need to come up with a way to save all the lists together with their items, so they can be displayed again when the app reloads. Maybe a text file with a structured format? Or maybe some kind of standard format like JSON? Feel free to discuss this with your classmates and point to nice solutions (but don't share code!).

In addition, this week, you will make sure that the app will always start *exactly* where the user left off in the app! This will make the app feel much more natural, especially when task switching (which may have your app killed without you knowing it!). Consider the following:

- Think about what a user expects when returning to the app: will we return to the same list, the same item? Does a form need to be filled in as it was? Probably yes!

- What data do you minimally need to save to *know* where you were last in the app? How do you encode this information to save and reload as quickly as possible?