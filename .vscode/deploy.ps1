$source = Join-Path $PSScriptRoot "..\target\AttendanceSystem.war"
$destWar = "C:\Users\YEABSIRA BELETE\Downloads\apache-tomcat-10.1.55-windows-x64\apache-tomcat-10.1.55\webapps\AttendanceSystem.war"
$destDir = "C:\Users\YEABSIRA BELETE\Downloads\apache-tomcat-10.1.55-windows-x64\apache-tomcat-10.1.55\webapps\AttendanceSystem"

Remove-Item -LiteralPath $destDir -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -LiteralPath $destWar -Force -ErrorAction SilentlyContinue
Copy-Item -LiteralPath $source -Destination $destWar -Force
