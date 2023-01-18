# Design Document

## _FitNSS_ Design

## 1. Problem Statement

FitNSS is a workout tracker log that will allow the user to keep track of the workouts complete on a weekly basis. 
With FitNSS you have to option to create your own weekly workout plans or get prescribed a weekly workout plan based on your experience level (Beginner, Intermediate, Advance). 
If one were to create their own plan they would be given the option to select how many days they would workout and then add exercises from the database into the days.
Once added they will then be able to they'll be able to keep a daily log of how many sets/reps/weights they've completed each time.




## 2. Top Questions to Resolve in Review


1. Figuring out how if we would have to make more than 1 dynamodb table or multiple gsi.
2. Figuring how to make a search function. (Sorting by typing the name)
3. Will I be able to add more than one "exerciseAdded" into the plan, or will adding an exercise overwrite the previous one?
4. Is a separate exercise table with all the exercises in the list for the day required?


## 3. Use Cases

_This is where we work backwards from the customer and define what our customers would like to do (and why). You may also include use cases for yourselves (as developers), or for the organization providing the product to customers._

U1. As a user, I want to be able to view all exercises in the database.

U2. As a user, I want to be able to add multiple empty HashMap/Sets/List (Not sure which one to use) that we can add the exercises into.

U3. As a user, I want to be able to create a new exercise and add that to the database if it did not exist already.

U4. As a user, I want to be able to update the number of Sets,Reps, and weight. So that I can change the information if needed.

U5. As a user, I want to be sort the exercises in the list, so that it'll be easier to search through.

U6. As a user, I want to be able to get a pre-generated workout plan based on the experience level selected (Beginner, Intermediate, Advanced). 

U7. As a user, I want to be able to create my own workout plan.

U8. As a user, I want to be able to delete an exercise from the database.

U9. As a user, I want to be able to view the log of the workout plan that was created with the number of exercises, sets, reps, and weights added in.


### 4.1. In Scope

* Adding, updating, and retrieving/viewing exercise information
* Creating own workout plan using the exercises.
* Retrieving pre-generated workout plan.
* Adding, updating, deleting, and viewing workout plan. 


### 4.2. Out of Scope

* Trying to have the majority of it on one page.


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
String exerciseName; GSI HASHKEY
String workingMuscle; GSI SORTKEY1
String exerciseMovementGroup; GSI SORTKEY2
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

## 6.2. _GetExercise Endpoint_

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

* Accepts `GET` requests to `/exerciseMuscle/:workingMuscle`
* Returns all the exercises in the requested muscle group in the ExerciseModel format.
    * If there is no exercise found, will throw a
      `InvalidExerciseException`

## 6.5. GetExerciseByMovement Endpoint

* Accepts `GET` requests to `/exerciseMovement/:exerciseMovementGroup`
* Returns all the exercises in the requested movement group in the ExerciseModel format.
    * If there is no exercise found, will throw a
      `InvalidExerciseException`

## 6.6. _UpdateWorkoutPlan Endpoint_

* Accepts `PUT` requests to `/workoutPlan/:workoutPlanId`
* Accepts data to update a workout plan including an updated
  workoutDayName, numberOfSets, numberOfReps, numberOfWeights. Returns the updated information.*
  ("workDayName": "Mon", "numberOfSets": 3, "numberOfReps" 10, "numberOfWeights": 135)
* If the workoutPlanId or name is not found, will throw a   
  `WorkoutPlanNotFoundException`

  
## 6.6. _AddExercise Endpoint_

* Accepts `POST` requests to `/exercise/`
* Accepts data to create a new exercise which includes their
   exerciseName, workingMuscle, exerciseMovementGroup and Returns the new exercise.
  ("exerciseName": "Barbell Bench Press", "workingMuscle": "Chest", "exerciseMovementGroup": "Push")

## 6.7 _AddWorkoutPlan Endpoint_

* Accepts `POST` requests to `/workoutPlan/`
* Accepts data to create a workout plan which includes workoutDayName, exerciseAdded, 
numberOfSets, numberOfReps, NumbersOfWeights.
  ("workDayName": "Mon", "exerciseAdded": "Barbell Bench Press", "numberOfSets": 3, "numberOfReps" 10, "numberOfWeights": 135)

## 6.8 _GetWorkoutPlan EndPoint_
* Accepts `GET` requests to `/workoutPlan/`
* Returns all the workout plans in the workoutPlanTable format.
    * If there is no data found, will throw a
      `NoDataFoundException`

## 6.9 _DeleteExercise EndPoint_
* Accepts `DELETE` requests to `/exercise/`
* Accepts data to delete the exercise by using the exerciseId 

## 6.10 _DeleteWorkoutPlan EndPoint_
* Accepts `DELETE` requests to `/workoutPlan/`
* Accepts data to delete the plan by using the workoutPlanId. 

# 7. Tables

_Define the DynamoDB tables you will need for the data your service will use. It may be helpful to first think of what objects your service will need, then translate that to a table structure, like with the *`Playlist` POJO* versus the `playlists` table in the Unit 3 project._

* ExerciseTable
    - exerciseId // partition key, string
    - exerciseName // string // GSI HASHKEY
    - workingMuscle // string // GSI SORTKEY
    - exerciseMovementGroup // string // GSI SORTKEY

* WorkoutPlanTable
    * workoutPlanId // partition key, string
    * workoutDayName // string
    * exerciseAdded // string
    * numberOfSets // integer
    * numberOfReps // integer
    * numberOfWeights // integer 


# 8. Pages

https://www.figma.com/file/ZgFECp4D767lH5I6B6KrUt/Untitled?node-id=0%3A1&t=8lsBQGgsLgJniUdI-0
