## Java Practical Questions – Inheritance, Interfaces, Packages & Exception Handling

#### 1. Method Overriding 
```
Write a Java program to create a superclass Animal with a method sound(). Create
subclasses Dog and Cat that override the sound() method. Display the appropriate sound for
each animal.

```
<a href="./Prog01.java">Code</a>

##### Output : 
<img width="750" height="101" alt="image" src="https://github.com/user-attachments/assets/eb171b49-6237-4a50-bcab-b0868bc9910d" />


#### 2. Dynamic Method Dispatch
```
Write a Java program to demonstrate dynamic method dispatch using a superclass Shape
and subclasses Circle and Rectangle. Override the draw() method in each subclass and
invoke it using a superclass reference.
```
<a href="./Prog02.java">Code</a>

<img width="861" height="82" alt="image" src="https://github.com/user-attachments/assets/6fcdea6e-7e84-4725-9d79-daba6c2136c8" />


#### 3. Abstract Class
```
Write a Java program to create an abstract class Vehicle containing an abstract method
start() and a concrete method display(). Create subclasses Car and Bike and implement the
start() method in each subclass.
```
<a href="./Prog03.java">Code</a>

<img width="735" height="125" alt="image" src="https://github.com/user-attachments/assets/332960ce-68ba-4cdf-81e4-3c489e362638" />

#### 4. Defining and Implementing an Interface
```
Define an interface Printable with a method print(). Create classes Student and Teacher that
implement the interface. Write a program to display the details of a student and a teacher
using the print() method.
```
<a href="./Prog04.java">Code</a>

<img width="761" height="229" alt="image" src="https://github.com/user-attachments/assets/20d9a230-1a69-4e7d-aa4b-1c9439d4cc1b" />


#### 5. Multiple Interfaces
```
Write a Java program to demonstrate the implementation of multiple interfaces. Define
interfaces Sports and Academics, each containing one method. Create a class Student that
implements both interfaces and displays the student's academic and sports information.
```
<a href="./Prog05.java">Code</a>
<img width="844" height="206" alt="image" src="https://github.com/user-attachments/assets/b50a3e19-4c5b-4478-96e5-e26fede4dac3" />

#### 6. Packages – Declaring and Importing a Package
```
Create a package named college containing a class Student with a method to display student
details. Write another Java program outside the package to import the college package and
access the Student class.
```
<a href="./college/Student.java">package code</a>
<br/>
<a href="./Prog06.java">package importing Code</a>
<img width="846" height="206" alt="image" src="https://github.com/user-attachments/assets/d8a87665-b4be-4e49-ad92-d26d9159c8eb" />

#### 7. Sub-packages
```
Create a package structure college.department. Define a class ITStudent inside the
department sub-package with a method to display student information. Write another Java
program to import and use this class.
```
<a href="./Prog07.java">Code</a>

#### 8. try-catch Exception Handling
```
Write a Java program to accept two integers from the user and perform division. Use try-
catch to handle the ArithmeticException that occurs when the denominator is zero.
```
<a href="./Prog08.java">Code</a>
#### 9. throw and throws
```
Write a Java program to create a method checkAge(int age) that throws an exception using
the throw keyword when the age is less than 18. Declare the exception using throws and
handle it in the calling method.
```
<a href="./Prog09.java">Code</a>
#### 10. Multiple Exceptions and finally
```
Write a Java program that accepts an array index and performs an operation on an array.
Use try-catch to handle ArrayIndexOutOfBoundsException and another appropriate
exception. Use a finally block to display a message indicating that exception handling has
been completed.
```
<a href="./Prog10.java">Code</a>
