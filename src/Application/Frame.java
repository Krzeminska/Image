package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Frame extends JFrame
{

    private final String appView ="com.sun.java.swing.plaf.windows.WindowsLookAndFeel";         
    private final String appTitle = "Image converter  ";
    private final ImageHandler imageHandler;
    private ImageObject imageData;
    private int CONTRAST = 0, BRIGHTNESS = 0;
    
    
    public Frame() 
    {        
        initComponents();
        
        try {
            UIManager.setLookAndFeel(appView);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("/Images/angry-bird-icon.png"));
        this.setIconImage(iconImage.getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH));
        
        tabbedPane.setVisible(false);
        imageHandler = new ImageHandler();
        this.setTitle(appTitle);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Image = new javax.swing.JInternalFrame();
        exit = new javax.swing.JButton();
        image = new javax.swing.JScrollPane();
        image_photo = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        pane_photo = new javax.swing.JScrollPane();
        panel_photo = new javax.swing.JPanel();
        label_photo = new javax.swing.JLabel();
        panel_left = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        panel_properties = new javax.swing.JPanel();
        prop_brightButton = new javax.swing.JButton();
        prop_brightSlider = new javax.swing.JSlider();
        prop_desc1 = new javax.swing.JLabel();
        prop_bps = new javax.swing.JLabel();
        prop_dimWidth = new javax.swing.JTextField();
        tool_x = new javax.swing.JLabel();
        prop_dimHeight = new javax.swing.JTextField();
        prop_changeButton = new javax.swing.JButton();
        prop_desc3 = new javax.swing.JLabel();
        prop_pane = new javax.swing.JScrollPane();
        prop_filePath = new javax.swing.JTextArea();
        prop_contChangeButton = new javax.swing.JToggleButton();
        prop_contrastSlider = new javax.swing.JSlider();
        prop_desc4 = new javax.swing.JLabel();
        prop_desc5 = new javax.swing.JLabel();
        panel_more = new javax.swing.JPanel();
        background = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        file_open = new javax.swing.JMenuItem();
        file_save = new javax.swing.JMenuItem();
        file_clear = new javax.swing.JMenuItem();
        file_exit = new javax.swing.JMenuItem();
        menu_edit = new javax.swing.JMenu();
        menu_edit_reverseChanges = new javax.swing.JMenuItem();

        Image.setVisible(true);

        exit.setText("Close image");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        Image.getContentPane().add(exit, java.awt.BorderLayout.PAGE_END);

        image_photo.setLayout(new java.awt.GridLayout());
        image.setViewportView(image_photo);

        Image.getContentPane().add(image, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Konwerter obrazów");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(90, 90, 90));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_photo.setLayout(new java.awt.GridLayout(1, 0));

        label_photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_photo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_photo.setOpaque(true);
        panel_photo.add(label_photo);

        pane_photo.setViewportView(panel_photo);

        panel_main.add(pane_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 680));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 900, 680));

        panel_left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setOpaque(true);
        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabbedPaneMousePressed(evt);
            }
        });

        panel_properties.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prop_brightButton.setText("Change brightness");
        prop_brightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prop_brightButtonActionPerformed(evt);
            }
        });
        panel_properties.add(prop_brightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        prop_brightSlider.setMajorTickSpacing(100);
        prop_brightSlider.setMaximum(255);
        prop_brightSlider.setMinimum(-255);
        prop_brightSlider.setMinorTickSpacing(50);
        prop_brightSlider.setPaintTicks(true);
        prop_brightSlider.setToolTipText("");
        prop_brightSlider.setValue(0);
        panel_properties.add(prop_brightSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, -1));

        prop_desc1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prop_desc1.setText("Change brightness:");
        panel_properties.add(prop_desc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 150, -1));

        prop_bps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prop_bps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prop_bps.setText("Bits per pixel: ");
        panel_properties.add(prop_bps, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, 40));

        prop_dimWidth.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prop_dimWidth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prop_dimWidthKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prop_dimWidthKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prop_dimWidthKeyTyped(evt);
            }
        });
        panel_properties.add(prop_dimWidth, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 60, 30));

        tool_x.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tool_x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tool_x.setText("X");
        panel_properties.add(tool_x, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 20, 30));

        prop_dimHeight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prop_dimHeight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prop_dimHeightKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prop_dimHeightKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prop_dimHeightKeyTyped(evt);
            }
        });
        panel_properties.add(prop_dimHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 60, 30));

        prop_changeButton.setText("Change");
        prop_changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prop_changeButtonActionPerformed(evt);
            }
        });
        panel_properties.add(prop_changeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 90, 30));

        prop_desc3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        prop_desc3.setText("File:");
        panel_properties.add(prop_desc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, 40));

        prop_filePath.setEditable(false);
        prop_filePath.setColumns(20);
        prop_filePath.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        prop_filePath.setLineWrap(true);
        prop_filePath.setRows(5);
        prop_filePath.setWrapStyleWord(true);
        prop_pane.setViewportView(prop_filePath);

        panel_properties.add(prop_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 90));

        prop_contChangeButton.setText("Change contrast");
        prop_contChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prop_contChangeButtonActionPerformed(evt);
            }
        });
        panel_properties.add(prop_contChangeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 140, -1));

        prop_contrastSlider.setMajorTickSpacing(100);
        prop_contrastSlider.setMaximum(255);
        prop_contrastSlider.setMinimum(-255);
        prop_contrastSlider.setMinorTickSpacing(50);
        prop_contrastSlider.setPaintTicks(true);
        prop_contrastSlider.setToolTipText("");
        prop_contrastSlider.setValue(0);
        panel_properties.add(prop_contrastSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 190, -1));

        prop_desc4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prop_desc4.setText("Change contrast");
        panel_properties.add(prop_desc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 160, -1));

        prop_desc5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        prop_desc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prop_desc5.setText("Change dimensions:");
        panel_properties.add(prop_desc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, 40));

        tabbedPane.addTab("Exercise 1.", panel_properties);

        panel_more.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        tabbedPane.addTab("Exercise 2.", panel_more);

        panel_left.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 680));

        getContentPane().add(panel_left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 680));

        background.setOpaque(true);
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 680));

        menu_file.setText("File");

        file_open.setText("Open");
        file_open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_openActionPerformed(evt);
            }
        });
        menu_file.add(file_open);

        file_save.setText("Save as");
        file_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_saveActionPerformed(evt);
            }
        });
        menu_file.add(file_save);

        file_clear.setText("Clear workspace");
        file_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_clearActionPerformed(evt);
            }
        });
        menu_file.add(file_clear);

        file_exit.setText("Exit");
        file_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_exitActionPerformed(evt);
            }
        });
        menu_file.add(file_exit);

        menuBar.add(menu_file);

        menu_edit.setText("Edit");

        menu_edit_reverseChanges.setText("Reverse all changes");
        menu_edit_reverseChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_edit_reverseChangesActionPerformed(evt);
            }
        });
        menu_edit.add(menu_edit_reverseChanges);

        menuBar.add(menu_edit);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_file_exitActionPerformed

    private void file_openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_openActionPerformed
        ImageObject temp = imageData;
        imageData = imageHandler.readImage();
       if(imageData == null)
       {
           imageData = temp;
           return;
       }
       CONTRAST = 0;
       BRIGHTNESS = 0;
       prop_brightSlider.setValue(0);
       tabbedPane.setVisible(true);
       label_photo.setIcon(imageData.getIcon());
       prop_dimWidth.setText(imageData.getWidth() + "");
       prop_dimHeight.setText(imageData.getHeight() + "");
       prop_filePath.setText(imageData.getPath());
       prop_bps.setText("Bits per pixel: " + imageData.getBitsPerPixel());
       label_photo.setSize(imageData.getWidth(), imageData.getHeight());
       this.setTitle(appTitle + "|  " + imageData.getName());
       
       image_photo.setSize(imageData.getWidth(), imageData.getHeight());
       Dialog dlg = new Dialog(this, appTitle + "|  " + imageData.getName(), "message", Image, exit);
       
       
       
    }//GEN-LAST:event_file_openActionPerformed

    private void file_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_clearActionPerformed
        reset();
    }//GEN-LAST:event_file_clearActionPerformed

    private void file_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_saveActionPerformed
        if(imageData == null)
        {
            JOptionPane.showMessageDialog(this, "Nothing to save");
            return;
        }
        Image toSave = ((ImageIcon)label_photo.getIcon()).getImage();        
        imageHandler.saveImage(toSave);
        
    }//GEN-LAST:event_file_saveActionPerformed

    private void prop_brightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prop_brightButtonActionPerformed
        BRIGHTNESS = prop_brightSlider.getValue();
        Image toDisplay = imageData.getImage();
        toDisplay = ImageOperation.changeBritghtness(imageData.getOriginalImageScaled(), BRIGHTNESS);
        toDisplay = ImageOperation.contrastChange(toDisplay, CONTRAST);
        imageData.setImage(toDisplay);
        label_photo.setIcon(new ImageIcon(toDisplay));
    }//GEN-LAST:event_prop_brightButtonActionPerformed

    private void prop_dimWidthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimWidthKeyPressed
       if(evt.getKeyChar() == KeyEvent.VK_ENTER)
       {
           prop_changeButton.doClick();
       }
    }//GEN-LAST:event_prop_dimWidthKeyPressed

    private void prop_dimHeightKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimHeightKeyPressed
       if(evt.getKeyChar() == KeyEvent.VK_ENTER)
       {
           prop_changeButton.doClick();
       }
    }//GEN-LAST:event_prop_dimHeightKeyPressed

    private void prop_dimWidthKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimWidthKeyReleased
      
            if(prop_dimWidth.getText().equals(""))
            {
                prop_dimHeight.setText("");
                return;
            }
            
           double diff = (double)imageData.getWidth()/imageData.getHeight();
           int currentWidth = Integer.valueOf(prop_dimWidth.getText());
           prop_dimHeight.setText(Integer.toString((int)((double)currentWidth/diff )));
        
    }//GEN-LAST:event_prop_dimWidthKeyReleased

    private void prop_dimHeightKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimHeightKeyReleased
        
            if(prop_dimHeight.getText().equals(""))
            {
                prop_dimWidth.setText("");
                return;
            }
            
           double diff = (double)imageData.getHeight()/imageData.getWidth();
           int currentHeight = Integer.valueOf(prop_dimHeight.getText());
           prop_dimWidth.setText(Integer.toString((int)((double)currentHeight/diff )));
        
    }//GEN-LAST:event_prop_dimHeightKeyReleased

    private void prop_dimWidthKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimWidthKeyTyped
        if(!ifDigit(evt.getKeyChar()))
             evt.consume();
        if(prop_dimWidth.getText().length()>3)
            evt.consume();
        if(prop_dimWidth.getText().length() == 0 && evt.getKeyChar() == '0')
            evt.consume();
    }//GEN-LAST:event_prop_dimWidthKeyTyped

    private void prop_dimHeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prop_dimHeightKeyTyped
        if(!ifDigit(evt.getKeyChar()))
            evt.consume();
        if(prop_dimHeight.getText().length()>3)
            evt.consume();
        if(prop_dimHeight.getText().length() == 0 && evt.getKeyChar() == '0')
            evt.consume();
    }//GEN-LAST:event_prop_dimHeightKeyTyped

    private void prop_changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prop_changeButtonActionPerformed
        if(prop_dimWidth.getText().length() < 1 || prop_dimHeight.getText().length() < 1)
        {
            return;
        }
        if(Integer.valueOf(prop_dimWidth.getText()) == imageData.getWidth() &&  Integer.valueOf(prop_dimHeight.getText()) == imageData.getHeight())
        {
             JOptionPane.showMessageDialog(panel_main, "Nothing to change");
             return;
        }        
        int imageWidth = Integer.valueOf(prop_dimWidth.getText());
        int imageHeight = Integer.valueOf(prop_dimHeight.getText()); 
        imageData.scaleImage(imageWidth, imageHeight);        
        label_photo.setIcon(imageData.getIcon());
        label_photo.setSize(imageData.getWidth(), imageData.getHeight());
    }//GEN-LAST:event_prop_changeButtonActionPerformed

    private void menu_edit_reverseChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_edit_reverseChangesActionPerformed
        if(imageData != null)
        {
            imageData.reverseAllChanges();
            label_photo.setIcon(imageData.getIcon());
            prop_dimWidth.setText(imageData.getWidth() + "");
            prop_dimHeight.setText(imageData.getHeight() + "");
        }
    }//GEN-LAST:event_menu_edit_reverseChangesActionPerformed

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        label_photo.setIcon(imageData.getIcon());
    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void prop_contChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prop_contChangeButtonActionPerformed
        CONTRAST = prop_contrastSlider.getValue();
        Image toDisplay = imageData.getImage();
        toDisplay = ImageOperation.contrastChange(imageData.getOriginalImageScaled(), CONTRAST);
        toDisplay = ImageOperation.changeBritghtness(toDisplay, BRIGHTNESS);
        imageData.setImage(toDisplay);
        label_photo.setIcon(new ImageIcon(toDisplay));
    }//GEN-LAST:event_prop_contChangeButtonActionPerformed

    private void tabbedPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMousePressed
        label_photo.setIcon(imageData.getIcon());
    }//GEN-LAST:event_tabbedPaneMousePressed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    public static void main(String args[]) 
    {
        new Frame().setVisible(true);
    }
    
    public void reset()
    {
        CONTRAST = 0;
        BRIGHTNESS = 0;
        imageData = null;
        tabbedPane.setVisible(false);
        label_photo.setIcon(null);
        prop_filePath.setText("");
        this.setTitle(appTitle);
        prop_brightSlider.setValue(0);
    }
    
    private boolean ifDigit(char zn)
    {
        if(zn>='0' && zn <='9')
            return true;
      
        return false;
    }
    
    public class Dialog extends JDialog implements ActionListener {
        public Dialog(JFrame parent, String title, String message, JInternalFrame f, JButton b) {
            super(parent, title, true);
            if (parent != null) {
                Dimension parentSize = parent.getSize(); 
                Point p = parent.getLocation(); 
                setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
            }
            JPanel messagePane = new JPanel();
            getContentPane().add(messagePane);
            messagePane.add(f);
            getContentPane().add(b, BorderLayout.SOUTH);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            pack(); 
            setVisible(true);
        }
        public void actionPerformed(ActionEvent e) {
            setVisible(false); 
            dispose(); 
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Image;
    private javax.swing.JLabel background;
    private javax.swing.JButton exit;
    private javax.swing.JMenuItem file_clear;
    private javax.swing.JMenuItem file_exit;
    private javax.swing.JMenuItem file_open;
    private javax.swing.JMenuItem file_save;
    private javax.swing.JScrollPane image;
    private javax.swing.JPanel image_photo;
    private javax.swing.JLabel label_photo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menu_edit;
    private javax.swing.JMenuItem menu_edit_reverseChanges;
    private javax.swing.JMenu menu_file;
    private javax.swing.JScrollPane pane_photo;
    private javax.swing.JPanel panel_left;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_more;
    private javax.swing.JPanel panel_photo;
    private javax.swing.JPanel panel_properties;
    private javax.swing.JLabel prop_bps;
    private javax.swing.JButton prop_brightButton;
    private javax.swing.JSlider prop_brightSlider;
    private javax.swing.JButton prop_changeButton;
    private javax.swing.JToggleButton prop_contChangeButton;
    private javax.swing.JSlider prop_contrastSlider;
    private javax.swing.JLabel prop_desc1;
    private javax.swing.JLabel prop_desc3;
    private javax.swing.JLabel prop_desc4;
    private javax.swing.JLabel prop_desc5;
    private javax.swing.JTextField prop_dimHeight;
    private javax.swing.JTextField prop_dimWidth;
    private javax.swing.JTextArea prop_filePath;
    private javax.swing.JScrollPane prop_pane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel tool_x;
    // End of variables declaration//GEN-END:variables
}
