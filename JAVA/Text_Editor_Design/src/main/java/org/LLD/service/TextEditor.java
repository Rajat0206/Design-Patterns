package org.LLD.service;

public class TextEditor {
    private String text;

    public TextEditor() {
        this.text = "";
    }

    public String getText() {
        return this.text;
    }

    public void typeAtEnd(String newText) {
        this.text += newText;
    }

    public void typeAtIndex(int index, String newText) {
        this.text = this.text.substring(0, index) + newText + this.text.substring(index);
    }

    public void deleteFromEnd(int length) {
        this.text = this.text.substring(0, this.text.length() - length);
    }

    public void deleteFromBetween(int index, int length) {
        this.text = this.text.substring(0, index + 1) + this.text.substring(index + length);
    }
}
