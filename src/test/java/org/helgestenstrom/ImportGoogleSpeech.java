package org.helgestenstrom;

import com.darkprograms.speech.util.Complex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ImportGoogleSpeech {
    @Test
    void method() {
        final ImportSpeech speech = new ImportSpeech();
        final Complex complex = speech.method();

        final Complex expected = new Complex(1, 0);
        assertEquals(expected.re(), complex.re());
        assertEquals(expected.im(), complex.im());

        // Fails, because Complex doesn't override hashCode. See Effective Java, Item 11.
        //assertEquals(expected, complex);
    }
}
