README

We have used offset as our grid method. So our first cell is 0,0 then the subsequent cell is 0,1
so on and so forth.

Keyboard events have two inputs, m and p. m indicates that the user would like to make a move
which hen allows te user to place a piece(logic for placing piece not implemented because not
required for this assignment) and p indicates the user would like to pass their turn.

Code Overview:

The model retains its role in tracking game state, while a new GUI interface
offers a contract for GUI implementations, fostering modularity. Controllers mediate between the model and view,
adhering to a controller interface for consistency. Two player types, Machine and Human, implement a Player
interface, accommodating diverse player interactions. The main function initializes two models, controllers, and GUIs.
In the case of a human player, the GUI awaits interaction, updating the model and triggering view updates. For machine
players, the GUI autonomously processes moves. The mock model incorporates a transcript, aiding the CaptureMax strategy
in determining the best move by evaluating legality for each piece on the board. The codebase now supports diverse
player interactions and maintains synchronization between models and views during gameplay.

Quick Start:
    To start the game:
        a model first needs to be created (BasicReversi model = new BasicReversi();)
        after which the method model.startGame((desired side length)) can be called which will
        start the game.
        for the GUI, you reate a model, start the model with the desired side length and pass
        the model to the GUI to render the game.

    How to play the game:
        Player A, Black, Starts.
        model.placePiece() - allows the user the place a piece on the given board.
        model.pass() - allows the user to pass their turn subsequently causing the alternate player
        to play.
        or if using the GUI you can select the pieces on the board.

key components:
    There are 4 main components:
        model:
            which contains all the logic and moves for a player to use when playing the game.
            It ensures the the game abides by the rules set by us and the game is played with
            our rules. It further contains the class to represent a player class to ensure we
            have control over the logic of the player.
        view:
            contains the textual view and interface classes which help in rendering the game to the
            user. this makes it more user-friendly and helps in the player understanding what is
            going on in the game.

        controller:
            The controller serves as the intermediary between the model and view components, facilitating seamless
            communication and updates within the Reversi game. Responsible for managing the flow of information,
            the controller ensures that player moves and game logic align with the established rules. It plays a vital
            role in maintaining synchronization between the model and view, ensuring that player interactions and
            updates are accurately reflected in the game state.
        test:
            tests all our methods to ensure that the logic has no flaws and that there are
            no anomalies when playing the game
        Reversi:
            Runs the GUI so that is displayed and can be used by the user.

Key subcomponents:
    There are 8 main classes in the package model:
    GamePieces:
        Is the interface for the player piece and enforces the toString method.
    ReversiPiece:
        Represents a potential piece on the board. There are 3 possible player pieces. "X" which
        represents a black piece, "O" which represents a white piece, and "-" which represents an
        empty slot on the board. The "-" piece is just there for textual purposes which makes
        it more user friendly for the person playing to understand the game. This class has methods
        that help in testing of the code and implementing few methods in our basic class, such as
        getColor or setColor.
    ReversiModel:
        Is the interface for the model class and enforces several rules and gameplay elements.
    BasicReversi:
        Is the class with all the rule logic and playable moves that the user can instantiate when
        playing the game. This class helps enforce the game is played the way it's intended.
    CaptureMax:
        which is the class to implement a stratergy for the AI for it to see whuch move
        would give it the highest points.
    MockBasicReversi:
        is a mock class for the reversi game to be able to test out different scenarios and
        situations to ensure the game works correctly.
    ReadOnlyReversiModel:
        Is the interface for all the read only methods in the reversi model to ensure
        the game logic cannot be accessed by user and that they can only get information
        about the game.
    ReversiStratergy:
        Interface to ensure all the stratergies we require are implemented.

    There are 2 main classes in our package view:
        TextualView:
            which is the interface class ensuring the toString method is enforced on the child
            class.
        ReversiTextualView:
            Contains the main toString method which renders our game to the user in a format
            that is easy to understand.
        CirclePanel:
            represents the class to create either a white or black circle to represent as a
            player piece.
        HexagonButton:
            Represents a hexagon button that is used in the GUI to display each cell of the board.
        ReversiGUI:
            Is the class for that creates the board, sets up the pieces and handles the game logic
            for the GUI.

    There is one main class in our package test:
        TestReversi:
            contains tests for all the methods that need to be tested to ensure the game logic is
            functional without any bugs or flaws that might affect the user when playing the game.

Source organization:
    src:
        model:
            BasicReversi
            CaptureMax
            GamePieces
            MockBasicReversi
            ReadOnlyReversiModel
            ReversiModel
            ReversiPiece
            ReversiStrategy
        view:
            CirclePanel
            HexagonButton
            ReversiGUI
            ReversiTextualView
            TextualView
        controller:
            HumanPlayer
            MachinePlayer
            Player
            RevControllers
            ReversiController
        stratergy:
            Human
            Machine
            PlayerStrat
        test:
            TestReversi
    README
    Reversi