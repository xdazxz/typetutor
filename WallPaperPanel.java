/* TeacherDashboardView1 
 * Created by: Johnson Duong
 * Updated on: 2019/05/27
 * The opening screen in the Teacher Dashboard
 */

import javax.swing.*;
import java.awt.*;

public class WallPaperPanel extends JPanel
{

 ImageIcon image;
 
 //constructor
  public WallPaperPanel()
  {
   super();
   image = new ImageIcon("Wallpaper.png");
   this.setPreferredSize(new Dimension(image.getImage().getWidth(null),image.getImage().getHeight(null)));
  }//end constructor
  
  //overriding the paintComponent method
  public void paintComponent(Graphics g)
  {
   super.paintComponent(g);
   Image pic = image.getImage();
   g.drawImage(pic,0,0,null);
  }//end paintComponent
 
}//ssalc
