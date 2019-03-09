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
public class ShooterTwo extends Subsystem {

  DoubleSolenoid pitchSolinoidTwo = null;


  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public  ShooterTwo() {
    //declares solonoid, sets it's state
    pitchSolinoidTwo = new DoubleSolenoid(RobotMap.SHOOTERTWO_PITCH_SOLINIOD_DEPLOY, RobotMap.SHOOTERTWO_PITCH_SOLINOID_RETRACT);
    pitchSolinoidTwo.set(Value.kReverse);
  }

  //sets piston state
  public void pitchUp(){
    pitchSolinoidTwo.set(Value.kForward);
  }
  public void pitchDown(){
    pitchSolinoidTwo.set(Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

}
