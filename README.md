# chat-program
A socket is an interface between an application and a network


The goal of this project is to create a simple two way chat program using TCP. Each chat
program should act as client and server, meaning any chat program can initiate communication
(client), or receive communication if already running (server). Since this is the case,
you should have only one chat program, which you can deploy on multiple machines for two
way communication. The chat program that initiates communication should request the
IP address of the destination chat program. You may have a predetermined port number
hard coded into your chat programs. NOTE: it’s not necessary for the chat programs to
have concurrent communication. You can assume only one chat program sends information
at a time. You can also assume there are only two chat programs communicating. Typing
“exit” on either the chat client or chat server should terminate both chat programs.
Example (assuming both chat programs are running):
Chat acting as client:
gallojm@archer:˜$java chat
Welcome to my two way chatter box!
Initiate chat-0, wait for response-1: 0
Specify IP address of destination chat program: 192.168.1.121
Source Chatter: hello?
Destination Chatter: I am here!!
Source Chatter: That’s good to know!
Destination Chatter: It was good talking with you..
Source Chatter: exit
Exiting chat program!

Chat acting as server:
gallojm@archer:˜$java chat
Welcome to my two way chatter box!
Initiate chat-0, wait for response-1: 1
Waiting for response...
Destination Chatter: hello?
Source Chatter: I am here!!
Destination Chatter: That’s good to know!
Source Chatter: It was good talking with you..
Destination Chatter: exit
Exiting chat program!
