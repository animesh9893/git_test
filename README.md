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

## DB Schemas  

### otps  

```                                                              Table "public.otps"
 Column  |         Type          | Collation | Nullable |             Default
---------+-----------------------+-----------+----------+----------------------------------
 id      | integer               |           | not null | nextval('otps_id_seq'::regclass)
 otp     | numeric               |           |          |
 email   | character varying(50) |           | not null |
 user_id | integer               |           |          |
```

### Users  

```
 Column |         Type          | Collation | Nullable |              Default
--------+-----------------------+-----------+----------+-----------------------------------
 id     | integer               |           | not null | nextval('users_id_seq'::regclass)
 name   | character varying(50) |           | not null |
 email  | character varying(50) |           | not null |
 token  | character varying(50) |           |          |
```

### Todos  

```
 Column    |         Type          | Collation | Nullable |              Default
--------+-----------------------+-----------+----------+-----------------------------------
 id        | integer               |           | not null | nextval('users_id_seq'::regclass)
 user_id   | integer               |           | not null |
 message   | character varying(50) |           | not null |
 user_name | character varying(50) |           |          |

```
## API contracts  
```

Request:
curl -X GET \
  http://localhost:4567/user \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 4c076649-0ba5-474a-b292-d74690c9d69a'
Response:
If user looged in:
{
	"Success": "true",
	"name": "blah",
	"id":47,
	"email": "blah@gmail.com",
	"Error": ""
}
If user not looged in:
{
	"Success": "true",
	"user": "",
	"id": "",
	"email": "",
	"Error": "User is not logged in"
}
```
```
Request:
curl -X POST \
  'http://localhost:4567/CreateToDo?id=48' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 98c74619-a8b7-465d-988b-109d012b7241' \
  -d '{
	"user":"blah",
	"message":"BC"
}'
Response:

```

```
Request:
curl -X GET \
  'http://localhost:4567/GetToDo?id=48' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 6ebf7b67-1b14-4f5f-9ec2-22ca64ab791d'

Response:
{"todos":["BC"],"success":"true","error":""}
```


```
Request:
GET /search?q=a&amp;id=48 HTTP/1.1
Host: localhost:4567
Cache-Control: no-cache
Content-Type: application/json
Postman-Token: d744f516-aef8-459a-9d1a-c8c5c956c479

Response:
{"todos":["asdfa"],"success":"true","error":""}
```
