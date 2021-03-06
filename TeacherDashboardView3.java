/* TeacherDashboardView3
 * Created by: Johnson Duong
 * Updated on: 2019/05/29
 * The opening page of the class list
 */

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class TeacherDashboardView3 extends JPanel
{
 //instance variables 
 private JFrame window;
 private FrameModel model;

 private Teacher teacher;
 private JPanel componentsPanel = new JPanel(new GridBagLayout());
 private JLabel classListText = new JLabel("Class List");
 private JLabel prompt = new JLabel("Choose a student");
 private String[] studentNames;
 private JList classList;
 private JScrollPane scrollPane;
 private CustomButton backButton = new CustomButton("Back", 112, 60, 30);
 private CustomButton newStudentButton = new CustomButton("   Add New Student", 460, 55, 20);
 private CustomButton removeStudentButton = new CustomButton("   Remove Student", 460, 55, 20);
 private GridBagConstraints gbc = new GridBagConstraints();

 //constructor
 public TeacherDashboardView3(FrameModel model, JFrame frame, Teacher currentTeacher)
 {
  super();
  this.window = frame;
  this.model = model;
  this.teacher = currentTeacher;
  this.studentNames = this.teacher.getStudents();
  this.classList = new JList(studentNames);
  this.scrollPane = new JScrollPane(this.classList);
  
  this.layoutView();
  this.registerControllers();
  this.update();

 }//end constructor

 //sets the initial layout of the view
 private void layoutView()
 {
  //the classlist
  this.classListText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf", 42f)); 
  this.gbc.insets = new Insets(70,0,0,1040);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(classListText,gbc);
  
  this.classList.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 25f));
  this.classList.setSelectionBackground(new Color(241, 248, 108));
  this.classList.setSelectionForeground(Color.BLACK);
  this.classList.setFixedCellHeight(50);
  this.classList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  this.scrollPane.setPreferredSize(new Dimension(375,530));
  this.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
  this.gbc.insets = new Insets(20,0,0,860);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(scrollPane,gbc);

  //buttons and text
  this.prompt.setFont(UIMethods.deriveFont("Barlow-Light.ttf", 32f));
  this.gbc.insets = new Insets(0,0,480,180);
  componentsPanel.add(prompt,gbc);

  this.gbc.insets = new Insets(60,1110,0,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 0;
  componentsPanel.add(backButton,gbc);

  this.newStudentButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(25,45,350,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(newStudentButton,gbc);

  this.removeStudentButton.setHorizontalAlignment(JButton.LEFT);
  this.gbc.insets = new Insets(0,45,205,0);
  this.gbc.gridx = 0;
  this.gbc.gridy = 1;
  componentsPanel.add(removeStudentButton,gbc);

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
  
  FrameSwitchController addStudentController = new FrameSwitchController(this.newStudentButton,this.model,"TeacherDashboard4");
  this.newStudentButton.addMouseListener(addStudentController);
  
  FrameSwitchController removeStudentController = new FrameSwitchController(this.removeStudentButton,this.model,"TeacherDashboard5");
  this.removeStudentButton.addMouseListener(removeStudentController);
  
  SelectionController studentSelectionController = new SelectionController(this.classList, this.model, "TeacherDashboard6");
  this.classList.addListSelectionListener(studentSelectionController);
 }//end registerControllers

 //updates the view
 public void update()
 {
  
 }//end update
 
}//ssalc
