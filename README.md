# JWT-SpringBootExample
A simple example to demonstrate how to use JWT in a spring boot application


How to run the role based security example.
Check out the code from the branch [Role based security](https://github.com/janakan86/JWT-SpringBootExample/tree/RoleBasedSecurity)
Run the JwtExampleApplication.java<br/>

Open postman and login using the user jana who is not an admin<br/>
<img width="100%" height="auto" alt="Screenshot 2025-07-16 at 6 35 56 am" src="https://github.com/user-attachments/assets/92e34e6b-9138-456c-9368-6c499ffe3f73" />

copy the returned JWT token. <br/>
<img width="100%" height="auto" alt="Screenshot 2025-07-16 at 6 40 18 am" src="https://github.com/user-attachments/assets/521d46de-2205-43ee-8aa4-79fa82f6a3c1" />


Paste the copied token on the subsequent request and we try to access a URL meant for admins only.<br/>
The access is denied because the user "jana" is not an admin <br/>
<img width="100%" height="auto" alt="Screenshot 2025-07-16 at 6 44 28 am" src="https://github.com/user-attachments/assets/7264c61e-cdcf-41da-9794-54be1785aee7" />




