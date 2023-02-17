import FitNSSClient from '../api/fitnssclient';
import Header from '../components/header';
import BindingClass from "../util/bindingClass";
import DataStore from "../util/DataStore";

/**
 * Logic needed for the view workout plan page of the website.
 */

class ViewAllExercises extends BindingClass {

    constructor() {
        super();
        this.bindClassMethods(['clientLoaded', 'mount', 'displayExercisesOnPage', 'generateTable', ], this);
        this.dataStore = new DataStore();
        this.dataStore.addChangeListener(this.displayExercisesOnPage);
        this.header = new Header(this.dataStore);
    }

    /**
        * Once the client is loaded, get the workout plan list.
        */
        async clientLoaded() {
            document.getElementById('exerciseList').innerText = "(Loading Exercise List...)";
            const exerciseList = await this.client.getAllExercises();
            this.dataStore.set('exerciseList', exerciseList);
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
     * When the exercises are updated in the datastore, update the list of exercises on the page.
     */
    async displayExercisesOnPage() {
        const exerciseList = this.dataStore.get('exerciseList');
        console.log(exerciseList);

        if (!exerciseList) {
        return;
        }

       let table = document.querySelector("table");

       //Flush the table first
       var tableHeaderRowCount = 1;
       var rowCount = table.rows.length;
       for (var i = tableHeaderRowCount; i < rowCount; i++) {
        table.deleteRow(tableHeaderRowCount);
        }
        //Generate table data with the new set of exercises
        this.generateTable(table, exerciseList);
        document.getElementById('exerciseList').innerText = "";

        if (exerciseList.length === 0) {
            document.getElementById('exerciseList').innerText = "(No Exercises found ..)";
        }
 }

    async generateTable(table, data) {

        if (data.length != 0) {
            for (let element of data) {

                let row = table.insertRow();

                row.addEventListener('click', async evt => {
                                        window.location.href = `/viewSingleExercise.html?id=${element.exerciseId}`;
                                      });

                let cell = row.insertCell();
                let text = document.createTextNode(element.userId);
                cell.appendChild(text);

                cell = row.insertCell();
                text = document.createTextNode(element.exerciseName);
                cell.appendChild(text);

            }
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const viewAllExercises = new ViewAllExercises();
    await viewAllExercises.mount();
};



window.addEventListener('DOMContentLoaded', main);

