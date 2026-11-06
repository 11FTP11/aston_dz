package ru.aston.homework.adapter;

import java.util.ArrayDeque;

class ModernAudioSystem {
    private ArrayDeque<ModernPlayer> players = new ArrayDeque<>();

    public void addPlayer(ModernPlayer player) {
	players.add(player);
    }

    public void playAll(String music) {
	for (ModernPlayer player: players) {
	    player.playMusic(music);
	}
    }
    
    public ModernPlayer popPlayer() {
	return !players.isEmpty()
	    ? players.pop()
	    : null;
    }
}
