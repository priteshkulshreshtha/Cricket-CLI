package org.example.main;

import org.example.controller.MatchController;

public class Main {
    public static void main(String[] args) {
        MatchController match = new MatchController(100);
        match.run();

    }
}