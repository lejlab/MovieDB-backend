**GET all movies**
----
  Returns json array data about all movie records in database.

* **URL**

  /movies

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, username : username, password : "test_password", avatarUrl : "test_avatarUrl, role : roleObject, owners : User[], subscriber: User[], notifications: Notification[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
![image info](./MoviesPostman/GetMoviesSuccess.png)

**GET movie by ID**
----
  Returns json data about a single movie found by ID.

* **URL**

  /movies/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />

* **Error Response:**

  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "Could not find user with ID = :id." }`
    
* **Sample Call:**

![image info](./MoviesPostman/GetMovieIdSucess.png)
