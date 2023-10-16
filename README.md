# ReadMe

Implementation description for the Ignitis homework task.

## Usage
* JRE 17 required.
* Project can be run by calling `gradle run` command.
* Functionality can be invoked via REST-API. Documentation for it is provided with springdoc OpenApi3 and can be accessed by visiting a link `http://localhost:8080/swagger-ui/index.html` when the project is running.
![openAPI](https://github.com/vsh1ft/ignitis-homework/assets/3269569/540092d4-2c5d-482d-a91d-6a5ad147e7b1)


# Implementation details

#####Basic requirements
- [x ] Use git version control system.
  ######Although the project is on git, there is only one big commit for the project, because I was relying on Intellij local history. Ideally there should be many small commits for every feature implemented/logical change.
- [x] Use Java 11+
- [x] Use Gradle (https://gradle.org/)
- [x] Use Spring boot
- [x] Use springdoc OpenApi3
- [x] Use h2 database (https://www.h2database.com)
- [x] Write plain SQL with ORM.
  ######Since the project uses Jooq ORM and it generates entities based on database schema, I have decided to use them instead of plain SQL, because then the code becomes type safe. Also, the dsl queries very closely mimic actual SQL queries.
- [x] Write automated tests

#####Advanced requirements
- [x] Use Liquibase (https://www.liquibase.org/)
  ######I have only integrated Liquibase with Spring Boot project after finishing the coding task.
- [x] Use JOOQ (https://www.jooq.org/)
- [ ] Authenticate users using JWT.
  ######The main functionality missing from the project. Right now every user can create a new user. With JWT authentication Spring could manage access to methods via `PreAuthorize("hasRole('ROLE_ADMIN')") ` annotation.
- [x] Create automated tests using Spock.



## Workflow
Below is the short description of the workflow for a sample API call.
1. In order to retrieve a user, a call too a Spring RestController is made.
```
 @GetMapping("/{userId}")
    public Person getUser(@PathVariable String userId) {
        return service.findUser(userId);
    }
```
2. The business logic, if there is any, is defiend in Service classes, which are accessed from the controllers. Adapter pattern is used for the repository classes, thus it would be easier to implement another ORM or database, if needed, based on interface contract.
```
public Person findUser(String userId) {
        return repository.findUser(userId);
    }
```
3. Repository classes use Jooq DSLContext API ant generated classes to stay type safe.

```
    @Override
    public Person findUser(String userId) {
        return dslContext.select(PERSON).from(PERSON).where(PERSON.ID.eq(userId)).fetchOneInto(Person.class);
    }
```



## Testing
Code is partially covered with unit tests using Spock. Integration tests are missing.
In order to run the tests call `gradle test`.
## Code quality assurance
List of tools used to automate code quality assurance:
* Jacoco - code coverage tool. Build fails if code coverage falls below certain percentage.
* Checkstyle - static analysis tool for code style. Build fails if Java code style issues are not fixed.
