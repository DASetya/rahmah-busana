Mini project technical test
Untuk menjalankan project di local, pastikan device telah memiliki MySQL dan Java.
Berikut langkah langkah konfigurasi.

1. Clone project ini pada device dan build project
2. Buka file application.properties dan sesuaikan nama database, username, dan password. Ubah pada bagian "spring.jpa.hibernate.ddl-auto" menjadi create saat menjalankan untuk pertama kalinya, selanjutnya ubah menjadi update
3. Jalankan program
4. Untuk testing API, gunakan postman atau lainnya, berikut adalah list dari API

#Clothes CRUD
##1. Post/add clothes
```
url : localhost:8080/clothes
method : POST
request body (JSON):
{
    "clothesName": "Jaket Coach",
    "brand": "Erigo",
    "material": "Taslan",
    "description": "Jaket coach dengan bahan kain taslan",
    "stock": 150,
    "price": 250000
}
```
##2. Get all clothes
```
url : localhost:8080/clothes
method : GET
```
##3. Get clothes by id
```
url : localhost:8080/clothes/{id}
method : GET
```
##4. Get clothes by Brand
```
url : localhost:8080/clothes?brand={brand}
method : GET
```
##5. Update clothes
```
url : localhost:8080/clothes
method : PUT
request body (JSON):
{
   "id": 1,
   "clothesName": "T-Shirt polos",
   "brand": "Erigo",
   "material": "cotton",
   "description": "Kaos T-Shirt polos bahan katun",
   "stock": 100,
   "price": 100000
}
```
##6. Delete clothes by id
```
url : localhost:8080/clothes/{id}
method : DELETE
```

#User
##1. Post/add user
```
url : localhost:8080/users
method : POST
request body (JSON):
{
    "firstName": "Aku",
    "lastName": "Aku",
    "email": "akuaku@gmail.com",
    "username": "akuaku",
    "password": "default"
}
```
##2. Get all users
```
url : localhost:8080/users
method : GET
```
##3. Get user by id
```
url : localhost:8080/users/{id}
method : GET
```
##4. Update user
```
url : localhost:8080/users
method : PUT
request body (JSON):
{
    "id" : 1,
    "firstName": "Aku",
    "lastName": "Aku",
    "email": "iniaku@gmail.com",
    "username": "akuaku",
    "password": "pass123"
}
```
##6. Delete user by id
```
url : localhost:8080/users/{id}
method : DELETE
```

#Transaction
##Buy clothes
```
url : localhost:8080/transaction
method : POST
request body (JSON) :
{
    "user" : {
        "id" : "1"
    },
     "purchaseDetails" : [
        {
            "clothes": {
                "id" : "2"
            },
            "quantity" : 3
        },
        {
            "clothes": {
                "id" : "3"
            },
            "quantity" : 1
        }
    ]
}
```