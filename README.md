✅ New Features:

UserController with endpoints to create, get, and delete users

ProductController for managing products similarly



 Updated REST Endpoints Overview
Controller	Method	Endpoint	Description
HelloController	GET	/api/hello	Simple greeting
UserController	GET	/api/users	Get all users
GET	/api/users/{id}	Get user by ID
POST	/api/users	Add user (JSON body)
DELETE	/api/users/{id}	Delete user by ID
ProductController	GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
POST	/api/products	Add product (JSON)
DELETE	/api/products/{id}	Delete product by ID

 Spring Boot project now includes full CRUD support (GET, POST, PUT, PATCH, DELETE) in both:

✅ OrderController

✅ CustomerController

Each controller supports:

@GetMapping – fetch all or one

@PostMapping – create new

@PutMapping – replace existing

@PatchMapping – partially update

@DeleteMapping – delete by ID

