package gitlet;

public enum GitletConstants {
    INIT_COMMIT_MESSAGE("initial commit"),

    REPO_ALREADY_EXISTS("A Gitlet version-control system already exists in the current directory."),

    MAIN_BRANCH("master"),

    REFS_HEADS("refs/heads/"),

    NO_INPUT_COMMEND("Please enter a command."),

    INVALID_COMMEND("No command with that name exists."),

    NOT_A_REPO("Not in an initialized Gitlet directory."),

    WRONG_OPERANDS("Incorrect operands."),

    FILE_NOT_EXIST("File does not exist."),


    ;

    private final String value;

    GitletConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
