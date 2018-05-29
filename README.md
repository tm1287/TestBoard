# Test Board
This is the code for the Test Board used to learn FRC programming, as written by Tejas Maraliga.

At the moment it contains code that can drive the two motors with a single joystick, read the values of the two encoders, and drive the motor to a certain encoder value using a PID controller.

# Tuning PID values

#### Method 1 - Ziegler - Nichols method

1. Start by setting `I` and `D` to 0.
2. Increase `P` until the system starts oscillating for a period of `Tu`. Oscillation must be large enouge to time. Maximum `P` will be refered to as `Ku`

|Control Types|    P   |      I    |      D     |
|:------------|:------:|:---------:|:----------:|
|P            |0.5\*Ku |     0     |      0     |
|PI           |0.45\*Ku|0.54\*Ku/Tu|      0     |
|PID          |0.6\*Ku |1.2\*Ku/Tu |3\*Ku\*Tu/40|
