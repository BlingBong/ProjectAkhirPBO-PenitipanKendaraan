package View;

import Controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class StatusView extends JFrame implements ActionListener {
    private JPanel panelStatus;
    private JButton btnKembali;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton btn17;
    private JButton btn19;
    private JButton btn18;
    private JButton btn20;
    private ButtonGroup btnGroup;

    public StatusView(String[] cek){
        setTitle("Status Penitipan");
        btnKembali.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);
        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);
        btn17.addActionListener(this);
        btn18.addActionListener(this);
        btn19.addActionListener(this);
        btn20.addActionListener(this);

        btnGroup = new ButtonGroup();
        btnGroup.add(btn1);
        btnGroup.add(btn2);
        btnGroup.add(btn3);
        btnGroup.add(btn4);
        btnGroup.add(btn5);
        btnGroup.add(btn6);
        btnGroup.add(btn7);
        btnGroup.add(btn8);
        btnGroup.add(btn9);
        btnGroup.add(btn10);
        btnGroup.add(btn11);
        btnGroup.add(btn12);
        btnGroup.add(btn13);
        btnGroup.add(btn14);
        btnGroup.add(btn15);
        btnGroup.add(btn16);
        btnGroup.add(btn17);
        btnGroup.add(btn18);
        btnGroup.add(btn19);
        btnGroup.add(btn20);

        cekButton(btnGroup, cek);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelStatus);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if(actionEvent.getSource() == btnKembali){
            MainController homeController = new MainController();
            homeController.homeLaunch();
            dispose();
        }
        else{
            String idBtn = actionEvent.getActionCommand();
            MainController gsdController = new MainController();
            gsdController.getStatData(idBtn);
            dispose();
        }
    }

    public void cekButton(ButtonGroup buttonGroup, String[] tempat) {
        for (Enumeration<AbstractButton> bg = buttonGroup.getElements(); bg.hasMoreElements();) {
            AbstractButton button = bg.nextElement();

            button.setFocusPainted(false);
            button.setEnabled(false);
            button.setBackground(Color.green);
            for (String s : tempat) {     //int i = 0; i < tempat.length; i++
                if (button.getText().equals(s)) {
                    button.setEnabled(true);
                    button.setBackground(Color.red);
                }
            }
        }
    }
}
