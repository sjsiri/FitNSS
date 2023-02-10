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
        this.bindClassMethods(['clientLoaded', 'mount', 'loadExerciseDropDown', 'submit', 'redirectToViewWorkoutPlan', ], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
    }

    async clientLoaded() {
        this.loadExerciseDropDown();
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

     /**
        * Method to run when the create Workout plan submit button is pressed. Call the FitNSSClient to
        * create the Exercise.
     */
     async submit() {
        const workoutDayName = document.getElementById('workoutDayName').value;
        const exerciseList = document.getElementById('exercisesList');
        const exerciseId = document.getElementById('exercisesList').value;
        const exerciseName = exerciseList.options[exerciseList.selectedIndex].innerHTML;
        const numberOfSets = document.getElementById('numberOfSets').value;
        const numberOfReps = document.getElementById('numberOfReps').value;
        const numberOfWeights = document.getElementById('numberOfWeights').value;
        const notesBox = document.getElementById('notesBox').value;

        let payload = {workoutDayName: workoutDayName}

        //payload.exerciseId = exerciseId;
        payload.exerciseAdded = new Array(exerciseName);
        payload.numberOfSets = new Array(numberOfSets);
        payload.numberOfReps = new Array(numberOfReps);
        payload.numberOfWeights = new Array(numberOfWeights);
        payload.notesBox = notesBox;

        // UNABLE TO DESERIALIZE THINK I HAVE TO MAKE ARRAYLISTS FOR THEM?


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