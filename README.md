## Setup
1. Clone the repo: `git clone git@bitbucket.org:tekion/bootcamp-playground.git`
2. `cd /bootcamp-playground`  
3. Install java: `brew install java`  
3. Install gradle 6.0: `i). curl -s "https://get.sdkman.io" | bash  ii). sdk install gradle 6.0`  
4. Install  and run postgres server as container: `docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=playground -e POSTGRES_USER=postgres -e POSTGRES_DB=playground postgres`  
5. Exec into the docker container, open psql console: `psql postgres -U postgres` and execute each of the query part of the playground.sql file.   
5. Build and run the server: `gradle clean build && gradle sS`  
6. Visit http://localhost:4567/home  

## Frontend tech  
`vue framework`: https://www.vuemastery.com/courses/intro-to-vue-js  
`vue axios`: https://github.com/imcvampire/vue-axios/blob/master/README.md  
`vue cookies`: https://github.com/alfhen/vue-cookie  

## Backend tech  

Java & dependencies part of build.gradle file  

## API contract  

T.B.W    

## DB schemas   

T.B.W  