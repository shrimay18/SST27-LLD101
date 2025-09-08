package com.example.notifications;

public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline
        base.notify("Baseline email only.");

        // Email + SMS
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("Build green");

        // Email + WhatsApp
        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("New feature released");

        // Email + Slack
        Notifier emailAndSlack = new SlackDecorator(base, "alerts");
        emailAndSlack.notify("Pipeline failed");

        // Email + WhatsApp + Slack
        Notifier full = new SlackDecorator(new WhatsAppDecorator(base, "user_wa"), "deployments");
        full.notify("Deployment completed");
    }
}