# Test Board
This is the code for the Test Board used to learn FRC programming, as written by Tejas Maraliga.

At the moment it contains code that can drive the two motors with a single joystick, read the values of the two encoders, and drive the motor to a certain encoder value using a PID controller.

# Tuning PID values

#### Method 1 - Ziegler-Nichols method

1. Start by setting 'I' and 'D' to 0.
2. Increase 'P' until the system starts oscillating for a period of 'Tu'. Oscillation must be large enouge to time. Maximum 'P' will be refered to as 'Ku'
3. Use the chart below to calculate the corresponding 'P', 'I', and 'D' value for your control system.

|Control Types|    P   |      I    |      D     |
|:------------|:------:|:---------:|:----------:|
|P            |0.5\*Ku |     0     |      0     |
|PI           |0.45\*Ku|0.54\*Ku/Tu|      0     |
|PID          |0.6\*Ku |1.2\*Ku/Tu |3\*Ku\*Tu/40|

##### NOTE: The period of oscillation is one full ‘stroke’, there and back. Imagine a grandfather clock with a pendulum, when it is all the way to the right, swings to the left, and hits the right again, that is 1 period.

#### Method 2 - Trial and Error method

1. Start with a small value for 'P' and 0 for 'I' and 'D'.
2. Raise 'P' until the robot is consistently oscillating around the setpoint.
3. Once this is accomplished, increase 'D' until the robot stops oscillating.
4. Finally, increase 'I' until the robot stops within a desired range of the setpoint.
