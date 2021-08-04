# Covid Vaccination Directory


## Table of Contents
1. [What is Covid Vaccination Directory](#what-is-covid-vaccination-directory)
2. [Author(s)](#authors)
3. [Stack](#stack)
4. [Description](#description)
5. [ER Diagram](#er-diagram)


## What is Covid Vaccination Directory
Covid Vaccination Portal is a Database web application that maintains the record of current vaccination data across US and individual user data about his vaccination records.

Designed in a way that the codebase can be easily extended and additional features such as analytics can be added.

## Authors
- Gnanamanickam Arumugaperumal
- Sharat Naik
- Ashwin Srivatsa

## Stack
- React.js
- Java Spring framework
- SQL database
- Tomcat Apache server

<!-- ## Features
- Dashboard 
- Authentication and Administration (Login and Authorizartion)
- Patient record entry form
- Eligibility Screening form
- RESTFul API Endpoints
- Zipcode Analytics -->

## Description

A user is signed into the portal and has a unique ID like (SSN), name, location and a phone number.
Each county or a district has different vaccination centers each of which has a unique ID, which records the track of people vaccinated, the dose of the vaccine and the stock of vaccination left.
A person can get the vaccine from any center but has to get the same 2 doses of vaccine.
Each vaccine has a unique number which can be used to track the person who has received the vaccine and the date they got the vaccine.
There is also information about the type of vaccine and the possible side effects caused by the vaccine in each dose. Finally the user can see  the states or the counties which have the highest vaccinations received.

## ER Diagram
![Screenshot 2021-07-06 at 10 39 32](https://github.com/diamalab/cs480---course-project-covid19_vaccination/blob/dev/Documentation/er%20-%20digram%20updated.png)

## Please refer to Project outline document under Documentation for detailed overview of the project.


<!-- ## How to build it?
1. Clone this repository in your local machine.
2. Install dependencies.
  ```
  pip install requirements.txt
  npm install
  ```
3. Make migrations and migrate the tables by running the following command:
  ```
  python core\manage.py migrate
  ```
4. Start the server by running the following command:
  ```
  python core\manange.py runserver
  ```
5. Open https://localhost:8000/ in browser to start using the Covid-Directory.
  

<!-- ![](https://komarev.com/ghpvc/?username=diamalab-cs480---course-project-covid19_vaccination&style=flat-square&color=blueviolet&label=Views) -->

