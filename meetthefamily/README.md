# Meet the Family

This project contains artefacts of the Geektrust backend challenge: Meet the Family.

### Assumptions

* Every family member has a unique name.

### Getting started with the project

1. Unzip the project into a folder (hence called the root folder).
2. Launch Eclipse, with the workspace being the root folder into which the project artefacts have been unzipped.
3. Click on File from the Menu bar -> Import -> Maven -> Existing Maven projects.
4. Select the root folder as the root directory and click on Browse.
5. The pom.xml within the project will be highlighted in the browse window. Select the checkbox against the pom.xml and click on Finish.
6. The project will now be added to the workspace. You may clean the project by clicking on Project from the Menu bar -> Clean.

### Running the project

1. To create an executable JAR, right click on the project -> Run As -> Maven Clean, followed by Maven Install.
2. If options 'Maven Clean', 'Maven Install' do not show up within the 'Run As' option menu, click on 'Update Project' instead, then attempt point 7 again.
3. An executable JAR with the name 'geektrust.jar' would get created, and will be available at the target folder of the workspace.
4. To test the project, open Command Prompt (on Windows), Terminal (on Mac) at the target folder location.
5. Execute the following command: java -jar geektrust.jar
6. A prompt will appear on the screen, requesting that the input file path be entered.
7. The output be displayed on the screen.

### Built with

* [Maven](https://maven.apache.org/) - Dependency management