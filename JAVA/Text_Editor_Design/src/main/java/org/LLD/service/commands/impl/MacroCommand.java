package org.LLD.service.commands.impl;

import org.LLD.service.commands.Command;

import java.util.List;

public class MacroCommand implements Command {
    List<Command> commands;

    public MacroCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for(Command cmd : commands) {
            cmd.execute();
        }
    }

    @Override
    public void undo() {
        for(int idx = commands.size() - 1; idx >= 0; idx--) {
            commands.get(idx).undo();
        }
    }

    @Override
    public void redo() {
        for(Command cmd : commands) {
            cmd.redo();
        }
    }
}
