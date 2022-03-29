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
[Evaluation of your app across the following attributes]
- **Category:** Cooking / Meal Planning
- **Mobile:** Mobile is needed for ease of access to use the app wherever the user wants instead of being tied to a desk. Users interact with the app to submit recipe links for processing which requires internet access. The camera is used to submit optional pictures of completed recipes.
- **Story:** Gives users an easy way to collect and collate all their recipes onto our platform. Grants efficiencies in meal planning and helps simplify the process needed to go from wanting to make a cool recipe you found online to enjoying it at home.
- **Market:** Any person who cooks food at home or would like to start cooking food at home.
- **Habit:** Users are interacting with the app when they want to cook at home or are thinking about cooking at home, multiple times a day. Users are also interacting with the app when they are planning, which can be as often as they wish to engage with the app.
- **Scope:** V1 would allow users to create recipes and ingredient lists from submitted URLs and save them in a library for later viewing, or manually enter them. V2 would incorporate the ability to create meal plans and shopping lists from one or more saved recipes. V3 would allow for recipes to be shared amongst all users and shopping lists to be shared between specific users. V4 would incorporate a grocery store finder to find your closest grocery store to purchase your ingredients.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [ ] User can sign up to create a new account using Parse authentication
- [ ] User can log in and log out of their account.
- [ ] The current signed in user is persisted across app restarts.
- [ ] User can provide the url to a recipe online and the app will extract ingredients, servings, and steps
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

* [list first screen here]
   * [list associated required story here]
   * ...
* [list second screen here]
   * [list associated required story here]
   * ...

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* [fill out your first tab]
* [fill out your second tab]
* [fill out your third tab]

**Flow Navigation** (Screen to Screen)

* [list first screen here]
   * [list screen navigation here]
   * ...
* [list second screen here]
   * [list screen navigation here]
   * ...

## Wireframes
[Lo - Fi]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### Hi Fi

### GIF of walkthrough

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]

