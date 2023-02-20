import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view exercise plan page of the website.
 */

class CreateWorkoutPlan extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'loadExerciseDropDown', 'loadExerciseDropDown2', 'loadExerciseDropDown3', 'loadExerciseDropDown4', 'submit', 'redirectToViewWorkoutPlan', ], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
    }

    async clientLoaded() {
        this.loadExerciseDropDown();
        this.loadExerciseDropDown2();
        this.loadExerciseDropDown3();
        this.loadExerciseDropDown4();
     }


    /**
     * Add the header to the page and load the FitNSSClient.
     */
     async mount() {
        document.getElementById('save-workoutplan').addEventListener('click', this.submit);
        this.header.addHeaderToPage();
        this.client = new FitNSSClient();
        await this.clientLoaded();
     }


     /**
     * Add LoadExerciseDropDown is order to select exercises
     */

     async loadExerciseDropDown() {
        // Get All Exercises API
        const exercises = await this.client.getAllExercises();
        const exerciseDropDown = document.getElementById('exercisesList');

        for (let key of exercises) {
                let option = document.createElement("option");
                option.setAttribute('value', key.exerciseId);
                option.setAttribute('innerHTML', key.exerciseName);
                let optionText = document.createTextNode(key.exerciseName);
                option.appendChild(optionText);
                exerciseDropDown.appendChild(option);
        }
     }


     async loadExerciseDropDown2() {
             // Get All Exercises API
             const exercises = await this.client.getAllExercises();
             const exerciseDropDown = document.getElementById('exercisesList2');

             for (let key of exercises) {
                     let option = document.createElement("option");
                     option.setAttribute('value', key.exerciseId);
                     option.setAttribute('innerHTML', key.exerciseName);
                     let optionText = document.createTextNode(key.exerciseName);
                     option.appendChild(optionText);
                     exerciseDropDown.appendChild(option);
             }
          }

     async loadExerciseDropDown3() {
             // Get All Exercises API
             const exercises = await this.client.getAllExercises();
             const exerciseDropDown = document.getElementById('exercisesList3');

             for (let key of exercises) {
                     let option = document.createElement("option");
                     option.setAttribute('value', key.exerciseId);
                     option.setAttribute('innerHTML', key.exerciseName);
                     let optionText = document.createTextNode(key.exerciseName);
                     option.appendChild(optionText);
                     exerciseDropDown.appendChild(option);
             }
          }

     async loadExerciseDropDown4() {
             // Get All Exercises API
             const exercises = await this.client.getAllExercises();
             const exerciseDropDown = document.getElementById('exercisesList4');

             for (let key of exercises) {
                     let option = document.createElement("option");
                     option.setAttribute('value', key.exerciseId);
                     option.setAttribute('innerHTML', key.exerciseName);
                     let optionText = document.createTextNode(key.exerciseName);
                     option.appendChild(optionText);
                     exerciseDropDown.appendChild(option);
             }
          }

     /**
        * Method to run when the create Workout plan submit button is pressed. Call the FitNSSClient to
        * create the Exercise.
     */
     async submit() {
        const workoutDayName = document.getElementById('workoutDayName').value;
        if (!document.getElementById('workoutDayName').value) {
            alert("Please enter a name for the workout.")
            return false;
        }
        const exerciseList = document.getElementById('exercisesList');
        const exerciseId = document.getElementById('exercisesList').value;
        const exerciseName = exerciseList.options[exerciseList.selectedIndex].innerHTML;
        if (exerciseName == "-- Select Exercises --") {
            alert("Please select an exercise for exercise 1.")
            return false;
        }

        const numberOfSets = document.getElementById('numberOfSets').value;
        if (numberOfSets == "") {
            alert("Please enter the amount of sets for Exercise 1.")
            return false;
        }

        const numberOfReps = document.getElementById('numberOfReps').value;
        if (numberOfReps == "") {
            alert("Please enter the amount of reps for Exercise 1.")
            return false;
        }

        const numberOfWeights = document.getElementById('numberOfWeights').value;
        if (numberOfWeights == "") {
            alert("Please enter the prescribed load for Exercise 1.")
            return false;
        }

        const exerciseList2 = document.getElementById('exercisesList2');
        const exerciseId2 = document.getElementById('exercisesList2').value;
        const exerciseName2 = exerciseList2.options[exerciseList2.selectedIndex].innerHTML;
        if (exerciseName2 == "-- Select Exercises --") {
            alert("Please select an exercise for exercise 2.")
            return false;
        }

        const numberOfSets2 = document.getElementById('numberOfSets2').value;
        if (numberOfSets2 == "") {
            alert("Please enter the amount of sets for Exercise 2.")
            return false;
        }

        const numberOfReps2 = document.getElementById('numberOfReps2').value;
        if (numberOfReps2 == "") {
            alert("Please enter the amount of reps for Exercise 2.")
            return false;
        }

        const numberOfWeights2 = document.getElementById('numberOfWeights2').value;
        if (numberOfWeights2 == "") {
            alert("Please enter the prescribed load for Exercise 2.")
            return false;
        }

        const exerciseList3 = document.getElementById('exercisesList3');
        const exerciseId3 = document.getElementById('exercisesList3').value;
        const exerciseName3 = exerciseList3.options[exerciseList3.selectedIndex].innerHTML;
        if (exerciseName3 == "-- Select Exercises --") {
            alert("Please select an exercise for exercise 3.")
            return false;
        }

        const numberOfSets3 = document.getElementById('numberOfSets3').value;
        if (numberOfSets3 == "") {
            alert("Please enter the amount of sets for Exercise 3.")
            return false;
        }

        const numberOfReps3 = document.getElementById('numberOfReps3').value;
        if (numberOfReps3 == "") {
            alert("Please enter the amount of reps for Exercise 3.")
            return false;
        }

        const numberOfWeights3 = document.getElementById('numberOfWeights3').value;
        if (numberOfWeights3 == "") {
            alert("Please enter the prescribed load for Exercise 3.")
            return false;
        }

        const exerciseList4 = document.getElementById('exercisesList4');
        const exerciseId4 = document.getElementById('exercisesList4').value;
        const exerciseName4 = exerciseList4.options[exerciseList4.selectedIndex].innerHTML;
        if (exerciseName4 == "-- Select Exercises --") {
            alert("Please select an exercise for exercise 4.")
            return false;
        }

        const numberOfSets4 = document.getElementById('numberOfSets4').value;
        if (numberOfSets4 == "") {
            alert("Please enter the amount of sets for Exercise 4.")
            return false;
        }

        const numberOfReps4 = document.getElementById('numberOfReps4').value;
        if (numberOfReps4 == "") {
            alert("Please enter the amount of reps for Exercise 4.")
            return false;
        }

        const numberOfWeights4 = document.getElementById('numberOfWeights4').value;
        if (numberOfWeights4 == "") {
            alert("Please enter the prescribed load for Exercise 4.")
            return false;
        }

        const notesBox = document.getElementById('notesBox').value;
        if (notesBox == "") {
            alert("Please enter some notes for the Workout.")
            return false;
        }

        var eList = [exerciseName, exerciseName2, exerciseName3, exerciseName4];
        var setList = [numberOfSets, numberOfSets2, numberOfSets3, numberOfSets4];
        var repList = [numberOfReps, numberOfReps2, numberOfReps3, numberOfReps4];
        var weightList = [numberOfWeights, numberOfWeights2, numberOfWeights3, numberOfWeights4];

        let payload = {workoutDayName: workoutDayName}


        payload.exercisesAdded = eList;
        payload.numberOfSets = setList;
        payload.numberOfReps = repList;
        payload.numberOfWeights = weightList;
        payload.notesBox = notesBox;




        document.getElementById('save-workoutplan').disabled = true;
        document.getElementById('save-workoutplan').innerHTML = 'Saving Workout...';
        document.getElementById('save-workoutplan').style.background='grey';
        const workoutplan = await this.client.createWorkoutPlan(payload);
        this.dataStore.set('workoutplan', workoutplan);
        this.redirectToViewWorkoutPlan();
     }

     /**
      * When the Workout is updated in the datastore, redirect to the view Workout Plan page.
      */
      redirectToViewWorkoutPlan() {
        const workoutplan = this.dataStore.get('workoutplan');
        if (workoutplan) {
            window.location.href = `/viewAllWorkoutPlans.html`;
        }
      }
}

/**
 * Main method to run when the page contents have loaded.
 */
 const main = async () => {
    const createWorkoutPlan = new CreateWorkoutPlan();
    createWorkoutPlan.mount();
 }

 window.addEventListener('DOMContentLoaded', main);