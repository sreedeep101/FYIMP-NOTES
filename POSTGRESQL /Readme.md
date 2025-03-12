
### HOW TO INSTALL AND START PSQL IN UBUNTU.
##### To Install 
<b>sudo apt install postgresql postgresql-contrib -y
##### To Check status 
sudo systemctl status postgresql
##### To start and enable psql
sudo systemctl start postgresql
<br><br>
sudo systemctl enable postgresql
##### To Switch To User
<ol>
  <li>sudo -i -u postgres (used to switch into user postgres)</li>
  <li>Now enter into psql shell we can use the command 'psql'</li>
  <li>\q => used to quit from psql shell</li>
  <li>exit => used to exit from user</li>
</ol>



# PSQL
<ul>
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
<br>
<pre>
👉INSERT INTO --> It is used to insert datas into a table
  
  Syntax:
      INSERT INTO table_name (col_name1,col_name2,col_name3,...,col_namen) VALUES ('value1','value2','value3',...,'valuen');




👉SELECT -->used to retrieve data from a database.

   Syntax for retrieving a table;
           SELECT * FROM table;



           
👉KEY WORDS USED TO SEARCH or FILTER and SORTHING
               |
               |---WHERE
               |      |--SEARCHING KEY WORDS Used with or without WHERE
               |                 |
               |                 |--BETWEEN
               |                 |
               |                 |--OR / AND / NOT
               |                 |
               |                 |--IN / NOT IN
               |                 |
               |                 |--IS NULL
               |                 |
               |                 |--LIKE (pattern serching key used with like)
               |                 |              |
               |                                |-- % (to represent any number of characters from 0 to n)
               |                                |
               |                                |-- _ (to represent one charecter)
               |                               
               |                 
               |                 
               |                 
               |--ORDER BY                 
               |
               |--DISTINCT
               | 
               |--GROUP BY
               |
               |
               |
               |
               |





👉Constraints 
       |
       |---NOT NULL
       |        |
       |        |-- To add NOT NULL CONSTRAINT in already existing TABLE column 
       |        |           ALTER TABLE table_name MODIFY col_name NOT NULL;
       |   
       |---UNIQUE
       |       |
       |       |--To Add UNIQUE constraints in already existing table column 
       |       |    ALTER TABLE table_name ADD CONSTRAINTS name_of_constraint UNIQUE (col_name);
       |
       |---PRIMARY KEY
       |
       |---FORIEN KEY





👉DELETE
   Syntax: 
       DELETE FROM table_name WHERE col_name = "value" ;
</pre>


 </b>
 


 
