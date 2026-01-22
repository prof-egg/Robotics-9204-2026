# Git and GitHub
Git is a [version control system](https://www.geeksforgeeks.org/git/version-control-systems/) (VCS) command-line tool that runs locally on your computer. 
A VCS is exactly what it sounds like, it's something that helps you manage versions of your project and is incredibly useful.

GitHub on the other hand, is as the name implies. It's an online hub for git projects. It allows for colloboration between git projects by letting multiple people contribute
the source code in a repository.

There are of course multiple VCSs and hubs like GitHub, Git isn't the only VCS and GitHub isn't the only git-hub, but these two are so incredibly popular you probably haven't heard of any others.

## Cheatsheet
### About Command-Line Tools
When using a command-line tool like git, every command starts with the internal name of the tool. So in this case, every command will start with `git` followed by a space.

The part that follows is typically the actual command you are running. In the case of `git clone`, the actual git command you are running is the `clone` command.

After that is any parameters or flags that the command can take, all of which is seperated by a space.

### Tips for Reading Cheatsheet
The commands in the cheatsheet have some rules for describing the command syntax:
- `a` - A string literal, you have to type this as is
- `[a]` - Optional item (you can add _a_ if you want, but you don't have to)
- `(a|b)` - Mutually exclusive items and choices are split with a `|` (pick either _a_ or _b_, you can't have both)
- `<a>...` - Can have more than one of that item
- `-c` - Is a flag. Flags are basically modifiers for a command where one letter flags are prefixed with a single dash (`-`), and word flags (i.e. `--create`) are prefixed with two dashes (`--`). 
> [!NOTE]
> A lot of one letter flags will have a capital letter variant, which means its a forceful variant. 
> `-d` for example is a flag on some commands that will make the command delete something, but the deletion can fail for a few reasons. 
> If you are sure about youre deletion, you can force delete something with the `-D` flag instead, but please try to stick to the lowercase flags for good measure.


Example (not real and made up) command: 
```
git draft (-d|-D) [--close] <branch>...
```

`git draft` means you start with `git draft`.
`(-d|-D)` means you must type `-d` or `-D`.
`[--close]` means that typing the "--close" flag is optional.
`<branch>` means that you need to insert something equivalent to a branch, like the name of a branch or the hash of a commit on a branch. 
And the `...` after `<branch>` means you can optionally add more than one branch.

Altogether, a command following that syntax could look like:
```
git draft -d feature/drivetrain
```

### Basic Commands
This is a cheatsheet I made using information I got from the [git docs](https://git-scm.com/docs). I actually didn't realise git has [their own cheatsheet](https://git-scm.com/cheat-sheet) until after I was mostly done with mine, and theirs looks a lot better than mine so you can also use that.

- [`git status`](https://git-scm.com/docs/git-status) - Show the working tree status.

- [`git log`](https://git-scm.com/docs/git-log) - Shows the commit logs.

- [`git config set [--global] <name> <value>`](https://git-scm.com/docs/git-config) - Get and set repository or global options.
  - `--global` - For writing options: write to global `~/.gitconfig` file rather than the repository `.git/config`. That is to say, `--global` means you are editing your settings globally, and without the flag you are editing the settings for your local rpo.
  - `<name>` - The name of the config setting.
  - `<value>` - The value you want to set for the setting.
  - You can also use `git config list` to see a list of your settings, and `git config get <name>` to see what value is set for one of your settings.

- [`git remote [-v]`](https://git-scm.com/docs/git-remote) - Manage the set of repositories ("remotes") whose branches you track.
  - `-v` - Be a little more verbose and show remote url after name.
  - Use `git remote add <name> <URL>` to add a remote specificied by the `<URL>` of name `<name>`.

- [`git clone <repository> [<directory>]`](https://git-scm.com/docs/git-clone) - Clones a repository into a newly created directory, creates remote-tracking branches for each branch in the cloned repository (visible using `git branch --remotes`), and creates and checks out an initial branch that is forked from the cloned repository’s currently active branch.
  - `<repository>` - The (possibly remote) <repository> to clone from. See the [GIT URLS](https://git-scm.com/docs/git-clone#URLS) section in the wiki for more information on specifying repositories.
  - `<directory>` - The name of a new directory to clone into. If left blank, command will use the current working directory.

- [`git init`](https://git-scm.com/docs/git-init) - Create an empty Git repository or reinitialize an existing one.

- [`git add <pathspec>...`](https://git-scm.com/docs/git-add) - Add contents of new or changed files to the index. The "index" (also known as the "staging area") is what you use to prepare the contents of the next commit.
  - `<pathspec>...` - Files to add content from. Fileglobs (e.g. *.c) can be given to add all matching files. Also a leading directory name (e.g. dir to add dir/file1 and dir/file2) can be given to update the index to match the current state of the directory as a whole (e.g. specifying dir will record not just a file dir/file1 modified in the working tree, a file dir/file2 added to the working tree, but also a file dir/file3 removed from the working tree).
  - You can use the command `git add .` to stage all changes instead of specifying files individually.

- [`git commit [-m <msg>]`](https://git-scm.com/docs/git-commit) - Create a new commit containing the current contents of the index and the given log message describing the changes. 
  - `-m <msg>` - Use `<msg>` as the commit message. For a message that is longer than one word, surround the `<msg>` in quotation marks (`"This is an example message."`). If no message is provided you will be prompted in your editor instead to give a message. A commit message is practically mandatory despite it being optional in the command line.

- [`git restore --staged <pathspec>...`](https://git-scm.com/docs/git-restore) - Restore specified paths in the working tree with some contents from a restore source. If a path is tracked but does not exist in the restore source, it will be removed to match the source. (It unstages files).
  - `--staged` - Specifies that you want to restore stages files.
  - `<pathspec>...` - Same deal as in `git add <pathspec>...`. 
  - Similarly to `git add`, you can use the comand `git restore --staged .` to restore all staged files.

- [`git reset [--soft | --mixed | --hard] <commit>`](https://git-scm.com/docs/git-reset) - Set the current branch head (HEAD) to `<commit>`.
  - `--soft` - Does not touch the index file or the working tree at all (but resets the head to `<commit>`, just like all modes do). This leaves all your changed files "Changes to be committed", as `git status` would put it.
  - `--mixed` - Resets the index but not the working tree (i.e., the changed files are preserved but not marked for commit) and reports what has not been updated. This is the default action.
  - `--hard` - Resets the index and working tree. Any changes to tracked files in the working tree since <commit> are discarded. Any untracked files or directories in the way of writing any tracked files are simply deleted.
  
- [`git branch [-m|-M] <branch-name>`](https://git-scm.com/docs/git-branch) - Creates a new branch with name of `<branch-name>` if the `-m` flag is not supplied.
  - `-m` - Renames the current branch to `<branch-name>`.

- [`git switch [-c|-C] <branch>`](https://git-scm.com/docs/git-switch) - Switch to a specified branch. The working tree and the index are updated to match the branch. All new commits will be added to the tip of this branch.
  - `-c` Create a new branch named `<new-branch>` before switching to the branch. This is the transactional equivalent of running `git branch <new-branch>` and then `git switch <new-branch>`.
  - `<branch>` - The branch to switch to or the name of the new branch if the create flag was used.

- [`git merge <commit>...​`](https://git-scm.com/docs/git-merge) - Incorporates changes from the named commits (since the time their histories diverged from the current branch) into the current branch. This command is used by `git pull` to incorporate changes from another repository and can be used by hand to merge changes from one branch into another.
  - `<commit>...` - The commits to merge. Supplying a branch name also works so for ease of use just imagine this command as merging branches together instead of specific commits.
  
- [`git pull [<repository> [<refspec>...​]]`](https://git-scm.com/docs/git-pull) - Integrate changes from a remote repository into the current branch.
  - `<repository>` - The "remote" repository to pull from. This can be either a [URL](https://git-scm.com/docs/git-pull#URLS) (wiki link on GIT URLs) or the [name of a remote](https://git-scm.com/docs/git-pull#REMOTES) (wiki link on remotes).
  - `<refspec>...` - Which branch or other reference(s) to fetch and integrate into the current branch, for example `main` in `git pull origin main`. Defaults to the configured upstream for the current branch.

- [`git push [<repository> [<refspec>...​]]`](https://git-scm.com/docs/git-push) - Updates one or more branches, tags, or other references in a remote repository from your local repository, and sends all necessary data that isn’t already on the remote.
  - `<repository>` - The "remote" repository that is the destination of a push operation. This can be either a [URL](https://git-scm.com/docs/git-pull#URLS) (wiki link on GIT URLs) or the [name of a remote](https://git-scm.com/docs/git-pull#REMOTES) (wiki link on remotes).
  - `<refspec>...` - Specify what destination ref to update with what source object.


### Resources
- [learngitbranching](https://learngitbranching.js.org/) - Interactive git branching simulation thingy
