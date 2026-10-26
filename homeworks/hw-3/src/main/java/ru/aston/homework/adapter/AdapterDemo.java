package ru.aston.homework.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("----------------------");

        ModernAudioSystem audioSystem = new ModernAudioSystem();
        ModernPlayer modernPlayer = new ModernPlayer();
        OldPlayer oldPlayer = new OldPlayer();
        ModernPlayer adaptedPlayer = new OldPlayerAdapter(oldPlayer);

        audioSystem.addPlayer(modernPlayer);
        audioSystem.addPlayer(adaptedPlayer);

        String track = "cool_music.mp4";
        System.out.printf("Target track: \"%s\"\n", track);
	System.out.println("----------------------");
        
        audioSystem.playAll(track);
    }
}
