 /*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
 
 //declares talons and drive as null so we can make constants
  Talon leftTalon = null;
 Talon rightTalon = null;


  DifferentialDrive differentailDrive = null;
  
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    
    setDefaultCommand(new DriveArcade());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public Drivetrain (){
    

  
    rightTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_TALON);
    
    leftTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_TALON);

    differentailDrive = new DifferentialDrive(leftTalon,rightTalon );

    differentailDrive.setSafetyEnabled(false);

  }

  //takes parameters and and calls arcadeDrive with our differentailDrive
  public void arcadeDrive(double moveSpeed,double rotateSpeed){
    differentailDrive.arcadeDrive(Math.pow(moveSpeed, 3),Math.pow(rotateSpeed, 3));
  }
}
