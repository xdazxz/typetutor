/* TeacherDashboardView2
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * The screen that allows a teacher to change their password
 */

import javax.swing.*;
import java.awt.*;

public class TeacherDashboardView2 extends JPanel
{
 //instance variables
 private JFrame window;
 private FrameModel model;

 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private JLabel title = new JLabel("Change Password");
 private JLabel prompt = new JLabel("Enter a new password:");
 private JTextField passwordField = new JTextField();
 private CustomButton confirmButton = new CustomButton("Confirm", 160, 60, 30);

 private GridBagConstraints gbc = new GridBagConstraints();
private Teacher loggedIn;
 //constructor
 public TeacherDashboardView2(FrameModel model, JFrame frame,Teacher user)
 {
  super();
  this.window = frame;
  this.model = model;
  this.loggedIn=user;
  this.layoutView();
  this.registerControllers();
  this.update();
 }//end constructor

 //set the initial layout of the window
 private void layoutView()
 {
  //the title, prompt, and back button
  this.title.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 
  this.prompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 21f)); 

  this.gbc.insets = new Insets(55,0,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(title,gbc);
  
  this.gbc.insets = new Insets(80,0,0,560);
  this.gbc.gridx = 0;
  this.gbc.gridy = 2;
  componentsPanel.add(prompt,this.gbc);
  
  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);
  
  //the password field and confirm button
  this.passwordField.setPreferredSize(new Dimension(770,70));
  this.passwordField.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 42f));

  this.gbc.insets = new Insets(0,0,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 3;
  componentsPanel.add(passwordField, gbc);

  this.gbc.insets = new Insets(10,0,0,600);
  this.gbc.gridx = 0;
  this.gbc.gridy = 4;
  componentsPanel.add(confirmButton, gbc);

  //the window
  componentsPanel.setOpaque(false);
  this.add(componentsPanel);
  this.setBackground(new Color(56, 183, 255));
  window.setContentPane(this);
  window.setVisible(true);
  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  window.setSize(1366, 768);

 }//end layoutView

 //registering the controllers
 private void registerControllers()
 {
  FrameSwitchController backController = new FrameSwitchController(this.backButton,this.model,"TeacherDashboard1");
  this.backButton.addMouseListener(backController);

  ChangePasswordController confirmController = new ChangePasswordController(this.confirmButton,this.model,this.passwordField,this.loggedIn);
  this.confirmButton.addMouseListener(confirmController);
 }//end registerControllers

 //updates the view
 private void update()
 {
  
 }//end update
 
}//ssalc
