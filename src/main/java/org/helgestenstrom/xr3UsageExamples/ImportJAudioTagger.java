package org.helgestenstrom.xr3UsageExamples;

import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.ID3v24FieldKey;

public class ImportJAudioTagger {

    String one() {
        final ID3v24FieldKey album = ID3v24FieldKey.ALBUM;
        new MP3File();
        return "pass";
    }
}
