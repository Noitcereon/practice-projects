package me.noitcereon;

public enum StartMenuOption {
    Start, Options, GameHistory;

    public static StartMenuOption getFromUserInput(String input){
        return switch (input) {
            case "1" -> Start;
            case "2" -> Options;
            case "3" -> GameHistory;
            default -> throw new IllegalArgumentException("Could not recognize that menu option.");
        };
    }
    public static StartMenuOption getFromUserInput(int input){
        return switch (input) {
            case 1 -> Start;
            case 2 -> Options;
            case 3 -> GameHistory;
            default -> throw new IllegalArgumentException("Could not recognize that menu option.");
        };
    }
}
