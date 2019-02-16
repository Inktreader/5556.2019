/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {

  DoubleSolenoid pitchSolinoid = null;

  


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public  Shooter() {
    //declares solinoid,set's it's state
    
    pitchSolinoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLINIOD_DEPLOY, RobotMap.SHOOTER_PITCH_SOLINOID_RETRACT);
    pitchSolinoid.set(Value.kReverse);
  
  }

  //sets piston state
  public void pitchUp(){
    pitchSolinoid.set(Value.kForward);
  }
  public void pitchDown(){
    pitchSolinoid.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
