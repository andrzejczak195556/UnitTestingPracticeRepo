package AVT;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    Player player;
    Tape tape = mock(Tape.class);
    private final static float BEGINNIG_OF_TAPE = 0.0f;
    @Before
    public void setUp()
    {
        player = new PlayerImpl();
    }

    @Test
    public void insertTape_ShouldAddTapeIntoThePlayer() {

        player.insertNewTape(tape);

        assertThat(player.isTapeInside()).isTrue();

    }

    @Test
    public void getCurrentTapePosition() throws NoTapeException {

        player.insertNewTape(tape);
        when(tape.getPosition()).thenReturn(BEGINNIG_OF_TAPE);

        float expectedPosition = player.getCurrentTapePosition();


        verify(tape).getPosition();
        assertThat(expectedPosition).isEqualTo(BEGINNIG_OF_TAPE);
    }

    @Test(expected = NoTapeException.class)
    public void ifThereIsNoTapeInsideShouldThrowNoTapeException() throws NoTapeException {
        player.getCurrentTapePosition();
    }

    @Test
    public void fastForwardTapeForm_0_to_0point5() throws NoTapeException, EndOfTapeException, BeginningOfTapeException {

        player.insertNewTape(new Tape());

        player.fastForward(0.5f);

        assertThat(player.getCurrentTapePosition()).isEqualTo(0.5f);

    }

    @Test
    public void revindTapeToTheBegining() throws NoTapeException, EndOfTapeException, BeginningOfTapeException {
        player.insertNewTape(tape);

        player.fastForward(0.5f);
        player.revindTape(0.5f);

        verify(tape).setPosition(0.5f);
        verify(tape).setPosition(-0.5f);
    }

    @Test(expected = EndOfTapeException.class)
    public void whenPlayerTriesToGoBeyondEndOfTape_ThrowException() throws NoTapeException, EndOfTapeException, BeginningOfTapeException {
        player.insertNewTape(new Tape());

        player.fastForward(10f);

    }

    @Test(expected = BeginningOfTapeException.class)
    public void whenPlayerTriesToGoBeyondBeginningOfTape_ThrowException() throws NoTapeException, EndOfTapeException, BeginningOfTapeException {
        player.insertNewTape(new Tape());

        player.fastForward(-10f);

    }

}
