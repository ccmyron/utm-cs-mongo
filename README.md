## About
Storing and encrypting sensitive data into a database (MongoDB)

## Features
### This app will:
• Create a MongoDB database which would contain some secured sensitive data (protected
via 2-way encryption)  
• Create an application which would display the data contained in the database (both
common data and the decrypted sensitive data)  
• Make sure that the sensitive data can only be accessed via your application (i.e. it is
secure).  

## How to use
### Prerequisites
• Intellij or other Java IDE's  
• JDK 11+  
• Docker

### Pre-config
• Start MongoDB:  
```shell
> docker-compose up -d
```
• Generate a private key (on Unix systems):
```shell
> dd if=/dev/urandom bs=1 count=32 2>/dev/null | base64
```
** If no distro of linux present and WSL2 not installed, navigate to 
https://bellard.org/jslinux/vm.html?url=alpine-x86.cfg&mem=192 for free online terminal

• Copy the generated key to mongodb.encrypt.keys.key field in resources/application.yml

### Running
• Execute the following command in the project root folder
```bash
> .\gradlew.bat bootRun
```

• To see the encrypted data, navigate to http://localhost/db/lab7/user 
