# Hello World API - Spring Boot + React Application

A full-stack application with Spring Boot backend and React frontend, featuring user authentication with signup and signin functionality for both regular users and admins.

## Features

- **Backend (Spring Boot)**
  - RESTful API with Spring Boot
  - User authentication with JWT tokens
  - Sign Up and Sign In endpoints
  - nd (React)**
  - Modern React application with routing
  - Sign Up form with role selection
  - Sign In form
  - Protected Dashboard
  - JWT token management
  - Responsive UI design

## Prerequisites

- Java 17 or higher
- Node.js 16 or higher
- npm or yarn

## Backend Setup

1. Navigate to the project root directory
2. Build the project:
   ```bash
   .\gradlew.bat build
   ```

3. Run the Spring Boot application:
   ```bash
   .\gradlew.bat bootRun
   ```

The backend will start on `http://localhost:8080`

## Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the React application:
   ```bash
   npm start
   ```

The frontend will start on `http://localhost:3000`

## API Endpoints

### Authentication Endpoints

- **POST** `/api/auth/signup` - Register a new user
  ```json
  {
    "username": "john_doe",
    "email": "john@example.com",
    "password": "password123",
    "role": "USER" // or "ADMIN"
  }
  ```

- **POST** `/api/auth/signin` - Sign in with credentials
  ```json
  {
    "username": "john_doe",
    "password": "password123"
  }
  ```

### Public Endpoints

- **GET** `/hello` - Returns "Welcome to the Hello World API"

## Usage

1. Start the backend server (port 8080)
2. Start the frontend server (port 3000)
3. Open `http://localhost:3000` in your browser
4. Sign up with a new account (choose USER or ADMIN role)
5. Sign in with your credentials
6. View your dashboard with user information

## Database

The application uses H2 in-memory database. You can access the H2 console at:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

## Project Structure

```
.
├── src/
│   ├── main/
│   │   ├── java/com/example/helloworldapi/
│   │   │   ├── config/          # Security configuration
│   │   │   ├── controller/      # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── repository/      # Data repositories
│   │   │   ├── service/         # Business logic
│   │   │   └── util/            # Utility classes (JWT)
│   │   └── resources/
│   │       └── application.properties
│   └── test/                    # Unit tests
├── frontend/
│   ├── src/
│   │   ├── components/          # React components
│   │   ├── services/            # API service
│   │   └── App.js
│   └── package.json
├── build.gradle
└── README.md
```

## Technologies Used

**Backend:**
- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (jjwt)

**Frontend:**
- React 18.2.0
- React Router DOM
- Axios
- CSS3

## Notes

- The JWT token is stored in localStorage
- Passwords are encrypted using BCrypt
- CORS is configured to allow requests from `http://localhost:3000`
- The H2 database is in-memory and data will be lost on application restart
