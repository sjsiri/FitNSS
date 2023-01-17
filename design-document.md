# Design Document

## _FitNSS_ Design

## 1. Problem Statement

FitNSS is a workout tracker log that will allow the user to keep track of the workouts complete on a weekly basis. 
With FitNSS you have to option to create your own weekly workout plans or get prescribed a weekly workout plan based on your experience level (Beginner, Intermediate, Advance).
If one were to create their own plan they would be given the option to select how many days they would work out and then add exercises from the database into the days. 
Once added they will then be able to type in the number of sets, reps, and weight loaded used for each exercise.

This design document describes the main use cases and functionality of FitNSS, a new, native AWS service that will provide users a cleaner, more informative means to view workout information.
It is designed to interact with the FitNSS Client( which allows users to view workout information based on the day ).


## 2. Top Questions to Resolve in Review

_List the most important questions you have about your design, or things that you are still debating internally that you might like help working through._

1. FitNSS contains list of exercises pulled form database.
2. Allows the user to make a "workout list" by adding the exercises from the database.
3. Be able to update numbers of sets, reps, and weight to each exercise in the list.
4. Is a separate exercise table with all the exercises in the list for the day required?


## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a user, I want to be able to view all exercises in the database.

U2. As a user, I want to be able to add the exercises from the database to the Day corresponding to the workout.

U3. As a user, I want to be able to create a new exercise and add that to the database if it did not exist already.

U4. As a user, I want to be able to update the Days List, so that I can change the information if needed.

U5. As a user, I want to be sort the exercises in the list, so that it'll be easier to search through.

U6. As a user, I want to be able to get a pre-generated workout plan based on my experience.

U7. As a user, I want to be able to create my own workout plan.


## 4. Project Scope

_Clarify which parts of the problem you intend to solve. It helps reviewers know what questions to ask to make sure you are solving for what you say and stops discussions from getting sidetracked by aspects you do not intend to handle in your design._


### 4.1. In Scope

_Which parts of the problem defined in Sections 1 and 2 will you solve with this design? This should include the base functionality of your product. What pieces are required for your product to work?_

* Adding, updating, and retrieving/viewing exercise information
* Creating own workout plan using the exercises.
* Retrieving pre-generated workout plan.
* Adding, updating, and viewing workout plan. 


### 4.2. Out of Scope

_Based on your problem description in Sections 1 and 2, are there any aspects you are not planning to solve? Do potential expansions or related problems occur to you that you want to explicitly say you are not worrying about now? Feel free to put anything here that you think your team can't accomplish in the unit, but would love to do with more time._

* Interactive UI.
* Trying to have majority of it on one page.
* Keeping logs of more than a week of workouts.

# 5. Proposed Architecture Overview

_Describe broadly how you are proposing to solve for the requirements you described in Section 2. This may include class diagram(s) showing what components you are planning to build. You should argue why this architecture (organization of components) is reasonable. That is, why it represents a good data flow and a good separation of concerns. Where applicable, argue why this architecture satisfies the stated requirements._

This initial iteration will provide the minimum viable product (MVP) including adding, retrieving, and updating an employee contact information for the admin role.

We will use API Gateway and Lambda to create endpoints (GetExercise, Add/UpdateExercise, GetAllExercise, GetExerciseByMuscle, GetExerciseByMovement, GetWorkoutPlan) that will handle the creation, updation, and retrieval of exercise and workout information to satisfy our requirements.

We will store exercise information in a table in DynamoDB.

FitNSS will also provide a web interface for users. A main page providing a variety of options to add, update and view workout plan information.


# 6. API

## 6.1. Public Models

_Define the data models your service will expose in its responses via your *`-Model`* package._

```
// ExerciseModel

String exerciseId;
String exerciseName;
String workingMuscle;
String exerciseMovementGroup;
```
```
// WorkoutPlanModel

String workoutPlanId;
String workoutDayName;
String exerciseAdded;
Integer numberOfSets;
Integer numberOfReps;
Integer numberOfWeights;

```

## 6.2. _GetEmployee Endpoint_

* Accepts `GET` requests to `/exercise/:exerciseId`
* Accepts an exerciseId and returns the corresponding exerciseModel.
    * If the given exerciseId is not found, will throw a
      `ExerciseNotFoundException`

## 6.3 _GetAllExercise Endpoint_

* Accepts `GET` requests to `/exercise`
* Returns all the exercises in the ExerciseModel format.
    * If there is no data found, will throw a
      `NoDataFoundException`

## 6.4. GetExerciseByMuscle Endpoint

* Accepts `GET` requests to `/exercise/:workingMuscle`
* Returns all the exercises in the requested muscle group in the ExerciseModel format.
    * If there is no exercise found, will throw a
      `InvalidExerciseException`

## 6.5. GetExerciseByMovement Endpoint

* Accepts `GET` requests to `/exercise/:exerciseMovementGroup`
* Returns all the exercises in the requested movement group in the ExerciseModel format.
    * If there is no exercise found, will throw a
      `InvalidExerciseException`

## 6.6. _UpdateWorkoutPlan Endpoint_

* Accepts `PUT` requests to `/workoutPlan/:workoutPlanId`
* Accepts data to update a workout plan including an updated
  workoutDayName, numberOfSets, numberOfReps, numberOfWeights. Returns the updated information.
* If the workoutPlanId or name is not found, will throw a   
  `WorkoutPlanNotFoundException`

  
## 6.6. _AddExercise Endpoint_

* Accepts `POST` requests to `/exercise/`
* Accepts data to create a new exercise which includes their
   exerciseName, workingMuscle, exerciseMovementGroup and Returns the new exercise.

## 6.7 _AddWorkoutPlan Endpoint_

* Accepts `POST` requests to `/workoutPlan/`
* Accepts data to create a workout plan which includes workoutDayName, exerciseAdded, 
numberOfSets, numberOfReps, NumbersOfWeights. 



## 6.8 GetWorkoutPlan
* Accepts `GET` requests to `/workoutPlan`
* Returns all the workout plans in the workoutPlanTable format.
    * If there is no data found, will throw a
      `NoDataFoundException`

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

* ExerciseTable
    - exerciseId // partition key, string
    - exerciseName // string
    - workingMuscle // string
    - exerciseMovementGroup // string

* WorkoutPlanTable
    * workoutPlanId // partition key, string
    * workoutDayName // string
    * exerciseAdded // string
    * numberOfSets // integer
    * numberOfReps // integer
    * numberOfWeights // integer 


# 8. Pages

https://www.figma.com/file/ZgFECp4D767lH5I6B6KrUt/Untitled?node-id=0%3A1&t=8lsBQGgsLgJniUdI-0
