package theory;

public class Architecture {

/*	Command Prompt (Start Remote WebDriver - Server)

	1) java -jar (Path or drag & drop selenium standalone server.jar)
	2) Get the local host port number (4444)
	3) Open localhost:4444
	4) Click on Console
	5) Create session - Chrome (Chromedriver should be placed in Windows/system32 folder)
	6) Open https://github.com/SeleniumHQ/selenium/wiki/JsonWireProtocol(google-json wire protocol selenium)
	   https://www.w3.org/TR/webdriver/#commands
	7) Install 'Postman' (Client) extension on Chrome

	Commands on Postman (: means pass value)

    http://localhost:4444/wd/hub - URL
    URI (uniform resource identifier) = URL (uniform resource locators(endpoint)) + URN (uniform resource names) + ? (prmtr: address=xyz)

    URI = URL + URN + ?Method='' & "Parameters"
    Request = REST API endpoint URL + API method + parameters
    
    (try apigee.com)

	1) /sessions (http://localhost:4444/wd/hub/sessions) 
	2) /session/:sessionId (http://localhost:4444/wd/hub/session/373d99eace114a4632a3b36d678d0e23) 
	3)POST - /session/:sessionId/url (click on hyperlink)

	URL Parameters:
	:sessionId - ID of the session to route the command to.

	JSON Parameters:
	url - {string} The URL to navigate to.

	Postman --> Body --> Raw --> JSON(application)

	{
	"url":"http://www.google.com"
	}

	http://localhost:4444/wd/hub/session/373d99eace114a4632a3b36d678d0e23/url

	8) Advanced Rest Client (add extension on Chrome) (chrome://apps/)
	
	To Close : Taskmanager --> End javaw.exe
	..................................................

	API (Application programming Interface)

	- Structured request and response (XML/JSON)
	- set of routines, protocols, and tools for building software applications. Specifies how software components should interact.

	REST API (Representational State Transfer)

	- Relies on stateless, client server protocol, almost always HTTP
	- Treats server objects as resources that can be created or destroyed
	
	By stateless it means that the server does not store any state about the client session on the server side.
	
	Statelessness means that every HTTP request happens in complete isolation. When the client makes an HTTP request, 
	it includes all information necessary for the server to fulfill that request. The server never relies on information 
	from previous requests. If that information was important, the client would have sent it again in this request.
	
	There are actually two kinds of state. Application State that lives on the client and Resource State that lives on the server.

    A web service only needs to care about your application state when you’re actually making a request. The rest of the time, 
    it doesn’t even know you exist. This means that whenever a client makes a request, it must include all the application 
    states the server will need to process it.

    Resource state is the same for every client, and its proper place is on the server. When you upload a picture to a server,
    you create a new resource: the new picture has its own URI and can be the target of future requests. 
    You can fetch, modify, and delete this resource through HTTP.

    ..........................................................................................................................

	HTTP methods GET (retrieve data), POST (submit data to be processed), PUT (update a specified resource), DELETE 

	JSON (JavaScript Object Notation)

	- Syntax for storing and exchanging data
	- Uses key/value pairs {"url":"https://www.google.com"}
	- When exchanging data between a browser and a server, the data can only be text. 
	  Since the JSON format is text only, it can easily be sent to and from a server, and used as a data format by any programming language.
	- JSON is text, and we can convert any JavaScript object into JSON, and send JSON to the server.
	- We can also convert any JSON received from the server into JavaScript objects.
	- JavaScript has a built in function to convert a string, written in JSON format, into native JavaScript objects: JSON.parse()

	JSON Serialization and de-serialization:

	- JSON is a format that encodes objects in a string. Serialization means to convert an object into that string, 
	  and deserialization is its inverse operation

....................................................
	
	*  The JSON wire protocol (JSONWP) is a transport mechanism created by WebDriver developers. This wire protocol is a 
	   specific set of predefined, standardized endpoints exposed via a RESTful API. 

	   ***************************************************Architecture******************************************************
	
/*	1) Java commands are taken by the Client Libraries (language bindings) and are converted to JSON format
	2) These are sent to the Client APIs (FirefoxDriver/ ChromeDriver) as a Rest service to GET: [sessionid: url] example
	
       FirefoxDriver
       
       The FirefoxDriver works as an extension to the Firefox browser. It uses the XPCOM (Cross Platform Component Object Model) 
       framework of Mozilla to execute the commands sent by the language bindings. Language bindings communicate with the extension, 
       that is, FirefoxDriver, by connecting over a socket and sending commands. This socket is bound to a port, 
       which is called the locking port; typically, it would be 7055. The reason it is called the locking port is because 
       it is used as a mutex so that it allows only one instance of Firefox to listen to a Firefox Driver on that port.

     3) After this socket is established, the client language binding (in our case, the Java binding) sends the commands to 
        the Firefox driver in a serialized JSON format.
        
     4) Once the commands reach from the client language bindings to the FirefoxDriver, it deserializes the JSON, 
        and the commands are interpreted and looked up in the Firefox Driver prototype, which are the JavaScript 
        functions for each command. After execution, the response is sent back via the socket to the client. 
        This response is again a JSON that contains methodName (this is same as the commandName in the request), 
        Context, isError (indicating if an error has occurred, so that the client can thrown an exception), 
        and ResponseText (the output of the command executed).  */
}
