# Warbots2019
The Software for the 2019 FRC Team 620 Robot

## Tasks ##
* Image Programming Laptops – Mark Kadonoff/Will Padgett Due by 1/25
* Test Spark Max and NeoMotor – Chase Bowen 1/25
* Create Xbox Controller Mapping Diagram – Ethan Wolman 1/23
* Procedures and State Diagrams for automation activities – Mr Mercer
* Alignment Tracking System – Keiran Khan 1/25
  * Create GRIP Pipeline
  * Compile and test on roboRIO
  * Compile and test Network Tables on RasbPI
  * Compile and test GRIP on RasbPI
* GitHub Master – Sam Parker 1/25
* Documentation – Chamin Lim
* Prepare Taz for drive team –
  * Get one single laptop setup for drive station -- Chase Bowen
  * Pull old code from GitHub, move it into new system – Sam Parker
  * Update firmware and image on RoboRio – Chamin Lim
  * Create program for drive team -- Sareena
* PathPlanner for Sandstorm -

## Scenarios for Scoring ##
1. Load a Hatch from Loading Station (Load and automatically back away))
2. Load a Hatch from the floor at speed (Prepare/Pickup)
3. Load a Ball from Loading Station (Load and wait to back away)
4. Load a Ball from the floor at speed (Prepare/Pickup)
5. Load a Ball from the floor in Corral
6. Score a Hatch at Rocket Level (1|2|3)
7. Score a Ball at Rocket Level (1|2|3)
8. Score a Ball in specific side of rocket
9. Score a Ball at Cargo Ship
10. Climb HAB (L2 or L3)

## Subsystems and Methods ##
### Tracking System ###
* `getAzimuthTarget` – get azimuth to reflective target
* `getDistanceTarget` – get distance to reflective target
* `getElevationTarget` – get elevation to reflective target
* `isLocked` – check if tracking system is locked on reflective target
* `Lock` – set tracking system lock on currently visible reflective target
* `getTargetX` – get X position of reflective target
* `getTargetY` – get Y position of reflective target
* `setMode` – set mode
* `getAzimuthLine` – get azimuth to start of line
* `getOrientationLine` – get orientation of line
* `isLineVisible` – check if line is in view
* `getConfidence` – get confidence factor of line in view

### DriveTrain ###
* `drive (vel, acc)` – start driving at specified velocity and acceleration
* `turn (vel, acc)` – start turning at specified velocity and acceleration
* `driveDistance (dist, vel, acc)` – drive specified distance
* `turnAngle (ang, vel, acc)` – turn specified angle
* `stop (decel)` – stop at specified deceleration
* `getDistanceTravelled` – query for distance travelled
* `getAngle` – query for angle turned
* `isAtTargetSpeed` – check if drivetrain is at target velocity
* `driveStraight (vel, acc)` – start driving straight (using gyro)
* `setMode` – set mode
* `extendClimber` – extend Climber mechanism
* `retractClimber` – retract Climber mechanism

### Hatch Grab System - preliminary ###
* `Load` -
* `pickUpFromFloor` -
* `deposit` -
* `hasCargo` -
* `setMode` -

### Cargo System - preliminary ###
* `Load` -
* `pickUpFromFloor` -
* `deposit` -
* `hasCargo` -
* `setMode` -

### Up/Down Mech - preliminary ###
* `moveUp` -
* `moveDown` -
* `getPosition` -
* `gotoPosition` -
* `calibrate` -
* `setMode` -

## Mission Requirements ##
1. We shall be able to control every subsystem
2. We shall have a 12 second round trip for delivering the cargo and hatches
3. We shall deliver 2 hatches during the 15-second sandstorm period
4. We shall jump down from the 6-inch platform to start the sandstorm
5. We shall be able to climb the tallest HAB platform in 10 seconds
6. We shall be able to pick up hatches from the ground in 1 second at 10 feet per second
7. We shall be able to deliver hatches and cargo to every port
8. We shall be able to control the robot autonomously during sandstorm and with operator control during the rest of the match
9. The robot will be able to operate in "aim-bot" mode to assist the driver with game object delivery
10. We shall be able to allow the driver to configure variables without recompiling

## Functions ##
1. Drive/Turn/Lift
2. Instructions from Driver
3. Give instructer feed from camera
4. Storing Data Permanently
    1. Data Logging
    2. Calibration
    3. Test Results
5. Acquire Robot Position

## Use Cases ##
1. DriveWithJoysticks
2. Exit Stations
3. Acquire target
4. Align with port
5. Deposit Hatch (Level 1|2|3)
6. Deposit Cargo (Level 1|2|3)
7.  Hatch
8. Load Cargo
9. Pick up Cargo from Floor
10. Pick up Hatch from Floor
11. Climb Level 2
12. Climb Level 3

## Interfaces ##
1. Robot/Drive Station
2. Hardware/Subsystem
3. Camera/Drivetrain
4. Robot/Scoring Mechanism
5. Drivers/Drive Station
6. Alignment System/Drivetrain
7. Vision System/Drivetrain

## Patterns ##
1. Command-based robot
2. PID Feedback Loop
3. Model View Controller
4. Finite-state Machines

## System Requirements ##
1. Shall be able to control drive train
2. Shall be able to control up/down mechanism
3. Shall be able to control vision tracking system
4. Get robot to be able to accelerate 4 feet per second to a maximum velocity of 10 feet per second
5. Get robot to be able to turn 180 degrees in 2 seconds
6. Travel 15 feet in a straight line
7. Shall be able to operate code when the field changes
8. Shall be able to reach the ball port with the up/down mechanism in 3 seconds
9. Shall be able to launch the ball into the ball port with a vertical accuracy of 1 inch
10. Shall be able to align with tape with an accuracy of 1 inch

## Layers ##
1. Driver
2. Driver Station
3. Commands
4. Subsystems
    1. Drivetrain
    2. Tracking System
    3. FRC Libraries
5. Drivers
6. Robot Hardware

## Subsystems ##
* Drive train
* Alignment System
* Up/Down Mechanism
* Drive station
* Motor Control

* Drive train
  * Wheels
  * Motors
  * Gears
* Up/Down Mechanism
  * Position Tracker
  * Activator
  * Grab Mechanism    
* Drive station
  * Xbox Controller
  * Driver
  * Laptop
* Driver Station Program
  * Dashboard
* Target Tracking
  * Camera
  * Reflective tape
  * Lighting
  * Light Relay
  * Raspberry Pi
* Alignment Tracking
  * Camera
  * White tape
  * Raspberry Pi
  * Gyroscope
* Motor Control
  * Neo-motors (x4)
  * Spark Max (x4)
  * Wheel Encoders

## Subsystem Requirements ##

### Drive Tracking ###
