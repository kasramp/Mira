# Mira

Mira is an ephemeral file upload from the command line. It is handy for uploading config files to transfer from one server/machine to another hassle-free. Similar to Bash Upload (bashupload.com) but open source and faster!

## Screenshots

### Web interface

![gui](https://github.com/kasramp/Mira/assets/4501120/509b71d2-b3b4-467e-8967-c2887b9ea5d6)

#### Command line

![command_line](https://github.com/kasramp/Mira/assets/4501120/96c93d27-25b3-4273-abef-0ac9e710b4aa)

## Dev run

```bash
$ ./mvnw spring-boot:run
```

## File upload

```bash
$ curl http://localhost:8080 -F "file=@your_file"
```
