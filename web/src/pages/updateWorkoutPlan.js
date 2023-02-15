import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class UpdateWorkoutPlan extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayWorkoutPlanDetails', 'update',  'loadExerciseDropDown', 'loadExerciseDropDown2', 'loadExerciseDropDown3', 'loadExerciseDropDown4', 'redirectToViewWorkoutPlans', ], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
    }

    /**
     * Once the client is loaded, get the exercise details.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const workoutPlanId = urlParams.get('id');
        this.dataStore.set('workoutPlanId', workoutPlanId);
        const workoutPlanDetail = await this.client.getWorkoutPlan(workoutPlanId);
        this.dataStore.set('workoutPlanDetail', workoutPlanDetail);
        this.loadExerciseDropDown();
        this.loadExerciseDropDown2();
        this.loadExerciseDropDown3();
        this.loadExerciseDropDown4();
        this.displayWorkoutPlanDetails();
    }

   /**
     * Add the header to the page and load the FitNSSClient.
     */
    async mount() {
        document.getElementById('save-workoutplan').addEventListener('click', this.update);
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
     * Display workout plan details  on the page.
     */
    displayWorkoutPlanDetails() {
        const workoutplanDetail = this.dataStore.get('workoutplanDetail');

        if (!workoutplanDetail) {
            return;
        }
        if (workoutplanDetail.workoutPlanId){
            document.getElementById('workoutPlanId').value = workoutplanDetail.workoutPlanId;
        }
        if (workoutplanDetail.workoutDayName){
            document.getElementById('workoutDayName').value = workoutplanDetail.workoutDayName;
        }
        if (workoutplanDetail.notesBox){
            document.getElementById('notesBox').value = workoutplanDetail.notesBox;
            }
        }

 /**
        * Method to run when the create Workout plan submit button is pressed. Call the FitNSSClient to
        * create the Exercise.
     */
     async update() {
        const workoutDayName = document.getElementById('workoutDayName').value;
        const exerciseList = document.getElementById('exercisesList');
        const exerciseId = document.getElementById('exercisesList').value;
        const exerciseName = exerciseList.options[exerciseList.selectedIndex].innerHTML;

        const exerciseList2 = document.getElementById('exercisesList2');
        const exerciseId2 = document.getElementById('exercisesList2').value;
        const exerciseName2 = exerciseList2.options[exerciseList2.selectedIndex].innerHTML;

        const exerciseList3 = document.getElementById('exercisesList3');
        const exerciseId3 = document.getElementById('exercisesList3').value;
        const exerciseName3 = exerciseList3.options[exerciseList3.selectedIndex].innerHTML;

        const exerciseList4 = document.getElementById('exercisesList4');
        const exerciseId4 = document.getElementById('exercisesList4').value;
        const exerciseName4 = exerciseList4.options[exerciseList4.selectedIndex].innerHTML;

        const numberOfSets = document.getElementById('numberOfSets').value;
        const numberOfSets2 = document.getElementById('numberOfSets2').value;
        const numberOfSets3 = document.getElementById('numberOfSets3').value;
        const numberOfSets4 = document.getElementById('numberOfSets4').value;

        const numberOfReps = document.getElementById('numberOfReps').value;
        const numberOfReps2 = document.getElementById('numberOfReps2').value;
        const numberOfReps3 = document.getElementById('numberOfReps3').value;
        const numberOfReps4 = document.getElementById('numberOfReps4').value;

        const numberOfWeights = document.getElementById('numberOfWeights').value;
        const numberOfWeights2 = document.getElementById('numberOfWeights2').value;
        const numberOfWeights3 = document.getElementById('numberOfWeights3').value;
        const numberOfWeights4 = document.getElementById('numberOfWeights4').value;

        const notesBox = document.getElementById('notesBox').value;

        var eList = [exerciseName, exerciseName2, exerciseName3, exerciseName4];
        var setList = [numberOfSets, numberOfSets2, numberOfSets3, numberOfSets4];
        var repList = [numberOfReps, numberOfReps2, numberOfReps3, numberOfReps4];
        var weightList = [numberOfWeights, numberOfWeights2, numberOfWeights3, numberOfWeights4];

        let payload = {workoutDayName: workoutDayName}

        //payload.exerciseId = exerciseId;
        payload.exercisesAdded = eList;
        payload.numberOfSets = setList;
        payload.numberOfReps = repList;
        payload.numberOfWeights = weightList;
        payload.notesBox = notesBox;

        // UNABLE TO DESERIALIZE THINK I HAVE TO MAKE ARRAYLISTS FOR THEM?


        document.getElementById('save-workoutplan').disabled = true;
        document.getElementById('save-workoutplan').innerHTML = 'Saving Workout...';
        document.getElementById('save-workoutplan').style.background='grey';
        let workoutPlanData = this.dataStore.get('workoutPlanDetail');
        const workoutplan = await this.client.updateWorkoutPlan(workoutPlanData.workoutPlanId, payload);
        this.dataStore.set('workoutplan', workoutplan);
        this.redirectToViewWorkoutPlans();
     }

     /**
      * When the Workout is updated in the datastore, redirect to the view Workout Plan page.
      */
      redirectToViewWorkoutPlans() {
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
      const updateWorkoutPlan = new UpdateWorkoutPlan();
      updateWorkoutPlan.mount();
  };

window.addEventListener('DOMContentLoaded', main);

