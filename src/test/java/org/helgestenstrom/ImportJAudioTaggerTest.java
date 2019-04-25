package org.helgestenstrom;

import org.jaudiotagger.tag.id3.ID3v24FieldKey;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ImportJAudioTaggerTest {

    @Test
    void makesomething() {
        final ID3v24FieldKey album = ID3v24FieldKey.ALBUM;

        final ImportJAudioTagger importJAudioTagger = new ImportJAudioTagger();
        final String result = importJAudioTagger.one();
        assertEquals("pass", result);
    }
}
