package com.qa.controller;

import org.apache.log4j.Logger;

import utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of function
 * to apply to an entity
 *  
 */
public enum Action {

	CREATE ("To save a new item into the database"), 
	READ ("To read an item from the database"), 
	UPDATE ("To change an item already in the database"), 
	DELETE ("To remove an item from the database"), 
	RETURN ("To return to domain selection");
	  
	public static final Logger LOGGER = Logger.getLogger(Action.class);
	
	private String description;
	
	Action (String description){
		this.description = description;
	}
	
	/*
	 * Describes the action
	 */
	public String description () {
		return this.description + ":" + this.description;
	}

	/*
	 * Prints out all the possible actions
	 */
	public static void printAction() {
		
		for(Action action : Action.values()) {
			LOGGER.info(action.description());
		}
	}
 
	/**
	 * Gets an action based on a users input. if user enters a non specified enum constant, it will take another input.
	 * @return
	 */
	public static Action getAction() {
		Action action;
		
		while(true) {
			try {
				action = Action.valueOf(Utils.getInput().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return action;
	}
} 