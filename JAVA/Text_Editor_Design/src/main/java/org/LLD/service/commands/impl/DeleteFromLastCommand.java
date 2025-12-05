package org.LLD.service.commands.impl;

import org.LLD.service.TextEditor;
import org.LLD.service.commands.Command;

public class DeleteFromLastCommand implements Command {
    TextEditor editor;
    int length;
    String text;

    public DeleteFromLastCommand(TextEditor editor, int length) {
        this.editor = editor;
        this.length = length;
    }

    @Override
    public void execute() {
        String editorText = editor.getText();
        if (this.length <= editorText.length()) {
            this.text = editorText.substring(editorText.length() - this.length);
            this.editor.deleteFromEnd(this.length);
        }
    }

    @Override
    public void undo() {
        this.editor.typeAtEnd(this.text);
    }

    @Override
    public void redo() {
        this.editor.deleteFromEnd(this.length);
    }
}
