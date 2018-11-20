# Test APIs 

The APIs are for General algorithmic tasks and building todo To Do List endpoints

You can run the https url below in integration test:

https://autoandgeneraltest.herokuapp.com

Please find some examples of end points below

<get>https://autoandgeneraltest.herokuapp.com/tasks/validateBrackets  //Checks if brackets in a string are balanced 
<post>https://autoandgeneraltest.herokuapp.com/todo  //Create a to do item
<get>https://autoandgeneraltest.herokuapp.com/todo/{id}  //Retrieve a specific item by id
<patch>https://autoandgeneraltest.herokuapp.com/todo/{id}  //Modify an item



just access https://searchclient.azurewebsites.net/

# File Path Structure

For https://github.com/JohnnyJNQuan/test-api/tree/master/test/main/java/com/todoservice/gemfirerestapi

    --src
      --__test__
          --index.test.tsx  // testing mounting components' state and props.
          --listItem.test.tsx // testing searched list result.
      --app
          --index.tsx   //main program of this app 
      --components      
          --listItem.tsx // item detail of search result
          --notFound.tsx // Not found page when not records matching your input keyword
          --searchAppBar.tsx // responsive search app bar
          --searchList.tsx // its is a list for wrapping list items
          --withRoot.tsx // make material ui compatible to Typescript


# Set Up Local env

1. clone the package to your local
2. run "npm install"
3. run "npm run serve" to start local server, you can find more details on package.json for more script commands.
4. access http://localhost:3000/ to play
5. have fun ^_^

