# lone.peak
This project contains UI Automation tests for https://www.podium.com/ and tests are executed on Google Chrome Browser 
There are 2 tests files
PodiumLandingPageIT : This executes tests on local machine
PodiumLandingPageDockerIT : This executes tests on Docker container
Project is share don Github here : 
# To Run tests on Local Machine from Command line
# Pre-Requisites
Below apps needs to be installed before executing tests
1. Java
2. Maven : M2_HOME set in system path
3. Chromedriver.exe (Webdriver for chrome) added in system path
# Steps to run tests
1. Download project from Github 
2. Navigate to project directory /lone.peak
3. Verify is mvn is accessible from this folder with command : mvn -version
4. Execute this command to run tests : mvn test -D="LocalMachineDemo"  
5. Test reports directory : Project home : lone.peak\target\surefire-reports Open index.html



# To Run tests on Docker Container from Command line
# Pre-Requisites
Below apps needs to be installed before executing tests
1. Java
2. Maven : M2_HOME set in system path
3. Docker
4. Make sure 4444 port is not in use
# Steps to run tests
1. Download project from Github 
2. Navigate to project directory /lone.peak
3. Execute command to create docker image (Dockerfile is located in lone.peak folder, this command must be run from this folder) : docker build lonePeak .
4. Validate docker image is created : docker images
5. Start container using the image : docker run -d -p 4444:4444 -v /dev/shm:/dev/shm lonePeak:latest
6. validate container is running : docker ps
3. Execute this command to run tests : mvn test -D="DockerDemo"  
5. Test reports directory : Project home : lone.peak\target\surefire-reports Open index.html

