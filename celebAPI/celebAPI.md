**Show Celebs**
----
  Returns json data about all celebs.

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
 
 
 
 
 
 
 **Show Celeb**
----
  Returns json data about a single celeb.

* **URL**

  /celebs/:name

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   name=[integer]

* **Data Params**

  None

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/celebs/{name}")
    public List<Celeb> find(@PathVariable("name") String name) {
        return celebsRepository.findByName(name);
    }
 
 
 
 
 
 **Show Celeb**
----
  Returns json data about a single celeb.

* **URL**

  /celebs/:date

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   date=[Date]

* **Data Params**

  None

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

 @GetMapping("/celebs/{date}")
    public List<Celeb> find(@PathVariable("name") Date date) {
        return celebsRepository.findByDateOfBirth(date);
    }
  
  
  
  
 
 
 
 * **Show Jobs**
----
  Returns json data about all jobs.

* **URL**

  /jobs

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   None

* **Data Params**

  None

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/jobs")
    public List<Job> find() {
        return jobsRepository.findAll();
    }
 

  
  
 
 
 
 * **Show celeb_jobs**
----
  Returns json data about all celeb_jobs.

* **URL**

  /celeb_jobs

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   None

* **Data Params**

  None

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/celebjobs")
    public List<CelebJobs> find() {
        return celebJobsRepository.findAll();
    }


 

  
  
 
 
 
 * **Show celeb_jobs**
----
  Returns json data about celeb_jobs with some celebID.

* **URL**

  /celeb_jobs/:id?type="celeb"

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   id=[integer]

* **Data Params**

  type="celeb"

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/celebjobs/{id}")
    public List<CelebJobs> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer celebJobId = parseInt(id);

        if (type.equals("celeb")){
            return celebJobsRepository.findByCelebId(celebJobId);
        }
        else if (type.equals("job")) {
            return celebJobsRepository.findByJobId(celebJobId);
        }
        else {
            return new ArrayList<CelebJobs>();
        }
    }
    


  
  
 
 
 
 * **Show celeb_jobs**
----
  Returns json data about celeb_jobs with some jobID.

* **URL**

  /celeb_jobs/:id?type="job"

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   id=[integer]

* **Data Params**

  type="job"

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/celebjobs/{id}")
    public List<CelebJobs> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type){
        Integer celebJobId = parseInt(id);

        if (type.equals("celeb")){
            return celebJobsRepository.findByCelebId(celebJobId);
        }
        else if (type.equals("job")) {
            return celebJobsRepository.findByJobId(celebJobId);
        }
        else {
            return new ArrayList<CelebJobs>();
        }
    }
  

  
    

 
 
 * **Show movie_celebs**
----
  Returns json data about all movie_celebs.

* **URL**

  /movie_celebs

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   None

* **Data Params**

  None

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

  @GetMapping("/moviecelebs")
    public List<MovieCeleb> find(){
        return movieCelebsRepository.findAll();
    }
   
  
 
 
 
 * **Show movie_celebs**
----
  Returns json data about movie_celebs with some celebID.

* **URL**

  /movie_celebs/:id?type="celeb"

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   id=[integer]

* **Data Params**

  type="celeb"

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

   @GetMapping("/moviecelebs/{id}")
    public List<MovieCeleb> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type) {
        Integer movieCelebId = parseInt(id);

        if (type.equals("celeb")) {
            return movieCelebsRepository.findByCelebId(movieCelebId);
        } else if (type.equals("movie")) {
            return movieCelebsRepository.findByMovieId(movieCelebId);
        } else {
            return new ArrayList<MovieCeleb>();
        }
    }
    

 
 
 * **Show movie_celebs**
----
  Returns json data about movie_celebs with some movieID.

* **URL**

  /movie_celebs/:id?type="movie"

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   id=[integer]

* **Data Params**

  type="movie"

* **Success Response:**

  Not tested
 
* **Error Response:**

  Not tested

* **Sample Call:**

   @GetMapping("/moviecelebs/{id}")
    public List<MovieCeleb> findByUserId(@PathVariable(value = "id") String id, @RequestParam String type) {
        Integer movieCelebId = parseInt(id);

        if (type.equals("celeb")) {
            return movieCelebsRepository.findByCelebId(movieCelebId);
        } else if (type.equals("movie")) {
            return movieCelebsRepository.findByMovieId(movieCelebId);
        } else {
            return new ArrayList<MovieCeleb>();
        }
    }    
