package ru.aston.homework.adapter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class OldPlayerAdapterTest {

    @Test
    public void shouldBeInstanceofModernPlayer() {
	OldPlayer oldP = new OldPlayer();
	OldPlayerAdapter adapter = new OldPlayerAdapter(oldP);
	assertInstanceOf(ModernPlayer.class, adapter);
    }

    @Test
    public void shouldPrintToSystemOutputWhenPlaying() {
        OldPlayer oldPlayer = new OldPlayer();
        OldPlayerAdapter adapter = new OldPlayerAdapter(oldPlayer);
	ModernPlayer modernPlayer = new ModernPlayer();

	ModernAudioSystem sysAudio = new ModernAudioSystem();
	sysAudio.addPlayer(modernPlayer);
	sysAudio.addPlayer(adapter);
	
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
     	    sysAudio.playAll("cool_music.mp4");
            String output = outputStream.toString().replace("\r\n","\n");
            assertEquals("Playing music (modern format): \"cool_music.mp4\"\nPlaying music (OLD FORMAT): \"cool_music.mp4\"\n", output);
        } finally {
            System.setOut(originalOut);
        }
    }
}
