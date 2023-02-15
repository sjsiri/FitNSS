import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class ViewWorkoutPlanDetail extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayWorkoutPlanDetails' ], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayWorkoutPlanDetails);
        this.header = new Header(this.dataStore);
    }

 /**
     * Once the client is loaded, get the workout plan details.
     */
    async clientLoaded() {
        const urlParams = new URLSearchParams(window.location.search);
        const workoutPlanId = urlParams.get('id');
        document.getElementById('workoutPlan_loading').innerHTML = "(Loading Workout plan details...)";

        const workoutplanDetail = await this.client.getWorkoutPlan(workoutPlanId);
        this.dataStore.set('workoutplanDetail', workoutplanDetail);
       document.getElementById('update-workout').addEventListener('click', async evt => {
                                console.log('The element that was clicked was ', workoutPlanId);
                                   window.location.href = `/updateWorkoutPlan.html?id=${workoutPlanId}`;
                                 });

        document.getElementById('workoutPlan_loading').innerHTML = "";
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
    displayWorkoutPlanDetails() {
        const workoutplanDetail = this.dataStore.get('workoutplanDetail');

        if (!workoutplanDetail) {
            return;
        }
        if (workoutplanDetail.workoutPlanId){
            document.getElementById('workoutPlanId').innerHTML = workoutplanDetail.workoutPlanId;
        }
        if (workoutplanDetail.workoutDayName){
            document.getElementById('workoutDayName').innerHTML = workoutplanDetail.workoutDayName;
        }
        if (workoutplanDetail.exercisesAdded){
            document.getElementById('exercisesAdded').innerHTML = workoutplanDetail.exercisesAdded;
        }
        if (workoutplanDetail.numberOfSets){
            document.getElementById('numberOfSets').innerHTML = workoutplanDetail.numberOfSets;
            }
        if (workoutplanDetail.numberOfReps){
           document.getElementById('numberOfReps').innerHTML = workoutplanDetail.numberOfReps;
           }
        if (workoutplanDetail.numberOfWeights){
            document.getElementById('numberOfWeights').innerHTML = workoutplanDetail.numberOfWeights;
            }
        if (workoutplanDetail.notesBox){
            document.getElementById('notesBox').innerHTML = workoutplanDetail.notesBox;
            }
        if (workoutplanDetail.userId){
            document.getElementById('userId').innerHTML = workoutplanDetail.userId;
            }
        }

 }




/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewWorkoutPlanDetail = new ViewWorkoutPlanDetail();
    await viewWorkoutPlanDetail.mount();
};

window.addEventListener('DOMContentLoaded', main);