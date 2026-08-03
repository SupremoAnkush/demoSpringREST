# Objective
Created first Spring Boot RESTful application using @RestController and 
Access the api using Requestly app.

## Tasks
* Create CustomerController class, added CRUD methods with simple String return statements.
* annotated the class with @RestController("/customer")
* Annotated the class's methods with @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
* Updated the configuration in application.properties file.
  * provided the context path as /customer-1
  * Application will be accessible on URI : localhost:8080/customer-1
* Added Spring web dependencies in POM.xml file.


# Objective 2
Create Spring boot REST application where handler methods of REST controller consumes and produces Java objects
Learn usage of ResponseEntity

## Task 
* Create createCustomer() URI /customers with POST mapping, uses consumes attribute @RequestBody
  * provide this data in JSON format in POST request
    {
    "phoneNo":8866886876,"name":"Smith","email":"Smith@gmail.com","age":28,"gender":"M"
    }
  
* Create fetchCustomer() URI /customers with GET Mapping, uses produces attribute

