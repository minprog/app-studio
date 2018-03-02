# Parsing JSON

A lot of times when dealing with an API, you will receive a response in JSON format. JSON stands for JavaScript Object Notation. It is a standard way in which data can be transmitted in a simple text format that is still readable to the human. If unfamiliar with JavaScript, the structure of a JSON response or JSON file might be slightly confusing, especially becauses reponses are often nested, which means that data elements contain other data elements and so forth. 

## Example

Consider this response from a given API:

``` json
        {
            "id": 2894,
            "name": "John Smith",
            "description": "A very interesting person",
            "age": 35,
            "job": "Programmer",
            "comments": [
                "A nice guy", 
                "Great to work with", 
                "Always helpful!"
            ],
            "skills" : [
                {
                    "name" : "cooking",
                    "experience" : 25,
                    "type" : "domestic"
                },
                {
                    "name" : "debugging",
                    "experience" : 100,
                    "type" : "professional"
                },  
                {
                    "name" : "drawing",
                    "experience" : 75,
                    "type" : "hobby"
                }        
            ]
        }
```

In this case, the reponse represents a person. Of course your API response might not look like this: depending on the API this could be different things. It could represent one thing, like in this example, but also a list of things. 

A JSON reponse typically consists of multiple key-value pairs with in a JSON object. The key is the bit before the `:` and is the part that allows you to extract the value that follows from the response. Keys can be mapped to values of different kinds, such as strings, numbers, arrays or other JSON objects.

What is important when attempting to translate a JSON APi response to something usable in your Java code, is to distinguish between JSON *arrays* and JSON *objects*. 

JSON objects are enclosed by curly braces, and arrays by square brackets. JSON arrays, like the arrays you are used to, can contain multiple values. In the example, the "comments"  key maps to a JSON array of strings. JSON arrays can also hold JSON objects, in the example the "skills" key maps to an array of JSON objects with properties of their own that each depict a certain skill.

Depending on the API, the responses can be complex and deeply nested, with objects in arrays in objects and so forth, many layers deep! When the JSON is shown as just a single line of text in your browser or print statement, it can be hard to figure out how to grab the data bits you want. To help with this, it's a good idea to put your JSON response through a [JSON formatter](https://jsonformatter.curiousconcept.com/) to have a better overview of what data is present in the response.


## Parsing JSON in Android Studio

To use the JSON responses in your code and get the values you need, Android has some nifty built-in functionality on which you can find the docs [here](https://developer.android.com/reference/org/json/package-summary.html). The methods provided by the `JSONArray` and `JSONObject` classes are probably going to be the most useful to you.

You either get a `JSONObject` directly from your API request, or you get a response string. If the string is valid JSON (use the formatter to check!) it can be converted to a `JSONObject` as well. 

Once you have the main `JSONObject` present in your code, it becomes easy to extract the values you need, provided that you take the correct "steps" through your JSON data to get there.



Imagine we have the main JSON object from the example present in a variable called `response` and want to extract values from it. If you simply want to extract a value that is present at the topmost level of the JSON, you can use methods like `getString()`, `getInt()` etc. You will need to supply the key of the property in the JSON as the argument. If we wanted to grab the age from the example JSON, it would look like this. 

    int personAge = response.getInt("age");

The same goes for arrays: if we want to extract the array called "comments", the following line of code will do that for us:

        JSONArray commentArrray = response.getJSONArray("comments");

The `commentArray` variable now contains all the JSONObjects that we need. Since it's an array, we can iterate over it using a loop and extract the values at each index to do something with them, i.e. print te contents of each entry in the array.

        for (int i = 0; i < commentArray.length(); i++) {
            System.out.println(commentArray.getString(i));
        }

If the data we want is deeper in the JSON, we need to take additional steps. To get to the "experience" attribute of a skill within the "skills" array, we first need to extract the skills array:

        JSONArray skillsArrray = response.getJSONArray("skills");

Again, we can iterate over the array, but since it's a JSON object that is present at each index, we need to first grab this object before we can look inside it:

        JSONObject skillObject = categoryArray.getJSONObject(i);
        int experience = skillObject.getInt("experience");


## Final notes

The complexity of parsing JSON is often not in the aspects mentioned above, but more in understanding how your data is constructed and what steps you need to take to get there, because APIs can return very large and complex datasets that might not even be consistent.

If confused, don't hesitate to grab some pen and paper and make some notes or draw how your JSON structure looks: sometimes it helps to make your data more visual. And the formatter really is your best friend!

Finally, a lot of JSON operations require you to surround them with a `try catch` block. When doing so, make sure to actually print your `JSONexception` to the console: the content of the exception will help you determine what went wrong when your parsing fails. 

