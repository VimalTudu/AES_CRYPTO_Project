package aesexample;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.imageio.ImageReader;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame implements ActionListener {

    String backgroundImagePath = "";
    String openFileIconPath = "";
    String saveFileIconPath = "";
    String exitFileIconPath = "";

    final int windowHeight = 600;
    final int windowWidth = 800;

    JMenu fileMenu, jcryptMenu, infoMenu;
    JMenuItem openFileItem, saveItem, exitItem;
    
    ImageIcon openFileIcon, saveItemIcon, exitIcon;
    ImageIcon backgroundImage;

    JLabel background;

    public MyFrame() {
        
        getProjectFilePaths();  // get the path for the files

        backgroundImage = new ImageIcon(backgroundImagePath);

        background = new JLabel("", backgroundImage, JLabel.CENTER);
        background.setBounds(0, 0, windowWidth, windowHeight);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AES - (Java Cryptography)");
        this.setSize(windowWidth, windowHeight);
        
        this.add(background);

        JMenuBar menuBar = createMenuBar();
        this.setJMenuBar(menuBar);
        
        this.setVisible(true);
    }

    // MenuBar
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        jcryptMenu = new JMenu("JCrypt");
        infoMenu = new JMenu("Info");

        // Menu-Items for fileMenu
        openFileItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        // Icons for File-Menu-Itenms
        openFileIcon = new ImageIcon(openFileIconPath);
        saveItemIcon = new ImageIcon(saveFileIconPath);
        exitIcon = new ImageIcon(exitFileIconPath);

        // actionListeners
        openFileItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        // set icons for file Menu
        openFileItem.setIcon(openFileIcon);
        saveItem.setIcon(saveItemIcon);
        exitItem.setIcon(exitIcon);

        // adinng shortcuts for the menu in menu-bar
        fileMenu.setMnemonic(KeyEvent.VK_F);   // Alt + F for File-menu
        jcryptMenu.setMnemonic(KeyEvent.VK_J); // Alt + J for Jcrypt-Menu
        infoMenu.setMnemonic(KeyEvent.VK_I);   // Alt + I for Info

        // adding shortcuts for the menu-items 
        openFileItem.setMnemonic(KeyEvent.VK_O); // O for open File
        saveItem.setMnemonic(KeyEvent.VK_S);     // S for save
        saveItem.setMnemonic(KeyEvent.VK_E);     // E for exit

        // add menu-items to file Menu
        fileMenu.add(openFileItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // add menu to Menu Bar
        menuBar.add(fileMenu);
        menuBar.add(jcryptMenu);
        menuBar.add(infoMenu);

        return menuBar;
    }


    // ActionListener - overriding the abstract method
    @Override
    public void actionPerformed(ActionEvent action) {
        
        if (action.getSource() == openFileItem) {
            System.out.println("Open a file");
            
            JFileChooser fileChooser = new JFileChooser();
            
            int response = fileChooser.showOpenDialog(null); // select file to open
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }

        if (action.getSource() == exitItem) {
            System.out.println("Exit from Window");
            System.exit(0);
        }

        if (action.getSource() == saveItem) {
            System.out.println("Save Item");

            JFileChooser fileChooser = new JFileChooser(); 

            // fileChooser.setCurrentDirectory(new File("C:\\Users\\Sapan\\Desktop"));

            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }


    // get project file paths
    void getProjectFilePaths() {
        Path currenRelativePath = Paths.get("");
        String path = currenRelativePath.toAbsolutePath().toString();

        backgroundImagePath = path + "/icons/background.jpg";
        openFileIconPath = path + "/icons/open.png";
        saveFileIconPath = path + "/icons/save.png";
        exitFileIconPath = path + "/icons/exit.png";
    }
}
