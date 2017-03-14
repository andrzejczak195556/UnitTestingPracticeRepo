package AVT;

/**
 * Created by user on 14.03.2017.
 */
public interface Player {
    float getCurrentTapePosition() throws NoTapeException;

    void insertNewTape(Tape tape);

    boolean isTapeInside();

    void fastForward(float howMuchForward);

    void revindTape(float howMuchBackwards);
}
