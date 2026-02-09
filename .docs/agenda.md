# Agenda
The agenda will hold general information about what we are maybe supposed to be doing for the week as the programming team. 

### Week 6 - 2026-02-16
Test the robot?

---
## [Week 5 - 2026-02-09](https://github.com/prof-egg/Robotics-9204-2026)
By now you should have a basic understanding of [command-based] programming and I am just about down with serve drive. 
From now on I plan on showing up just Mondays and Thursdays and I leave the rest of the bot up to you guys.

### General
- Finish up tank drive code if you haven't.
- Once I merge the `feature/swerve-drive` branch into the main branch, feel free to pull those changes to your local repo
and create a new branch where you can mess around and run the code.
  - You can try and do something like make the chassis move forward at a fix speed upon pressing the A button on the controller for a little exercise.

Tom will be here most Tuesdays and he will try to make Wednesdays. When I'm not around feel free to ask him questions about programming. If we are
both not around, then try to find the best answer you can by yourself. A lot of computer science is just research at the end of the day anyway.

---

## Week 4 - 2026-02-02
I want us to be able to finish up the tank drive test program and do a test drive by the end of the week.
I want to be able to finish up swerve drive for the actual robot, and then leave the rest of the robot to you guys.

### General
- Keep researching basic tank drive (tutorials, questions, example source code, docs, last week's links, etc.).
- Keep programming basic tank drive.
- Try and test tank drive by the end of the week.
- Understand the [command-based] framework.
  - [Subsystems](https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html#creating-a-subsystem)
  - [Commands](https://github.com/prof-egg/Robotics-9204-2026/edit/main/.docs/agenda.md)
  - [Command-Scheduler](https://docs.wpilib.org/en/stable/docs/software/commandbased/command-scheduler.html)
  - [Triggers](https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers.html)
  - [Robot Container](https://docs.wpilib.org/en/stable/docs/software/commandbased/structuring-command-based-project.html#robotcontainer)

Soon enough I plan to not show up as much so I can focus on other things before I go back to school. I want to make
sure you guys can handle yourselves when I start to not appear as much (though I will still be maintaining this repo).

## Week 3 - 2026-01-26
Last week we went over basic git and github practices (or at least half of us did), this week we are getting into programming fr fr.
### General
- Research basic tank drive
- Program basic tank drive
  - We are each going to each make our own branch and title it according to [naming convetions]. For example: `feature/mik-tank-drive`.
  - In our own branches, we will get comfortable with using the [command-based] framework by programming our own [tank drive] software.
  - This will include things like making a tank drive [subsystem] (name the file something like `TankDrivetrainSybsystem.java`),
    making a drive [command], adding any necessary [constants] to the [`Constants.java`] file to keep your code clean,
    and making sure everything gets hooked up properly in the [robot container] ([`RobotContainer.java`]).
  - Hopefully we will have time to [deploy] our code to the roboRIO and debug if we need to (we are probably going to have to enlist Tom to help us).
- Our focus this year is swerve drive, but programming tank drive first will be good practice and gives us an easy drivetrain to test other robot modules on.
> The name of the drivetrain subsystem file would usually just be named `DrivetrainSubsystem.java`. But, we are going to try and make a swerve-drive subsystem as well, so we should make the name of the tank drive file distinct. Hence: `TankDrivetrainSybsystem.java`.



## Week 2 - 2026-01-19
Last week was crazy because we didn't actually do anything, the goal this week: do something
### General
- Speedrun week 1 stuff
- Try to program basic tank drive on the old robot chassis
  - What does command-based programming look like?
  - What does interacting with the robot through WPILib actually look like? (interact with motors, get controller input, etc.)
  - How do we deploy our code to the robot? (I actually don't know so we gotta figure this one out)
  - How can we test code without needing to deploy? (something to think about but I think we will have to answer this some other time)

## Week 1 - 2026-01-12
This week we are just going to try and figure out how exactly things will work for this season. By the end of the week hopefully we will feel comfortable actually getting started on programming.

### General
- New smaller GroupMe for team programmers?
- Figure out who is on the programming roster this season
  - Originally, it seemed that nolan was interested in being on the programming team but he may have backed out, and we might get some more members
- Figure out programming situation
  - There is only one device that the team has that we can currently program on, that is obviously not enough
  - Our choices seem to be to either get the bigwigs at PCHS HQ to let us use the CAD Lab computers, or use some of the spare robotics laptops
- Figure out what we are even going to program
  - The engineers seemed on the edge on whether we were doing tank drive again, taking a shot at swerve drive, or doing both
- Go over [command-based] programming for FRC robotics

### Git/GitHub
- Go over the basics of Git and GitHub
- Cover information about this repo
- Create GitHub accounts and add team to this private repo
- Team members successfully cloned the repo
- "Who was here?" github excersize

[deploy]: https://docs.wpilib.org/en/stable/docs/software/vscode-overview/deploying-robot-code.html#building-and-deploying-robot-code
[robot container]: https://docs.wpilib.org/en/stable/docs/software/commandbased/structuring-command-based-project.html#robotcontainer
[constants]: https://docs.wpilib.org/en/stable/docs/software/commandbased/structuring-command-based-project.html#constants
[tank drive]: https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html
[naming convetions]: naming-conventions.md
[`Constants.java`]: ../src/main/java/frc/robot/Constants.java
[`RobotContainer.java`]: ../src/main/java/frc/robot/RobotContainer.java
[subsystem]: https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html
[command-based]: https://docs.wpilib.org/en/stable/docs/software/commandbased/index.html
[command]: https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html
[tank drive]: https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html
