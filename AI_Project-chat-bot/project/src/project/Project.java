package project;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project {

    public static void main(String[] args) {

        jade.core.Runtime r = jade.core.Runtime.instance();

        Profile p = new ProfileImpl("localhost", 10000, "TestMain");
        ContainerController main = r.createMainContainer(p);

        try {
            AgentController agentgui = main.createNewAgent("Main", "jade.tools.rma.rma", null);
            agentgui.start();

            AgentController agentgui2 = main.createNewAgent("sender", "project.Agent1", null);
            agentgui2.start();

            AgentController agentgui3 = main.createNewAgent("reciver", "project.Agent2", null);
            agentgui3.start();

        } catch (StaleProxyException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
