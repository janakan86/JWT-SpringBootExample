# JWT-SpringBootExample
To document
- how to run
- user account details
- simple jwt example document


Table of contents <br>
[How to run the role based security example](https://github.com/janakan86/JWT-SpringBootExample/edit/main/README.md#how-to-run-the-role-based-security-example)



## How to run the role based security example.
Check out the code from the branch [role based security](https://github.com/janakan86/JWT-SpringBootExample/tree/RoleBasedSecurity) <br/><br/>
Run the JwtExampleApplication.java<br/>

Open postman and login using the user jana who is not an admin<br/>
<img width="80%" height="auto" alt="Screenshot 2025-07-16 at 6 35 56 am" src="https://github.com/user-attachments/assets/92e34e6b-9138-456c-9368-6c499ffe3f73" />

copy the returned JWT token.(without the word bearer) <br/>
<img width="80%" height="auto" alt="Screenshot 2025-07-16 at 6 40 18 am" src="https://github.com/user-attachments/assets/521d46de-2205-43ee-8aa4-79fa82f6a3c1" />


Paste the copied token on the subsequent request and we try to access a URL meant for admins only.<br/>
The access is denied because the user "jana" is not an admin <br/>
<img width="80%" height="auto" alt="Screenshot 2025-07-16 at 6 44 28 am" src="https://github.com/user-attachments/assets/7264c61e-cdcf-41da-9794-54be1785aee7" />


Now we try the same approach with the user "admin"
<img width="80%" height="auto" alt="Screenshot 2025-07-16 at 6 46 14 am" src="https://github.com/user-attachments/assets/b4edb723-a9e4-4a88-a987-be55721b1461" />

The user is allowed to access the url meant only for the admins
<img width="80%" height="auto" alt="Screenshot 2025-07-16 at 6 49 13 am" src="https://github.com/user-attachments/assets/cf68e8e2-aa8b-4e14-b476-a0b09249421c" />
