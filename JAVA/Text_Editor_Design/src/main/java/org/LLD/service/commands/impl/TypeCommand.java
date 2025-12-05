package org.LLD.service.commands.impl;

import org.LLD.service.TextEditor;
import org.LLD.service.commands.Command;

public class TypeCommand implements Command {
    TextEditor editor;
    String text;

    public TypeCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        this.editor.typeAtEnd(text);
    }

    @Override
    public void undo() {
        this.editor.deleteFromEnd(text.length());
    }

    @Override
    public void redo() {
        this.editor.typeAtEnd(text);
    }
}
