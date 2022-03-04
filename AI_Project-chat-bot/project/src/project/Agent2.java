/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
// reciever

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Random;

/**
 *
 * @author hoda , hanan, fatema
 */
public class Agent2 extends Agent {

    String[] s1 = {"hi", "hello", "hey", "ola",  "hi,there"};

    String[] s2 = {"good", "doing well", "great", "fine,thank", "so far so good", "well"};

    String[] s3 = {"Hoda Abdllah", "Hanan Abd-elghany", "Fatema Yasser"};

    String[] s4 = {"You my help me by standing over there", "waiting for me to decide if I need your help",
        "I don’t need your help just yet thank you",
        "you could ask them a question about the product you were looking at"};

    String[] s5 = {"YES,OFCORSE.", "WHAT DO YOU THINK?", "ACTUALY,I'M VERY INTELLIENT!"};

    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage msg = receive();
                if (msg != null) {
                    ACLMessage acl;
                    acl = new ACLMessage(ACLMessage.INFORM);
                    acl.addReceiver(new AID("sender", false));
                    String mss = msg.getContent();
                    Random r = new Random();
                    switch (mss) {
                        case "hi":
                            int randomNum = r.nextInt(s1.length);
                            acl.setContent(s1[randomNum]);
                            break;
                        case "hello":
                            int randomNum2 = r.nextInt(s1.length);
                            acl.setContent(s1[randomNum2]);
                            break;
                        case "how are you?":
                            int rn3 = r.nextInt(s2.length);
                            acl.setContent(s2[rn3]);
                            break;
                        case "what is your name?":
                            int rn4 = r.nextInt(s3.length);
                            acl.setContent(s3[rn4]);
                            break;
                        case "can i help you?":
                            int rn5 = r.nextInt(s4.length);
                            acl.setContent(s4[rn5]);
                            break;
                        case "are you intelligent?":
                            int rn6 = r.nextInt(s5.length);
                            acl.setContent(s5[rn6]);
                            break;
                        default:
                            acl.setContent("I don't understand you !!!");
                    }

                    send(acl);
                } else {
                    block();
                }
            }
        });

    }

    protected void takeDown() {

    }

}
