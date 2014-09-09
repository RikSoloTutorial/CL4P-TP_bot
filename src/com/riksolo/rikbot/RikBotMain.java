package com.riksolo.rikbot;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.jibble.pircbot.*;

public class RikBotMain {
    
    public static void main(String[] args) throws Exception {
       
        // Now start our bot up.
        RikBot bot = new RikBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
       
        // Join the #pircbot channel.
        
        
        if (args.length > 0 && args[0].equals("-esper")){
            bot.connect("irc.esper.net");
        } else if (args.length > 0 && args[0].equals("-twitch")){
            bot.connect("irc.twitch.tv", 6667, "oauth:ouzm0ccuh5tn2gqrn1h7zmpn7k95gkr");
        } else {
        	bot.log("no arg found");
        }
        
        bot.joinChannel("#riksolo");

        
    }
    
}