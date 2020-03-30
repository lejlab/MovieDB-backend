**GET all movies**
----
  Returns json array data about all movie records in database.

* **URL**

  /movies

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, title : title, releaseDate: "releaseDate", boxOffice : "boxOffice", genres: Genre[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />

* **Sample Success Call:**
![image info](WatchlistPostman/getMoviesSuccess.png)

**GET movie by ID**
----
  Returns json data about a single movie found by ID.

* **URL**

  /movies/:id

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : 1, title : title, releaseDate: "releaseDate", boxOffice : "boxOffice", genres: Genre[]}, ...]`
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
    **Content:** `{ message : "Could not find movie with ID = :id." }`
    
* **Sample Call:**
    * **Error:**
    ![image info](WatchlistPostman/getMovieIdFail.png)
    
    * **Success:**
    ![image info](WatchlistPostman/getMovieIdSuccess.png)

**ADD new movie**
----
  Returns json data about a single movie added by API call.

* **URL**

  /movies

* **Method:**

  `POST`
  
* **Data params: **
   * **Required: ** 
 
   `title=[string]`
   `releaseDate=[Date]`
   `boxOffice=[double]`

  * **Optional: **
    `genres=[Genre[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, title : title, releaseDate: "releaseDate", boxOffice : "boxOffice", genres: Genre[]}`
 
* **Error Response:**
  * **Code:** 500 <br />
    
* **Sample Call:**
  * **Error:**
  ![image info](WatchlistPostman/addMovieFail.png)
  
  * **Success:**
  ![image info](WatchlistPostman/addMovieSuccess.png)
  
 **PUT movie**
----
  Returns json data about a single movie edited by API call.

* **URL**

  /movies

* **Method:**

  `PUT`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`
  
* **Data params: **
   * **Required: ** 
 
   `title=[string]`
   `releaseDate=[Date]`
   `boxOffice=[double]`

  * **Optional: **
     `genres=[Genre[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, title : title, releaseDate: "releaseDate", boxOffice : "boxOffice", genres: Genre[]}`
 
    
* **Sample Call:**
  * **Success:**
  ![image info](WatchlistPostman/putMovieSuccess.png)
  
  * **Error:**
  ![image info](WatchlistPostman/putMovieFail.png)
  
 **DELETE movie by ID**
----
  Deletes movie found by ID.

* **URL**

  /movies/:id

* **Method:**

  `DELETE`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 500 Internal Server Error <br />
    
* **Sample Call:**
  * **Success:**
  ![image info](WatchlistPostman/deleteMovieSuccess.png)
  
**GET all genres**
----
  Returns json array data about all genre records in database.

* **URL**

  /genres

* **Method:**

  `GET`
  
* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[{ id : id, name: name, movies: Movie[]}, ...]`
 
* **Error Response:**
  
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
![image info](ReviewsPostman/getGenresSuccess.png)


**GET genre by ID**
----
  Returns json data about a single genre found by ID.

* **URL**

  /genres/:id

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, name: name, movies: Movie[]}`
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
    **Content:** `{ message : "Could not find genre with ID = :id." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](ReviewsPostman/getGenreIdSuccess.png)
  * **Error:**
  ![image_info](ReviewsPostman/getGenreIdFail.png)
  
    
**ADD new genre**
----
  Adds new genre by API call.

* **URL**

  /genres

* **Method:**

  `POST`
  
* **Data params: **
   * **Required: ** 
 
   `name=[string]`

  * **Optional: **
    `movies=[Movie[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, name: name, movies: Movie[]}`
 
* **Error Response:**
  * **Code:** 500 <br />
    
* **Sample Call:**
  * **Error:**
  ![image info](ReviewsPostman/addGenreFail.png)
  
  * **Success:**
  ![image info](ReviewsPostman/addGenreSuccess.png)
  
 **PUT genre**
----
  Returns json data about a single genre edited by API call.

* **URL**

  /genres

* **Method:**

  `PUT`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`
  
* **Data params: **
   * **Required: ** 
 
   `name=[string]`

  * **Optional: **
     `movies=[Movie[]]`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : id, name : name, movies: Movie[]}`
 
    
* **Sample Call:**
  * **Success:**
  ![image info](ReviewsPostman/putGenreSuccess.png)
  
  * **Error:**
  ![image info](ReviewsPostman/putGenreFail.png)
  
 **DELETE genre by ID**
----
  Deletes genre found by ID.

* **URL**

  /genre/:id

* **Method:**

  `DELETE`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "Could not find genre with ID = :id." }`
    
* **Sample Call:**
  * **Success:**
  ![image info](ReviewsPostman/deleteGenreSuccess.png)
  * **Error:**
  ![image info](ReviewsPostman/deleteGenreFail.png)
  
**GET all genreMovies**
   ----
     Returns json array data about all genreMovie records in database.
   
   * **URL**
   
     /genreMovies
   
   * **Method:**
   
     `GET`
     
   * **Success Response:**
   
     * **Code:** 200 <br />
     
   * **Error Response:**
     
     * **Code:** 500 Internal Server Error <br />
   
   * **Sample Success Call:**
   ![image info](CommentsPostman/getGenreMoviesSuccess.png)
   
   **GET genreMovie by ID**
   ----
     Returns json data about a single genreMovie found by ID.
   
   * **URL**
   
     /genreMovies/:id
   
   * **Method:**
   
     `GET`
     
   *  **Path variables**
   
      **Required:**
    
      `id=[integer]`
   
   * **Success Response:**
   
     * **Code:** 200 <br />
     
   * **Error Response:**
   
     * **Code:** 404 Not Found Error <br />
       **Content:** `{ message : "Could not find genreMovie with ID = :id." }`
       
   * **Sample Call:**
       * **Error:**
       ![image info](CommentsPostman/getGenreMoviesIdFail.png)
       
       * **Success:**
       ![image info](CommentsPostman/getGenreMoviesIdSuccess.png)
       
       
**GET genreMovie by genre ID**
----
  Returns json data about a single genreMovie found by genreID.

* **URL**

  /genreMoviess/genre/:id

* **Method:**

  `GET`
  
*  **Path variables**

   **Required:**
 
   `id=[integer]`

* **Success Response:**

  * **Code:** 200 <br />
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
    **Content:** `{ message : "Could not find genreMovie with genreID = :id." }`
    
* **Sample Call:**
  * **Success:**
   ![image info](CommentsPostman/getGenreMovieByGenreIdSuccess.png)
  * **Error:**
   ![image_info](CommentsPostman/getGenreMovieByGenreIdFail.png)
  
  
**GET genreMovie by movie ID**
  ----
    Returns json data about a single genre found by movieID.
  
  * **URL**
  
    /genreMovies/movie/:id
  
  * **Method:**
  
    `GET`
    
  *  **Path variables**
  
     **Required:**
   
     `id=[integer]`
  
  * **Success Response:**
  
    * **Code:** 200 <br />
    
   
  * **Error Response:**
  
    * **Code:** 404 Not Found Error <br />
      **Content:** `{ message : "Could not find genreMovie with movie ID = :id." }`
      
  * **Sample Call:**
    * **Success:**
    ![image info](CommentsPostman/getGenreMovieByMovieIdSuccess.png)
    * **Error:**
    ![image_info](CommentsPostman/getGenreMovieByMovieIdFail.png)
   
   **ADD new genreMovie**
   ----
     Returns json data about a single genreMovie added by API call.
   
   * **URL**
   
     /movies
   
   * **Method:**
   
     `POST`
     
   * **Data params: **
      * **Required: ** 
    
      `genre=[Genre]`
      `movie=[Movie]`
      
   * **Success Response:**
   
     * **Code:** 200 <br />
     
   * **Error Response:**
     * **Code:** 500 <br />
       
   * **Sample Call:**
     * **Error:**
     ![image info](CommentsPostman/postGenreMovieFail.png)
     
     * **Success:**
     ![image info](CommentsPostman/postGenreMovieSuccess.png)
     
    **DELETE genreMovie by ID**
   ----
     Deletes genreMovie found by ID.
   
   * **URL**
   
     /genreMovies/:id
   
   * **Method:**
   
     `DELETE`
     
   *  **Path variables**
   
      **Required:**
    
      `id=[integer]`
   
   * **Success Response:**
   
     * **Code:** 200 <br />
    
   * **Error Response:**
   
     * **Code:** 500 Internal Server Error <br />
       
   * **Sample Call:**
     * **Error:**
     ![image info](CommentsPostman/deleteGenreMoviesIdFail.png)
     * **Success:**
     ![image info](CommentsPostman/deleteGenreMoviesIdSuccess.png)