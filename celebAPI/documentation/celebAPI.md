**GET all jobs**
----
  Returns json array data about all jobs records in database.

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

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "title": "Actor",
                          "celebs": [
                              {
                                  "id": 1,
                                  "celeb": {
                                      "id": 1,
                                      "firstName": "Nebojsa",
                                      "lastName": "Glogovac",
                                      "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                                      "movies": [
                                          {
                                              "id": 1
                                          }
                                      ]
                                  }
                              },
                              {
                                  "id": 2,
                                  "celeb": {
                              ...    
`
 
* **Error Response:**

  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**

  ![image info](./jobPostman/getAll.png)
  
**GET job by ID**
----
  Returns json data about single job found by ID.

* **URL**

  /jobs/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                      "id": 3,
                      "title": "Producer",
                      "celebs": [
                          {
                              "id": 8,
                              "celeb": {
                                  "id": 2,
                                  "firstName": "Brad",
                                  "lastName": "Pitt",
                                  "dateOfBirth": "1963-12-18T00:00:00.000+0000",
                                  "movies": [
                                      {
                                          "id": 2
                                      },
                                      {
                                          "id": 8
                                      }
                                  ]
                              }
                          },
                          {
                              "id": 10,
                              "celeb": {
                                  "id":
                          ...        
`
 
* **Error Response:**
  * **Code:** 404 Not Found Error <br />
      **Content:** `{ message : "Could not find job with id = :id" }`  
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
  * **Success:**
  ![image info](./jobPostman/getOneById.png)
  * **Error:**
  ![image info](./jobPostman/getOneByIdNF.png)
    

**GET all celebs**
----
  Returns json array data about all celebs records in database.

* **URL**

  /celebs

* **Method:**

  `GET`
  
* **URL Params**

  **Required:**
 
  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "firstName": "Nebojsa",
                          "lastName": "Glogovac",
                          "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                          "jobs": [
                              {
                                  "id": 1,
                                  "job": {
                                      "id": 1,
                                      "title": "Actor"
                                  }
                              }
                          ],
                          "movies": [
                              {
                                  "id": 1
                              }
                          ]
                      },
                      {
                          "id": 2,
                          "firstName": "Brad",
                          "lastName": "Pitt",
                      ...    
`
 
* **Error Response:**
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
    
    ![image info](./celebPostman/getAll.png)

 
 **GET celeb by ID**
----
  Returns json data about single celeb found by ID.

* **URL**

  /celebs/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                      "id": 2,
                      "firstName": "Brad",
                      "lastName": "Pitt",
                      "dateOfBirth": "1963-12-18T00:00:00.000+0000",
                      "jobs": [
                          {
                              "id": 2,
                              "job": {
                                  "id": 1,
                                  "title": "Actor"
                              }
                          },
                          {
                              "id": 8,
                              "job": {
                                  "id": 3,
                                  "title": "Producer"
                              }
                          }
                      ],
                      "movies": [
                          {
                              "id": 2
                          },
                          {
                              "id": 8
                          }
                      ]
                  }`
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb with id = :id" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
  * **Success:**
  ![image info](./celebPostman/getOneById.png)
  * **Error:**
  ![image info](./celebPostman/getOneByIdNF.png)  
  
  
 **GET all celeb by name**
----
  Returns json array data about all celeb records with some name in database.

* **URL**

  /celebs/identification/:name?type=name

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `name=[string]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `[
                        {
                            "id": 2,
                            "firstName": "Brad",
                            "lastName": "Pitt",
                            "dateOfBirth": "1963-12-18T00:00:00.000+0000",
                            "jobs": [
                                {
                                    "id": 2,
                                    "job": {
                                        "id": 1,
                                        "title": "Actor"
                                    }
                                },
                                {
                                    "id": 8,
                                    "job": {
                                        "id": 3,
                                        "title": "Producer"
                                    }
                                }
                            ],
                            "movies": [
                                {
                                    "id": 2
                                },
                                {
                                    "id": 8
                                }
                            ]
                        }
                    ]`
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./celebPostman/getAllbySomethingName.png)
  * **Error:**
  ![image info](./celebPostman/getAllbySomethingTypeNF.png)
  
**GET all celeb by date of birth**
----
  Returns json array data about all celeb records with some date of birth in database.

* **URL**

  /celebs/identification/:date?type=date

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `date=[string]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `[
                        {
                            "id": 1,
                            "firstName": "Nebojsa",
                            "lastName": "Glogovac",
                            "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                            "jobs": [
                                {
                                    "id": 1,
                                    "job": {
                                        "id": 1,
                                        "title": "Actor"
                                    }
                                }
                            ],
                            "movies": [
                                {
                                    "id": 1
                                }
                            ]
                        }
                    ]`
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./celebPostman/getAllbySomethingDate.png)
  * **Error:**
  ![image info](./celebPostman/getAllbySomethingTypeNF.png)
     
**GET all celeb jobs**
----
  Returns json array data about all celeb jobs records in database.

* **URL**

  /celebjobs

* **Method:**

  `GET`
  
* **URL Params**

  **Required:**
 
  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "job": {
                              "id": 1,
                              "title": "Actor"
                          },
                          "celeb": {
                              "id": 1,
                              "firstName": "Nebojsa",
                              "lastName": "Glogovac",
                              "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                              "movies": [
                                  {
                                      "id": 1
                                  }
                              ]
                          }
                      },
                      {
                          "id": 2,
                          "job": {     
                      ...
    `
 
* **Error Response:**
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
    
    ![image info](./CelebJobPostman/getAll.png)  

**GET celeb by ID**
----
  Returns json data about single celeb job found by ID.

* **URL**

  /celebjobs/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                     "id": 2,
                     "firstName": "Brad",
                     "lastName": "Pitt",
                     "dateOfBirth": "1963-12-18T00:00:00.000+0000",
                     "jobs": [
                         {
                             "id": 2,
                             "job": {
                                 "id": 1,
                                 "title": "Actor"
                             }
                         },
                         {
                             "id": 8,
                             "job": {
                                 "id": 3,
                                 "title": "Producer"
                             }
                         }
                     ],
                     "movies": [
                         {
                             "id": 2
                         },
                         {
                             "id": 8
                         }
                     ]
                 }
  `
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb job with id = :id" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
  * **Success:**
  ![image info](./CelebJobPostman/getOneById.png)
  * **Error:**
  ![image info](./CelebJobPostman/getOneByIdNF.png)  
  
**GET all celeb jobs by celebId**
----
  Returns json array data about all celeb job records with some celebId in database.

* **URL**

  /celebjobs/list/:id?type=celeb

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `[
                        {
                            "id": 6,
                            "job": {
                                "id": 2,
                                "title": "Director"
                            },
                            "celeb": {
                                "id": 6,
                                "firstName": "Frank",
                                "lastName": "Darabont",
                                "dateOfBirth": "1959-01-28T00:00:00.000+0000",
                                "movies": [
                                    {
                                        "id": 6
                                    },
                                    {
                                        "id": 7
                                    }
                                ]
                            }
                        },
                        {
                            "id": 7,
      `
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb job with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./CelebJobPostman/getAllbyIdTypeCeleb.png)
  * **Error:**
  ![image info](./CelebJobPostman/getAllbyIdTypeTypeNF.png)

**GET all celeb jobs by jobId**
----
  Returns json array data about all celeb job records with some jobId in database.

* **URL**

  /celebjobs/list/:id?type=job

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `[
                        {
                            "id": 7,
                            "job": {
                                "id": 3,
                                "title": "Producer"
                            },
                            "celeb": {
                                "id": 6,
                                "firstName": "Frank",
                                "lastName": "Darabont",
                                "dateOfBirth": "1959-01-28T00:00:00.000+0000",
                                "movies": [
                                    {
                                        "id": 6
                                    },
                                    {
                                        "id": 7
                                    }
                                ]
                            }
                        },
                        {
                            "id": 8,
                        ...    
      `
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find celeb job with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./CelebJobPostman/getAllbyIdTypeJob.png)
  * **Error:**
  ![image info](./CelebJobPostman/getAllbyIdTypeTypeNF.png)

**GET all movie celebs**
----
  Returns json array data about all celeb jobs records in database.

* **URL**

  /moviecelebs

* **Method:**

  `GET`
  
* **URL Params**

  **Required:**
 
  None

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
                      {
                          "id": 1,
                          "celeb": {
                              "id": 1,
                              "firstName": "Nebojsa",
                              "lastName": "Glogovac",
                              "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                              "jobs": [
                                  {
                                      "id": 1,
                                      "job": {
                                          "id": 1,
                                          "title": "Actor"
                                      }
                                  }
                              ]
                          },
                          "movieId": 1
                      },
                      {
                          "id": 2,
                 ...
    `
 
* **Error Response:**
    
  * **Code:** 500 Internal Server Error <br />
    **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
    
    ![image info](./MovieCelebPostman/getAll.png)  

**GET movie celeb by ID**
----
  Returns json data about single movie celeb found by ID.

* **URL**

  /moviecelebs/:id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
                      "id": 5,
                      "celeb": {
                          "id": 5,
                          "firstName": "Tim",
                          "lastName": "Robbins",
                          "dateOfBirth": "1958-10-16T00:00:00.000+0000",
                          "jobs": [
                              {
                                  "id": 5,
                                  "job": {
                                      "id": 1,
                                      "title": "Actor"
                                  }
                              },
                              {
                                  "id": 12,
                                  "job": {
                                      "id": 2,
                                      "title": "Director"
                                  }
                              },
                              {
                                  "id": 13,
                                  "job": {
                                      "id": 3,
                                      "title": "Producer"
                                  }
                              }
                          ]
                      },
                      "movieId": 1
                  }
  `
 
* **Error Response:**

  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find movie celeb with id = :id" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`

* **Sample Call:**
  * **Success:**
  ![image info](./MovieCelebPostman/getOneById.png)
  * **Error:**
  ![image info](./MovieCelebPostman/getOneByIdNF.png)  
  
**GET all movie celebs by celebId**
----
  Returns json array data about all movie celebs records with some celebId in database.

* **URL**

  /moviecelebs/list/:id?type=celeb

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `
      [
          {
              "id": 1,
              "celeb": {
                  "id": 1,
                  "firstName": "Nebojsa",
                  "lastName": "Glogovac",
                  "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                  "jobs": [
                      {
                          "id": 1,
                          "job": {
                              "id": 1,
                              "title": "Actor"
                          }
                      }
                  ]
              },
              "movieId": 1
          }
      ]
      `
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find movie celeb with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./MovieCelebPostman/getAllbyIdTypeCeleb.png)
  * **Error:**
  ![image info](./MovieCelebPostman/getAllbyIdTypeTypeNF.png)

**GET all movie celebs by movieId**
----
  Returns json array data about all movie celebs records with some movieId in database.

* **URL**

  /moviecelebs/list/:id?type=movie

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  `type=[string]`

* **Success Response:**

  * **Code:** 200 <br />
      **Content:** `[
                        {
                            "id": 1,
                            "celeb": {
                                "id": 1,
                                "firstName": "Nebojsa",
                                "lastName": "Glogovac",
                                "dateOfBirth": "1969-08-30T00:00:00.000+0000",
                                "jobs": [
                                    {
                                        "id": 1,
                                        "job": {
                                            "id": 1,
                                            "title": "Actor"
                                        }
                                    }
                                ]
                            },
                            "movieId": 1
                        },
                        {
                            "id": 2,
                   ...    
      `
 
* **Error Response:**
    
  * **Code:** 404 Not Found Error <br />
        **Content:** `{ message : "Could not find movie celeb with type = type" }`  
      
  * **Code:** 500 Internal Server Error <br />
      **Content:** `{ message : "...", details : "..." }`


* **Sample Call:**
  * **Success:**
  ![image info](./MovieCelebPostman/getAllbyIdTypeMovie.png)
  * **Error:**
  ![image info](./MovieCelebPostman/getAllbyIdTypeTypeNF.png)
