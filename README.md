# OAuth2 Login with React JS

This project demonstrates how to implement OAuth2 login in a **React JS** application, using Google OAuth2 authentication.

#Features
- Google OAuth2 login.
- Secure user authentication flow.
- Responsive UI with Google login button.
- Display authenticated user profile data.

# Prerequisites

Ensure you have the following installed:
- Node.js (v14 or above)
- npm or yarn
- JDK 17
- A backend with OAuth2 support (e.g., Spring Boot or any other OAuth2 service)

# Steps to Get OAuth2 Credentials
1. Create a Google Cloud Project
- Go to the Google Cloud Console.
- Sign in with your Google account.
- Click on the Select a project dropdown at the top and select New Project.
- Enter your project name and click Create.
  
2. Enable the OAuth2 API
- In the left-hand menu, navigate to APIs & Services > Library.
- Search for Google OAuth2 API.
- Click on the Google OAuth2 API result and then click Enable.
  
3. Configure OAuth2 Consent Screen
- In the left-hand menu, click on OAuth Consent Screen.
- Select the type of app (for most apps, you’ll select External).
- Fill in the required details (App Name, User Support Email, etc.).
- Under Scopes, click Add or Remove Scopes and add the appropriate scopes for your app (e.g., email, profile).
- Click Save and Continue.
  
4. Create OAuth2 Credentials
In the left-hand menu, navigate to Credentials.
- Click on Create Credentials and choose OAuth 2.0 Client ID.
- Select the Web Application type.
- Under Authorized redirect URIs, enter the redirect URL for your backend (e.g., http://localhost:8080/login/oauth2/code/google).
- Click Create.
  
5. Get Your Client ID and Client Secret
- After creating the credentials, you’ll see the Client ID and Client Secret. Save these values somewhere secure.
  
6. Configure Your Backend (Spring Boot)
- In your Spring Boot application, you’ll need to configure these credentials in your application.yml or application.properties file.

# Getting Started

# 1. Clone the Repository

```bash
https://github.com/Prathamesh-Jagtap/SpringBoot-React-Oauth2.git
cd SpringBoot-React-Oauth2/frontend
cd SpringBoot-React-Oauth2/backend
```

# Install Dependencies

```bash
npm install
```

# Build and Run the Application

```bash
//frontend
npm run dev
//backend
mvn clean install
mvn spring-boot:run
```

