
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
</pre>


<pre>
👉SELECT -->used to retrieve data from a database.

   Syntax for retrieving a table;
           SELECT * FROM table;
           
### MORE ABOUT SELECT Command 
      |
      |
      |--used to Fetching Data → Extracts data from tables.
      |      Syntax : SELECT * FROM table-name;
      |
      |--used to Filtering Data → Retrieves specific records using "WHERE".
      |      Syntax : SELECT * FROM table-name WHERE column-name = 'value'; 
      |
      |--Sorting Data → Uses "ORDER BY" to sort results.             
      |     Syntax : SELECT * FROM table-name ORDER BY any-column DESC;
      |                                                              |   | DESC is used to order in descending order. |  
      |                                                              |---| we can also use ASC to make it in ascending|
      |                                                                  | order (ASC is the default order)           |
      |
      |--Aggregating Data → Uses functions like SUM(), AVG(), COUNT().
      |     Syntax : SELECT COUNT(*) FROM table-name;
      |
      |--Joining Tables → Combines data from multiple tables.
      |      Syntax : SELECT x.column-name-in-the-first-table, y.column-name-in-the-second-table
      |               FROM name-of-table1-that-fist-column-belongs x 
      |              JOIN name-of-table2-that-second-column-belongs y ON x.Forien-KEY-intable1 = y.PRIMARY-KEY-table-2;
      |        +------------------------------------------------------------------------------------------------------+
      |        |     Examble : if i have two table named as "products", "suppliers" and "prod_name"&"sup_name" are the|
      |        |               respective column and "sup_id" is the FORIEN KEY in table "products" and "supply_id"is |
      |        |               the PRIMARY-KEY in table "suppliers" then the syntax become.                           |
      |        |                                                                                                      |
      |        |               SELECT p.prod_name, s.sup_name                                                         |
      |        |               FROM products p                                                                        |
      |        |               JOIN suppliers s ON p.sup_id = s.supply_id;                                            |
      |        +------------------------------------------------------------------------------------------------------+
      |
      |--Grouping Data → Uses "GROUP BY" for summary reports.
      |       Syntax : SELECT col_name, COUNT(*) FROM table-name GROUP BY col-name;
      |
</pre>

<pre>           
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
</pre>


<pre>
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

</pre>

<pre>
👉DELETE
   Syntax 01: 
       DELETE FROM table_name WHERE col_name = "value" ;  ( it is used to deleate a specific row in the table)
   Syntax 02:
       DELETE FROM table_name; ( it is used to delete all rows but keep the structure)

  📝Note : we can also use "TRUNCATE" command insted of 'DELETE' to remove all rows faster
           Syntax : TRUNCATE TABLE table_name;
</pre>

<pre>
  👉DROP => It is used to delete entire table(including it's structure) , Database , users , constraints,etc ...
     
  
</pre>

 </b>
 


 
