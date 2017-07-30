# TicketReservation

## NOTE: 
This project was created some time ago and looking at it now I am not satisfied with some decisions that I made during development.

This is why I have decide to create a new project with the same goal but I would like to use thing that I have learned that I did not know back then.

New project can be found [here](https://github.com/kolszewska/Ticket-reservation-v.2). 

Basic web application made for booking cinema tickets. 

## Technology:
- Maven
- Spring
- Apache Tomcat
- PostgreSQL

## What do you need?
- IntelliJ IDEA (Ultimate Edition)
- Apache Tomcat (8.5.6)
- PostgreSQL (9.6)

## How to make it work?
First you need to create a local database named `ticket_reservation`, to do that you need to open Postgres console (`psql`) and use the command below:

```
CREATE DATABASE ticket_reservation;
```
After cloning this repository, open it in IntelliJ. Now we have to configure Tomcat to be able to run our application.
To do that you need to:
- click Edit Configuration,
- add New Configuration,
- pick Tomcat Server (Local),
- configure Application Server (point it to your Tomcat folder).

Now you will get a warning saying :

> No artifacts marked fo development.

To resolve that just click 'Fix' button and select `TicketReservation:war`. Click Apply and finally OK.

Now the last step is to go to `/src/main/resources/application.properties` and fill:
- mailSender.username
- mailSender.password

Remember that you will have to use your real Gmail account.
If you run to any authentication problems follow the instructions [here](https://support.google.com/accounts/answer/6010255). 
