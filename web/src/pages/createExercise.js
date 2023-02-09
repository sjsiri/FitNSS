import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class CreateExercise extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['mount', 'submit', 'redirectToViewExercise', ], this);
        this.dataStore = new DataStore();
        this.header = new Header(this.dataStore);
    }

   /**
     * Add the header to the page and load the FitNSSClient.
     */
    async mount() {
        document.getElementById('save-exercise').addEventListener('click', this.submit);
        this.header.addHeaderToPage();
        this.client = new FitNSSClient();
    }

    /**
         * Method to run when the create Exercise submit button is pressed. Call the FitNSSClient to create the
         * Exercise.
         */
        async submit() {
            const exerciseName = document.getElementById('exerciseName').value;
            const workingMuscle = document.getElementById('workingMuscle').value;
            const exerciseMovementGroup = document.getElementById('exerciseMovementGroup').value;


            if (!exerciseName || !workingMuscle || !exerciseMovementGroup) {
                alert("Please fill in all required fields");
                return;
            }

            let payload = {exerciseName: exerciseName, workingMuscle: workingMuscle, exerciseMovementGroup: exerciseMovementGroup}


            document.getElementById('save-exercise').disabled = true;
            document.getElementById('save-exercise').innerHTML = 'Saving Exercise...';
            document.getElementById('save-exercise').style.background='grey';
            const exercise = await this.client.createExercise(payload);
            this.dataStore.set('exercise', exercise);
            this.redirectToViewExercise();
        }

        /**
         * When the Exercise is updated in the datastore, redirect to the view Exercise page.
         */
        redirectToViewExercise() {
            const exercise = this.dataStore.get('exercise');
            if (exercise) {
                window.location.href = `/viewAllExercises.html`;
            }
        }
    }

    /**
     * Main method to run when the page contents have loaded.
     */
    const main = async () => {
        const createExercise = new CreateExercise();
        createExercise.mount();
    };

    window.addEventListener('DOMContentLoaded', main);