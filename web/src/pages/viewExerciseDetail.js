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
        this.bindClassMethods(['clientLoaded', 'mount', 'displayExerciseDetails' ], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayExerciseDetails);
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
       // document.getElementById('update-department').addEventListener('click', async evt => {
                        // console.log('The element that was clicked was ', deptId);
                           // window.location.href = `/update_department.html?id=${deptId}`;
                        //  });

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
     * Display workout plan details  on the page.
     */
    displayExerciseDetails() {
        const exerciseDetail = this.dataStore.get('exerciseDetail');

        if (!exerciseDetail) {
            return;
        }
        if (exerciseDetail.exerciseId){
            document.getElementById('exerciseId').innerHTML = exerciseDetail.exerciseId;
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
