/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketpractice;

import java.io.*;
import java.net.*;
public class StudentServer {
private ObjectOutputStream outputToFile;
private ObjectInputStream inputFromClient;
public static void main(String[] args) {
new StudentServer();
}
public StudentServer() {
try {
// Create a server socket
ServerSocket serverSocket = new ServerSocket(8000);
System.out.println("Server started ");
// Create an object output stream
outputToFile = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Tsede\\Desktop\\Student.txt", true));
while (true){
// Listen for a new connection request
Socket socket = serverSocket.accept();
// Create an input stream from the socket
inputFromClient = new ObjectInputStream(socket.getInputStream());

// Read from input
Object object = inputFromClient.readObject();
// Write to the file
outputToFile.writeObject(object);
System.out.println("A new student object is stored");
}}
catch(ClassNotFoundException ex) {
ex.printStackTrace();
}
catch(IOException ex) {
ex.printStackTrace();
}
finally {
try {
inputFromClient.close();
outputToFile.close();
}
catch (Exception ex) {
ex.printStackTrace();
} } } }