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
        document.getElementById('workoutList').innerText = "(Loading workout plan list...)";
        const workoutList = await this.client.getAllWorkoutPlans();
        this.dataStore.set('workoutList', workoutList)
    }

/**
 * Add the header to the page and load the FitNSSClient.
 */
    async mount() {
        this.header.addHeaderToPage();
        this.header.loadData();
        this.client = new FitNSSClient();
        await this.clientLoaded();
    }

    async generateList(newList, data) {
        if (data.length != 0) {
            for (let element of data) {
               let row = newList.insertRow();

               row.addEventListener('click', async evt => {
                    window.location.href = '/view_workoutPlan.html?id=${element.workoutPlanId}';
               });

               let cell = row.insertCell();
               let text = document.createTextNode(element.workoutPlanId);
               cell.appendChild(text);

               cell = row.insertCell();
               text = document.createTextNode(element.workoutPlanName);
               cell.appendChild(text);
            }
        }
    }
/**
 * When the workout plans are updated in the datastore, update the list of workout plans on the page.
 */
    async displayWorkoutPlansOnPage() {
        const workoutList = this.dataStore.get('workoutList');

        if (!workoutList) {
            return;
            }

        let newList = document.querySelector("newList");

        this.generateList(newList, workoutList);
        document.getElementById('workoutList').innerText = "";

        if (workoutList.length === 0) {
            document.getElementById('workoutList').innerText = "(No Workout Plans found...)";
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewDepartments = new ViewWorkoutPlans();
    await viewDepartments.mount();
};


window.addEventListener('DOMContentLoaded', main);