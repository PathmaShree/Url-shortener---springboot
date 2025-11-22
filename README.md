# 🔗 URL Shortener Project

A full-stack URL Shortener application built with **Spring Boot (Java)** backend and **React.js** frontend.  
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

### Backend
- **Short URL creation** with optional expiry
- **Redirection** with visit logging
- **Analytics:** Browser, OS, device, IP, referrer, timestamp
- **Visit count** for each short URL
- **CRUD operations** for URL management
- **REST APIs** for all operations

### Frontend
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




