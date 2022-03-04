/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
// sender 

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author hoda , hanan, fatema
 */
public class Agent1 extends Agent implements ActionListener {

    JPanel panel = new JPanel();
    JTextArea t1 = new JTextArea();
    JLabel l = new JLabel("Type A message here : ");
    JTextArea t2 = new JTextArea();
    JButton button = new JButton();

    public Agent1() {

        JFrame frame = new JFrame("Chat Bot");

        panel.setLayout(new FlowLayout());

        t1.setColumns(43);
        t1.setRows(23);
        t2.setColumns(43);
        t2.setRows(3);
        button.setText("Send");

        button.setBackground(Color.blue);
        button.setForeground(Color.WHITE);
        l.setForeground(Color.blue);
        Font font = new Font("SansSerif", Font.PLAIN, 18);
        Font font2 = new Font("SansSerif", Font.PLAIN, 10);
        button.setFont(font);
        l.setFont(font);

        button.setPreferredSize(new Dimension(150, 35));
        panel.add(t1);
        panel.add(l);
        panel.add(t2);
        panel.add(button);

        t1.setForeground(Color.blue);
        button.addActionListener(this);
        frame.add(panel);
        frame.setTitle("Chat Bot");
        frame.setVisible(true);
        frame.setBounds(50, 50, 500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    ACLMessage acl;

    protected void setup() {

        acl = new ACLMessage(ACLMessage.INFORM);
        acl.addReceiver(new AID("reciver", false));
        ////
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    t1.setText(t1.getText() + "Reciver : " + msg.getContent() + "\n---------------------------------------------\n");

                } else {
                    block();
                }
            }
        });
    }

    protected void takeDown() {

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button) {
            acl.setContent(t2.getText());
            send(acl);
            t1.setText(t1.getText() + "Sender : " + t2.getText() + "\n");
            t2.setText("");

        }

    }

}
