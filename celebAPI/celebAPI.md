**Show Celebs**
----
  Returns json data about a single user.

* **URL**

  /celebs

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
 
 
 **Show Celebs**
----
  Returns json data about a single user.

* **URL**

  /celebs/name

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   name

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{ id : 2, firstName : "Brad", lastName : "Pitt" }`
 
* **Error Response:**

 Not tested

* **Sample Call:**

 @GetMapping("/celebs/{name}")
    public List<Celeb> find(@PathVariable("name") String name) {
        return celebsRepository.findByName(name);
    }
 
