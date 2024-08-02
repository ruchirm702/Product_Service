
# Product Service

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

## Project Description

The Product Service project is a Spring Boot application designed to manage and retrieve product information by integrating with a third-party FakeStore API. It also demonstrates seamless integration with a MySQL database for storing and managing product data. The application features comprehensive exception handling, RESTful API endpoints, and a clean, modular code structure.

## Project Structure

```plaintext
product_service_24/
├── configurations/
│   └── ApplicationConfig.java
├── controller_advice/
│   └── GlobalExceptionHandler.java
├── controllers/
│   └── ProductController.java
├── dtos/
│   ├── ExceptionDTO.java
│   └── FakeStoreProductDTO.java
├── exceptions/
│   └── ProductNotFoundException.java
├── models/
│   ├── BaseModel.java
│   ├── Category.java
│   └── Product.java
├── projections/
│   └── ProductWithIdAndTitle.java
├── repositories/
│   ├── CategoryRepository.java
│   └── ProductRepository.java
├── services/
│   ├── FakeStoreProductService.java
│   ├── ProductService.java
│   └── SelfProductService.java
└── ProductServiceApplication.java

```

## Features

- **Fetch Products**: Retrieve product details from the FakeStore API.
- **Manage Products**: Perform CRUD operations on products.
- **Exception Handling**: Global exception handling with custom messages.


## FakeStore Implementation

The `FakeStoreProductService` class is used to interact with the FakeStore API. This service handles HTTP requests to fetch, update, and manage products from the FakeStore API.

### Key Components:

- **`ApplicationConfig.java`**: Configures the `RestTemplate` bean used for HTTP requests.
  
- **`GlobalExceptionHandler.java`**: Handles various exceptions such as `ArithmeticException`, `ArrayIndexOutOfBoundsException`, and `ProductNotFoundException`.

- **`ProductController.java`**: Provides endpoints to manage products, including `GET`, `POST`, `PUT`, `PATCH`, and `DELETE` operations.

- **`FakeStoreProductService.java`**:
  - **`getSingleProduct(Long productId)`**: Fetches a product by its ID from the FakeStore API.
  - **`getAllProducts()`**: Retrieves all products from the FakeStore API.
  - **`updateProduct(Long id, Product product)`**: Partially updates a product via the FakeStore API.
  - **`replaceProduct(Long id, Product product)`**: Fully replaces a product (not yet implemented).
  - **`deleteProduct(Long id)`**: Deletes a product (not yet implemented).
  - **`addNewProduct(Product product)`**: Adds a new product (not yet implemented).


### Sample API Calls:

- **GET /products/{id}**: Retrieve a product by its ID.
- **GET /products**: Retrieve all products.
- **POST /products**: Add a new product.
- **PUT /products/{id}**: Replace a product by its ID.
- **PATCH /products/{id}**: Update a product partially.
- **DELETE /products/{id}**: Delete a product by its ID.

## Getting Started

### Prerequisites

- [Java JDK 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)
- [MySQL 8.0](https://dev.mysql.com/downloads/mysql/)



### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/product_service_24.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd product_service_24
    ```

3. **Install dependencies and build the project:**

    ```bash
    mvn clean install
    ```

4. **Configure MySQL database settings in `application.properties`:**

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/Product_Service
    spring.datasource.username=Product_Service_User
    spring.datasource.password=your_password
    ```

5. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

### Usage

Access the API at `http://localhost:8080/products`.

### Testing

Run tests using Maven:

```bash
mvn test
 ```

   

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.


## Acknowledgements

- [Fake Store API](https://fakestoreapi.com) for providing the product data.
