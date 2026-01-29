# Swerve Chassis Details
This chart is based off of [this chart](https://docs.yagsl.com/configuring-yagsl/getting-to-know-your-robot) in the YAGSL docs.

| Feature | Value | Relevance |
| - | - | - |
| Drive [Gear Ratio] | N/A | The _Drive Gear Ratio_ is the ratio describing how many times the drive motor shaft must rotate for the wheel to complete one rotation. This is usually available on the website of the Swerve Module purchased. |
| Steering [Gear Ratio] | N/A | The _Steering Gear Ratio_ is the ratio describing how many times the steering motor shaf1t must rotate for the wheel to complete one spin. This is usally available on the website of the Swerve Module purchased. |
| Absolute Encoder Ticks Per Revolution| N/A | [See here](https://docs.yagsl.com/devices/absolute-encoders) |
| CAN Bus Name | `rio` | If you are using a [CANivore] you may place CTRE devices such as the [Falcon500], [Kraken], [Pigeon2.0], and [CANCoder] on that bus. You must [set this value to the name of your CANivore]. |
| CAN or PWM or Analog Input ID of every sensor and motor controller. | [See here](#Module-CAN-IDs) | If this is incorrect it will cause major issue's because you will be controlling one motor thinking it's another! |
| Connection method for Gyroscope (NavX only) | N/A | If you are using a NavX over usb the device type should be `navx_usb` however if you are on the MXP please use `navx_spi`. |
| Inversion state of the motors | [See here](#Motor-Inversion-States)| The inversion state needs to make the wheels go forward and spin clockwise. |
| Inversion state of the absolute encoder | N/A | Typically the absolute encoder will increase in value along with the steering motor movements, if this is not the case it needs to be changed!!! |
| Inversion state of the gyroscope | N/A | The gyroscope needs to be counter clockwise positive, if it isn't it needs to be inverted! |
| Absolute Encoder Offsets | [See here](#Absolute-Encoder-Offsets) | The absolute encoder offset is given when you straighten out all modules (facing the same way!) then read the value from the vendor client or from SmartDashboard while the robot is Disabled! |
| Motor Controller PIDF values | [See here](#PIDF-Values) | Typical values are available in YAGSL-Example for NEO's and Falcon500's, however these may need to be further tuned. Ideally you can do this with the vendor client. |
| Distance **in inches** from the center of your robot to the center of each wheel. | N/A | This is used for [`SwerveDriveKinematics`] while setting up your robot in YAGSL. |


### Module CAN IDs
| Module | Azimuth CAN ID | Drive CAN ID |
| - | :-: | :-: |
| Front Left | `1` | `2` |
| Front Right | `3` | `4` |
| Back Left | `5` | `6` |
| Back Right | `7` | `8` |

### Motor Inversion States
| Module | Inverted |
| - | :-: |
| Front Left | N/A |
| Front Right | N/A |
| Back Left | N/A |
| Back Right | N/A |

### Absolute Encoder Offsets
| Module | Encoder Offset |
| - | :-: |
| Front Left | N/A |
| Front Right | N/A |
| Back Left | N/A |
| Back Right | N/A |

### PIDF Values
| Set | P | I | D | F | iz |
| - | :-: | :-: | :-: | :-: | :-: |
| Drive | N/A | N/A | N/A | N/A | N/A |
| Angle | N/A | N/A | N/A | N/A | N/A |

[CANivore]: https://store.ctr-electronics.com/canivore/
[Falcon500]: https://store.ctr-electronics.com/falcon-500-powered-by-talon-fx/
[Kraken]: https://store.ctr-electronics.com/kraken-x60/
[Pigeon2.0]: https://store.ctr-electronics.com/pigeon-2/
[CANCoder]: https://store.ctr-electronics.com/cancoder/

[set this value to the name of your CANivore]: https://pro.docs.ctr-electronics.com/en/stable/docs/canivore/canivore-setup.html#renaming-canivores
[Gear Ratio]: https://docs.yagsl.com/fundamentals/swerve-modules#conversion-factor
[`SwerveDriveKinematics`]: https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/math/kinematics/SwerveDriveKinematics.html
