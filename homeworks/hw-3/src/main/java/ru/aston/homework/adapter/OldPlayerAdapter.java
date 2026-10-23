package ru.aston.homework.adapter;

class OldPlayerAdapter extends ModernPlayer {
    private final OldPlayer wrapee;

    public OldPlayerAdapter(OldPlayer wrapee) {
	this.wrapee = wrapee;
    }

    @Override
    public void playMusic(String music) {
	this.wrapee.playOldFormat(music);
    }
}
