**Show Celebs**
----
  Returns json data about a single user.

* **URL**

  /users

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 2, firstName : "Brad", lastName : "Pitt" }`
 
* **Error Response:**

 Not tested

* **Sample Call:**

 @GetMapping("/celebs")
    public List<Celeb> find() {
        return celebsRepository.findAll();
    }
 
