# FinalProject
This is my Final Project for the Promineo Tech Back-End course. It is a database for the scenario of a veterinarian that specializes in cats! There are three entities: cats, owners, and doctors. Currently Cat and Owner have full CRUD operation, while Doctor simply allows you to fetch the information of a given doctor. There is also a method to assign a many-to-many relationship between a doctor and a cat.

Design flaws that I am aware of: 
-the update methods are based on a given cat or owner id, so it is not currently changeable while the rest of the info is malleable.
-a cat's age can only be given in years
-the only method of getting a primary key to enter a relationship is fetching the entity, which consumes extra time
-due to time constraints, doctors can only be fetched
