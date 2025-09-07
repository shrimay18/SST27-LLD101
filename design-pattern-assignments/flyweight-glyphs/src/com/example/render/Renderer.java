package com.example.render;


public class Renderer {

    private final TextStyleFactory styleFactory = new TextStyleFactory();

    public int render(String text) {
        int cost = 0;
        for (char c : text.toCharArray()) {
            TextStyle style = styleFactory.getTextStyle("Arial", 12, false);
            Glyph g = new Glyph(c, style);
            cost += g.drawCost();
        }
        return cost;
    }
}
