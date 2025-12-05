package org.LLD.service;

import com.sun.jdi.request.InvalidRequestStateException;
import org.LLD.service.commands.Command;

import java.util.Stack;

public class CommandManager{
    private final Stack<Command> history;
    private final Stack<Command> future;

    public CommandManager() {
        this.history = new Stack<>();
        this.future = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if(!history.isEmpty()) {
            Command cmd = history.pop();
            cmd.undo();
            future.push(cmd);
        }
    }

    public void redo() {
        if(!future.isEmpty()) {
            Command cmd = future.pop();
            cmd.redo();
            history.push(cmd);
        }
    }
}
