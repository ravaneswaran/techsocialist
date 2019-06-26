# Development Environment Setup of TECH SOCIALIST

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

**sudo tar -xvf tar-file /opt/softwares/java-sdk/1.8.0_191**

1. Create a 'bin' directory under /opt
2. Create a soft link to the file **java -> /opt/softwares/java-sdk/1.8.0_191/bin/java**

### Exporting OPT_BIN path to the PATH environment variable
1. Open /etc/profile in you favourite text editor and insert the following lines at the bottom of the file
  - export OPT_BIN=/opt/bin
  - export PATH=$PATH:$OPT_BIN

### Setting JAVA_HOME and updating PATH environment variable
1. Open /etc/profile in you favourite text editor and insert the following lines at the bottom of the file
  - export JAVA_HOME=/opt/softwares/java-sdk/1.8.0_191

Logout and Login back to have the changes be in effect...

## Installation of Maven

We are going to use the same procedure as we had for the installation of Java

Goto the following link to download maven tar ball

Create a folder path **/opt/softwares/apache-maven** as follows....

**sudo mkdir -p /opt/softwares/apache-maven**

Now extract the downloaded tar ball to the folder /opt/softwares/apache-maven/**3.6.0** using the following command.

**sudo tar -xvf <tar-file> /opt/softwares/apache-maven/3.6.0**
  
1. Create a soft link to the file **mvn -> /opt/softwares/apache-maven/3.6.0/bin/mvn**

### Setting M2_HOME and updating PATH environment variable
1. Open /etc/profile in you favourite text editor and insert the following lines at the bottom of the file
  - export M2_HOME=/opt/softwares/apache-maven/3.6.0
  
Logout and Login back to have the changes be in effect...

## Creating 'liferay' Directory

This is one of the most important steps in the setup... i.e creating liferay direcory

Use the following command to create a directory under /tmp folder

**sudo mkdir -p /tmp/liferay**

Once the directory is created, change the owner ship of the directory as follows....

**sudo chown user-name:user-group /temp/liferay**

