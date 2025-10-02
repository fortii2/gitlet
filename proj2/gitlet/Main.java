package gitlet;

import java.io.IOException;

/**
 * Driver class for Gitlet, a subset of the Git version-control system.
 *
 * @author Ethan
 */
public class Main {

    /**
     * Usage: java gitlet.Main ARGS, where ARGS contains
     * <COMMAND> <OPERAND1> <OPERAND2> ...
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            Utils.message(GitletConstants.NO_INPUT_COMMEND.getValue());
            System.exit(0);
        }

        String firstArg = args[0];
        switch (firstArg) {
            case "init":
                if (args.length != 1) {
                    Utils.message(GitletConstants.WRONG_OPERANDS.getValue());
                }
                Repository.init();
                break;
            case "add":
                if (args.length != 2) {
                    Utils.message(GitletConstants.WRONG_OPERANDS.getValue());
                }
                Repository.add(args[1]);
                break;
            // TODO: FILL THE REST IN
            default:
                Utils.message(GitletConstants.INVALID_COMMEND.getValue());
                System.exit(0);
                break;
            // TODO: invalid errors need implement
        }
    }
}
