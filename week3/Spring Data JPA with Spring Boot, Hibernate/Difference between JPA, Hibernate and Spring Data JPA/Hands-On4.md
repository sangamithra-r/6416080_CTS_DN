
# 4. Hands-On Lab: Difference between JPA, Hibernate, and Spring Data JPA
 summarization of  the practical differences between JPA, Hibernate, and Spring Data JPA based on my hands-on experience during the Week 3 Java lab.



##  JPA (Java Persistence API)

1) JPA is a standard/specification defined by JSR 338.
2) It defines how Java objects should be mapped to database tables.
3) Provides annotations like @Entity, @Id, @OneToMany, etc.
4) JPA itself has no implementation — it only sets the rules.
5) It needs a provider (like Hibernate) to work.

In lab: We used annotations like @Entity and @Id in our Spring Data JPA project.


## Hibernate

1) Hibernate is the most widely used implementation of JPA.
2) It’s an ORM (Object Relational Mapping) tool that manages the mapping between Java objects and database rows.
3) Adds features like lazy loading, caching, and automatic dirty checking.
4) Can be used directly (with configuration) or as a JPA provider under Spring.

In lab: Hibernate was automatically used under the hood when we used Spring Data JPA.

## Spring Data JPA

1) Spring Data JPA is a Spring module built on top of JPA and Hibernate.
2) It provides ready-to-use repository interfaces (like JpaRepository) to reduce boilerplate code.
3) Supports derived queries like findByTitle() with no SQL required.
4) Integrates seamlessly with Spring Boot and Spring Transaction management.

In lab: We created a BookRepository interface and Spring handled all the DB operations automatically using Hibernate and JPA.


## DIFFERTIATION_TABLE:

## Feature                   JPA                      Hibernate                Spring Data JPA                

1) What it is                Specification (JSR 338)  ORM Framework            Spring abstraction on JPA      
2) Provides implementation?  No                       Yes                      Uses Hibernate internally    
3) Maintained by             Jakarta EE               Red Hat                  Spring Team                    
4) Spring Boot support       Indirect                 Direct                   Recommended & Built-in      
5) Boilerplate code?         Some                     Some                     Very little (interface-based)  



##  Conclusion

JPA gives us the rules.  
Hibernate does the work.  
Spring Data JPA makes it easier to use — especially in Spring Boot projects.

This hands-on lab helped me understand how all three work together in real-world applications.
