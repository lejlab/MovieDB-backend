**Users**
----
  Returns json array data about all user records in database.

* **URL**

  /users

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, username : "test_username", password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], notifications: User[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
![logo2](./UsersPostman/GetUsersSuccess.png)
Format: ![Alt Text](url)
  ```
