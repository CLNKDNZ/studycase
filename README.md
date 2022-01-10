# studycase

# 1) Clone project
 Clone your project local pc

# 2) Use docker compose
 Use docker-compose up -d  command on terminal
 Project(database and web api) will be initilazed in 2 minutes

# 2) Acces database user interface
You can acces the  user interface from http://localhost:8091/ui/index.html 
Username: Administrator
Password : password

# 4) Login app with postman and get bearer token  
Use  POST  http://localhost:9090/api/user/login  x-www-form-urlencoded for login and to get accesToken
 
When app start, save 2 user with command runner in to database. Can use these user for testing app. 
  Users:
   username: dnzcelenk
   password: deniz123
   role:ROLE_ADMIN

   username: clnkDeniz
   password: deniz123+-
   role:ROLE_USER

# 5) Test web api
Web api endpoints are in security config. Use those endpoints for testing 
Example : http://localhost:9090/.....   

