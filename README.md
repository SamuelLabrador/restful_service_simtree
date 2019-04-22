# SIM TREE RESTFUL API SERVICE

Last Update: 4/22/2019  
Written by Samuel Labrador  
Intended To Be Used For BitSecure Lab  
__Currently under development__

### Dependencies

* _Java 1.8_  
* _JRE  1.8_  
* _Apache Maven_ 
* _Curl_ (For testing)

### Preface

This project was built on top of another project. It can be found here: https://github.com/spring-guides/gs-rest-service

This should be ran on a Linux machine. Although it can be used on a Windows machine, I have not written the script to build and start the service on a Windows machine.

# Intro

The purpose of this project is to create a service that takes in a file via a GET request and returns a json response after processing the file. This services utilizes the Spring Framework for handling requests and returning reponses.  

The intention is that the front end Visual Studio plugin (https://github.com/SamuelLabrador/SimTree.git) sends a file to this service (via a GET request). Once this service receives the file, it passes the file's contents to the SimilarityTree algorithm. After the algorithm analyzes the file and produces the changes, the restful service returns a json response that contains the produced changes.  

# How It Works

### Starting the service

1. Navigate to the folder _complete_.
2. Run the script _start_service_
3. The Maven script should handle all the dependencies and building

### Testing the service

1. In root folder, run a file named _test_upload.sh_
2. _test_upload.sh_ takes the file, _test.txt_ (in the same directory), and sends it to the RESTful service. 
3. The response should be in a json format. It should contain two changes along with the content of the file. This shows that the service received the file correctly and was able to read its contents. Feel free to modify the contents of _test.txt_ to change the response. 

### Using the service

* The service should run on _http://localhost:8080/file_ when using the start script. In production, the service should be modified to run on a different address and port.

1. To use the service, send a GET request WITH the attached file to: _http://localhost:8080/file_ (or whatever address and port the service is listening on)

	1. Example using curl: _curl -F 'file=@path_to_file' http://localhost:8080/file_

2. The service should return a response with 2 pre-defined changes and a change with the content of the file.

# Technical Details

### JSON Response Format

* The JSON response consists of an array of _Change_ objects.

* The _Change_ object is specified in in the file: _\complete\src\main\java\hello\Change.java_

* The _Change_ object consists of two private members:
	* _target_ -- What string should be found in the editor.  
	* _replacement_ -- What string to replace the target with in the editor.

### Request Processing Details

* The Spring framework is modeled after MVC (Model View Controller). 

* When a request is sent to _http://localhost:8080/file_, the function _change_, in the file _\complete\src\main\java\hello\Change.java_, processes the request. 

* The _change_ function:
	* Deserializes the file from the request
	* Returns the response, specified in _JSON response format_ (above).

### TODO:

* Integrate the _similarity tree_ algorithm into the service. Possibly pass the file content to another class, dedicated to processing the content.

* Clean up the project structure... There are still some files from the original project that was used as a buildupon (ie Greeting.java, GreetingController.java, etc).
