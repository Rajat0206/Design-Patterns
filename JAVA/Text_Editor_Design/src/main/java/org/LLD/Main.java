package org.LLD;

import org.LLD.service.CommandManager;
import org.LLD.service.TextEditor;
import org.LLD.service.commands.Command;
import org.LLD.service.commands.impl.DeleteFromBetweenCommand;
import org.LLD.service.commands.impl.DeleteFromLastCommand;
import org.LLD.service.commands.impl.MacroCommand;
import org.LLD.service.commands.impl.TypeCommand;

import java.util.List;

public class Main {
    static void main() {
        CommandManager commandManager = new CommandManager();
        TextEditor editor = new TextEditor();

        // Commands
        Command typeHello = new TypeCommand(editor, "Hello ");
        Command typeWorld = new TypeCommand(editor, "World!");
        Command typeExclamation = new TypeCommand(editor, "!!!");
        Command typeSpace = new TypeCommand(editor, " ");
        Command deleteLast3 = new DeleteFromLastCommand(editor, 3);
        Command typeText = new TypeCommand(editor, "This is working.");
        Command deleteFromBetween = new DeleteFromBetweenCommand(editor, 4, 6);
        Command macro = new MacroCommand(List.of(typeWorld, typeExclamation, typeSpace, deleteFromBetween));

        // Execute Commands
        commandManager.executeCommand(typeHello);
        commandManager.executeCommand(macro);
        commandManager.executeCommand(typeText);
        commandManager.executeCommand(deleteLast3);
        commandManager.executeCommand(typeSpace);
        commandManager.executeCommand(typeHello);
        System.out.println("Current Text: " + editor.getText());

        // Undo Operations
        commandManager.undo();
        commandManager.undo();
        commandManager.undo();
        System.out.println("After Undo Text: " + editor.getText());

        // Redo Operations
        commandManager.redo();
        System.out.println("After Redo Text: " + editor.getText());
    }
}
