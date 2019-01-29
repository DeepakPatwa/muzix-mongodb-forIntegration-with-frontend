=================Installation of Mongodb==========


1. sudo apt-get update

2. sudo apt-get install mongodb

3. mongod --version // to check version of mongodb for the conformation of installation
 
if some error comes then try to upgrade using "sudo apt-get upgrade" and again try to run 2nd command

 

==========Creating db and configuring user to mongo db==========

1. mongo --port 27017

2. use admin

3. db.createUser(
	{
	  user: "AdminUser",
	  pwd: "admin123",
	  roles: [{role: "userAdminAnyDatabase", db: "admin" }, "readWriteAnyDatabase" ]
	}
)

4. exit 

5. mongo --port 27017 -u "AdminUser" -p "admin123" --authenticationDatabase "admin"

6. use admin







