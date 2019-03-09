/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.ModuleDescriptor.Requires;
import frc.robot.Robot;
import javax.swing.JFrame;
import javax.swing.Timer;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.subsystems.LiftSubsystem;

/**
 * Add your docs here.
 */
public class AutoLiftTimer extends InstantCommand {

  private static int cnt = 0;
  private static int isFinished = 0;
  /**
   * Add your docs here.
   */
  public AutoLiftTimer() {
    super();
    requires(Robot.m_liftSubsystem);
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
 // ActionListener actListener = new ActionListener(){
  
   // @Override
    //public void actionPerformed(ActionEvent arg0) {
      //cnt += 1;
    //}
  //};
  //if( cnt <= 4){
 //Robot.m_liftSubsystem.LiftZoom();
 //Timer timer = new Timer(2 , actListener);
  //} else if(cnt >= 4){
    //if (isFinished < 1){
      //Robot.m_liftSubsystem.LiftNeutral();
      //isFinished += 1;
    //}else{

    //}
 
  }
    
    
  }
//}

  
  


