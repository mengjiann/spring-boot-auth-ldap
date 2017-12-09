# Spring Boot Auth Ldap
Sample Spring Boot Web App Auth using Spring Data Ldap

# Note
- Use spring-data-ldap to implement custom authentication provider
- Use embedded ldap server for POC.
- Implement custom authentication success handler with redirection to the request path before login (spring session attribute:SPRING_SECURITY_SAVED_REQUEST)
- Use thymeleaf-extras-springsecurity4 to access authentication principal from Thymeleaf.

# References:
- https://www.ldap.com/unboundid-ldap-sdk-for-java
