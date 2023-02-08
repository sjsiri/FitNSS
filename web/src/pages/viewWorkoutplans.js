import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class ViewWorkoutPlans extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayWorkoutPlansOnPage',], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayWorkoutPlansOnPage);
        this.header = new Header(this.dataStore);
    }

/**
    * Once the client is loaded, get the workout plan list.
    */
    async clientLoaded() {
        document.getElementById('workoutplan').innerText = "(Loading Workout Plan List...)";
        const workoutplan = await this.client.getAllWorkoutPlans();
        this.dataStore.set('workoutplan', workoutplan);
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
     * When the workouts are updated in the datastore, update the list of workouts on the page.
     */
    async displayWorkoutPlansOnPage() {
        const workoutplan = this.dataStore.get('workoutplan');

        if (workoutplan == null) {
        return;
        }

        let workoutplanHTML = '';
        let workouts;
        for (workouts of workoutplan) {
            workoutplanHTML += `
            <li class="workoutplan">
            <span class="workoutDayName">$(workouts.workoutDayName)</span>
            </li>
            `;
        }
    document.getElementById('workoutplan').innerHTML = songHtml;
 }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewWorkoutPlans = new ViewWorkoutPlans();
    await viewWorkoutPlans.mount();
};



window.addEventListener('DOMContentLoaded', main);