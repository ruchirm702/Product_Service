
# Product Service

This repository contains the implementation of a Product Service that interacts with the [Fake Store API](https://fakestoreapi.com). The service fetches product data from the API and provides various endpoints to manage and retrieve product information.

## Features

- Fetch products from the Fake Store API
- List all products
- Retrieve details of a specific product
- Search for products by category
- Create, update, and delete products (CRUD operations)

## Getting Started

### Prerequisites

- [Java JDK 11 or higher](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven](https://maven.apache.org/)

### Installation

1. Clone the repository:

    \`\`\`bash
    git clone https://github.com/ruchirm702/product-service.git
    \`\`\`

2. Navigate to the project directory:

    \`\`\`bash
    cd product-service
    \`\`\`

3. Build the project using Maven:

    \`\`\`bash
    mvn clean install
    \`\`\`

### Configuration

Create an \`application.properties\` file in the \`src/main/resources\` directory and add the following configuration:

    \`\`\`
    api.base.url=https://fakestoreapi.com
    server.port=8080
    \`\`\`

### Running the Service

Start the service using the following command:

\`\`\`bash
mvn spring-boot:run
\`\`\`

The service will be available at \`http://localhost:8080\`.

### API Endpoints

- \`GET /products\`: Retrieve a list of all products
- \`GET /products/{id}\`: Retrieve details of a specific product by ID
- \`GET /products/category/{category}\`: Retrieve products by category
- \`POST /products\`: Create a new product
- \`PUT /products/{id}\`: Update an existing product by ID
- \`DELETE /products/{id}\`: Delete a product by ID

### Example Requests

- Retrieve all products:

    \`\`\`bash
    curl -X GET http://localhost:8080/products
    \`\`\`

- Retrieve a product by ID:

    \`\`\`bash
    curl -X GET http://localhost:8080/products/1
    \`\`\`

- Retrieve products by category:

    \`\`\`bash
    curl -X GET http://localhost:8080/products/category/electronics
    \`\`\`

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.


## Acknowledgements

- [Fake Store API](https://fakestoreapi.com) for providing the product data.
