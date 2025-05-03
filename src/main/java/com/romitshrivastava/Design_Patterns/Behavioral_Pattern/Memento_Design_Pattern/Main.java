package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Memento_Design_Pattern;


import java.util.Stack;

// Memento class (stores state)
class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

// Originator class (creates and restores mementos)
class Editor {
    private String content;

    public void type(String words) {
        content += words;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }
}

// Caretaker class (manages mementos)
class History {
    private final Stack<EditorMemento> history = new Stack<>();

    public void save(Editor editor) {
        history.push(editor.save());
    }

    public void undo(Editor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.type("This is the first sentence. ");
        history.save(editor);

        editor.type("This is the second sentence. ");
        history.save(editor);

        editor.type("This is the third sentence.");

        System.out.println("Current Content: " + editor.getContent());
        history.undo(editor);
        System.out.println("After one undo: " + editor.getContent());
        history.undo(editor);
        System.out.println("After second undo: " + editor.getContent());
    }
}

