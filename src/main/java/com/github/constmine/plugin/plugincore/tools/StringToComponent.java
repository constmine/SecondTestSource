package com.github.constmine.plugin.plugincore.tools;

import net.kyori.adventure.text.Component;

import java.util.List;

public class StringToComponent {

    private StringToComponent() {}

    public static Component changeString(String text) {
        return Component.text(text);

    }

    public static List<Component> changeStringList(List<String> texts) {
        List<Component> components = null;
        for(String c : texts) {
            components.add(changeString(c));
        }
        return components;
    }

}
