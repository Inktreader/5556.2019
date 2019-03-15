/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ShooterDown;
import frc.robot.commands.ShooterUp;
import frc.robot.commands.ShooterDownTwo;
import frc.robot.commands.ShooterUpTwo;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftUp;
import frc.robot.commands.LiftNeutral;
import frc.robot.commands.LiftUpFast;
import frc.robot.commands.LiftDownFast;
import frc.robot.commands.LiftDownSlow;
import frc.robot.commands.LiftUpSlow;

import frc.robot.commands.AutoLiftTimer;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  //declares joystick
  public Joystick liftJoystick = new Joystick(RobotMap.LIFT_JOYSTICK);
  public Joystick driverController = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);

  //declares joystick buttons
  Button D1 = new JoystickButton(driverController, 1);
  Button D2 = new JoystickButton(driverController, 2);
  Button D3 = new JoystickButton(driverController, 3);
  Button D4 = new JoystickButton(driverController, 4);
  Button D5 = new JoystickButton(driverController, 5);
  Button D6 = new JoystickButton(driverController, 6);
  Button D7 = new JoystickButton(driverController, 7);
  Button D8 = new JoystickButton(driverController, 8);
  Button D9 = new JoystickButton(driverController, 9);
  Button D10 = new JoystickButton(driverController, 10);
  Button D11 = new JoystickButton(driverController, 11);
  Button D12 = new JoystickButton(driverController, 12);

  //gives button actions (ex. d4, released) a command (call shooter up)
public OI(){

  
  

  D5.whenPressed(new ShooterUp());
  D3.whenPressed(new ShooterDown());

  D6.whenPressed(new ShooterUpTwo());
  D4.whenPressed(new ShooterDownTwo());

  D7.whenPressed(new LiftDownFast());
  D7.whenReleased(new LiftNeutral());

  D8.whenPressed(new LiftUpFast());
  D8.whenReleased(new LiftNeutral());

  D9.whenPressed(new LiftDown());
  D9.whenReleased(new LiftNeutral());
 
  D10.whenPressed(new LiftUp());
  D10.whenReleased(new LiftNeutral());

  D11.whenPressed(new LiftDownSlow());
  D11.whenPressed(new LiftNeutral());

  D12.whenPressed(new LiftUpSlow());
  D12.whenPressed(new LiftNeutral());

  
}
















  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
