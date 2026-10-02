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
<img width="591" height="123" alt="image" src="[https://github.com/user-attachments/assets/512db093-c702-4f09-903f-9b6eb0a338fe](https://private-user-images.githubusercontent.com/178543801/663896680-512db093-c702-4f09-903f-9b6eb0a338fe.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3OTA5MzU4NjcsIm5iZiI6MTc5MDkzNTU2NywicGF0aCI6Ii8xNzg1NDM4MDEvNjYzODk2NjgwLTUxMmRiMDkzLWM3MDItNGYwOS05MDNmLTliNmViMGEzMzhmZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjYxMDAyJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI2MTAwMlQxMDA2MDdaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT01YWM0NjAxMzk1NDVhOTcxMDg5NmY0NWExZTJjMGViNGQ0YjE0MDgwOTQ1M2ZhNDE2MTFmNGVmMjVjNzI5MWY4JlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZyZXNwb25zZS1jb250ZW50LXR5cGU9aW1hZ2UlMkZwbmcifQ.DMLvOipA1nAc1kO6J91lgK64wsOJs7S19LNyPWu0sGY)" />


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
