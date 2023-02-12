# Assignment 4 Activity 1
	####linke to the video:  https://drive.google.com/drive/folders/1JqW41m4GvPVj2vgTc_EsI9Mb03xGyvhf?usp=share_link

## Description
The initial Performer code only has one function for adding strings to an array: 

## Protocol

### Requests
request: { "selected": <int: 1=add, 2=clear, 3=find, 4=display, 5=sort, 6=prepend
0=quit>, "data": <thing to send>}

  add: data <string> -- a string to add to the list, this should already mostly work
  clear: data <> -- no data given, clears the whole list
  find: data <string> -- display index of string if found, else -1
  display: data <> -- no data given, displays the whole list
  sort: data <> -- no data given, sorts the list
  prepend: data <int> <string> -- index and string, prepends given string to string at index

### Responses

success response: {"ok" : true, type": <String> "data": <thing to return> }

type <String>: echoes original selected from request
data <string>: 
    add: return current list
    clear: return empty list
    find: return integer value of index where that string was found or -1
    display: return current
    sort: return current list
    prepend: return current list


error response: {"ok" : false, "message"": <error string> }
error string: Should give good error message of what went wrong


## How to run the program
### Terminal
Base Code, please use the following commands:
```
    For Server, run "gradle runServer -Pport=9099 -q --console=plain"
```  Default:   gradle runTask1
```   
    For Client, run "gradle runClient -Phost=localhost -Pport=9099 -q --console=plain"
```   
```
   For ThreadedServer, "gradle runThreadedServer -Pport=9099 -q --console=plain"
```   Default:   gradle runTask2
```
   For ThreadedPoolServer,  "gradle runThreadedPoolServer -Pport=9099 -PpoolSize=2 -q --console=plain" 
```  Default:   gradle runTask3
```
**** Requirment met*****
  **** Task 1 *******
* add:    The client may add a string by typing 1. The server then adds it to the list and displays it back to the client.
*clear:   The client clear the list by typing 2. the server return empty list.
*find:    The client serach for string in the list by typing 3 and the string. The server return the index of that string.
*display: The client may display the string list with 4. The server then displays the current list.
*quit:    The client can quit with 0. The server ends the connection and keeps running, waiting for other clients.

***** Task 2 ********
  * Task 2 uses the class "ThreadedServer", as shown in the build file.
  * This server has no bound on how many clients can be handled, and creates a new thread for each client connection.
  * No clients block, and all clients can act at the same time. I used a synchronize block for changing data.
  * The strings list is shared between clients, so all clients can change and view the same list.

**** Task 3 **********
  * Task 3 uses the class "ThreadedPoolServer", as shown in the build file.
  * Users can specify the number of threads to be bound by, as shown in the "How to run the program" section.
  * When the server reaches its max number of active threads, the following clients recieve a "Server Busy" error message and respond accordingly.









