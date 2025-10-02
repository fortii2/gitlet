package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

/**
 * Represents a gitlet repository.
 * <p>
 * <p>
 * .gitlet/
 * ├─ HEAD                       ← 当前所在分支（内容一般是 "refs/heads/master"）
 * ├─ commits/                   ← 存所有 commit 对象（以 commitID 命名）
 * │   ├─ a1b2c3...
 * │   └─ ...
 * ├─ blobs/                     ← 存文件内容（blob 对象）
 * │   ├─ f7e8d9...
 * │   └─ ...
 * ├─ refs/
 * │   ├─ heads/                 ← 本地分支
 * │   │   ├─ master             ← 内容是 commit ID
 * │   │   └─ dev
 * │   └─ remotes/               ← 远端分支（如果你实现了 remote 功能）
 * └─ index/                     ← 暂存区（add/rm 用）
 *
 * @author Ethan
 */
public class Repository {

    /**
     * The current working directory.
     */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /**
     * The .gitlet directory.
     */
    public static final File GITLET_DIR = join(CWD, ".gitlet");
    /**
     * The head file. Which indicates which branch we currently are
     */
    public static final File HEAD_FILE = join(GITLET_DIR, "HEAD");
    /**
     * The commits directory is used to persist all the commit object
     */
    public static final File COMMITS_DIR = join(GITLET_DIR, "commits");
    /**
     * The blobs directory is used to save all the blobs. Which is the different version of files.
     */
    public static final File BLOBS_DIR = join(GITLET_DIR, "blobs");
    /**
     * The refs directory is used to save different kinds of references.
     */
    public static final File REFS_DIR = join(GITLET_DIR, "refs");

    /**
     * the HEADS directory under refs saves different local branches.
     * Each branch is a file, including the commit id of the newest commit of this branch
     */
    public static final File REFS_HEADS_DIR = join(REFS_DIR, "heads");
    /**
     * the REMOTES directory under refs saves different url of remote repo.
     * Also, each file save just url.
     */
    public static final File REFS_REMOTES_DIR = join(REFS_DIR, "remotes");
    /**
     * optional now. Don't know using for what.
     */
    public static final File INDEX_DIR = join(GITLET_DIR, "index");


    public static void init() throws IOException {
        if (GITLET_DIR.exists()) {
            message(GitletConstants.REPO_ALREADY_EXISTS.getValue());
            return;
        }

        // init .gitlet directory structure
        GITLET_DIR.mkdir();
        COMMITS_DIR.mkdir();
        BLOBS_DIR.mkdir();
        REFS_DIR.mkdir();
        REFS_HEADS_DIR.mkdir();
        REFS_REMOTES_DIR.mkdir();
        INDEX_DIR.mkdir();

        // init commit
        Commit initCommit = Commit.initCommit();
        String initCommitName = sha1((Object) serialize(initCommit));
        File initCommitFile = join(COMMITS_DIR, initCommitName);

        initCommitFile.createNewFile();
        writeObject(initCommitFile, initCommit);

        // init main branch
        File masterBranch = join(REFS_HEADS_DIR,
                GitletConstants.MAIN_BRANCH.getValue());
        masterBranch.createNewFile();
        writeContents(masterBranch, initCommitName);

        // point to main branch
        HEAD_FILE.createNewFile();
        writeContents(HEAD_FILE, GitletConstants.REFS_HEADS.getValue()
                + GitletConstants.MAIN_BRANCH.getValue());
    }

    public static void add(String fileName) {
        if (!GITLET_DIR.exists()) {
            message(GitletConstants.NOT_A_REPO.getValue());
            return;
        }

        File file = join(CWD, fileName);
        if (!file.exists()) {
            message(GitletConstants.FILE_NOT_EXIST.getValue());
            return;
        }



    }
}
