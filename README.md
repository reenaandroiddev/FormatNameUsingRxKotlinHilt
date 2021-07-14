# FormatNameUsingRxKotlinHilt

Analysis
As a user want see list of names with first letter in caps.

Approach
Need to modify data which is coming from data source in order to accomplish requirement.
Will make use of RxJava Flatmap and map Operators to modify data coming from source. Once Observable emits data we apply map function to data to make first letter capital

To achieve separation of concerns developed app using Clean Architecture + MVVM

# Architecture Overview
Making use of Clean Architecture to handle 
    - Separation of  concern
    - Making code easily testable
    - Easy for Dependency  injection

 
# Programming Language
- Kotlin

# Presentation Layer
This includes applications Activities,Fragments and ViewModels etc.
- Views
Responsible for displaying and responding to user actions. Reacts to data changes from the View Model.

- View Models
Responsible for exposing and preparing data to be presented by a View. Exposes observables for Views to react to. It should not hold any reference to any View.

# Domain Layer
Contains all the use cases of application which holds the business actions
- Use Cases
Responsible for encapsulating a specific business action, performs integration and orchestration with the data layer, and mapping between entity and domain models.

# Data layer
This layer has all the repositories which the domain layer can use. This layer exposes data to outside classes 

# Repositories
Returns data from data source either from Remote Service or Local Storage
- Remote Services / Local Storage
Responsible for serving as an access point to external data layers and persistence.

# External Libraries Used
- RxJava/RxAndroid -  Provides observables and reactive streams that enables us to leverage on reactive style programming
- Hilt - A static, compile-time dependency injection library for Android
- Mockito - Mocking framework for unit test cases
