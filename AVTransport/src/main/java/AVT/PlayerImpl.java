package AVT;

/**
 * Created by user on 14.03.2017.
 */
public class PlayerImpl implements Player {

    Tape tape;

    public float getCurrentTapePosition() throws NoTapeException {
        if(isTapeInside() == false)
        {
            throw new NoTapeException();
        }
        return tape.getPosition();
    }

    public void insertNewTape(Tape tape) {
        this.tape = tape;
    }

    public boolean isTapeInside() {
        return tape!=null;
    }

    public void fastForward(float howMuchForward) throws NoTapeException, EndOfTapeException, BeginningOfTapeException {

        this.tape.setPosition(howMuchForward);
        checkForBeginningOfTapeorEndOfTape();
    }

    public void revindTape(float howMuchBackwards) throws NoTapeException, EndOfTapeException, BeginningOfTapeException {

        this.tape.setPosition(-howMuchBackwards);
        checkForBeginningOfTapeorEndOfTape();
    }
    private void checkForBeginningOfTapeorEndOfTape() throws NoTapeException, BeginningOfTapeException, EndOfTapeException {
        if(getCurrentTapePosition() < 0)
        {
            tape.setPosition(0.0f);
            throw new BeginningOfTapeException();
        }
        else if(getCurrentTapePosition() > 1f)
        {
            tape.setPosition(1.0f);
            throw new EndOfTapeException();
        }
    }
}
