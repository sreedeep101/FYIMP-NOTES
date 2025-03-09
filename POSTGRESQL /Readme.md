# PSQL
<b><ul>
  <li> \l => it is used to list databases. </li>
  <li> \c => it is used to change/switch databases. </li>
  <li> \d => used to see relations in the DB.</li>
</ul> 

## HOW TO CREATE DATABASES
 <br><br>
 To create database  we use the syntax,
 <br><br>
 CREATE DATABASE database-name ;    
 <br><br>
 
## HOW TO CREATE TABLE
<br><br>
 To create table  we use the syntax,
 <br><br>
 CREATE TABLE table-name (columnname1 datatype another-constraints , columnname2 datatype another-constraints  );   
 <br><br>
 ### Example :<br><br>? create a department table with 2column first is it's ID and the second column cotain department name ??
 Syntax ;<br>
 CREATE TABLE department ( dept_id INT PRIMARY KEY,dept_name VARCHAR(50) NOT NULL);
 <ul>
   <br>
   Here ,<br>
  <li>  dept_id & dept_name=> column name</li>
  <li>  INT & VARCHAR=> It is the datatype </li>
  <li>  PRIMARY KEY & NOT NULL=> another constrains so here 'NOT NULL' is used to say that the dept_name column not be empty & 'PRIMARY KEY this make the dept_id column as the primary key </li>
</ul> 
 </b>


 
