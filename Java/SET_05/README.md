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
<img width="591" height="123" alt="image" src="https://github.com/user-attachments/assets/512db093-c702-4f09-903f-9b6eb0a338fe" />


#### 2. Creating Threads using Thread Class
```
Write a Java program to create three threads by extending the Thread class. Each thread
should perform a different task, such as printing numbers, displaying characters, and
displaying a message. Execute all three threads concurrently and observe their execution
order.
```

#### 3. Creating Threads using Runnable Interface
```
Write a Java program to create two or more threads by implementing the Runnable
interface. Each thread should perform a separate task. Explain why implementing Runnable
can be preferable to extending the Thread class in certain situations.
```
#### 4. Synchronization
```
Write a Java program in which multiple threads access and update a shared bank account
balance. Demonstrate the problem that can occur when multiple threads modify the
balance simultaneously. Then use the synchronized keyword to ensure that the balance is
updated correctly.
```
#### 5. Multithreading with Synchronization
```
Develop a Java program that simulates a ticket booking system. Create multiple threads
representing customers attempting to book tickets from the same limited ticket pool. Use
synchronization to ensure that two customers cannot book the same ticket. Display the
booking details and remaining number of tickets after each transaction.
```
