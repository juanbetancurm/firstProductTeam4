<br />
<div align="center">
<h3 align="center">firstProductTeam4</h3>
  <p align="center">
    Implementation of user creation functionality. Users can provide their email and password, their information can be stored and retrieved from the database. Each user is unique and can be queried using their username and password. It generates a token for authentication purposes and also asks for confirmation via email.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

# Clone

```bash
git clone -b master https://github.com/juanbetancurm/firstProductTeam4.git 'nameSelectedByYou'
```

# Configuration

1. Go to Settings and, in the Gradle JVM, select:
```bash
corretto-17 'Amazon Corretto version 17.0.7'
```
2. Go to Project Structure and select in the SDK field:
```bash
17 -  Sealed types, always-strict floating-point semantics
```
3. Refresh Gradle and Run.

# Functioning

In this Java project, we have a model class that represents a table. The model contains properties (fields in the table), and one of these properties is the key used to identify records in the users table. The model class also includes setters, getters, and a constructor.

The logic for the user class is implemented in the service class. The saveUser function takes a variable of type UserModel, which is also the name of the user model in this case. When we call this function, it triggers two methods. First, it applies user validation from the userValidation class. The user model is validated using various validation methods.

If the validation passes successfully, the save method from the user repository (JPA) is applied to the user model variable. This saves the user information, including all the properties and data inserted by the user.

To define the route for accessing this functionality, we use the user controller class. The user controller class defines the URL ("/api/users") and maps it to the saveUser method. Annotations are used to map the user model and retrieve the data from it.

There is a condition that checks if the email already exists. If it does, an exception is thrown indicating that the user already exists. This functionality is provided by a built-in method in JPA, and the logic for it is implemented in the repository.

The repository class acts as a bridge between our project and the JPA code. It is an interface that contains all the necessary methods provided by JPA. In this case, it is used for the user model class, which has an ID of type long.

Throughout the process, we have other agents involved. For example, in the validation step, there is a validation folder containing the validateUserModel method. This method is applied to a variable of type UserModel, and it calls several validation methods such as validateMandatoryFields, validateMail, validatePasswordFormat, and validateCoincidentPasswords.

The validateMandatoryFields ensures that no fields are left empty. The validateMail checks the structure of an email to ensure it follows the correct format. The validatePasswordFormat validates the structure of the password, requiring a specific pattern. The validateCoincidentPasswords compares the two passwords provided by the user to check if they match.

If any of these validations fail, the corresponding exceptions are thrown. These exceptions are defined in the configuration folder, specifically in the exceptions class. The controller advisor class handles each exception and provides the appropriate response with error messages. The error messages are defined in the constants class.

When an exception occurs, it is caught by the controller advisor, which formats the response and includes the specific exception message. These messages can be seen in the console for debugging purposes.
