Automation Hand-On Interview

1. Go to the Internet Heroku App web site and take an initial quick peek. https://the-internet.herokuapp.com/

2. You need to write an automation testing framework in the Java programming language. The framework must use a popular java testing framework, such as TestNG, or JUnit. You can use an IDE of your choice (such as IntelliJ IDEA or Eclipse).

3. Create a ReadMe file, It should include execution instructions and prerequisites. Keep in mind that it needs to be able to run on a different host and environment than your own.

4. Any test that will be run, will first open a web browser and then navigate to the Internet Heroku App web site - which will be your home page. You can choose any browser you like to run the tests on, but your framework should address the fact that in the future it will need to support multiple browsers. In order to save considerable time, it is highly recommended to use the open source Augmented Driver project which extends Selenium 2.0 Web Driver to achieve the above.

5. Any test that will be run, should report meaningful informative messages during the run, on different levels, to a logging system of your choice. There must be persistence for the test reports, so only writing to the console is not enough. Just to be crystal clear, do not implement your own logging framework! Instead, use a 3rd party dependency, or just write to logs file, to accomplish the above.

6. Create runnable tests that you think are necessary for testing the following: 1. Go to the Checkboxes page, modify the checkboxes states (checked/unchecked) for each of the checkboxes, to the opposite state than the one in which the page loaded, and then validate that the state changed as expected.

7. Go to the Frames page, and then to the iframe page. Write your name inside the TinyMCE Editor text paragraph, and ensure that it was written.

8. Go to the Public APIs page go to the Weather section (at the bottom) https://github.com/public-apis/public-apis, select one of the weather apis (for example https://www.metaweather.com/api/ ) and create some api tests to check the API functionality.

9. Additional Guidelines: • Use Object Oriented Programming principles as best you can. • Aim to use a meaningful & consistent code convention.