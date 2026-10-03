## Java Threads – Practice Questions
#### 1. Thread Life Cycle
```
Write a Java program that demonstrates the different stages of a thread’s life cycle. Create a
thread, start it, make it sleep for a specified period, and allow it to complete. Explain the
transition between the New, Runnable, Running, Waiting/Timed Waiting, and Terminated
states.
```
<a href=./Prog01.java>code</a>
<br/>
<img width="591" height="123" alt="image" src="https://github.com/user-attachments/assets/bbf9047e-b272-4847-b3ff-5ab4b1ef6d24" />


#### 2. Creating Threads using Thread Class
```
Write a Java program to create three threads by extending the Thread class. Each thread
should perform a different task, such as printing numbers, displaying characters, and
displaying a message. Execute all three threads concurrently and observe their execution
order.
```
<a href=./Prog02.java>code</a>
<br/>
<img width="629" height="296" alt="image" src="https://github.com/user-attachments/assets/384cff5b-164c-4c52-a385-7e4bcf543852" />

#### 3. Creating Threads using Runnable Interface
```
Write a Java program to create two or more threads by implementing the Runnable
interface. Each thread should perform a separate task. Explain why implementing Runnable
can be preferable to extending the Thread class in certain situations.
```
<a href=./Prog03.java>code</a>
<br/>
<img width="626" height="204" alt="image" src="https://github.com/user-attachments/assets/0fe57f6f-1ae7-4896-a8f3-f6f11bfe31f2" />

#### 4. Synchronization
```
Write a Java program in which multiple threads access and update a shared bank account
balance. Demonstrate the problem that can occur when multiple threads modify the
balance simultaneously. Then use the synchronized keyword to ensure that the balance is
updated correctly.
```
<a href=./Prog04.java>code</a>
<br/>
<img width="788" height="149" alt="image" src="https://github.com/user-attachments/assets/49fa4c47-0e42-4ee8-ade0-c63fa9e8234a" />


#### 5. Multithreading with Synchronization
```
Develop a Java program that simulates a ticket booking system. Create multiple threads
representing customers attempting to book tickets from the same limited ticket pool. Use
synchronization to ensure that two customers cannot book the same ticket. Display the
booking details and remaining number of tickets after each transaction.
```
