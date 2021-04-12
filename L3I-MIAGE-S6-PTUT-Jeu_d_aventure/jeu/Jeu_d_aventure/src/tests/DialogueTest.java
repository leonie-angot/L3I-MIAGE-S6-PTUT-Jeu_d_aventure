package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Jeu.Dialogue;

class DialogueTest {

    Dialogue d;

    @BeforeEach
    void setUp() throws Exception {
        d = new Dialogue(1, "Salut tout le monde", false);
    }

    @Test
    void testGetNumeroDialogue() {
        assertEquals(d.getNumeroDialogue(), 1);
    }

    @Test
    void testGetDialogueTexte() {
        assertEquals(d.getDialogueTexte(), " | Salut tout le monde\n");
    }

    @Test
    void testGetDejaParle() {
        assertFalse(d.getDejaParle());
    }

    @Test
    void testSetDejaParle() {
        d.setDejaParle();
        assertTrue(d.getDejaParle());
    }

    @Test
    void testTostring(){
        Dialogue s=new Dialogue("Holla");
        String m= "\n" + "(Indice) " + s.dialogueIndice;
        assertEquals(m,s.toString());
    }
    @Test
    void testsetIndiceRecup() {
        d.setIndiceRecup();
        assertTrue(d.getIndiceRecup());
    }


}