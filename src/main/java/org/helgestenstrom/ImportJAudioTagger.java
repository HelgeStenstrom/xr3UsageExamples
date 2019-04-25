package org.helgestenstrom;

import java.io.File;

import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.ID3v1FieldKey;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v24FieldKey;
import org.jaudiotagger.tag.id3.ID3v24Tag;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImportJAudioTagger {

    String one() {
        final ID3v24FieldKey album = ID3v24FieldKey.ALBUM;
        new MP3File();
        return "pass";
    }
}
