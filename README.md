# ANDigital Coding Exercise

Technical exercise for ANDigital.

## Synopsis

This is a web application that integrates with the Foursquare API and allows you to search for a place by name
and return the recommended or popular venues near that location. Optionally, the **Recommended** checkbox can be
unchecked to search all the venues near the location, not just the recommended ones.
The search for recommended venues is ordered by rating.


## Build & run

Build the Maven project (*mvn install*) and deploy the generated war file on a Servlet 3.0 container like Tomcat 8.
The **maven-war-plugin** in the Maven POM has an <outputDirectory> tag where you can insert the deployment
folder of your server for an automatic deploy. The war file name is **venues-app.war**.

The web application path is **/venues-app**. Your application URL will look something like this:
http://localhost:8080/venues-app/


## Design

I have created a Spring MVC application, using the Spring RestTemplate to make calls to the Foursquare API and retrieve
the results as Java POJOs. The information is then rendered with JSP views that use JSTL tags. Best viewed on desktops.

I opted for this solution because I'm mainly a Java backend developer and that was a good way to show my skills,
but it would have been easier in this case to create an AngularJS application and use the Angular $http service to query
the Foursquare API and directly consume the JSON response in Javascript, without creating any additional model objects.
I would have implemented that alternative solution too if I had had the time.

The API calls and parameters are configurable in the **application.properties** file. Specific notes and considerations
about the Foursquare API calls and parameters can be found in that file.

As the exercise allows to display the results as we see fit, I chose to display only some relevant venue fields on the
application. There are many other fields that could be displayed in a similar way if that was required.


## Improvements

The program could be improved with a better handling of bad requests when there are no results
and the Foursquare API returns meta -> code 400.
So far there is only basic validation on the input search form. Validation could also be improved by defining exactly the
input characters that are going to be allowed on the search. Since this is a GET (read) request and not a write
operation, validation of special characters is not critical.


## Test automation

Components are covered with unit tests. Integration tests have not been implemented.


## Technologies used

Java, Spring, Spring MVC, RestTemplate, JUnit, Mockito, JSP, JSTL, HTML5, CSS.


## Feedback

It's a nice test that feels like doing something useful. I enjoyed doing it much more than the typical exercises about
implementing a random algorithm and printing something on the console. However, it favours developers whose language of
choice is JavaScript. Maybe an alternative test could be presented as a choice for back-end developers; for example,
creating RESTful webservices instead of consuming them.
