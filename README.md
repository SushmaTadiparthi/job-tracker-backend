# Job Tracker - Backend

A REST API for managing job applications. Built with Spring Boot and MySQL.

**Live API:** https://job-tracker-backend-q1yc.onrender.com

---

## Features

- User registration and login
- JWT authentication (secure tokens)
- Create, read, update, delete job applications
- Change job status
- Password encryption
- CORS enabled for frontend

---

## Tech Stack

- Java 17
- Spring Boot 4.0
- Spring Data JPA
- Spring Security
- JWT (JJWT)
- MySQL
- Maven

---

## Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Installation

```bash
# Clone repo
git clone https://github.com/SushmaTadiparthi/job-tracker-backend.git
cd job-tracker-backend

# Create database
mysql -u root -p
CREATE DATABASE job_tracker;
EXIT;

# Update application.properties
# Edit: src/main/resources/application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/job_tracker
# spring.datasource.username=root
# spring.datasource.password=your_password

# Build
mvn clean package -DskipTests

# Run
mvn spring-boot:run
```

Server runs at http://localhost:8080

---

## API Endpoints

### Authentication

**Register**
POST /api/auth/register
Content-Type: application/json
{
"name": "Your Name",
"email": "your@email.com",
"password": "Password123"
}

Returns: `{ token, email, name }`

---

### Jobs

All job endpoints require token:
Authorization: Bearer {token}
**Get All Jobs**
GET /api/jobs
**Add Job**
POST /api/jobs
{
"companyName": "Google",
"role": "Software Engineer",
"jobUrl": "https://...",
"notes": "Optional notes"
}

**Update Job**
PUT /api/jobs/{id}
{
"companyName": "Google",
"role": "Software Engineer",
"jobUrl": "https://...",
"notes": "Updated notes"
}

**Change Status**
PUT /api/jobs/{id}/status
{
"status": "APPLIED|INTERVIEW|OFFER|REJECTED"
}

**Delete Job**
DELETE /api/jobs/{id}

---

### User

**Change Password**
PUT /api/user/password
{
"currentPassword": "old",
"newPassword": "new"
}

**Delete Account**
DELETE /api/user/account

---

## Database Schema

### users table
id (PRIMARY KEY)
email (UNIQUE)
password (encrypted)
name
created_at

### job_applications table
id (PRIMARY KEY)
user_id (FOREIGN KEY)
company_name
role
job_url
notes
status (APPLIED/INTERVIEW/OFFER/REJECTED)
applied_date
updated_at

**Relationship:** One user has many jobs (1:N)

---

## Security

- Passwords encrypted with BCrypt
- JWT tokens with 24-hour expiry
- CORS configured for frontend
- Input validation
- SQL injection prevention (JPA)

---

## Deployment

Deployed on **Render** with **Railway MySQL**.

### Environment Variables (Render)
SPRING_DATASOURCE_URL=jdbc:mysql://...
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=...
JWT_SECRET=...
JWT_EXPIRATION=86400000

Auto-deploys from GitHub on every push.

---

## Testing

### Using Postman

1. **Register**: POST http://localhost:8080/api/auth/register
2. **Login**: POST http://localhost:8080/api/auth/login (copy token)
3. **Get jobs**: GET http://localhost:8080/api/jobs (add token in header)

---

## Common Issues

**Q: Cannot connect to database**
- Check MySQL is running
- Check connection string
- Check username/password

**Q: 401 Unauthorized**
- Token expired or invalid
- Login again to get new token

**Q: 404 Not Found**
- Backend not running
- Check endpoint spelling

---

## Frontend Repository

https://github.com/SushmaTadiparthi/job-tracker-frontend

---

**Built by Sushma Tadiparthi | May 2026**
