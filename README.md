# CSc242



Nicholas Engle

CS242 

Milestone 1
Monday, October 23rd

Dr. Daqing Hou
Fall 2023









a. In your test class SocketServerTest, what happens if you provide a negative value for a port number? (Remember port numbers are always positive) How do you think you can fix these issues? 
If a negative value is provided, it will result in an IllegalArgumentException being thrown, and the code will not proceed to the line that prints "Negative port number was accepted." I was able to fix this error by adding the following code to throw the exception in socket server:
public SocketServer(int x) {
   if (x <= 0) {
       throw new IllegalArgumentException("Port number must be a positive value.");
   }
   PORT = x;
}

In this code snippet, the parameterized constructor SocketServer checks whether the provided port number is greater than zero. If a negative value is passed, an IllegalArgumentException is raised, indicating an invalid port number.

b. In your ServerHandler class, what happens if you do not override the run() function? Is there an error? Why?
In the ServerHandler class, the overridden run() method is responsible for executing the logic that handles client communication. This method is the entry point for concurrent execution when a client connection is accepted. Custom logic for I/O and communication with the client should be implemented within the run() method to achieve the intended functionality of the class. Without this custom logic, the thread created from the ServerHandler class will perform no meaningful tasks when started.
If you do not override the `run()` function in your `ServerHandler` class, there won't be a compilation error because the `Thread` class has a default implementation of the `run()` method, which does nothing (it's an empty method). In other words, it's not mandatory to override the `run()` method when you extend the `Thread` class. 
However, without overriding the `run()` method with your custom logic, the `ServerHandler` class won't achieve its intended purpose, which is to handle client communication concurrently. Instead, it will behave as if it does nothing when you start a thread from this class.

c. My Contribution
I did tasks 5-8. I was responsible for creating all of the classes and test classes for the project based on the attributes described in the milestone 1 rubric.
d. Partner’s Contribution
My partner was Aidan Collins and was responsible for the first 4 tasks. He created the project and had me finish it off. 
d. GitHub
https://github.com/nickengle4292/CS242.git
