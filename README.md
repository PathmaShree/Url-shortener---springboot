# 🔗 URL Shortener Project

URL Shortener application is built with **Spring Boot (Java)** backend and **React.js** frontend.  
Allows users to create short URLs, track analytics, view visit counts, and manage URLs with expiry features.

---

## 🛠 Tech Stack

**Backend:**
- Java 17
- Spring Boot
- Spring Data JPA & Hibernate
- Jakarta Servlet
- H2 / MySQL Database
- Maven

**Frontend:**
- React.js (Functional Components + Hooks)
- React Router
- Axios
- CSS with gradients & smooth animations

**Utilities / Features:**
- User-Agent parsing (browser, OS, device)
- IP tracking and country detection
- Base62 encoding for short URLs
- URL expiry management
- URL analytics tracking (browser, OS, device, IP, referrer, timestamp)

---

## ⚙️ Features

**Backend**
- **Short URL creation** with optional expiry
- **Redirection** with visit logging
- **Analytics:** Browser, OS, device, IP, referrer, timestamp
- **Visit count** for each short URL
- **CRUD operations** for URL management
- **REST APIs** for all operations

**Frontend**
- **Create URL:** Submit original URL, get short URL
- **Available URLs:** List of all shortened URLs
- **Analytics:** Fetch and view detailed URL analytics
- **Visit Count:** Displays total visits for a URL
- **Redirection:** Handles short URL redirects
- **Responsive Navigation** with gradient styling

---

### API Endpoints

| Endpoint                                   | Method | Description               |
| ------------------------------------------ | ------ | ------------------------- |
| `/api/urlMapping/createShorten`            | POST   | Create a short URL        |
| `/api/urlMapping/redirect/{shortCode}`     | GET    | Redirect to original URL  |
| `/api/urlMapping/getAnalytics/{shortCode}` | GET    | Fetch analytics for a URL |
| `/api/urlMapping/getById/{id}`             | GET    | Get URL by ID             |
| `/api/urlMapping/getAll`                   | GET    | Fetch all URLs            |
| `/api/urlMapping/update/{id}`              | PUT    | Update URL expiry         |
| `/api/urlMapping/deleteById/{id}`          | DELETE | Delete URL                |
| `/api/urlAnalytics/getAll/{shortCode}`     | GET    | All analytics for a URL   |
| `/api/urlAnalytics/count/{shortCode}`      | GET    | Total visits for a URL    |

## 📂 Folder Structure

### Backend (`src/main/java/com/example/url`)
<img width="514" height="994" alt="image" src="https://github.com/user-attachments/assets/9ae452ab-5e3f-4ed1-9a54-7fe3eda970f9" />

### Frontend (`src/`)
<img width="409" height="916" alt="image" src="https://github.com/user-attachments/assets/e39b0e52-dd9e-4376-bf62-cfab94ffaa4b" />

##Frontend
<img width="1976" height="1077" alt="image" src="https://github.com/user-attachments/assets/8c89c34d-3ea2-4f98-af1f-c225542fc3f4" />
<img width="2099" height="1160" alt="image (1)" src="https://github.com/user-attachments/assets/23e818e9-a9d9-4c44-831b-70c24c6c2cef" />
<img width="1998" height="900" alt="image (2)" src="https://github.com/user-attachments/assets/9e25dbf9-b8dd-4e9f-9ef9-5e58325053b8" />
<img width="1620" height="589" alt="image (3)" src="https://github.com/user-attachments/assets/c6a46e57-5896-4246-9fba-a59fedf50b54" />

##Sample Request
# URL Shortener API – Sample Requests & Responses

## Create Short URL

**Request**

```http
POST /api/urlMapping/createShorten
Content-Type: application/json

{
  "originalUrl": "https://www.netflix.com/in/",
  "expireAt": "2025-11-25T06:08:29"
}

{
  "id": 17,
  "originalUrl": "https://www.netflix.com/in/",
  "shortCode": "1248h",
  "createdAt": "2025-11-24T16:38:32",
  "expireAt": "2025-11-25T06:08:29"
}






