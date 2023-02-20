import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view exercise page of the website.
 */

class ViewExerciseDetail extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayExerciseDetails', 'deleteExerciseFromTable' ], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayExerciseDetails);
        document.getElementById('delete-exercise').addEventListener('click', this.deleteExerciseFromTable);
        this.header = new Header(this.dataStore);
    }

 /**
     * Once the client is loaded, get the workout plan details.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const exerciseId = urlParams.get('id');
        document.getElementById('exercise_loading').innerHTML = "(Loading exercise details...)";

        const exerciseDetail = await this.client.getExercise(exerciseId);
        this.dataStore.set('exerciseDetail', exerciseDetail);
        document.getElementById('update-exercise').addEventListener('click', async evt => {
                         console.log('The element that was clicked was ', exerciseId);
                            window.location.href = `/updateExercise.html?id=${exerciseId}`;
                          });

        document.getElementById('exercise_loading').innerHTML = "";
    }

    /**
     * Add the header to the page and load the FitNSSClient.
     */
    async mount() {
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
            document.getElementById('exerciseName').innerHTML = exerciseDetail.exerciseName;
        }
        if (exerciseDetail.workingMuscle){
            document.getElementById('workingMuscle').innerHTML = exerciseDetail.workingMuscle;
        }
        if (exerciseDetail.exerciseMovementGroup){
            document.getElementById('exerciseMovementGroup').innerHTML = exerciseDetail.exerciseMovementGroup;
            }
        if (exerciseDetail.userId){
            document.getElementById('userId').innerHTML = exerciseDetail.userId;
            }
        }

    async deleteExerciseFromTable() {
            const urlParams = new URLSearchParams(window.location.search);
            const exerciseId = urlParams.get('id');

            document.getElementById('delete-exercise').disabled = true;
            document.getElementById('delete-exercise').value = 'Deleting Exercise...';
            document.getElementById('delete-exercise').style.background='grey';

            const exercise = await this.client.deleteExercise(exerciseId);
            if (exercise) {
                window.location.href = `/viewAllExercises.html`;
            }
    }
}







/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewExerciseDetail = new ViewExerciseDetail();
    await viewExerciseDetail.mount();
};

window.addEventListener('DOMContentLoaded', main);
