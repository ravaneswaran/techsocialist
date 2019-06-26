# Development Environment Setup of Tech Socailist

The following are the software requirements to have the development environment in place...

1. Java - 8
2. Maven - 3.6.0
3. IntelliJ - IDEA - 2018.3.2

At time of writing this document, I have used Ubuntu - 16.04 LTS as Operating System.

Let us Install the softwares required one by one.

## Installation of Java - 8

The way I prefer to install java is to extract the tar ball to a common folder, In mycase the folder I preferred was **/opt**.

Just go the following link and grab the latest version of java-8 I mean the tar ball 

**https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html**

After you download....

Create a folder path **/opt/softwares/java-sdk** as follows....

**sudo mkdir -p /opt/softwares/java-sdk**


Now extract the downloaded tar ball to the folder /opt/softwares/java-sdk/**1.8.0_191** using the following command.

**sudo tar -xvf <tar-file> /opt/softwares/java-sdk/1.8.0_191**

1. Create a 'bin' directory under /opt
2. Create a soft link to the file **java -> /opt/softwares/java-sdk/1.8.0_191/bin/java**

#### Setting JAVA_HOME and updating PATH environment variable

