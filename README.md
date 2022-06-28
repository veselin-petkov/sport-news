# SportNews

Full stack website for sporting news built with ReactJS, Spring, and MySQL.

Note: This is the backend part of the project. To view the frontend [click here.](https://git.trading212.io/trading212-bootcamp-cohort-apr-2022/m02/)

## Features
- Create, update, and delete news 
- Create and delete custom categories
- Create and delete entry tags
- User roles restrictions

### Technical features
- JWT authentication
- REST API
- Uploading images through Google Firebase
- Using SofaScore's API to display LiveScores  
- ReactJS Front-end

## Screenshots


## Installation
If you want to run the project via Docker you can visit the DockerHub page [click here](https://hub.docker.com/repository/docker/veselinpetkov/sportsnews) .
And if you want to check the ReactJS Front-end you can [click here]().

--Otherwise--
1. Clone this repository

2. Set up a MySQL server and execute ```sportsnews.sql``` to create the database

3. Edit the config file ```src/main/resiyrces/application.properties``` to point to your MySQL server

4. Build with java 17 and run

## Authors and acknowledgment
The project was built by Veselin Petkov with the help of other fellow bootcamp colleagues.

## License
MIT License

## Project status
The project is in a working state but other features were planned which could not be implemented at this point.
Such features are:
- Reporting users and sellers who are trying to scam others
- Admin panel where admins can check out reports and contact possible michevous users
- Search bar to find posts based on keywords which might be included in the description or title