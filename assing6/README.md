# GRPC Services and Registry

The following folder contains a Registry.jar which includes a Registering service where Nodes can register to allow clients to find them and use their implemented GRPC services. 

Some more detailed explanations will follow and please also check the build.gradle file

Before starting do a "gradle generateProto".

### gradle runRegistryServer
Will run the Registry node on localhost (arguments are possible see gradle). This node will run and allows nodes to register themselves. 

The Server allows Protobuf, JSON and gRPC. We will only be using gRPC

### gradle runNode
Will run a node with an Echo and Joke service. The node registers itself on the Registry. You can change the host and port the node runs on and this will register accordingly with the Registry

### gradle runClient
Will run a client which will call the services from the node, it talks to the node directly not through the registry. At the end the client does some calls to the Registry to pull the services, this will be needed later.

### gradle runDiscovery
Will create a couple of threads with each running a node with services in JSON and Protobuf. This is just an example and not needed for assignment 6. 

### gradle testProtobufRegistration
Registers the protobuf nodes from runDiscovery and do some calls. 

### gradle testJSONRegistration
Registers the json nodes from runDiscovery and do some calls. 

######################### Project description ###############################
Client/Server program That allows a client to connect to the server and request many kind of services. 
###Client activities                 ###Server activities 
1-Joke                               send jokes.
2-setJoke                            adds a new joke.
3-encrypt                            save encrypeted passward with a name.
4-decrypte                           decrypted a passward and send it to user.
5-List passward                      shows all passward.
6-Write                              server save name, city, and region.
7-read                               show all names, cities, and regions.
8-search(by city name)               list of all student in a city.
9-pin Address                        get the ip address for a website and save it under a name.
10-get Ip                            search for ip by name.

######################## Requirements met #############################
1. (3 points) Must have: We need to be able to run the service node through "gradle
runNode" which should use default arguments, and the client through "gradle run-
ClientJava" using the correct default values to connect to the started service node!!!!
If this does not work we will not run things.
	met
2. (20 points each service) Implement 2 from the 4 services that are given in the
.proto files, choose from these 4 protos: recipe, weather, password, hometownsRead
through the Protobuf files for more details on how the services are supposed
to work.
	met

3. (8 points) Your client should let the user decide what they want to do with some
nice terminal input easy to understand, e.g. first showing all the available services,
then asking the user which service they want to use, then asking for the input the
service needs. Good overall client that does not crash.
	met

4. (4 points) Give the option that we can run "gradle runClient -Phost=host -Pport=port
-Pauto=1" which will run all requests on its own with input data you hardcode and
give good output results and also of course shows what was called. This will call the
server directly without using any registry. So basically shows your test cases running
successfully. See video about Task 1 for more details
	Not met

5. (5 points) Server and Client should be robust and not crash.
	met
Task 2: Inventing your own service (30 points)
	requirement fulfills

Task 3.1: Register things locally
	Met

####################### How To Run It ######################
Default:
Server: ## gradle runNode
Client: ## gradle runClientJava

###For Taske 3:
With Default args:
Registery:## gradle runRegistry
Server:   ## gradle registerServiceNode
Client:   ## gradle runClient2


######################## How to work with the program ################
The services that I implemented are password and, hometownsRead
When Client connect to server, Server shows client a menu with all avialable services as the following:

#### Avilable Services #####
please make a selection....
1:get joke.
2:save a passward.
3:get a passward by name.
4:print list of all passward.
5:Enter region info
6:search for person by city
7:List of HomeTowns
8:ping url
9:serch for Ip by name
0:exit!.

Then client can enter an integer to select one of the options.

# if client chose # 1:get joke.

server ask: # How many jokes would you like?
client Enter numer of jokes
server: send jokes
------------------------------------------------------------------------------------
# if client chose # 2:save a passward.
server will ask for the following:
	1-Enter a name for the passward
	2-Enter the passward
client enter the required files
server reply with:
	true
	Passward saved....
------------------------------------------------------------------------------------
# if client chose # 3:get a passward by name.
server will ask for:
	Enter a name to search for the passward
after client enter the name for a passward server will reply with:
	Your Passwatd is : passward
------------------------------------------------------------------------------------
# if client chose # 4:print list of all passward.
server will reply with:
	List of All passward names:
------------------------------------------------------------------------------------
# if client chose # 5:Enter region info
server will ask for the following info:
	1-Enter your name
	 eg. alhaj
	2-Enter your city
	  eg. phoenix
	3-Enter your region
  	  eg. usa
server will savae the info an reply with:
	true
        saved new Entry...
------------------------------------------------------------------------------------
# if client chose # 6:search for person by city
server will ask for:
	Enter your a city name
	  eg. phoenix
then server will print all studend in that city
	List of Student From: phoenix
	Name: alhaj city: phoenix Region: usa
------------------------------------------------------------------------------------

# if client chose # 7:List of HomeTowns
server will reply with:
	true
	List of HomeTowns:
	Name: alhaj city: phoenix Region: usa
------------------------------------------------------------------------------------
# if client chose # 8:ping url
server will ask for:
	1-Enter a the websit name(eg. Google):
		eg. google
	2-Enter a the websit URL(eg. www.Google.com):
		eg. www.google.com
server will reply with:
	true
	Ip for www.google.com saved under google
------------------------------------------------------------------------------------
# if client chose # 9:serch for Ip by name
server will ask for:
	Enter the name:
		eg. google
server will reply with:
	The ip for: google is: www.google.com/142.250.72.228
------------------------------------------------------------------------------------
# if client chose # 0:exit!.
server will reply with:
	### Bye, see you soon ###
	client get disconnected.

------------------------------------------------------------------------------------


