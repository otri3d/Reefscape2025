# Ri3D 2025 - Reefscape
### Description
This repository contains all of the code contained for all of the subsystems of our FRC robot. This includes a drivetrain system, a system for picking up and dropping off coral pieces and a system for algae.

All the robot code is in the `src\main\java\frc\robot` folder. WPILib provides resources and the ability to simulate and deploy code, but the code that is written to the robot is stored here.

#### `Constants.java`
All of the variables and values we will be using are stored in a single file. While building or testing there will be a need to change values, or reference them such as CAN ID. Instead of going through each file and changing all occurences indivually, we change it once and all other files that reference the variable will change.

#### `RobotContainer.java`
This is where everything is put together to make the robot. The controllers and subsystems are defined and referenced here. Configure Bindings is a method that will define a command/action to certain joysticks or buttons. Autonomous modes are also referenced here for the robot to do during the auto period.

### Technical Challenges

### Workarounds

### Notes
Controller 1 (Driver): PlayStation 5 Controller

![PS5 Mapping](/PS5Mapping.png "San Juan Mountains")

Controller 2 (Operator): PlayStation 4 Controller

![PS4 Mapping](/PS4Mapping.png "San Juan Mountains")
