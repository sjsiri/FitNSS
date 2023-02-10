import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class UpdateExercise extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayExerciseDetails', 'update', 'redirectToViewExercise', ], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
    }



 /**
     * Once the client is loaded, get the exercise details.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const exerciseId = urlParams.get('id');
        this.dataStore.set('exerciseId', exerciseId);
        const exerciseDetail = await this.client.getExercise(exerciseId);
        this.dataStore.set('exerciseDetail', exerciseDetail);
        this.displayExerciseDetails();
    }


    /**
     * Add the header to the page and load the FitNSSClient.
     */
    async mount() {
        document.getElementById('save-exercise').addEventListener('click', this.update);
        this.header.addHeaderToPage();
        this.client = new FitNSSClient();
        await this.clientLoaded();
    }

  /**
      * Display exercise details  on the page.
      */
     displayExerciseDetails() {
         const exerciseDetail = this.dataStore.get('exerciseDetail');

         if (!exerciseDetail) {
             return;
         }

         if (exerciseDetail.exerciseName){
             document.getElementById('exerciseName').value = exerciseDetail.exerciseName;
         }
         if (exerciseDetail.workingMuscle){
             document.getElementById('workingMuscle').value = exerciseDetail.workingMuscle;
         }
         if (exerciseDetail.exerciseMovementGroup){
             document.getElementById('exerciseMovementGroup').value = exerciseDetail.exerciseMovementGroup;
             }
         }

     async update() {
          const exerciseId = this.dataStore.get('exerciseId');
          const exerciseName = document.getElementById('exerciseName').value;
          const workingMuscle = document.getElementById('workingMuscle').value;
          const exerciseMovementGroup = document.getElementById('exerciseMovementGroup').value;

          if (!exerciseName || !workingMuscle || !exerciseMovementGroup) {
                alert("Please fill in all required fields");
                return;
            }

         const exercise = {
            exerciseId,
            exerciseName,
            workingMuscle,
            exerciseMovementGroup };

         const exerciseUpdated = await this.client.updateExercise(exercise);
         this.dataStore.set('exercise', exerciseUpdated);
         document.getElementById('save-exercise').disabled = true;
         document.getElementById('save-exercise').innerHTML = 'Saving Exercise...';
         document.getElementById('save-exercise').style.background='grey';
         this.redirectToViewExercise();
      }

      /**
       * When the Exercise is updated in the datastore, redirect to the view Exercise page.
       */
      redirectToViewExercise() {
              window.location.href = `/viewAllExercises.html`;
          }
      

}
       /**
       * Main method to run when the page contents have loaded.
       */
          const main = async () => {
              const updateExercise = new UpdateExercise();
              updateExercise.mount();
          };

    window.addEventListener('DOMContentLoaded', main);

