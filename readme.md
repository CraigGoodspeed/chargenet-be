# Chargenet backend technical interview

## Contents

1. Simple project used spring initializr to create the framework.
2. Authentication consists of two users

|username| password|
| --- | --- |
| craig@goodspeed.co.za | AWeakP@5sw0rd |
|ingrid@goodspeed.co.za | r34lLyB@dPassword|

3. Users are stored in cognito.
4. Examples of authentication and authorization are in the `./auth` folder.
5. Database is on top of mysql with user

| username | password |
| --- | --- |
| chargenet | WelikeElectricvehicles |

6. Database is created using liquibase on startup so the database needs to be running
7. Outstanding items:
   1. include unit tests
   2. include front end.
   3. remove the hardcoded auth end points.
   4. bulk order is not elegant i need to find a better way to do this.
   5. `JwtUser` class needs refactoring - i dont like how the token is mapped and defaulted.
   6. docker compose as well as k8s yaml files.
   7. update test scripts with valid data
   8. work on the db schema seems a bit off.

   