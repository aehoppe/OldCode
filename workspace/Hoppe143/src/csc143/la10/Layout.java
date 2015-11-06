package csc143.la10;

/**
 * A sample showing how some common layout managers work.
 * 
 * @author Dan
 * @version 0.2
 */
public class Layout
{
  // the window
  private javax.swing.JFrame win;
  
  // the content pane
  private java.awt.Container c;
  
  // a panel for the toolbar
  private java.awt.Container toolbar;
  
  // the buttons to be arranged
  private javax.swing.JButton b1;
  private javax.swing.JButton b2;
  private javax.swing.JButton b3;
  private javax.swing.JButton b4;
  private javax.swing.JButton b5;
  private javax.swing.JButton b6;
  
  /**
   * Constructor for objects of class Layout
   */
  public Layout()
  {
    // create the window
    win = new javax.swing.JFrame("Sample Layouts");
    // get the content pane
    c = win.getContentPane();
    
    // create the toolbar
    toolbar = new javax.swing.JPanel();
    
    // create the buttons
    b1 = new javax.swing.JButton("A Button");
    b2 = new javax.swing.JButton("Bob");
    b3 = new javax.swing.JButton("Charlie");
    b4 = new javax.swing.JButton("Doris");
    b5 = new javax.swing.JButton("Ernie, but not Bert");
    b6 = new javax.swing.JButton("Frank");
    
    // add a button
    c.add(b1);
    
    // set window characteristics
    win.setLocation(50, 50);
    win.setSize(246, 214);
    win.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    win.setVisible(true);
    win.toFront();
  }
  
  /**
   * Use a grid layout to display the buttons
   */
  public void useGridLayout()
  {
    // create a grid layout and use it in the content pane
    c.setLayout(new java.awt.GridLayout(2, 3));
    
    // add the buttons into the layout
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(b4);
    c.add(b5);
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Use a flow layout to display the buttons
   */
  public void useFlowLayout()
  {
    // create a flow layout and use it in the content pane
    c.setLayout(new java.awt.FlowLayout());
    
    // add the buttons into the layout
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(b4);
    c.add(b5);
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Use a border layout to display the buttons
   */
  public void useBorderLayout()
  {
    // create a border layout and use it in the content pane
    c.setLayout(new java.awt.BorderLayout());
    
    // add the buttons into the layout
    c.add(b1, java.awt.BorderLayout.NORTH);
    c.add(b2, java.awt.BorderLayout.SOUTH);
    c.add(b3, java.awt.BorderLayout.CENTER);
    c.add(b4, java.awt.BorderLayout.EAST);
    c.add(b5, java.awt.BorderLayout.WEST);
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Make to toolbar to display the buttons
   */
  public void useToolbar()
  {
    // create a border layout and use it in the content pane
    c.setLayout(new java.awt.BorderLayout());
    
    // add the buttons into the layout
    toolbar.add(b1);
    toolbar.add(b2);
    toolbar.add(b3);
    toolbar.add(b4);
    toolbar.add(b5);
    
    // put the toolbar at the top
    c.add(toolbar, java.awt.BorderLayout.NORTH);
    // add a button to center
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Make to toolbar to display the buttons
   * using two rows
   */
  public void useToolbarII()
  {
    // create a border layout and use it in the content pane
    c.setLayout(new java.awt.BorderLayout());
    
    // add the buttons into the layout
    toolbar.add(b1);
    toolbar.add(b2);
    toolbar.add(b3);
    toolbar.add(b4);
    toolbar.add(b5);
    
    // get the height of the toolbar and double it
    java.awt.Dimension d = toolbar.getPreferredSize();
    d.height *= 1.9;
    toolbar.setPreferredSize(d);
    
    // put the toolbar at the top
    c.add(toolbar, java.awt.BorderLayout.NORTH);
    // add a button to center
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Make to toolbar to display the buttons
   * using BoxLayout
   */
  public void useBoxLayout()
  {
    // create a border layout and use it in the content pane
    c.setLayout(new java.awt.BorderLayout());
    
    // get the toolbar from Box
    toolbar = javax.swing.Box.createHorizontalBox();
    
    // add the buttons into the layout
    toolbar.add(b1);
    toolbar.add(b2);
    toolbar.add(b3);
    toolbar.add(b4);
    toolbar.add(b5);
    
    // put the toolbar at the top
    c.add(toolbar, java.awt.BorderLayout.NORTH);
    // add a button to center
    c.add(b6);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * display the UI as initially created.
   */
  public void showAButton()
  {
    // set the layout to border layout
    c.setLayout(new java.awt.BorderLayout());
    
    // add a button to the layout
    c.add(b1);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Use no layout manager to display the buttons
   */
  public void useCustomLayout()
  {
    // use no layout manager in the content pane
    c.setLayout(null);
    
    // add the buttons into the layout
    c.add(b1);
    c.add(b2);
    c.add(b3);
    c.add(b4);
    c.add(b5);
    c.add(b6);
    b1.setSize(100, 25);
    b1.setLocation(10, 10);
    b2.setSize(100, 25);
    b2.setLocation(120, 10);
    b3.setSize(100, 25);
    b3.setLocation(10, 45);
    b4.setSize(100, 25);
    b4.setLocation(120, 45);
    b5.setSize(210, 50);
    b5.setLocation(10, 80);
    b6.setSize(100, 25);
    b6.setLocation(65, 140);
    
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Remove the toolbar from the content pane and
   * create a new toolbar.
   */
  public void resetToolbar()
  {
    // remove the toolbar from the content pane
    c.remove(toolbar);
    // recreate the toolbar
    toolbar = new javax.swing.JPanel();
    // make the layout manager work
    c.validate();
  }
  
  /**
   * Pack the contents of the window.
   */
  public void pack()
  {
    // pack the contents of the window
    win.pack();
  }
}
