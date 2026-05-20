Tomcat setup for this workspace
===============================

If you use the "Tomcat for Java" VS Code extension, register your Tomcat installation so the extension deploys to the same Tomcat used by these tasks.

Steps to register Tomcat in the extension UI:

1. Open the "Tomcat" view in VS Code (View -> Explorer -> Tomcat or use the extension icon).
2. Click the + (Add Tomcat Server).
3. When prompted, choose the Tomcat installation folder and point it to:

   C:\Users\YEABSIRA BELETE\Downloads\apache-tomcat-10.1.55-windows-x64\apache-tomcat-10.1.55

4. After adding the server, right click it and choose "Add WAR..." and select:

   ${workspaceFolder}\\target\\AttendanceSystem.war

Notes:
- I added tasks in `.vscode/tasks.json` to automate build, copy and start operations. Use the "Run Task" command (Ctrl+Shift+B or Terminal -> Run Task) and run `build-deploy-start`.
- If the extension still deploys a different instance, remove other Tomcat entries or configure the extension settings to point to the above installation.
