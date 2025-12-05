package org.LLD.service.commands.impl;

import org.LLD.service.TextEditor;
import org.LLD.service.commands.Command;

public class DeleteFromBetweenCommand implements Command {
    TextEditor editor;
    int index;
    int length;
    String text;

    public DeleteFromBetweenCommand(TextEditor editor, int index, int length) {
        this.editor = editor;
        this.index = index;
        this.length = length;
    }

    @Override
    public void execute() {
        this.text = editor.getText().substring(this.index, this.index + this.length);
        this.editor.deleteFromBetween(this.index, this.length);
    }

    @Override
    public void undo() {
        this.editor.typeAtIndex(this.index, this.text);
    }

    @Override
    public void redo() {
        this.editor.deleteFromBetween(this.index, this.length);
    }
}
