**GET all users**
----
  Returns json array data about all user records in database.

* **URL**

  /users

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
![image info](./UsersPostman/GetUsersSuccess.png)

**GET user by ID**
----
  Returns json data about a single user found by ID.

* **URL**

  /users/:id

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}`
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find user with ID = :id." }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
![image info](./UsersPostman/GetUserByUserIdObjectJson.png)

**GET user by username**
----
  Returns json data about a single user found by username.

* **URL**

  /users/:username

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `username=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}`
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find user with username = :username." }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](./UsersPostman/GetUsersByUsernameSuccess.png)

**ADD new user**
----
  Returns json data about a single user added by API call.

* **URL**

  /users

* **Method:**

  `POST`
  
* **Data params: **
   * **Required: ** 
 
   `username=[string]`
   `password=[string]`
   `avatarUrl=[string]`

  * **Optional: **
    `role=[Role]`
    `owners=[User[]]`
    `subscribers=[User[]]`
    `notifications=[Notification[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}`
 
* **Error Response:**
  * **Code:** 500 Internal Server Error<br />
    
* **Sample Call:**
  * **Success:**
  ![image info](./UsersPostman/PostUsersSuccess.png)
  
**EDIT existing user**
----
  Returns json data about a single user edited by API call.

* **URL**

  /users

* **Method:**

  `PUT`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`
  
* **Data params: **
   **Required: ** 
 
   `username=[string]`
   `password=[string]`
   `avatarUrl=[string]`

  **Optional: **
    `role=[Role]`
    `owners=[User[]]`
    `subscribers=[User[]]`
    `notifications=[Notification[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}`
 
    
* **Sample Call:**
  * **Success:**
  ![image info](./UsersPostman/UpdateUserSuccess.png)
  
  * **Success (ID not found):**
  ![image info](./UsersPostman/UpdateUserSuccessNotFounded.png)
  
 **DELETE user by ID**
----
  Deletes user found by ID.

* **URL**

  /users/:id

* **Method:**

  `DELETE`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find user with ID = :id." }`
    
   * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](./UsersPostman/DeleteUserSuccess.png)
  * **Error:**
  ![image info](./UsersPostman/DeleteUserFail.png)
  
**GET all roles**
----
  Returns json array data about all role records in database.

* **URL**

  /roles

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, type: "rolename", users: User[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
![image info](./RolesPostman/GetRoles.png)


**GET role by ID**
----
  Returns json data about a single role found by ID.

* **URL**

  /roles/:id

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, type: "rolename", users: User[]}`
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find user with ID = :id." }`
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](./RolesPostman/GetRoleByIdSuccess.png)
  * **Error:**
  ![image_info](./RolesPostman/GetRoleByIdFail.png)
  
**GET role by type**
----
  Returns json data about a single role found by type.

* **URL**

  /roles/identification/:type

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, type: :type", users: User[]}`
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find user with type = :type." }`

  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](./RolesPostman/GetRoleByTypeSuccess.png)
  * **Error:**
  ![image_info](./RolesPostman/GetRoleByTypeFail.png)
  
**ADD new role**
----
  Returns json data about a single role added by API call.

* **URL**

  /roles
* **Method:**

  `POST`
  
* **Data params: **
   * **Required: ** 
 
   `type=[string]`

  * **Optional: **
    `type=[string]`
    `users=[User[]]`

    
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, type : type, users : User[]}`
 
* **Error Response:**
  * **Code:** 500 Internal Server Error<br />
    
* **Sample Call:**
  * **Success:**
  ![image info](./RolesPostman/AddRole.png)
  
**EDIT existing role**
----
  Returns json data about a single role edited by API call.

* **URL**

  /roles

* **Method:**

  `PUT`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`
  
*  **Data params: **
   **Required: ** 
 
   `type=[string]`

   **Optional: **
    `users=[User[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 1, type : type, users : User[]}`
 
    
* **Sample Call:**
  * **Success:**
  ![image info](./RolesPostman/UpdateRoleSuccess.png)
 
 
 **DELETE role by ID**
----
  Deletes role found by ID.

* **URL**

  /roles/:id

* **Method:**

  `DELETE`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 Error Not Found <br />
    **Content:** `{ message : "Could not find role with ID = :id." }`
    
   * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "..." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](./RolesPostman/DeleteRoleSuccess.png)
  * **Error:**
  ![image info](./RolesPostman/DeleteRoleFail.png)
