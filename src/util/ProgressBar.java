package util;

import java.awt.BorderLayout;
import java.awt.Image;

import java.awt.Color;

import java.awt.Container;

import java.awt.Dimension;

import java.awt.event.ActionEvent;

 

import java.awt.event.ActionListener;



 

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;


import javax.swing.JProgressBar;

import javax.swing.Timer;


import javax.swing.event.ChangeEvent;

import javax.swing.event.ChangeListener;

 

public class ProgressBar implements ActionListener, ChangeListener {

    JFrame frame = null;
    
    JFrame loginFrame = null;

    JProgressBar progressbar;

    JLabel label;

    Timer timer;

    JButton b;

 

    public ProgressBar(JFrame loginFrame) {

       frame = new JFrame("通讯录管理系统");

       frame.setBounds(100, 100, 400, 130);

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       frame.setResizable(false);

       Container contentPanel = frame.getContentPane();

       label = new JLabel("  ", JLabel.CENTER);

       progressbar = new JProgressBar();

       progressbar.setOrientation(JProgressBar.HORIZONTAL);

       progressbar.setMinimum(0);

       progressbar.setMaximum(100);

       progressbar.setValue(0);

       progressbar.setStringPainted(true);

       progressbar.addChangeListener(this);

       progressbar.setPreferredSize(new Dimension(300, 20));

       progressbar.setBorderPainted(true);

       progressbar.setBackground(Color.pink);
       

       timer = new Timer(100, this);


       contentPanel.add(label, BorderLayout.CENTER);

       contentPanel.add(progressbar, BorderLayout.SOUTH);

       frame.pack();

       frame.setVisible(true);
       
       Image img = new ImageIcon("image/R1.png").getImage();
       
       frame.setIconImage(img);
       
       this.loginFrame = loginFrame;
       
       frame.setLocationRelativeTo(null);
       
       timer.start();
    }

 

    public void actionPerformed(ActionEvent e) {
    	
       if (e.getSource() == timer) {

           int value = progressbar.getValue();

           if (value < 100)

              progressbar.setValue(value+=(10*Math.random()));

           else {

              timer.stop();

              frame.dispose();

           }

       }
    }

 

    public void stateChanged(ChangeEvent e1) {

       int value = progressbar.getValue();

       if (e1.getSource() == progressbar) {

           label.setText("目前已完成进度：" + Integer.toString(value) + "%");

           label.setForeground(Color.blue);
           if(value >= 100) {
        	   try{
        		   Thread.sleep(1000);
        	   }catch (Exception e) {
				// TODO: handle exception
        		   e.printStackTrace();
			}
        	   
        	   this.loginFrame.setVisible(true);
           }
              
       }
    }

}