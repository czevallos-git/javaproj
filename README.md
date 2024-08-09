# javaproj
Repo to learn java and related technologies

First Project: To-Do List Application

Description
This is a command-line application that will allow users to add, view, remove, and mark tasks as complete.
Focus is on oop, file handling, and basic user input/output in java.

Project Outline
Features to be implemented:
1. Add Tasks: Allow users to add tasks to the to-do list.
2. View Tasks: Display all tasks, indicating whic are completed.
3. Mark Tasks as Complete: Allow users to mark specific tasks as completed.
4. Remove Tasks: Allow users to remove tasks from the list.
5. Persist Data: Save the tasks list to a file so that it persist across program runs.

Project Structure
javaproj/
│
├── src/
│   ├── Task.java
│   ├── TaskManager.java
│   └── Main.java
└── data/
    └── tasks.txt

Task.java: This class will represent an individual task.
TaskManager.java: This class will handle the operations on the tasks, such as adding, viewing, and removing tasks.
Main.java: This class will contain the main method and user interface logic.
tasks.txt: This file will store tasks so that they persist between program runs.