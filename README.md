TinyLink — URL Shortener

TinyLink is a full-stack URL shortening application that converts long URLs into short, shareable links and generates a QR code for each shortened URL.

The project is built using Angular, Spring Boot, Redis, and Docker, with a focus on REST APIs, caching, scalability, and a clean separation between frontend and backend.

---

🚀 Features

- Convert long URLs into short URLs
- Redirect users from short URLs to the original URL
- Generate QR codes for shortened URLs
- Store URL mappings using Redis
- RESTful Spring Boot backend
- Angular-based frontend
- Dockerized backend
- Responsive and simple user interface
- Separate frontend and backend architecture

---

🏗️ Architecture

                    ┌──────────────────┐
                    │      User        │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │ Angular Frontend │
                    └────────┬─────────┘
                             │ REST API
                             ▼
                    ┌──────────────────┐
                    │  Spring Boot API │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │      Redis       │
                    │  URL → Short ID  │
                    └──────────────────┘

URL Shortening Flow

Long URL
↓
Angular
↓
Spring Boot
↓
Generate Short Code
↓
Store mapping in Redis
↓
Return Short URL + QR Code

URL Redirection Flow

User opens Short URL
↓
Spring Boot
↓
Find Short Code in Redis
↓
Retrieve Original URL
↓
Redirect to Original URL

---

🛠️ Tech Stack

Frontend

- Angular
- TypeScript
- HTML
- CSS

Backend

- Java
- Spring Boot
- Spring Web
- Spring Data Redis
- REST APIs

Database / Cache

- Redis

DevOps

- Docker
- Docker Compose

Version Control

- Git
- GitHub

---

📁 Project Structure

tinylink-url-shortener/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── tinylink/
│   │       │           ├── controller/
│   │       │           ├── service/
│   │       │           ├── repository/
│   │       │           ├── model/
│   │       │           └── TinyLinkApplication.java
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   ├── Dockerfile
│   ├── .dockerignore
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── angular.json
│
├── docker-compose.yml
├── .gitignore
└── README.md

---

🔌 API Endpoints

Create Short URL

POST /api/urls/shorten

Request:

{
"longUrl": "https://example.com/a/very/long/url"
}

Response:

{
"shortUrl": "http://localhost:8080/Ab12X",
"qrCode": "..."
}

---

Redirect to Original URL

GET /{shortCode}

Example:

GET /Ab12X

The backend retrieves the original URL from Redis and redirects the user to it.

---

⚡ Redis

Redis is used to store the relationship between the generated short code and the original URL.

Example:

Key:   Ab12X
Value: https://example.com/a/very/long/url

This allows the application to quickly retrieve the original URL when a user opens a shortened link.

---

🐳 Running with Docker

Make sure Docker is installed and running.

From the project root:

docker compose up --build

To run in the background:

docker compose up --build -d

Stop the containers:

docker compose down

---

💻 Running Backend Locally

Navigate to the backend directory:

cd backend

Build the application:

./mvnw clean package

Run the application:

./mvnw spring-boot:run

The backend will run on:

http://localhost:8080

---

🎨 Running Frontend Locally

Navigate to the frontend directory:

cd frontend

Install dependencies:

npm install

Start Angular:

ng serve

The frontend will normally be available at:

http://localhost:4200

---

🔐 Environment Configuration

Do not commit passwords, API keys, or other secrets to GitHub.

Use environment variables for production configuration.

Example:

REDIS_HOST=localhost
REDIS_PORT=6379

For production, configure these values through the deployment platform rather than storing sensitive credentials directly in the repository.

---

🧪 Example

Input:

https://www.example.com/products/category/smartphones/product-details

TinyLink generates:

http://localhost:8080/X7kP2

And provides a QR code that points to the shortened URL.

When a user visits:

http://localhost:8080/X7kP2

TinyLink retrieves the original URL from Redis and redirects the user.

---

📈 Future Improvements

- URL click analytics
- Click count tracking
- Expiring URLs
- Custom short URLs
- User authentication
- Rate limiting
- URL history
- Dashboard for analytics
- Custom domain
- Production monitoring
- Automated CI/CD pipeline

---

🎯 Learning Objectives

This project demonstrates practical experience with:

- REST API development
- Spring Boot
- Java backend development
- Redis data storage and caching
- Angular frontend development
- Docker containerization
- Frontend-backend integration
- API design
- Git and GitHub
- Basic system design concepts

---

👨‍💻 Author

Prince Kumar

Java Backend Developer | Spring Boot | REST APIs | Redis | Docker | Angular

---

⭐ Project

If you find this project useful, consider giving the repository a ⭐ on GitHub.d RESTful APIs, Dockerized the application, and deployed the Angular frontend on Vercel and Spring Boot backend on Render with production CORS configuration.





TinyLink — URL Shortener

TinyLink is a full-stack URL shortening application that converts long URLs into short, shareable links and generates a QR code for each shortened URL.

The project is built using Angular, Spring Boot, Redis, and Docker, with a focus on REST APIs, caching, scalability, and a clean separation between frontend and backend.

---

🚀 Features

- Convert long URLs into short URLs
- Redirect users from short URLs to the original URL
- Generate QR codes for shortened URLs
- Store URL mappings using Redis
- RESTful Spring Boot backend
- Angular-based frontend
- Dockerized backend
- Responsive and simple user interface
- Separate frontend and backend architecture

---

🏗️ Architecture

                    ┌──────────────────┐
                    │      User        │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │ Angular Frontend │
                    └────────┬─────────┘
                             │ REST API
                             ▼
                    ┌──────────────────┐
                    │  Spring Boot API │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │      Redis       │
                    │  URL → Short ID  │
                    └──────────────────┘

URL Shortening Flow

Long URL
↓
Angular
↓
Spring Boot
↓
Generate Short Code
↓
Store mapping in Redis
↓
Return Short URL + QR Code

URL Redirection Flow

User opens Short URL
↓
Spring Boot
↓
Find Short Code in Redis
↓
Retrieve Original URL
↓
Redirect to Original URL

---

🛠️ Tech Stack

Frontend

- Angular
- TypeScript
- HTML
- CSS

Backend

- Java
- Spring Boot
- Spring Web
- Spring Data Redis
- REST APIs

Database / Cache

- Redis

DevOps

- Docker
- Docker Compose

Version Control

- Git
- GitHub

---

📁 Project Structure

tinylink-url-shortener/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── tinylink/
│   │       │           ├── controller/
│   │       │           ├── service/
│   │       │           ├── repository/
│   │       │           ├── model/
│   │       │           └── TinyLinkApplication.java
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   ├── Dockerfile
│   ├── .dockerignore
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── angular.json
│
├── docker-compose.yml
├── .gitignore
└── README.md

---

🔌 API Endpoints

Create Short URL

POST /api/urls/shorten

Request:

{
"longUrl": "https://example.com/a/very/long/url"
}

Response:

{
"shortUrl": "http://localhost:8080/Ab12X",
"qrCode": "..."
}

---

Redirect to Original URL

GET /{shortCode}

Example:

GET /Ab12X

The backend retrieves the original URL from Redis and redirects the user to it.

---

⚡ Redis

Redis is used to store the relationship between the generated short code and the original URL.

Example:

Key:   Ab12X
Value: https://example.com/a/very/long/url

This allows the application to quickly retrieve the original URL when a user opens a shortened link.

---

🐳 Running with Docker

Make sure Docker is installed and running.

From the project root:

docker compose up --build

To run in the background:

docker compose up --build -d

Stop the containers:

docker compose down

---

💻 Running Backend Locally

Navigate to the backend directory:

cd backend

Build the application:

./mvnw clean package

Run the application:

./mvnw spring-boot:run

The backend will run on:

http://localhost:8080

---

🎨 Running Frontend Locally

Navigate to the frontend directory:

cd frontend

Install dependencies:

npm install

Start Angular:

ng serve

The frontend will normally be available at:

http://localhost:4200

---

🔐 Environment Configuration

Do not commit passwords, API keys, or other secrets to GitHub.

Use environment variables for production configuration.

Example:

REDIS_HOST=localhost
REDIS_PORT=6379

For production, configure these values through the deployment platform rather than storing sensitive credentials directly in the repository.

---

🧪 Example

Input:

https://www.example.com/products/category/smartphones/product-details

TinyLink generates:

http://localhost:8080/X7kP2

And provides a QR code that points to the shortened URL.

When a user visits:

http://localhost:8080/X7kP2

TinyLink retrieves the original URL from Redis and redirects the user.

---

📈 Future Improvements

- URL click analytics
- Click count tracking
- Expiring URLs
- Custom short URLs
- User authentication
- Rate limiting
- URL history
- Dashboard for analytics
- Custom domain
- Production monitoring
- Automated CI/CD pipeline

---

🎯 Learning Objectives

This project demonstrates practical experience with:

- REST API development
- Spring Boot
- Java backend development
- Redis data storage and caching
- Angular frontend development
- Docker containerization
- Frontend-backend integration
- API design
- Git and GitHub
- Basic system design concepts

---

👨‍💻 Author

TinyLink — URL Shortener

TinyLink is a full-stack URL shortening application that converts long URLs into short, shareable links and generates a QR code for each shortened URL.

The project is built using Angular, Spring Boot, Redis, and Docker, with a focus on REST APIs, caching, scalability, and a clean separation between frontend and backend.

---

🚀 Features

- Convert long URLs into short URLs
- Redirect users from short URLs to the original URL
- Generate QR codes for shortened URLs
- Store URL mappings using Redis
- RESTful Spring Boot backend
- Angular-based frontend
- Dockerized backend
- Responsive and simple user interface
- Separate frontend and backend architecture

---

🏗️ Architecture

                    ┌──────────────────┐
                    │      User        │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │ Angular Frontend │
                    └────────┬─────────┘
                             │ REST API
                             ▼
                    ┌──────────────────┐
                    │  Spring Boot API │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │      Redis       │
                    │  URL → Short ID  │
                    └──────────────────┘

URL Shortening Flow

Long URL
↓
Angular
↓
Spring Boot
↓
Generate Short Code
↓
Store mapping in Redis
↓
Return Short URL + QR Code

URL Redirection Flow

User opens Short URL
↓
Spring Boot
↓
Find Short Code in Redis
↓
Retrieve Original URL
↓
Redirect to Original URL

---

🛠️ Tech Stack

Frontend

- Angular
- TypeScript
- HTML
- CSS

Backend

- Java
- Spring Boot
- Spring Web
- Spring Data Redis
- REST APIs

Database / Cache

- Redis

DevOps

- Docker
- Docker Compose

Version Control

- Git
- GitHub

---

📁 Project Structure

tinylink-url-shortener/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── tinylink/
│   │       │           ├── controller/
│   │       │           ├── service/
│   │       │           ├── repository/
│   │       │           ├── model/
│   │       │           └── TinyLinkApplication.java
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   ├── Dockerfile
│   ├── .dockerignore
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── angular.json
│
├── docker-compose.yml
├── .gitignore
└── README.md

---

🔌 API Endpoints

Create Short URL

POST /api/urls/shorten

Request:

{
"longUrl": "https://example.com/a/very/long/url"
}

Response:

{
"shortUrl": "http://localhost:8080/Ab12X",
"qrCode": "..."
}

---

Redirect to Original URL

GET /{shortCode}

Example:

GET /Ab12X

The backend retrieves the original URL from Redis and redirects the user to it.

---

⚡ Redis

Redis is used to store the relationship between the generated short code and the original URL.

Example:

Key:   Ab12X
Value: https://example.com/a/very/long/url

This allows the application to quickly retrieve the original URL when a user opens a shortened link.

---

🐳 Running with Docker

Make sure Docker is installed and running.

From the project root:

docker compose up --build

To run in the background:

docker compose up --build -d

Stop the containers:

docker compose down

---

💻 Running Backend Locally

Navigate to the backend directory:

cd backend

Build the application:

./mvnw clean package

Run the application:

./mvnw spring-boot:run

The backend will run on:

http://localhost:8080

---

🎨 Running Frontend Locally

Navigate to the frontend directory:

cd frontend

Install dependencies:

npm install

Start Angular:

ng serve

The frontend will normally be available at:

http://localhost:4200

---

🔐 Environment Configuration

Do not commit passwords, API keys, or other secrets to GitHub.

Use environment variables for production configuration.

Example:

REDIS_HOST=localhost
REDIS_PORT=6379

For production, configure these values through the deployment platform rather than storing sensitive credentials directly in the repository.

---

🧪 Example

Input:

https://www.example.com/products/category/smartphones/product-details

TinyLink generates:

http://localhost:8080/X7kP2

And provides a QR code that points to the shortened URL.

When a user visits:

http://localhost:8080/X7kP2

TinyLink retrieves the original URL from Redis and redirects the user.

---

📈 Future Improvements

- URL click analytics
- Click count tracking
- Expiring URLs
- Custom short URLs
- User authentication
- Rate limiting
- URL history
- Dashboard for analytics
- Custom domain
- Production monitoring
- Automated CI/CD pipeline

---

🎯 Learning Objectives

This project demonstrates practical experience with:

- REST API development
- Spring Boot
- Java backend development
- Redis data storage and caching
- Angular frontend development
- Docker containerization
- Frontend-backend integration
- API design
- Git and GitHub
- Basic system design concepts

---

👨‍💻 Author

Prince Kumar

Java Backend Developer | Spring Boot | REST APIs | Redis | Docker | Angular

---

⭐ Project

If you find this project useful, consider giving the repository a ⭐ on GitHub.

@ 2026 Prince Thakur. ALL Rightes Reserved.
