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
        this.bindClassMethods(['clientLoaded', 'mount', 'displayWorkoutPlansOnPage', 'generateTable', ], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayWorkoutPlansOnPage);
        this.header = new Header(this.dataStore);
    }

/**
    * Once the client is loaded, get the workout plan list.
    */
    async clientLoaded() {
        document.getElementById('workoutplans').innerText = "(Loading Workout Plan List...)";
        const workoutplans = await this.client.getAllWorkoutPlans();
        this.dataStore.set('workoutplans', workoutplans);
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
        const workoutplans = this.dataStore.get('workoutplans');

        if (!workoutplans) {
        return;
        }

       let table = document.querySelector("table");

       //Flush the table first
       var tableHeaderRowCount = 1;
       var rowCount = table.rows.length;
       for (var i = tableHeaderRowCount; i < rowCount; i++) {
        table.deleteRow(tableHeaderRowCount);
        }
        //Generate table data with the new set of workouts
        this.generateTable(table, workoutplans);
        document.getElementById('workoutplans').innerText = "";

        if (workoutplans.length === 0) {
            document.getElementById('workoutplans').innerText = "(No workouts found ..)";
        }
 }

    async generateTable(table, data) {

        if (data.length != 0) {
            for (let element of data) {

                let row = table.insertRow();

                let cell = row.insertCell();
                let text = document.createTextNode(element.workoutDayName);
                cell.appendChild(text);
                console.log(text);
            }
        }
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