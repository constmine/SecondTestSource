package com.github.constmine.plugin.plugincore.player;

import net.kyori.adventure.text.Component;

public abstract class PlayerSendMessage {

    public Component stringToComponent(String text) {
        return Component.text(text);
    }
}
