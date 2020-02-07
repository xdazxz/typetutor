import javax.swing.*;
import java.awt.*;

public class IntroGameView extends WallPaperPanel
{
  private FrameModel frameModel;
  private JFrame window;
  private int requiredAccuracy;
  private int requiredSpeed;
  private int level;
  private boolean backAllowed;
  private JLabel levelText = new JLabel();
  private JLabel accuracyText = new JLabel();
  private JLabel wpmText = new JLabel();
  private JLabel backspace = new JLabel();
  private CustomButton next = new CustomButton("Next",300,80,50f);
  private BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
  public IntroGameView(FrameModel model, JFrame frame,int curLevel,  int wpm,int accuracy, boolean backspaceAllowed)
  {
    this.frameModel = model;
    this.window=frame;
    this.requiredAccuracy=accuracy;
    this.requiredSpeed=wpm;
    this.backAllowed=backspaceAllowed;
    this.level=curLevel;
    
    this.layoutView();
    this.registerControllers();
    
  }
  public void layoutView()
  {
    this.setLayout(layout);
    this.levelText.setText("Level "+ this.level);
    this.levelText.setFont(UIMethods.deriveFont("leaguespartan-bold.ttf",50f));
    this.levelText.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
    
    this.accuracyText.setText("Required Accuracy: " + this.requiredAccuracy + "%");
    this.accuracyText.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    
    this.wpmText.setText("Required Speed: " + this.requiredSpeed+ " WPM");
    this.wpmText.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    
    this.backspace.setFont(UIMethods.deriveFont("Barlow-Light.ttf",40f));
    if(backAllowed)
    {
      this.backspace.setText("Backspace Allowed: Yes");
    }
    else
    {
      this.backspace.setText("Backspace Allowed: No");
    }
    JPanel topPanel = new JPanel();
    topPanel.add(levelText);
    topPanel.setOpaque(false);
    JPanel secondRow = new JPanel();
    secondRow.add(accuracyText);
    secondRow.setOpaque(false);
    
    JPanel thirdRow = new JPanel();
    thirdRow.add(wpmText);
    thirdRow.setOpaque(false);
    
    
    JPanel fourthRow = new JPanel();
    fourthRow.add(backspace);
    fourthRow.setOpaque(false);
    
    JPanel fifthRow = new JPanel();
    fifthRow.add(next);
    fifthRow.setOpaque(false);
    
    JPanel emptyPanel = new JPanel();
    emptyPanel.setPreferredSize(new Dimension(1366,50));
    emptyPanel.setOpaque(false);
    
    this.add(topPanel);
    this.add(secondRow);
    this.add(thirdRow);
    this.add(fourthRow);
    this.add(fifthRow);
    this.add(emptyPanel);
    
    this.setPreferredSize(new Dimension(1366,768));
    window.setTitle("Game Mode");
    window.setContentPane(this);
    window.setSize(1366,768);
    window.setVisible(true);
    
  }
  public void registerControllers()
  {
    FrameSwitchController levelController = new FrameSwitchController(next,frameModel,"level"+this.level);
    this.next.addMouseListener(levelController);
  }
  
  
  
}