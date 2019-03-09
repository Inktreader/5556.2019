/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.LiftArcade;


/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
 // DigitalInput forwardLimitSwitch = null;
  //DigitalInput reverseLimitSwitch = null;
  Talon liftMotor = null;
  Joystick liftJoystick = null;
  
  //declares talon as null so we can declare it as a constant
  //Talon LiftMotor = null;
  Talon GhostMotor = null;

  DifferentialDrive liftDrive = null;
  
  // Put methods for controlling this subsystem
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftArcade());
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  
  // here. Call these from Commands.
  public LiftSubsystem(){
  
    //declares talon constant. see it in robotMap
    //ghost motor does not exist
    GhostMotor = new Talon(RobotMap.GHOST_TALON);
    liftMotor = new Talon(RobotMap.LIFT_MOTOR);



    liftDrive = new DifferentialDrive(liftMotor, GhostMotor);
    liftDrive.setSafetyEnabled(false);
  
  }
  
  
  
  public void LiftArcade(double moveSpeed, double turnSpeed ){
liftDrive.arcadeDrive(moveSpeed, turnSpeed);

  }

  

  

  public void LiftJoyControl(double moveSpeedPre){
   liftMotor.set(moveSpeedPre);
  }

  //this sets the motor speed
  public void LiftDownFast (){
    liftMotor.set(-0.8);
  }
  
  public void LiftUpFast (){
  liftMotor.set(0.8);
  }
  
  public void LiftUp (){
    liftMotor.set(0.5);
  }
 
  public void LiftDown (){
 liftMotor.set(-0.5);
  }

  public void LiftNeutral(){
    liftMotor.set(0.0);
  }

  public void LiftUpSlow(){
    liftMotor.set(0.2);
  }

  public void LiftDownSlow(){
    liftMotor.set(-0.2);
  }

//makes lift do big speed
  public void LiftZoom(){
  liftMotor.set(1.0);
  }


    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  
  

