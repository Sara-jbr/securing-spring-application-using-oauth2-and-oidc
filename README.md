# Overview of Securing Applications with OAuth 2 and OpenID Connect

## Prerequisites

- [**JDK 8+**](https://adoptopenjdk.net/)
- [**Keycloak**](https://www.keycloak.org/)
- [**Spring Boot**](https://spring.io/projects/spring-boot)
- [**Maven**](https://maven.apache.org/download.cgi)
  
## Overview

**OAuth 2.0** and **OpenID Connect (OIDC)** provide secure methods to authorize and authenticate users in modern applications. OAuth 2.0 allows third-party applications to access user resources securely without requiring credentials, while OpenID Connect extends OAuth 2.0 to handle identity verification. Together, these protocols establish robust security, especially for distributed systems like microservices architectures.

---

## Introduction to Application Security

In distributed applications, particularly microservices, securing user data and access is critical. **Application security** involves:

1. **Identification**: Users claim their identity, typically through a username or email.
2. **Authentication**: The system verifies the identity claim using methods such as passwords or tokens.
3. **Authorization**: The system assigns permissions, determining which resources the user can access.

These steps form a foundational approach to access control, ensuring user privileges are managed securely and effectively.

---

## Example System: Bookshop

Consider a hypothetical **Bookshop** system where users access services through an API gateway, which manages requests to underlying microservices (e.g., inventory, orders, and book details). This setup represents a typical microservices architecture.

### Initial Setup Without Security

In a basic setup, the **book service** might be a Spring Boot application with endpoints for managing books, allowing unsecured GET and POST requests. Without security, services remain vulnerable to unauthorized access.

---

## Implementing Spring Security

**Spring Security** is a powerful framework for securing Spring applications, offering:

- Authentication support (username/password, OAuth 2.0, OpenID Connect)
- Endpoint-level authorization
- Protection against common threats, like Cross-Site Request Forgery (CSRF) and session fixation

### Authentication Flow in a Secured System

In this scenario, the **edge service** (API gateway) initiates authentication by delegating it to a trusted authorization service, such as **Keycloak**. Using OpenID Connect, Keycloak verifies the user’s identity, allowing the edge service to securely trust and grant access.

---

## Integration with Keycloak

Keycloak serves as the **authorization server**, handling authentication requests from the edge service. Keycloak uses OpenID Connect to authenticate users, enabling centralized management of authentication and authorization across microservices.

### Security Policies Configuration

Developers configure **security policies** in the edge service, requiring authentication to access certain endpoints. Unauthenticated users are redirected to Keycloak’s login page, providing centralized and consistent authentication.

---

## Delegated Access to Microservices

Post-authentication, the edge service accesses backend microservices on behalf of the user. Keycloak issues an **access token** upon successful login, allowing secure access to protected resources within microservices.

---

## Conclusion

The combination of OAuth 2.0 and OpenID Connect delivers a flexible framework for managing authentication and authorization in microservices-based applications, ensuring secure access and data protection.

---

## OAuth 2.0 Overview

OAuth 2.0 enables secure third-party access to user information without compromising credentials. It relies on **access tokens** for resource access.

### Key Components

- **Access Tokens**: Temporary tokens issued by the authorization server, permitting specific actions in the application.
- **Resource Server**: Validates access tokens and serves protected resources, allowing only authorized requests.

---

## Security Configuration with Spring Security

With Spring Security, resources like a book service can be secured by requiring **OAuth 2.0** authentication and **JWT (JSON Web Tokens)** for access tokens, which are compact and secure.

### Authentication Flow

Services communicate using **token relay**, passing access tokens in headers to ensure secure and stateless backend interactions.

---

## Single Page Applications (SPAs)

SPAs need special configurations for security:

1. **CSRF Protection**: SPAs often require CSRF tokens in cookies.
2. **Login Flow**: SPAs typically initiate login through a button that redirects to the authentication provider.

---

## Logout Mechanism

**Client-Initiated Logout** propagates logout requests to the authorization provider (e.g., Keycloak), logging users out of both the application and authentication provider.

---

## Authorization Considerations

OAuth 2.0 manages authorization using **roles and permissions** embedded in access tokens as scopes or claims, enabling fine-grained access control.

---

## Additional Resources

For more on Spring Security, OAuth 2.0, and OpenID Connect, visit [Spring Security Documentation](https://spring.io/projects/spring-security) and [OAuth 2.0 Specification](https://oauth.net/2/).
