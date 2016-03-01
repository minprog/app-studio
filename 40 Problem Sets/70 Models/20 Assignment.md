## Assignment

We will be doing one final 3.0 version of the todo list app. This time, we are going to make the code design more object-oriented.

Most likely, much of your important code now resides in one or more controllers (ViewControllers/Activities). However, if we move some of this code into separate classes, the whole codebase can become more understandable. This is the principle of *separation of concerns*. The "ideal" of this principle is to have each class be responsible for one single thing. In practice, we usually don't take it that far.

Here are the classes we think you should make, along with their responsibilities:

- `TodoItem`

    Stores data for a single todo item. This class is very simple and looks a little bit like a `struct` in C. The class variables (such as `title`) should not be `public`, but `private`. Where needed, you can expose the variables through getters and setters.

- `TodoList`

    Stores data for a single todo list. That means that each instance of this class contains many `TodoItem`s! The class variables (such as `title`) should not be `public`, but `private`. Where needed, you can expose the variables through getters and setters.

- `TodoManager`

    A singleton class that groups some common functionality. It contains the list of `TodoList`s for your application, and it has two functions that are reponsible for persistence of the lists between application runs: `readTodos` and `writeTodos`.
