/*
 * @(#)Splash.java  2.0  January 31, 2004
 *
 * Copyright (c) 2003-2004 Werner Randelshofer
 * Staldenmattweg 2, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * This software is in the public domain.
 */

/**
 * @author werni
 */
package ca.strangebrew.ui.swing.dialogs;

import ca.strangebrew.Debug;
import ca.strangebrew.Options;
import ca.strangebrew.ServerRunner;
import ca.strangebrew.WebServer;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;


public class StrangeBrew {
    /**
     * Shows the splash screen, launches the application and then disposes
     * the splash screen.
     * @param args the command line arguments
     */
    private static Options opts;

    private static Logger logger = Logger.getLogger(StrangeBrew.class.getName());

    public static void main(String[] args) {
        opts = Options.getInstance();

        configureMacintoshProperties();
        setDebugMode(args);
        setDefaultExceptionHandler();
        configureLookAndFeel();
        initWebserver();

        invokeGUI(args);
    }

    private static void invokeGUI(String[] args) {
        SplashWindow.splash(StrangeBrew.class.getResource("/splash.gif"));
        SplashWindow.invokeMain("StrangeSwing", args);
        SplashWindow.disposeSplash();
    }

    private static void setDebugMode(String[] args) {
        if (args.length > 0) {
            // Are we in debug mode?
            if (args[0].equals("-d")) {
                Debug.set(true);
            }
        }
    }

    private static void setDefaultExceptionHandler() {
        //Not the cleanest, but it'll do as a backup until I can fix stuff.
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("Caught Exception in thread" + t.getName() + " - " + e.getMessage());
                e.printStackTrace();
                System.exit(-1);

            }
        });
    }

    private static void configureMacintoshProperties() {
        // check if this is a mac/osx machine, and deal accordingly
        String lcOSName = System.getProperty("os.name").toLowerCase();
        Debug.print("OS is: " + lcOSName);
        //Debug.flush();

        if (lcOSName.indexOf("mac") > -1) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "StrangeBrew");
        }
    }

    private static void configureLookAndFeel() {
        // What fonts do we have
        //String cFront = GraphicsEnvironment.getLocalGraphicsEnvironment().
        String[] fList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        /*Debug.print("Available fonts: ");
    	for(String f : fList) {
    		Debug.print(f);
    	}*/

        Debug.print("Current font: " + UIManager.getDefaults().getFont("TabbedPane.font"));

        //Is someone overriding the Look And Feel?
        if (System.getProperty("swing.defaultlaf") == null) {
            // Lets try to get the look and feel running nicely.
            try {
                // check for a option first
                String appearance = opts.getProperty("optAppearance");

                if (appearance == null) {
                    appearance = UIManager.getSystemLookAndFeelClassName();
                }

                Debug.print("Attempting to set the UI to: " + appearance);
                // Set System L&F
                UIManager.setLookAndFeel(appearance);
            } catch (UnsupportedLookAndFeelException e) {
                // handle exception
            } catch (ClassNotFoundException e) {
                // handle exception
            } catch (InstantiationException e) {
                // handle exception
            } catch (IllegalAccessException e) {
                // handle exception
            }
        }
    }

    private static void initWebserver() {
        logger.info("Checking for webserver");
        // Startup the WebServer if it's requested (this'll be set to on for now)
        if (opts.getBProperty("optWebServer")) {

            int port = opts.getIProperty("optWebServerPort");
            if (port == 0) {
                port = 8080;
            }

            System.out.println("Starting the webserver on port " + port);

            ServerRunner server = new ServerRunner(WebServer.class, port);
            Thread serverThread = new Thread(server);
            serverThread.start();

        }
        logger.info("Server started");
    }

}
