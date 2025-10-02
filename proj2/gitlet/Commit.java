package gitlet;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

/**
 * Represents a gitlet commit object.
 *
 * @author Ethan
 */
public class Commit implements Serializable, Dumpable {

    /**
     * The message of this Commit.
     */
    private String message;

    /**
     * The Date of this commit.
     */
    private Date timestamp;

    /**
     * files this commit contains.
     */
    private HashMap<String, String> trackedFiles;

    /**
     * parent pointer.
     */
    private Commit parent;

    public static Commit initCommit() {
        Commit initCommit = new Commit();

        initCommit.message = GitletConstants.INIT_COMMIT_MESSAGE.getValue();
        initCommit.timestamp = new Date(0);
        initCommit.trackedFiles = new HashMap<>();
        initCommit.parent = null;

        return initCommit;
    }

    @Override
    public void dump() {
        System.out.println("message: " + message);
        System.out.println("commitTime: " + timestamp);
        System.out.println("files: " + trackedFiles);
        System.out.println("parentCommit: " + parent);
    }

    /* TODO: fill in the rest of this class. */
}
