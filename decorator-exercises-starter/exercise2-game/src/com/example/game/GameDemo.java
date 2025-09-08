package com.example.game;

public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        System.out.println("\n--- Buffed (Speed + Damage) ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();

        System.out.println("\n--- Shiny (Buffed + GoldenAura) ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();

        System.out.println("\n--- Without Aura (back to Buffed only) ---");
        Character withoutAura = buffed;
        withoutAura.move();
        withoutAura.attack();
    }
}