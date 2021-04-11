package com.itijm.jitselogs.Util;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import club.minnced.discord.webhook.send.WebhookMessage;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;

public class DiscordWebhook {
    public static class EmbedBuilder {
        private int color;
        private String message = "undefined";
        private boolean ping = false;

        public EmbedBuilder() {}

        public EmbedBuilder setColor(int color) {
            this.color = color;

            return this;
        }

        public EmbedBuilder setMessage(String message) {
            this.message = message;

            return this;
        }

        public EmbedBuilder setPing(boolean ping) {
            this.ping = ping;

            return this;
        }

        public void send() {
            WebhookClient client = new WebhookClientBuilder("https://discord.com/api/webhooks/830722111944917013/anl9bt5LIhG6g9HfgmajFkcbFJ-x-a3yCzv8iybyvjsr-XtD_AOr3N3k6LC1IRJOzq-M").build();

            WebhookEmbed content = new WebhookEmbedBuilder()
                    .setColor(this.color)
                    .setDescription(message)
                    .build();

            if (ping) {
                client.send("@everyone").whenComplete((v, e) -> {
                    if (e != null && e.getMessage().contains("Request returned failure 404")) {
                        System.out.println("Request failed");
                    }
                });
            }

            client.send(content).whenComplete((v, e) -> {
                if (e != null && e.getMessage().contains("Request returned failure 404")) {
                    System.out.println("Request failed");
                }
                client.close();
            });
        }
    }

    public static class MessageBuilder {
        private String message = "undefined";
        private String name = "undefined";

        public MessageBuilder() {}

        public MessageBuilder setMessage(String message) {
            this.message = message;

            return this;
        }

        public MessageBuilder setName(String name) {
            this.name = name;

            return this;
        }

        public void send() {
            WebhookClient client = new WebhookClientBuilder("https://discord.com/api/webhooks/830722111944917013/anl9bt5LIhG6g9HfgmajFkcbFJ-x-a3yCzv8iybyvjsr-XtD_AOr3N3k6LC1IRJOzq-M").build();
            WebhookMessage webhookMessage = new WebhookMessageBuilder()
                    .setUsername(name)
                    .setContent(message)
                    .setAvatarUrl("https://mc-heads.net/head/" + name + "/100.png")
                    .build();

            client.send(webhookMessage).whenComplete((v, e) -> {
                if (e != null && e.getMessage().contains("Request returned failure 404")) {
                    System.out.println("Request failed");
                }
                client.close();
            });
        }
    }
}