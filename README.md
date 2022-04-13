Original App Design Project - README
===

# Yes, Chef!

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Yes Chef is an intelligent meal planning application that can ingest a link to a recipe and generate a list of ingredients and the steps to make it, along with other helpful features for meal planning and grocery shopping.

### App Evaluation
- **Category:** Cooking / Meal Planning
- **Mobile:** Mobile is needed for ease of access to use the app wherever the user wants instead of being tied to a desk. Users interact with the app to submit recipe links for processing which requires internet access. The camera is used to submit optional pictures of completed recipes.
- **Story:** Gives users an easy way to collect and collate all their recipes onto our platform. Grants efficiencies in meal planning and helps simplify the process needed to go from wanting to make a cool recipe you found online to enjoying it at home.
- **Market:** Any person who cooks food at home or would like to start cooking food at home.
- **Habit:** Users are interacting with the app when they want to cook at home or are thinking about cooking at home, multiple times a day. Users are also interacting with the app when they are planning, which can be as often as they wish to engage with the app.
- **Scope:** V1 would allow users to create recipes and ingredient lists from submitted URLs and save them in a library for later viewing, and potentially manually enter them. V2 would incorporate the ability to create meal plans and shopping lists from one or more saved recipes. V3 would allow for recipes to be shared amongst all users and shopping lists to be shared between specific users. V4 would incorporate a grocery store finder to find your closest grocery store to purchase your ingredients.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [ ] User can sign up to create a new account using Parse authentication
- [ ] User can log in and log out of their account.
- [ ] The current signed in user is persisted across app restarts.
- [x] User can provide the url to a recipe online and the app will extract ingredients, servings, and steps
- [ ] User can browse and edit their recipe library
- [ ] User can create a meal plan consisting of one or more meals per day, one or more days per meal plan
- [ ] User can create a shopping list, broken down by grocery store category, based on their meal plan
- [ ] User can share recipes, meal plans, and shopping lists with other users
- [ ] Shopping lists are built as checklists to allow for tracking shopping progress
- [ ] User can utilize location services to find grocery stores in their area

**Optional Nice-to-have Stories**

- [ ] User can query their shopping list with grocery stores in their area to see which items are on sale
- [ ] User can query their shopping list with grocery store delivery services in their area and get an estimated price for their meal plan
- [ ] Shopping list progress is synchronized between users who share it
- [ ] Users can browse recipe library of community-entered recipes to add to their collection
- [ ] Users can input and track personal stock of ingredients to see what recipes they can make with what they have on hand
- [ ] Once recipe is added to meal plan, ingredient stock is decremented by amounts indicated in recipe
- [ ] User can manually input ingredients, servings, and recipe steps to create a new recipe
- [ ] User can adjust number of servings a recipe is intended for and reflect changes in ingredient quantities

### 2. Screen Archetypes

* Splash Screen
    * User can sign up to create a new account using Parse Authentication
    * User can log in and log out of their account
* Register Screen
    * User can sign up to create a new account using Parse Authentication
* Login Screen
    * User can log in and log out of their account
* Home Screen
    * The current signed in user is persisted across app restarts.
    * User can share recipes, meal plans, and shopping lists with other users
* Individual Post Screen
    * User can share recipes, meal plans, and shopping lists with other users
* Create Post Screen
    * User can share recipes, meal plans, and shopping lists with other users
* Recipes Screen
    * User can share recipes, meal plans, and shopping lists with other users
* Recipe Library Screen
    * User can browse and edit their recipe library
* URL Extractor Screen
    * User can provide the url to a recipe online and the app will extract ingredients, servings, and steps
* Meal Planning Screen
    * User can create a meal plan consisting of one or more meals per day, one or more days per meal plan
    * User can create a shopping list, broken down by grocery store category, based on their meal plan
    * User can share recipes, meal plans, and shopping lists with other users
* Shopping List Screen
    * User can create a shopping list, broken down by grocery store category, based on their meal plan
    * Shopping lists are built as checklists to allow for tracking shopping progress
    * User can share recipes, meal plans, and shopping lists with other users
* Find Store Screen
    * User can utilize location services to find grocery stores in their area
* My Profile Screen
    * User can log in and log out of their account

  

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home Screen
* Recipes Screen
* My Profile Screen

**Flow Navigation** (Screen to Screen)

* Splash Screen
   * If user already logged in -> directly to home screen, else:
   * Login button goes to login screen
   * Register button goes to register screen
* Home Screen
   * Click on post recipe to go to specific post screen (detailed view of post)
   * Create Post via floating button
* Recipes Screen - tiles to navigate to the following screens
   * Recipe Library Screen
   * URL Extractor Screen
   * Meal Planning Screen
   * Shopping List Screen
   * Find Store Screen
* My Profile Screen
   * Logout button goes back to Splash Screen

## Wireframes
### [Lo - Fi]
<img src ="https://user-images.githubusercontent.com/47534734/160746315-625355ec-0fda-4706-bae9-9cb0369bb308.png">

<img src = "https://user-images.githubusercontent.com/74472745/160739286-5ee81edc-1429-4f49-a775-6ae3d4b14388.jpg">

### Hi Fi!

<img src ="https://user-images.githubusercontent.com/47534734/160746347-e21ac85b-2314-45a8-8652-30075cdae4e5.png">




### GIF of walkthrough

<img src = "https://user-images.githubusercontent.com/47534734/160746873-e3e96227-ce5e-49ea-946f-7b18e37c010a.gif">

## Schema 

### Models

User

|     Property         |     Type      |     Description                                |
|----------------------|---------------|------------------------------------------------|
|     userID           |     String    |     Generated by   back4app (default field)    |
|     Username         |     String    |     Users email   address                      |
|     DisplayedName    |     String    |     Name   displayed to users of the app       |
|     Password         |     String    |     Hashed user   password                     |
|     ProfilePic       |     File      |     User’s uploaded   profile pic              |
|     About            |     String    |     User’s   description                       |
|     FirstName        |     String    |     User’s first   name                        |
|     LastName         |     String    |     User’s last   name                         |

Post

|     Property       |     Type                          |     Description                                      |
|--------------------|-----------------------------------|------------------------------------------------------|
|     postID         |     String                        |     Generated by   back4app (default field)          |
|     RecipeID       |     Pointer to   Recipe object    |     Subject of   post                                |
|     Image          |     File                          |     Picture of   finished recipe (optional)          |
|     Description    |     String                        |     User’s   description of recipe                   |
|     Likes          |     Array                         |     Array of userID   pointers who liked the post    |
|     Comments       |     Array                         |     Array of JSON   objects representing comments    |
|     UserID         |     Pointer to   User object      |     User who made   post                             |

Recipe

|     Property       |     Type                 |     Description                                                                 |
|--------------------|--------------------------|---------------------------------------------------------------------------------|
|     Private        |     Boolean              |     Controls   visibility of recipe on app                                      |
|     recipeID       |     String               |     Generated by   back4app (default field)                                     |
|     userID         |     Pointer to   user    |     User who   uploaded recipe                                                  |
|     savesCount     |     Number               |     Number of   users who have saved this recipe to their profile               |
|     Source         |     String               |     url string if   generated from web, ‘Manual’ if manually entered by user    |
|     createdAt      |     DateTime             |     Date when recipe   is created (default field)                               |
|     Ingredients    |     Array                |     Array of JSON   objects representing the ingredients for this recipe        |
|     Steps          |     Array                |     Array of JSON   objects representing the steps for this recipe              |

Meal Plan

|     Property      |     Type                 |     Description                                                                      |
|-------------------|--------------------------|--------------------------------------------------------------------------------------|
|     Private       |     Boolean              |     Controls   visibility of meal plan on app                                        |
|     planID        |     String               |     Generated by   back4app (default field)                                          |
|     userID        |     Pointer to   user    |     User who   uploaded meal plan                                                    |
|     savesCount    |     Number               |     Number of   users who have saved this meal plan to their profile                 |
|     Recipes       |     Array                |     Array of JSON   objects representing the day / meal and the pointer to recipe    |
|     createdAt     |     DateTime             |     Date when meal   plan is created (default field)                                 |
|     updatedAt     |     DateTime             |     Date when   meal plan is updated (default field)                                 |

Shopping List

|     Property       |     Type                 |     Description                                                                                      |
|--------------------|--------------------------|------------------------------------------------------------------------------------------------------|
|     listID         |     String               |     Generated by   back4app (default field)                                                          |
|     userID         |     Pointer to   user    |     User who   created shopping list                                                                 |
|     sharedWith     |     Array                |     Array of   pointers to user objects representing those who have access to the shopping   list    |
|     Ingredients    |     Array                |     Array of JSON   objects representing the ingredients that make up the shopping list              |
|     createdAt      |     DateTime             |     Date when shopping   list is created (default field)                                             |
|     updatedAt      |     DateTime             |     Date when shopping   list is updated (default field)                                             |

### Networking
- Splash Screen
   - N/A
- Register Screen
   - (Create/POST) Create a new user account
   ```
   ParseUser newUser =  new ParseUser();
   newUser.put("display_name",display_name);
   newUser.put("username", username);
   newUser.put("password", password);
   //Profile pic, About, fname, lname could be in other screens such as profile settings or app tutorial if we get one,
   newUser.signUpInBackground(e -> {
       if(e!=null){
           Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, "Account was created!\nYou can now log in!", Toast.LENGTH_LONG).show();
       }
   });
   ```
- Login Screen
   - (Read/POST) Login to user account
   ```
   ParseUser.logInInBackground(username, password, new LogInCallback(){
    @Override
    public void done(ParseUser user, ParseException e) {
        if (e!=null){
            Log.e(TAG, "Issue with login", e);
            return;
        }
        goMainActivity();
    }
   });
- Home Screen
   - (Read/GET) Query logged in user object
   - (Create/POST) Create a new like on a post
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.setLikes(post.getLikes()+1); 
       post.setUsersLikedArray(post.getUsersLikedArray().add(currentUser)); 
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Delete) Delete existing like
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.setLikes(post.getLikes()-1); 
       post.setUsersLikedArray(post.getUsersLikedArray().remove(currentUser)); 
   }else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Create/POST) Create a new comment on a post (stretch)
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.addUserComment(userCommentObj); //Adds comment to the array in the Post Object
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Delete) Delete existing comment (stretch)
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.deleteUserComment(userCommentObj); \\Uses id in the User object to get rid of comment in the User Comment Array
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Edit/PUT) edit comment on a post (stretch)
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.updateUserComment(userCommentObj); \\Uses id in the User object to update of comment in the User Comment Array
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
- Individual Post Screen
   - (Create/POST) Create a new like on a post
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.setLikes(post.getLikes()+1); 
       post.setUsersLikedArray(post.getUsersLikedArray().add(currentUser)); 
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Delete) Delete existing like
   ```
   ParseQuery<ParseObject> query = ParseQuery.getQuery("Post");
   query.getInBackground(postID, (post, e) -> {
   if (e == null) {
       //Object was successfully retrieved
       // Update the fields we want to
       post.setLikes(post.getLikes()+1); 
       post.setUsersLikedArray(post.getUsersLikedArray().add(currentUser)); 
   } else {
       Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
   }
   });
   ```
   - (Create/POST) Create a new comment on a post (stretch)
   - (Delete) Delete existing comment (stretch)
   - (Edit/PUT) edit comment on a post (stretch)
- Create Post Screen
   - (Create/POST) Create a new post object
   ```
   Post post = new Post();
   post.setRecipe(recipe);
   post.setDescription(description);
   post.setImage(new ParseFile(photoFile)); //Recommended but optional
   post.setUser(currentUser);

   post.saveInBackground(new SaveCallback() {
       @Override
       public void done(ParseException e) {
           if(e!=null){
               Log.e(TAG, "Error while saving", e);
               Toast.makeText(getContext(), "Error while saving!", Toast.LENGTH_SHORT).show();
           }
           Log.i(TAG, "POST save was successful!");
           Toast.makeText(getContext(), "Posted!", Toast.LENGTH_SHORT).show();
       }
   });
   ```
- Recipes Screen
   - N/A
- Recipe Library Screen
   - (Read/GET) Query users recipe objects
   - (Delete) Delete existing recipe objects
- URL Extractor / Recipe Creator Screen
   - (Read/GET) Generate new recipe object from provided URL
   - (Create/POST) Create new recipe object
- Meal Planning Screen
   - (Create/POST) Create new meal plan object
   - (Read/GET) Query users meal plan objects
   - (Update/PUT) Update users meal plan objects
   - (Read/GET) Query users recipe objects
   - (Delete) Delete existing meal plan objects
   - (Create/POST) Create new shopping list object
- Shopping List Screen
   - (Read/GET) Query users shopping list objects
   - (Update/PUT) Update users shopping list objects
   - (Delete) Delete existing shopping list objects
- Find Store Screen
   - (Read/GET) Query users location
   - (Read/GET) Query points of interest near user
   - (Create/POST) Send directions from current location to point of interest to Maps
- My Profile Screen
   - (Read/GET) Query logged in user object
   - (Update/PUT) Update user object
   - (Read/GET) Query users post objects

- [OPTIONAL: List endpoints if using existing API such as Yelp]

