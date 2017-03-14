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

    public void fastForward(float howMuchForward) {
        this.tape.setPosition(howMuchForward);
    }

    public void revindTape(float howMuchBackwards) {
        this.tape.setPosition(-howMuchBackwards);
    }
}
