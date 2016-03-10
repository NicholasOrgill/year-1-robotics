package JUnitTests;

import ServerClasses.Message;
import interfaces.MessageHeader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MessageTest {
    private Message message;

    @Before
    public void setUp() {
        message = new Message(MessageHeader.MOVE, "Content");
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void testGetHeader() throws Exception {
        assertEquals(message.getHeader(), MessageHeader.MOVE);
    }

    @Test
    public void testSetHeader() throws Exception {
        message.setHeader(MessageHeader.MOVE_COMPLETE);
        assertEquals(message.getHeader(), MessageHeader.MOVE_COMPLETE);
    }

    @Test
    public void testGetContent() throws Exception {
        assertEquals(message.getContent(), "Content");
    }

    @Test
    public void testSetContent() throws Exception {
        message.setContent("New Content");
        assertEquals(message.getContent(), "New Content");
    }
}