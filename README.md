# Best Mart Pet Care – Mobile Application
A dynamic and feature-rich mobile application designed for **dog owners** to find and purchase high-quality dog food and nutrition-related products. Developed as part of a university coursework for **Mobile Application Development (MAD)**.

This project provides an end-to-end solution including user registration, product browsing, shopping cart functionality, educational content about dog nutrition, and admin management features.

## 📌 Project Overview
This project was developed to:
- Provide a seamless shopping experience for pet owners.
- Enable users to browse, search, and purchase dog food and related products.
- Deliver educational content about dog nutrition and health.
- Allow administrators to manage products and articles efficiently.
- Ensure a secure, responsive, and user-friendly interface across Android devices.

## 📱 Technologies Used
- **Frontend:** Android (Java/Kotlin), XML
- **IDE:** Android Studio
- **Backend:** Firebase / Local SQLite (as per implementation)
- **Development Tools:** Git & GitHub
- **UI/UX Design Tools:** Figma / Canva (for mockups and wireframes)

## ⚙️ Key Features

### 👨‍🦰 User Features
- **User Registration & Login**: Secure sign-up and login with validation.
- **Profile Management**: View and update personal details.
- **Product Catalog**: Browse and search for dog food and nutrition products.
- **Shopping Cart**: Add, remove, and update items in the cart.
- **Checkout & Order Placement**: Complete purchases securely.
- **Educational Articles**: Access informative content about dog nutrition.
- **Navigation Menu**: Easy access to all sections of the app.

### 🔐 Admin Panel
- **Login**: Exclusive admin dashboard access.
- **Product Management**: Add, edit, delete, and view products.
- **Article Management**: Upload and update educational content.
- **User Management**: View registered users.

### 📱 Responsive UI
- Fully responsive layout for various screen sizes.
- Intuitive navigation and smooth transitions.

### 🛡️ Security & Testing
- Input validation and error handling.
- Role-based access control (User/Admin).
- Over 20 test cases performed covering functionality, usability, and edge cases.
- Screenshots available for each test case.

## 🔒 User Credentials for Testing
Admin:
Email: admin@example.com
Password: adminpass

User:
Email: Rishinishakya@gmail.com
Password: 1234

## 📁 Project Structure
/app/
│
├── manifests/
│   └── AndroidManifest.xml
├── java/
│   └── com.example.dogfoodapp/
│       ├── AdminDashboardActivity.java
│       ├── Category.java
│       ├── CategoryAdapter.java
│       ├── DatabaseHelper.java
│       ├── LoginActivity.java
│       ├── MainActivity.java
│       ├── ManageProductsActivity.java
│       ├── Product.java
│       ├── ProductAdapter.java
│       ├── ProductCatalogActivity.java
│       ├── ProductDetailActivity.java
│       ├── ProductListActivity.java
│       ├── ProductManagementAdapter.java
│       ├── ProfileActivity.java
│       ├── RegistrationActivity.java
│       ├── Review.java
│       ├── ReviewAdapter.java
│       └── UserDashboardActivity.java
├── res/
│   ├── drawable/
│   ├── font/
│   ├── layout/
│   ├── mipmap/
│   ├── values/
│   └── xml/
├── java (generated)/
├── res (generated)/
├── Gradle Scripts/
│   ├── build.gradle.kts (Project: DogFoodApp)
│   └── build.gradle.kts (Module :app)
├── proguard-rules.pro
├── gradle.properties
├── gradle-wrapper.properties
├── libs.versions.toml
└── local.properties

## 📊 Database (If using local SQLite or Firebase)
Includes tables/entities such as:
- `users` – stores user profiles
- `products` – product catalog
- `cart_items` – user shopping cart data
- `orders` – order history
- `articles` – educational content

## ✅ Test Cases Overview
- Total: 26+ test cases
- Coverage: Registration, login, profile update, product management, cart operations, checkout, article viewing
- All passed with confirmation and screenshots included in `/test_cases/`

## 📷 Screenshots & Demo

Screenshots and UI mockups are available in the `/mockups` and `/test_cases` folders. These include:

- Main Page
- Login Page
- Register Page
- Product Catalog
- Shopping Cart
- Admin Dashboard
- Checkout Process

## 🧠 Lessons Learned

- Full lifecycle development of a mobile app from planning to testing.
- Importance of clean UI/UX design and user-centered thinking.
- Implementing robust user authentication and role-based access.
- Managing complex workflows like cart and checkout systems.
- Using Android Studio effectively for debugging and performance tuning.

## 🛡️ License
This project is licensed under a custom license based on  
**CC BY-NC-ND 4.0**.

© 2025 Rishini Shakya | University of Colombo School of Computing

You may:
- View, use, and share the content for personal, educational, and non-commercial purposes.

You may not:
- Modify, redistribute, or use this portfolio commercially without written permission.
See the full LICENSE file for more information.

---

## 📬 Contact
For questions, feedback, or collaboration opportunities, reach out via:
- Email: [pethumhewage66@gmail.com](mailto:pethumhewage66@gmail.com)

---

> “Help your furry friend eat well and live better – with Best Mart Pet Care!”
