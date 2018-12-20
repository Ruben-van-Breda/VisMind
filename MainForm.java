/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.pkg17;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben van Breda
 */
public class MainForm extends javax.swing.JFrame {

   int currentSizeX = 100;
   int currentSizeY = 100;
   
   
   Color colorSelected = Color.gray;
   String currentBrushFill = "lightGreen"; // Image/colour
   String currentBrushType = "Square"; // shape of the brush
   String lastBrushFill = currentBrushFill;
   
   Point pointStart = new Point(100, 100); // Start Point or the point at which the 1st click was made
   Point pointEnd = null; // End Point or the point at which the 2nd click was mad
   Point newPoint = pointStart; // Declare the new Point and set it = to pointStart to avoid null errors.
   
   
   boolean isInNewDrawingPhase = false; // Boolean to keep track if the user is in a drawing phase.
   boolean isUseColor = false; // Use a color or an asset as the shape fill.
   Graphics g; // Graphics object
   DrawManager dM = null; // DrawManager object need to acess the functions created in that class.
   
   
                            
    public MainForm() {
        
        initComponents(); // Initialize the components of the UI
        this.g = canvas.getGraphics(); // Initalize the graphics object.
        this.dM = new DrawManager(g);// Initalize the DrawManger object.
        dM.ClearTempFile(); //  Clear the temporary file.
        
        // Set the size slider default value.
        sliderBrushSize.setValue(50);
        currentSizeX = sliderBrushSize.getValue();
        currentSizeY = sliderBrushSize.getValue();
        lbUserDebug.setText(currentSizeY+"");
        txtBrushSize.setText(String.valueOf(sliderBrushSize.getValue()));
        
        // Clear the canvas when starting the program to avoid potential errors.
        canvas.repaint();
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        canvas = new javax.swing.JPanel();
        lbUserDebug = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        sliderBrushSize = new javax.swing.JSlider();
        btnBrushTypeOval = new javax.swing.JButton();
        btnBrushTypeSquare = new javax.swing.JButton();
        txtBrushSize = new javax.swing.JTextField();
        toolSelectColor = new javax.swing.JPanel();
        cbUseColor = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnWhiteFill = new javax.swing.JButton();
        btnBlackFill = new javax.swing.JButton();
        btnRedSquare = new javax.swing.JButton();
        btnBlueSquare = new javax.swing.JButton();
        btnOrangeFill = new javax.swing.JButton();
        btnLightGreenFill = new javax.swing.JButton();
        btnYellowFill = new javax.swing.JButton();
        btnDarkGreenFill = new javax.swing.JButton();
        btnBrownFill = new javax.swing.JButton();
        btnLightBlueFill = new javax.swing.JButton();
        btnGreyFill1 = new javax.swing.JButton();
        MainMenuBar = new javax.swing.JMenuBar();
        menuSave = new javax.swing.JMenu();
        menuItemNew = new javax.swing.JMenuItem();
        menuItemSave = new javax.swing.JMenuItem();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemHelp = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VisMind");
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(153, 153, 255));
        setMaximumSize(new java.awt.Dimension(900, 1080));
        setMinimumSize(new java.awt.Dimension(900, 840));
        setName("mainFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 800));
        setSize(new java.awt.Dimension(900, 800));
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        canvas.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        canvas.setMaximumSize(new java.awt.Dimension(900, 800));
        canvas.setName("Canvas"); // NOI18N
        canvas.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                canvasMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                canvasMouseDragged(evt);
            }
        });
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                canvasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                canvasMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canvasMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        lbUserDebug.setText("Brush Size");

        jTabbedPane1.setForeground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setForeground(new java.awt.Color(153, 153, 255));

        sliderBrushSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrushSizeStateChanged(evt);
            }
        });

        btnBrushTypeOval.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnBrushTypeOval.setText("o");
        btnBrushTypeOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrushTypeOvalActionPerformed(evt);
            }
        });

        btnBrushTypeSquare.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnBrushTypeSquare.setText("[]");
        btnBrushTypeSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrushTypeSquareActionPerformed(evt);
            }
        });

        txtBrushSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBrushSize.setText("10");
        txtBrushSize.setToolTipText("");
        txtBrushSize.setActionCommand("<Not Set>");
        txtBrushSize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBrushSize.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBrushSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtBrushSizeMouseExited(evt);
            }
        });
        txtBrushSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrushSizeActionPerformed(evt);
            }
        });
        txtBrushSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBrushSizeKeyPressed(evt);
            }
        });

        toolSelectColor.setBackground(new java.awt.Color(204, 204, 204));
        toolSelectColor.setForeground(new java.awt.Color(102, 102, 102));
        toolSelectColor.setMinimumSize(new java.awt.Dimension(32767, 0));
        toolSelectColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toolSelectColorMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toolSelectColorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toolSelectColorMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout toolSelectColorLayout = new javax.swing.GroupLayout(toolSelectColor);
        toolSelectColor.setLayout(toolSelectColorLayout);
        toolSelectColorLayout.setHorizontalGroup(
            toolSelectColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
        );
        toolSelectColorLayout.setVerticalGroup(
            toolSelectColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        cbUseColor.setFont(new java.awt.Font("Phosphate", 0, 13)); // NOI18N
        cbUseColor.setForeground(new java.awt.Color(255, 255, 255));
        cbUseColor.setText("Use Colour");
        cbUseColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbUseColorMouseClicked(evt);
            }
        });
        cbUseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbUseColor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolSelectColor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(txtBrushSize, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(sliderBrushSize, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(btnBrushTypeSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrushTypeOval, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(toolSelectColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtBrushSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderBrushSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnBrushTypeSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBrushTypeOval, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbUseColor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Home", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnWhiteFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/whiteSquare.png"))); // NOI18N
        btnWhiteFill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnWhiteFill.setPreferredSize(new java.awt.Dimension(25, 25));
        btnWhiteFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWhiteFillActionPerformed(evt);
            }
        });

        btnBlackFill.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnBlackFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/blackSquare.png"))); // NOI18N
        btnBlackFill.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBlackFill.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBlackFill.setIconTextGap(0);
        btnBlackFill.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBlackFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlackFillActionPerformed(evt);
            }
        });

        btnRedSquare.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnRedSquare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/redSquare.png"))); // NOI18N
        btnRedSquare.setPreferredSize(new java.awt.Dimension(25, 25));
        btnRedSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedSquareActionPerformed(evt);
            }
        });

        btnBlueSquare.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnBlueSquare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OVAL/blueOval.png"))); // NOI18N
        btnBlueSquare.setPreferredSize(new java.awt.Dimension(25, 25));
        btnBlueSquare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBlueSquareActionPerformed(evt);
            }
        });

        btnOrangeFill.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        btnOrangeFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/orangeSquare.png"))); // NOI18N
        btnOrangeFill.setPreferredSize(new java.awt.Dimension(25, 25));
        btnOrangeFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrangeFillActionPerformed(evt);
            }
        });

        btnLightGreenFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/lightGreenSquare.png"))); // NOI18N
        btnLightGreenFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightGreenFillActionPerformed(evt);
            }
        });

        btnYellowFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/yellowSquare.png"))); // NOI18N
        btnYellowFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYellowFillActionPerformed(evt);
            }
        });

        btnDarkGreenFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/darkGreenSquare.png"))); // NOI18N
        btnDarkGreenFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarkGreenFillActionPerformed(evt);
            }
        });

        btnBrownFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/brownSquare.png"))); // NOI18N
        btnBrownFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrownFillActionPerformed(evt);
            }
        });

        btnLightBlueFill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/lightBlueSquare.png"))); // NOI18N
        btnLightBlueFill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightBlueFillActionPerformed(evt);
            }
        });

        btnGreyFill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SQUARE/greySquare.png"))); // NOI18N
        btnGreyFill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGreyFill1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBlackFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnWhiteFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLightGreenFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDarkGreenFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRedSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBlueSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnYellowFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLightBlueFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrangeFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGreyFill1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBrownFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGreyFill1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrownFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLightGreenFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlackFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnWhiteFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarkGreenFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRedSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBlueSquare, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnYellowFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLightBlueFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrangeFill, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assets", jPanel1);

        MainMenuBar.setBackground(new java.awt.Color(153, 153, 255));
        MainMenuBar.setForeground(new java.awt.Color(153, 153, 255));

        menuSave.setText("File");

        menuItemNew.setText("New");
        menuItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewActionPerformed(evt);
            }
        });
        menuSave.add(menuItemNew);

        menuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        menuItemSave.setText("Save");
        menuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSaveActionPerformed(evt);
            }
        });
        menuSave.add(menuItemSave);

        menuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        menuItemOpen.setText("Open...");
        menuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenActionPerformed(evt);
            }
        });
        menuSave.add(menuItemOpen);

        MainMenuBar.add(menuSave);

        menuItemHelp.setText("Help");
        menuItemHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHelpActionPerformed(evt);
            }
        });
        menuItemHelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuItemHelpKeyPressed(evt);
            }
        });

        menuHelp.setText("Documentation");
        menuHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHelpActionPerformed(evt);
            }
        });
        menuItemHelp.add(menuHelp);

        MainMenuBar.add(menuItemHelp);

        setJMenuBar(MainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())
                    .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUserDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserDebug, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        
      
            //Check that the mouse has moved
            // check is is currently in the drawing phase i.e isInDrawingPhase
            // if in drawing phase, this click will complete the drawing.
            // if not in drawing phase set the startPoint to the mouse position and set the isInDrawingPhase = true.
            
            if(!isInNewDrawingPhase)
            {
                
               
                pointStart = evt.getPoint();
                isInNewDrawingPhase = true;
              
                
                canvas.setCursor(new Cursor(12));
                return;
            }
            if (isInNewDrawingPhase) {
                
                // this mouse position will be the endPos
                //defensive programming. Ensure that a pointStart does exsits.
                if (pointStart != null) {
                    pointEnd = evt.getPoint();  // Set the pointEnd pos to the current mouse pos.
                    //check that the mouse has moved
                    if (!pointStart.equals(pointEnd)) {
                        newPoint = dM.getDrawPosition(pointStart, pointEnd);
                        g.setColor(colorSelected);
                        dM.draw(pointStart.x, pointStart.y, newPoint.x, newPoint.y, currentBrushFill,currentBrushType, colorSelected);              
                        dM.createEntry(pointStart.x, pointStart.y, newPoint.x, newPoint.y, currentBrushFill,currentBrushType, colorSelected);
                      
                        
                    } else {
                        dM.draw(pointEnd.x, pointEnd.y, currentSizeX, currentSizeY, currentBrushFill,currentBrushType, colorSelected);
                        dM.createEntry(pointEnd.x, pointEnd.y, currentSizeX, currentSizeY, currentBrushFill,currentBrushType, colorSelected);
                       
                    }

                    // Changing the visual cursuror to indicate the action has been performed.
                    isInNewDrawingPhase = false;
                    // Setting the cursor to the default user cursor.
                    canvas.setCursor(Cursor.getDefaultCursor());
                    
                    if (pointStart == null)
                    {
                        JOptionPane.showMessageDialog(null, "PointStart is null, CanvasMouseClicked.");
                    }
               

            }


        }

       
    }//GEN-LAST:event_canvasMouseClicked

    private void menuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSaveActionPerformed
       
        // FileChooser to chose the location to save the file.
        JFileChooser fileCh = new JFileChooser();
        int response = fileCh.showSaveDialog(null);
        // Get the selected file.
        File file = fileCh.getSelectedFile();
        
        // Check that the AbsoluteFile is not null  to ensure defensive programming to prevent crashes.
        if(file.getAbsoluteFile() != null)
        {
            // Get the path of the file to pass to the SaveToFile method.
            String fileName = file.getAbsolutePath();
            
        if(response == JFileChooser.APPROVE_OPTION)
        {
            dM.SaveToFile(fileName);
        }
        // If the user did not save the file  but canceled the process.
        else if (response != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("FileChooser closed.");
            
                  
        }
        
        }
        
       
       
        
    }//GEN-LAST:event_menuItemSaveActionPerformed

    private void menuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenActionPerformed
      
        // THis will cause a bug where if you cancele the dialog it will repaint the canvas.
        // I am aware of this issue but due to time this will remain.
        
        // Clear the canvas.
        canvas.repaint();
        // set the arrayCount = 0
        dM.arrayCount = 0;
        // Create a new FileChooser object
        JFileChooser fileCh = new JFileChooser();
        // Store the users response to a integer.
        int response = fileCh.showOpenDialog(null);

        // If the user completed the open process
        if (response == JFileChooser.APPROVE_OPTION) {
            try {
        
                // Get the file that was selected via the dialog.
        File file = fileCh.getSelectedFile();
        // Get the path to the file.
        String fileName = file.getAbsolutePath();
                // Call the openFile function created in the DrawManager class.
                dM.OpenFile(fileName);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        } else if (response != JFileChooser.APPROVE_OPTION) {
            System.out.println("FileChooser closed.");

        }
    }//GEN-LAST:event_menuItemOpenActionPerformed

    private void menuItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewActionPerformed
        // Create a new canvas.
        PrintWriter pw = null;
        try {
            // Clear the VisMindTemp.txt file.
            pw = new PrintWriter(new File("VisMindTemp.txt"));
            pw.flush();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        
       
        
        // Repaint the canvas
        canvas.repaint();
    }//GEN-LAST:event_menuItemNewActionPerformed

    private void canvasMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseDragged
       
        pointStart = pointEnd;
        // Get the current position of the mouse.
        pointEnd = evt.getPoint();
        
        // Draw and create an entry of the new drawing.
        dM.draw(pointEnd.x, pointEnd.y, currentSizeX, currentSizeY, currentBrushFill,currentBrushType, colorSelected);
        dM.createEntry(pointEnd.x, pointEnd.y, currentSizeX, currentSizeY, currentBrushFill,currentBrushType, colorSelected);
        

       
    }//GEN-LAST:event_canvasMouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void canvasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMousePressed
        //pointStart = evt.getPoint(); 
    }//GEN-LAST:event_canvasMousePressed

    private void canvasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseReleased
//        
//       
//        pointEnd = evt.getPoint();
//        
////        //Check if the mouse has moved
////            if (pointStart.equals(pointEnd)) {
////                dM.draw(pointStart.x, pointStart.y, currentSizeX, currentSizeY, currentBrushFill, colorSelected);
////               
////            }
//
//             if (!pointStart.equals(pointEnd)) {
//                //The mouse has moved
//                newPoint = dM.getDrawPosition(pointStart, pointEnd);
//                dM.draw(pointStart.x, pointStart.y, newPoint.x, newPoint.y, currentBrushFill, colorSelected);
// 
//                System.out.println("CanvasMouseReleased : moved - " + evt.getX() + "#" + evt.getY() + "#" + newPoint.x + "#" + newPoint.y + "#" + currentBrushFill + "#" + colorSelected.toString());
//            }
//
//        try {
//
////            //Check if the mouse has moved
////            if (pointStart.equals(pointEnd)) {
////                //dM.draw(pointStart.x, pointStart.y, currentSizeX, currentSizeY, currentBrushFill, colorSelected);
////                dM.createEntry(pointStart.x, pointStart.y, currentSizeX, currentSizeY, currentBrushFill, colorSelected);
////                System.out.println("CanvasMouseReleased : not moved - " + evt.getX() + "#" + evt.getY() + "#" + currentSizeX + "#" + currentSizeY + "#" + currentBrushFill + "#" + colorSelected.toString());
////            }
//
//             if (!pointStart.equals(pointEnd)) {
//                //The mouse has moved
//                //newPoint = dM.getDrawPosition(pointStart, pointEnd);
//                //dM.draw(pointStart.x, pointStart.y, newPoint.x, newPoint.y, currentBrushFill, colorSelected);
//                dM.createEntry(pointStart.x, pointStart.y, newPoint.x, newPoint.y, currentBrushFill, colorSelected);
//                System.out.println("CanvasMouseReleased : moved - " + evt.getX() + "#" + evt.getY() + "#" + newPoint.x + "#" + newPoint.y + "#" + currentBrushFill + "#" + colorSelected.toString());
//            }
//
//       
//        
//       
//           
//           
//       } catch (FileNotFoundException ex) {
//           Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
//       }
//         
//        pointStart = null;
//        pointEnd = null;
        
    }//GEN-LAST:event_canvasMouseReleased

    private void canvasMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseMoved
       // Draw canvas Cursur
        
        
        
        //Check if user has pressed/started to draw
        if(pointStart != null){
        int currentMovingX = evt.getX() - pointStart.x;
        int currentMovingY = evt.getY() - pointStart.y;
                 
        //canvas.repaint();
         //g.drawRect(pointStart.x, pointStart.y, currentMovingX, currentMovingY);
        }

    }//GEN-LAST:event_canvasMouseMoved

    private void canvasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseEntered
       
    }//GEN-LAST:event_canvasMouseEntered

    private void menuItemHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHelpActionPerformed
       
    }//GEN-LAST:event_menuItemHelpActionPerformed

    private void menuItemHelpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuItemHelpKeyPressed
       
    }//GEN-LAST:event_menuItemHelpKeyPressed

    private void menuHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHelpActionPerformed
        // Create a new HelpForm object.
        HelpForm helpFM = new HelpForm();
        // Display the UI to the screen.
        helpFM.setVisible(true);
        System.out.println("Help called.");  
    }//GEN-LAST:event_menuHelpActionPerformed

    private void btnGreyFill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGreyFill1ActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.
        currentBrushFill = "grey";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnGreyFill1ActionPerformed

    private void btnLightBlueFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLightBlueFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "lightBlue";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnLightBlueFillActionPerformed

    private void btnBrownFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrownFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "brown";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnBrownFillActionPerformed

    private void btnDarkGreenFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarkGreenFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill= "darkGreen";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnDarkGreenFillActionPerformed

    private void btnYellowFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYellowFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "yellow";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnYellowFillActionPerformed

    private void btnLightGreenFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLightGreenFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "lightGreen";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
        
    }//GEN-LAST:event_btnLightGreenFillActionPerformed

    private void btnOrangeFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrangeFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "orange";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnOrangeFillActionPerformed

    private void btnBlueSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlueSquareActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "blue";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnBlueSquareActionPerformed

    private void btnRedSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedSquareActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "red";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnRedSquareActionPerformed

    private void btnBlackFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBlackFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.currentBrushFill = "black";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnBlackFillActionPerformed

    private void btnWhiteFillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWhiteFillActionPerformed
        //Set the new brushFill and set the lastBrushFill equal to the currentBrushFill 
        // Set the check box Use color to false.
        currentBrushFill = "white";
        lastBrushFill = currentBrushFill;
        cbUseColor.setSelected(false);
    }//GEN-LAST:event_btnWhiteFillActionPerformed

    private void cbUseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseColorActionPerformed

    }//GEN-LAST:event_cbUseColorActionPerformed

    private void cbUseColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbUseColorMouseClicked
       
        // Toggle the check box Use Color.
        if(cbUseColor.isSelected())
        {
            currentBrushFill = "Color";
        }

        else if(!cbUseColor.isSelected())
        {
            currentBrushFill = lastBrushFill;
        }
    }//GEN-LAST:event_cbUseColorMouseClicked

    private void toolSelectColorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolSelectColorMouseEntered

    }//GEN-LAST:event_toolSelectColorMouseEntered

    private void toolSelectColorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolSelectColorMouseExited

    }//GEN-LAST:event_toolSelectColorMouseExited

    private void toolSelectColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toolSelectColorMouseClicked
        // Show a Color picker
        JColorChooser colorCh = new JColorChooser();

        colorSelected  = colorCh.showDialog(null,"Select your color",colorSelected);
        
        // Defend against potential errors
        if(colorSelected==null)
        {

            dM.currentColor = colorSelected;
        }

        else if(colorSelected != null)
        {
            dM.currentColor = colorSelected;

        }
        // Update the fields
        g.setColor(colorSelected);
        dM.currentColor = colorSelected;
        dM.g.setColor(colorSelected);
        toolSelectColor.setBackground(dM.g.getColor());
    }//GEN-LAST:event_toolSelectColorMouseClicked

    private void txtBrushSizeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrushSizeKeyPressed

    }//GEN-LAST:event_txtBrushSizeKeyPressed

    private void txtBrushSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrushSizeActionPerformed


        // Check that the textfield is no null to avoid errors.
        if(txtBrushSize.getText() != null)
        {
            int number = 0;
            try{
                number =  Integer.parseInt(txtBrushSize.getText());
            
                lbUserDebug.setText("Brush SizeX: "+currentSizeX);
            }
            catch(NumberFormatException ex)
            {
                
                txtBrushSize.setText("");
                System.out.println("Error" + ex);
            }
            currentSizeX = number;
        }
    }//GEN-LAST:event_txtBrushSizeActionPerformed

    private void txtBrushSizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBrushSizeMouseExited
        
        // This can cause errors as the textfield doesnt have validation to prevent the use of characters that are not numbers
        
        // Make sure that the textfield is not empty/null
        if(txtBrushSize.getText() != null)
        {
            // Convert the String to an integer.
            currentSizeX = Integer.parseInt(txtBrushSize.getText());
            // Set the label in the debug area to the selected number.
            lbUserDebug.setText("Brush SizeX: "+currentSizeX);
            // Convert the String to an integer.
            currentSizeY = Integer.parseInt(txtBrushSize.getText());
        }
        // If the textfield is empty/null
        else if(txtBrushSize.getText() == null)
        {
            // Set the label to the slider's value
            txtBrushSize.setText(String.valueOf(sliderBrushSize.getValue()));
            //Convert the String to a number
            currentSizeX = Integer.parseInt(txtBrushSize.getText());
            currentSizeY = Integer.parseInt(txtBrushSize.getText());
            // Update the label
            lbUserDebug.setText("Brush SizeX: "+currentSizeX);
        }
    }//GEN-LAST:event_txtBrushSizeMouseExited

    private void btnBrushTypeSquareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrushTypeSquareActionPerformed
        currentBrushType = "Square";
    }//GEN-LAST:event_btnBrushTypeSquareActionPerformed

    private void btnBrushTypeOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrushTypeOvalActionPerformed
        currentBrushType = "Oval";
    }//GEN-LAST:event_btnBrushTypeOvalActionPerformed

    private void sliderBrushSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrushSizeStateChanged
        // If the slider value has changed
        txtBrushSize.setText(String.valueOf(sliderBrushSize.getValue()));
        // Update the variables.
        currentSizeX = sliderBrushSize.getValue();
        currentSizeY = sliderBrushSize.getValue();
        lbUserDebug.setText("Brush Size : "+currentSizeX);
    }//GEN-LAST:event_sliderBrushSizeStateChanged

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MainMenuBar;
    private javax.swing.JButton btnBlackFill;
    private javax.swing.JButton btnBlueSquare;
    private javax.swing.JButton btnBrownFill;
    private javax.swing.JButton btnBrushTypeOval;
    private javax.swing.JButton btnBrushTypeSquare;
    private javax.swing.JButton btnDarkGreenFill;
    private javax.swing.JButton btnGreyFill1;
    private javax.swing.JButton btnLightBlueFill;
    private javax.swing.JButton btnLightGreenFill;
    private javax.swing.JButton btnOrangeFill;
    private javax.swing.JButton btnRedSquare;
    private javax.swing.JButton btnWhiteFill;
    private javax.swing.JButton btnYellowFill;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel canvas;
    private javax.swing.JCheckBox cbUseColor;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbUserDebug;
    private javax.swing.JMenuItem menuHelp;
    private javax.swing.JMenu menuItemHelp;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemSave;
    private javax.swing.JMenu menuSave;
    private javax.swing.JSlider sliderBrushSize;
    private javax.swing.JPanel toolSelectColor;
    private javax.swing.JTextField txtBrushSize;
    // End of variables declaration//GEN-END:variables
}
