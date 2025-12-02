package com.mall.command;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
	
    private final List<Command> queue = new ArrayList<>();
    
    public void addCommand(Command c) { 
    	queue.add(c); 
    }
    
    public void executeAll() { 
    	queue.forEach(Command::execute); 
    	queue.clear(); 
    }
}