# spring-mvc-notes

#### To run the application you have to the following MySQL database.
Name it however you want, make sure you change the database name in ``application.properties``.

###### notes 
``user_id : bigint`` <br/>
``id : bigint, autoincrement`` <br/>
``content : text``<br/>
``title: varchar(40)``<br/>
``creation_date : date``

###### users
``id : bigint, autoincrement`` <br/>
``username : varchar(45)`` <br/>
``password : varchar(60)``<br/>
``first_name : varchar(30)``<br/>
``last_name : varchar(30)``