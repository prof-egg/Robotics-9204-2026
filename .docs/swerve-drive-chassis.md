# Swerve Chassis Details
This chart is based off of [this chart](https://docs.yagsl.com/configuring-yagsl/getting-to-know-your-robot) in the YAGSL docs.

| Feature | Value | Relevance |
| - | - | - |
| Drive [Gear Ratio] | `5.08/1` | The _Drive Gear Ratio_ is the ratio describing how many times the drive motor shaft must rotate for the wheel to complete one rotation. This is usually available on the website of the Swerve Module purchased. |
| Steering [Gear Ratio] | `~46.42:1` (`9424:203`) | The _Steering Gear Ratio_ is the ratio describing how many times the steering motor shaf1t must rotate for the wheel to complete one spin. This is usally available on the website of the Swerve Module purchased. |
| Absolute Encoder Ticks Per Revolution| `8192` | [See here](https://docs.yagsl.com/devices/absolute-encoders) |
| CAN Bus Name | `rio` | If you are using a [CANivore] you may place CTRE devices such as the [Falcon500], [Kraken], [Pigeon2.0], and [CANCoder] on that bus. You must [set this value to the name of your CANivore]. |
| CAN or PWM or Analog Input ID of every sensor and motor controller. | [See here](#Module-CAN-IDs) | If this is incorrect it will cause major issue's because you will be controlling one motor thinking it's another! |
| Connection method for Gyroscope (NavX only) | `navx_spi` | If you are using a NavX over usb the device type should be `navx_usb` however if you are on the MXP please use `navx_spi`. |
| Inversion state of the motors | [See here](#Module-Details) | The inversion state needs to make the wheels go forward and spin clockwise. |
| Inversion state of the absolute encoder | [See here](#Module-Details) | Typically the absolute encoder will increase in value along with the steering motor movements, if this is not the case it needs to be changed!!! |
| Inversion state of the gyroscope | `false` | The gyroscope needs to be counter clockwise positive, if it isn't it needs to be inverted! |
| Absolute Encoder Offsets | [See here](#Module-Details) | The absolute encoder offset is given when you straighten out all modules **(facing the same way!)** then read the value from the vendor client or from SmartDashboard while the robot is Disabled! |
| Motor Controller PIDF values | [See here](#PIDF-Values) | Typical values are available in YAGSL-Example for NEO's and Falcon500's, however these may need to be further tuned. Ideally you can do this with the vendor client. |
| Distance **in inches** from the center of your robot to the center of each wheel. | [See here](#Module-Details) | This is used for [`SwerveDriveKinematics`] while setting up your robot in YAGSL. |
| Wheel diameter **in inches** | `3` | No idea what the relevance is since I added this row but heres the link to the [modules we are using](https://www.revrobotics.com/rev-21-3005/). |


### Motor Details
| Module | Drive CAN ID | Angle CAN ID | Drive Motor Type | Angle Motor Type |
| - | :-: | :-: | :-: | :-: |
| Front Left | `2` | `1` | `sparkflex_vortex` | `sparkmax_neo550` |
| Front Right | `4` | `3` | `sparkflex_vortex` | `sparkmax_neo550` |
| Back Left | `6` | `5` | `sparkflex_vortex` | `sparkmax_neo550` |
| Back Right | `8` | `7` | `sparkflex_vortex` | `sparkmax_neo550` |

### Module Details
We are using [NEO Vortex MAXSwerve](https://www.revrobotics.com/rev-21-3005/) Modules in this chassis.
| Module | Drive Inverted | Angle Inverted | Encoder Inverted | Encoder Offsets <br> (degrees) | Encoder Type | Offset +X (front) | Offset +Y (left) |
| - | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
| Front Left | `true` | `false` | `true` | `1.39` | `attatched` | `11.75` | `11.75` |
| Front Right | `true` | `false` | `true` | `359.6` | `attatched` | `11.75` | `-11.75` |
| Back Left | `true` | `false` | `true` | `359.9` | `attatched` | `-11.75` | `11.75` |
| Back Right | `true` | `false` | `true` | `0.3` | `attatched` | `-11.75` | `-11.75` |
> [!NOTE]
> For some reason the offsets are using modified cartesian coordinates where positive X points towards the front of the robot and positive Y point towards the left.
> You can see [this page](https://docs.yagsl.com/bringing-up-swerve/check-your-motors) on the YAGSL docs for a chart.

> [!WARNING]
> The absolute encoders might have been zeroed out in the wrong direction, the actual offsets may be `180`.

### PIDF Values
| Set | P | I | D | F | iz |
| - | :-: | :-: | :-: | :-: | :-: |
| Drive | `0.0020645` | `0` | `0` | `0` | `0` |
| Angle | `0.01` | `0` | `0` | `0` | `0` |

[CANivore]: https://store.ctr-electronics.com/canivore/
[Falcon500]: https://store.ctr-electronics.com/falcon-500-powered-by-talon-fx/
[Kraken]: https://store.ctr-electronics.com/kraken-x60/
[Pigeon2.0]: https://store.ctr-electronics.com/pigeon-2/
[CANCoder]: https://store.ctr-electronics.com/cancoder/

[set this value to the name of your CANivore]: https://pro.docs.ctr-electronics.com/en/stable/docs/canivore/canivore-setup.html#renaming-canivores
[Gear Ratio]: https://docs.yagsl.com/fundamentals/swerve-modules#conversion-factor
[`SwerveDriveKinematics`]: https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/math/kinematics/SwerveDriveKinematics.html
