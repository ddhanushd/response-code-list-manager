# response-code-list-manager
🔍 Manage and explore HTTP response codes visually with images — built using Angular, Spring Boot, and MySQL. Includes login, filtering, and list-saving features.

## 🔍 Project Overview

This project enables users to:
- Browse HTTP response codes with corresponding images.
- Search/filter response codes (e.g., by `2xx`, `404`, etc.).
- Create, save, edit, and delete custom lists of response codes.
- Basic login/signup functionality (handled on Angular frontend).
- Experience a dynamic and responsive UI.

## 🛠️ Tech Stack

- **Frontend:** Angular, TypeScript, HTML, CSS
- **Backend:** Spring Boot, Spring Data JPA, MySQL
- **Authentication:** Handled in frontend logic (Angular service + form validation)
- **Database:** MySQL
- **Tools:** Postman (API Testing), GitHub

## ⚙️ Features

- 👤 **Login/Signup** – Simple authentication system on the frontend with route guarding.
- 📄 **CRUD Operations** – Manage saved lists of response codes (Create, Retrieve, Update, Delete).
- 🔎 **Filtering/Search** – Dynamic frontend filtering and backend wildcard search (`LIKE '2__'`).
- 🧪 **Tested APIs** – Verified using Postman.
- 📊 **Query Optimization** – Efficient queries with documented complexity:
  - O(1) for primary key lookups
  - O(N) for list retrieval


