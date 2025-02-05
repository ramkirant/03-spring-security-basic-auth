# Spring Security Basic Authentication

Spring enables basic authentication by default when we include the spring security jars in pom.xml. This basic authentication is achieved using an user name and password. 

When we start the application spring security would generate a default password to be used for authentication. This default password is to be used only for development purposes. Default user name we can use is user. 

We can customize the default password and default username using the below properties 

1. spring.security.user.name
2. spring.security.user.password

## Session Management
Once we login using the username and password, Spring would generate a session and associate it with a session id. For further interactions, it would be enough for the client to send this generated session id and not the credentials. This session will be active till:

1. The user logs out by visiting the logout screen.
2. The session times out. Spring security as such don't have a default timeout. It inherits the timeout from the underlying container. For Tomcat and Jetty, the timeout would be 30 minutes. 

### How can we configure the session timeout
Session timeout can be configured using the property server.servlet.session.timeout. This property captures the timeout in seconds. 

## CSRF
CSRF stands for Cross Site Request Forgery. CSRF is a web security vulnerability where an attacker would trick the user to perform actions that he has not indented to do. Attackers achieve this by sending a malicious link to the user and by tricking him to click it.

As mentioned before, when Spring Security is enabled, once the user logs in using his credentials, Spring would generate a session and would store it in the browser as a cookie. When the user clicks on the malicious link when the session is stored as a cookie on the browser, the attacker would steal the cookie and sends his malicious request to the server using the same session id. Server assumes that the request came from the legitimate user and performs the activity. 



