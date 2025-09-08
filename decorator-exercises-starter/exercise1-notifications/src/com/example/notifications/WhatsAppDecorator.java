package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String username;

    public WhatsAppDecorator(Notifier wrappee, String username) {
        super(wrappee);
        this.username = username;
    }

    @Override
    public void notify(String text) {
        super.notify(text);
        System.out.println("[WhatsApp -> " + username + "]: " + text);
    }
}