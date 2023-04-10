<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->




<!-- PROJECT LOGO -->
<br />
<div align="center">
  <img src="https://i.imgur.com/yp6g0ba.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">FitNSS</h3>

  <p align="center">
    The FitNSS app is a tool that supports users to create their own workout plans with using exercises that are in the database or created by others.
    <br />
  </p>  

</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project
The FitNSS application is for people who want a way to keep a log of their workouts. It allows the user to create multiple workout plans or view other users workout plans in the database. The workout plans uses data created by users that keeps track of all the exercises that were created in it.

<img src="https://i.imgur.com/qc2DPO1.png">
<img src="https://i.imgur.com/yr7jR1u.png">
<img src="https://i.imgur.com/kCjYOAd.png">
<img src="https://i.imgur.com/5DK1IfQ.png">

### Features
U1. Be able to view all exercises in the database.

U2. Be able to create workout plans by adding the exercises into it.

U3. Create a new exercise and add that to the database.

U4. Update the number of Sets,Reps, and weight.

U5. Be able to delete an exercise from the database.

U6. Be able to view the log of the workout plan that was created with the number of exercises, sets, reps, and weights added in.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With
<img src="https://github.com/lafleurss/employee-management-app/raw/main/resources/images/architecture_diagram.png">

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Getting Started

The following instructions will guide you on setting up and running the project locally.

### Prerequisites and Installation

1. Create or use an existing Amazon AWS account
2. Install the latest version of AWS CLI [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
3. Install the latest version of AWS SAM CLI [AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)
4. Install Docker [Docker](https://docs.docker.com/get-docker/)
5. Install NodeJS to be able to run `npm` commands

- On Windows / WSL:
```shell
curl -fsSL https://deb.nodesource.com/setup_18.x | sudo -E bash - &&\
sudo apt-get install -y nodejs
```
- On macOS:
```shell
brew install node
```

### Run Locally
1. **DATA** 
Create some sample data: `aws dynamodb batch-write-item --request-items file://data/data.json`

2. **BACKEND**: Run the Lambda service
    - Build the Java code: `sam build`
    - Create an S3 bucket: `aws s3 mb s3://YOUR_BUCKET`
    - Deploy the SAM template: `sam deploy --s3-bucket BUCKET_FROM_ABOVE --parameter-overrides S3Bucket=BUCKET_FROM_ABOVE FrontendDeployment=local`
    - Run the local API: `sam local start-api --warm-containers LAZY`
   
3. **FRONTEND**: Run a local web server (aka the frontend):
    - CD into the web directory: `cd web`
    - Install dependencies : `npm install`
    - Run the local server: `npm run run-local`


After doing all of this, you will have a server running on port `8000` - you can access it by going to [http://localhost:8000](http://localhost:8000) in your browser.

To stop either the local backend (the `sam local...` command) or local frontend (the `npm run...`) command, simply press `Ctrl-C` in the terminal where the process is running.

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Surinh Jack Siri - [Email](surinhjs@gmail.com) - [LinkedIn](https://www.linkedin.com/in/surinhsiri/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

* []() Nashville Software School for supporting me in my journey of lifelong learning
* []() Instructors Andy Collins and Charlie Penner for their endless patience, wisdom and guidance

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Talkon2000/EmployeeManagementClient.svg?style=for-the-badge
[contributors-url]: https://github.com/talkon2000/EmployeeManagementClient/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Talkon2000/EmployeeManagementClient.svg?style=for-the-badge
[forks-url]: https://github.com/talkon2000/EmployeeManagementClient/network/members
[stars-shield]: https://img.shields.io/github/stars/talkon2000/EmployeeManagementClient.svg?style=for-the-badge
[stars-url]: https://github.com/talkon2000/EmployeeManagementClient/stargazers
[issues-shield]: https://img.shields.io/github/issues/Talkon2000/EmployeeManagementClient.svg?style=for-the-badge
[issues-url]: https://github.com/Talkon2000/EmployeeManagementClient/issues
[license-shield]: https://img.shields.io/github/license/Talkon2000/EmployeeManagementClient.svg?style=for-the-badge
[license-url]: https://github.com/Talkon2000/EmployeeManagementClient/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: resources/images/employee-management-client.png
[architecture diagram]: resources/images/architecture_diagram.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
