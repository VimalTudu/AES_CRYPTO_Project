package aesexample;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyFrame extends JFrame implements ActionListener {

    JMenu fileMenu, jcryptMenu, infoMenu;
    JMenuItem openFileItem, saveItem, exitItem;

    public MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AES - (Java Cryptography)");
        this.setSize(800, 600);

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

        // Menu - Items for fileMenu
        openFileItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        // actionListeners
        openFileItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

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
        }

        if (action.getSource() == exitItem) {
            System.out.println("Exit from Window");
            System.exit(0);
        }

        if (action.getSource() == saveItem) {
            System.out.println("Save Item");
        }
    }
}
