package com.github.FilipeRobot;

import com.github.FilipeRobot.view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            MenuPrincipal frame = new MenuPrincipal();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}