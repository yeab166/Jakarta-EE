## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# How to run the code step by step

1. Open VS Code in this project folder:

 -> C:\Users\YEABSIRA BELETE\OneDrive\Documents\Codes\Jakarta-EE
2. Open the Command Palette:

 -> Press Ctrl+Shift+P
3. Run the task runner:

 -> Type Run Task
 -> Press Enter

4. Choose the task:

 -> Select build-deploy-start
5. Wait for it to finish:

 -> It will first run mvn clean package
 -> then copy AttendanceSystem.war into Tomcat webapps
 -> then start Tomcat with startup.bat
6. After the task completes, open the app:

 -> Go to http://localhost:8080/AttendanceSystem/
 -> Press Ctrl+F5 to force refresh

# If you want to stop and restart Tomcat later
Use the task runner again:

 -> Run Task
 -> choose tomcat: stop
 -> then choose build-deploy-start again


# Option 1: Quick Manual Start/ Best

1. Open PowerShell (Win+X → PowerShell)
2. Run these commands:
  -> cd "C:\Users\YEABSIRA BELETE\Downloads\apache-tomcat-10.1.55-windows-x64\apache-tomcat-10.1.55\bin"
 -> cmd /c startup.bat
3. Keep the window open — leave it running
4. In browser: http://localhost:8080/AttendanceSystem/

# Option 2: Use VS Code Tasks

Modify your tomcat: start task to keep the window open instead of closing it.

Now your workflow is:

1. In VS Code: Ctrl+Shift+B → Select build-deploy-start
2. A terminal opens and keeps Tomcat running
3. Browser: http://localhost:8080/AttendanceSystem/