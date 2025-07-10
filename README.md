# 🎓 Student Grade Tracker (Java GUI)

A simple Java-based GUI application to manage and analyze student grades. Designed for students and beginners to practice Java Swing and file handling.

## ✅ Features

- Add, edit, and delete student records
- Search students by name or ID
- Sort records by name or marks
- Calculate average, highest, and lowest grades
- Save and load data using file I/O
- User-friendly interface built with Java Swing

## 🛠️ Tech Stack

- Java (JDK 8 or above)
- Java Swing (GUI)
- File I/O (Text File for data persistence)

## 📸 Screenshots

### Adding Students
![image](https://github.com/user-attachments/assets/c9829cbb-6313-4d28-8653-35aa40ed19a1)

### Summary Of Students
![image](https://github.com/user-attachments/assets/6a08498c-e3bc-4d0c-b508-cf333bc1ee78)

### Sorted By Grades
![image](https://github.com/user-attachments/assets/7105e00d-8fc3-4d8a-b4fe-2b43115134f6)

### Searched By Names
![image](https://github.com/user-attachments/assets/213e70b0-3c3b-44d7-9925-407f1f546f8b)


## 🧩 How to Use This Project

1. Place all files in the **"src" folder**:
   - `Student.java`
   - `StudentManager.java`
   - `StudentGradeTrackerGUI.java`

2. Open terminal/command prompt and compile:

```bash
javac Student.java StudentManager.java StudentGradeTrackerGUI.java
```

3. Then run the program:

```bash
java StudentGradeTrackerGUI
```

4. A GUI window will open, allowing you to:
   - Add a student with name and grade
   - Search using the Enter key
   - Sort records
   - See summary statistics
   - Reset everything using the Refresh button

---

## ✅ Features

- ➕ Add student name and grade
- 🔍 Search student by name (press **Enter** after typing)
- 📊 Show summary (Average, Highest, Lowest)
- 🔀 Sort by Name or Grade
- ♻️ Refresh button clears all inputs and saved records
- 💾 Auto-saves student list to `students.txt`
- 🎨 Polished and aligned layout (rounded buttons, unified spacing)

---

## 📁 File Structure

```
student-grade-tracker/
├── Student.java
├── StudentManager.java
├── StudentGradeTrackerGUI.java
├── README.md
├── .gitignore
└── assets/
    └── screenshot.png
```

---

## 🧾 .gitignore (recommended)

```
# Ignore compiled files
*.class

# Ignore student data file
students.txt

# System / editor settings
.vscode/
.DS_Store
*.log
```

---

## 💻 Tech Stack

- Language: **Java**
- GUI: **Swing**
- No external dependencies or libraries

---

## 👨‍💻 Author

- **Ishank Anand**
- GitHub: [@Ishank112](https://github.com/Ishank112)

---

## 📝 Notes

- `students.txt` is created automatically to store student data.
- Pressing **Enter** in the search box will search for the student directly.
- You can delete `students.txt` to reset the application permanently.

---
