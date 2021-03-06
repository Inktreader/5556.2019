/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class LiftSubsystem extends Subsystem {
 //declares talon as null so we can declare it as a constant
  Talon LiftMotor = null;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public LiftSubsystem(){
    //declares talon constant. see it in robotMap
    LiftMotor = new Talon(RobotMap.LIFTSUBSYSTEM_TALON);
  }

  //this sets the motor speed
  public void LiftDownFast (){
    LiftMotor.set(-0.8);
  }
  
  public void LiftUpFast (){
    LiftMotor.set(0.8);
  }
  
  
  public void LiftUp (){
    LiftMotor.set(0.5);
  }
 
  public void LiftDown (){
 LiftMotor.set(-0.5);
  }

  public void LiftNeutral(){
    LiftMotor.set(0.0);
  }

  public void LiftUpSlow(){
    LiftMotor.set(0.2);
  }

  public void LiftDownSlow(){
    LiftMotor.set(-0.2);
  }

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
