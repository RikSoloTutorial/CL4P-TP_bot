package com.riksolo.rikbot;
import java.io.IOException;
import java.util.Random;

import org.jibble.pircbot.*;


public class RikBot extends PircBot {

	

	public RikBot() throws NickAlreadyInUseException, IOException, IrcException {
		this.setName("CL4p_tp_bot");
		
	    
		
	}
   
	
	public void onJoin(String channel,String  sender,String login,String hostname) {
		sendMessage(channel, sender + " has joined the channel!");
		if (this.getServer() == "irc.esper.net"){
			
		if (sender.equalsIgnoreCase("misterxerox")) {
			this.voice(channel, sender);
		}
		if (sender.equalsIgnoreCase("othlon")) {
			this.voice(channel, sender);
		}}
	}
	
	public void onPart(String channel,String  sender,String login,String hostname) {
		sendMessage(channel, sender + " has left the channel!");
	}
	 
	public void onConnect() {
		if (this.getServer() == "irc.esper.net"){
		identify("romeinen");
	} }

	
	
	
	
	public void onMessage(String channel, String sender, String login, String hostname, String message ) {
		
		
		
		if (message.startsWith("@join")) {
			if (sender.equalsIgnoreCase("riksolo")) {
				String joinchan = message.toString().replaceFirst("@join", "").trim();
				sendMessage(channel, "Joining channel: " + joinchan);
				joinChannel(joinchan);
			}
		}
		else if (message.startsWith("@leave")) {
			if (sender.equalsIgnoreCase("RikSolo")){
				String partchan = message.toString().replaceFirst("@leave", "").trim();
				sendMessage(channel, "Leaving channel: " + partchan);
				partChannel(partchan);
			}
		}
	

		else if (message.startsWith("@nick")) {
			if (sender.equalsIgnoreCase("RikSolo")) {
				if (this.getServer() == "irc.esper.net"){
				String newnick = message.toString().replaceFirst("@nick", "").trim();
				changeNick(newnick);
				}
			}
		
			}
		else  if (message.startsWith("@tech"))  {	
			if (sender.equalsIgnoreCase("riksolo")){
			
		        
				sendAction(channel, "we are experiencing technical difficulties, please hang on");	
			}}
		
		else  if (message.startsWith("@contactprofound"))  {	
		
			    sendMessage(channel, "check profound's facebook: facebook.com/profoundgames");
		        sendMessage(channel, "follow profound on twitter: twitter.com/profoundgames");
				sendMessage(channel, "subscribe to profound on youtube: youtube.com/profoundgame");	
			}
		
	
						
		
		else  if (message.startsWith("@anvil"))  {	
			if (sender.equalsIgnoreCase("riksolo") || sender.equalsIgnoreCase("MisterCash01")){
			
		        String partchan = message.toString().replaceFirst("@anvil", "").trim();
				sendAction(channel, "drops an anvil on " + partchan + "'s head");	
			}}
		else  if (message.startsWith("@cl4p-tp")) {	
			sendMessage(channel, "Welcome to Fyrestone!");
			sendMessage(channel, "I am CL4P-TP, you may call me by my locally designated name, 'Claptrap'.");
			sendMessage(channel, "Before continuing, please accept this ECHO communication device and heads-up display provided free of charge by the Dahl corporation!");
	}
		else  if (message.startsWith("@hate")) {	
			
			sendAction(channel, "likes watching haters hate, they look so pathetic");
			
	}
		
		else if (message.startsWith("@commands")) {
			
				
				sendMessage(channel, "I know the following commands:");
				sendMessage(channel, "All User Commands:");
				sendMessage(channel, "@anvil [name] : Drop an anvil on name's head | @cl4p-tp : find out yourself");
				sendMessage(channel, "Owner Only Commands:");
				sendMessage(channel, "@join [channel] : Joins [channel] | @leave [channel] : Leaves #channel | @nick [nick] : Set the bot's nick (IRC ONLY)");
				
			
		}
		
		
	
	}
}
