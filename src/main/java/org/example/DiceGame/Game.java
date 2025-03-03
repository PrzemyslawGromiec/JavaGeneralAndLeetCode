package org.example.DiceGame;

import java.util.*;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private final String[] playerNames = {"Player 1", "Player 2", "Player 3"};

    // Main method to run the game logicGa
    public void runGame() {
        System.out.println("Welcome to the Dice Game\n");
        String[][] userBoard = generateBoard();
        displayBoard(userBoard);

        int TOTAL_ROUNDS = 11;
        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            System.out.println("=== Round " + round + " ===");
            boolean enforceUniqueColumns = (round == 1);
            runOneRoundForAll(userBoard, enforceUniqueColumns);
        }

        System.out.println("=== Game Over ===");
        displayColumnWinners(userBoard);
    }

    // Method to run one round of play for all players
    public void runOneRoundForAll(String[][] gameBoard, boolean firstRoundUnique) {
        Set<Integer> usedColumnsThisRound = new HashSet<>();

        for (int playerNum = 0; playerNum < playerNames.length; playerNum++) {
            System.out.println(playerNames[playerNum] + " is playing now.");
            int[] score = throwTwoDice();
            displayUserScore(score);
            int totalScore = calculateScoreOfTwoDice(score);
            System.out.println(playerNames[playerNum] + " scored: " + totalScore + "\n");

            int scoreColumn;
            boolean validColumn = false;

            while (!validColumn) {
                scoreColumn = chooseColumn();

                // Check if the player has already entered a score in this column
                if (hasPlayerEnteredScoreInColumn(gameBoard, playerNum, scoreColumn)) {
                    System.out.println("You have already entered a score in column " + scoreColumn + ". Choose another column.");
                }
                // Check if the column is full
                else if (isColumnFull(gameBoard, scoreColumn)) {
                    System.out.println("Column " + scoreColumn + " is full. Choose another column.");
                }
                // If it's the first round, ensure columns are unique among players
                else if (firstRoundUnique && usedColumnsThisRound.contains(scoreColumn)) {
                    System.out.println("Column " + scoreColumn + " has already been chosen. In round one, choose another column.");
                } else {
                    usedColumnsThisRound.add(scoreColumn);
                    insertValue(gameBoard, playerNum, scoreColumn, String.valueOf(totalScore));
                    validColumn = true;
                }
            }

            displayBoard(gameBoard);
            scanner.nextLine();
        }
    }

    // Method to check if a player has already entered a score in a column
    private boolean hasPlayerEnteredScoreInColumn(String[][] gameBoard, int playerNum, int columnNumber) {
        String cellValue = gameBoard[playerNum + 1][columnNumber - 1].trim();
        return !cellValue.isEmpty() && !cellValue.equals(" ");
    }

    // Method to generate the initial game board
    public String[][] generateBoard() {
        String[][] array = new String[4][13];
        initializeHeader(array);
        for (int i = 1; i < 4; i++) {
            array[i][0] = playerNames[i - 1];
        }

        initializeEmptyCells(array);
        return array;
    }

    public void displayBoard(String[][] array) {
        int columns = array[0].length;
        int lineLength = columns * 5;
        String roundName = "Round 1";
        String[][] roundHeader = generateRoundHeader(columns, roundName);
        insertTextInTheHeader(roundHeader, roundName);
        printRoundHeader(roundHeader);

        for (int i = 0; i < array.length; i++) {
            drawHorizontalLine(lineLength);
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].length() > 1) {
                    System.out.print("| " + array[i][j]);
                } else {
                    System.out.print("| " + array[i][j] + " ");
                }
            }
            System.out.println();
        }
        drawHorizontalLine(lineLength);
        System.out.println();
    }

    // Method to initialize the header with player names and column numbers
    private void initializeHeader(String[][] array) {
        int spaceLength = "Player 1".length();
        array[0][0] = " ".repeat(spaceLength);
        for (int j = 1; j <= 11; j++) {
            array[0][j] = String.valueOf(j + 1);
        }
        array[0][12] = "Scores";
    }

    // Method to fill the game board with empty spaces initially
    private void initializeEmptyCells(String[][] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = " ";
            }
        }
    }

    private void drawHorizontalLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private String[][] generateRoundHeader(int gameHeaderLength, String roundName) {
        int textLength = roundName.length();
        int paddingLength = 6;
        int totalColumns = Math.max(gameHeaderLength * 3, textLength + paddingLength);

        String[][] roundHeader = new String[3][totalColumns];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < totalColumns; j += 3) {
                roundHeader[i][j] = "-";
                roundHeader[i][j + 1] = "*";
                roundHeader[i][j + 2] = "-";
            }
        }

        insertTextInTheHeader(roundHeader, roundName);
        return roundHeader;
    }

    private void printRoundHeader(String[][] roundHeader) {
        for (String[] row : roundHeader) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private void insertTextInTheHeader(String[][] header, String text) {
        int textLength = text.length();
        int totalColumns = header[0].length;
        int availableSpace = totalColumns - textLength;
        int leftPadding = availableSpace / 2;

        for (int j = 0; j < totalColumns; j++) {
            if (j >= leftPadding && j < leftPadding + textLength) {
                header[1][j] = String.valueOf(text.charAt(j - leftPadding));
            } else if (header[1][j] == null) {
                header[1][j] = "-*-";
            }
        }
    }

    public void insertValue(String[][] array, int playerNumber, int columnNumber, String value) {
        if (isValidInput(array, playerNumber, columnNumber)) {
            int newScore = Integer.parseInt(value);
            updateColumnScores(array, playerNumber, columnNumber, newScore);

            if (isColumnFull(array, columnNumber)) {
                processFullColumn(array, columnNumber);
            }
        } else {
            System.out.println("Wrong column number.");
        }
    }

    // Validates if the input for the player and column is within bounds
    private boolean isValidInput(String[][] array, int playerNumber, int columnNumber) {
        return playerNumber >= 0 && playerNumber < array.length && columnNumber >= 2 && columnNumber <= 12;
    }

    // Updates the scores in the column, replacing lower scores with stars, or updating the player's value
    private void updateColumnScores(String[][] array, int playerNumber, int columnNumber, int newScore) {
        boolean higherScoreExists = false;

        for (int i = 1; i < array.length; i++) {
            if (i != playerNumber + 1) {
                String existingValue = array[i][columnNumber - 1];
                if (isNumeric(existingValue)) {
                    int existingScore = Integer.parseInt(existingValue);
                    higherScoreExists = updateHigherOrLowerScore(array, columnNumber, newScore, i, existingScore);
                }
            }
        }

        if (higherScoreExists) {
            array[playerNumber + 1][columnNumber - 1] = "*";
        } else {
            array[playerNumber + 1][columnNumber - 1] = String.valueOf(newScore);
        }
    }

    // Compares the new score with an existing score in the column and updates the array
    private boolean updateHigherOrLowerScore(String[][] array, int columnNumber, int newScore, int playerIndex, int existingScore) {
        if (existingScore > newScore) {
            return true;
        } else if (existingScore < newScore) {
            array[playerIndex][columnNumber - 1] = "*";
        }
        return false;
    }

    private void processFullColumn(String[][] gameBoard, int columnNumber) {
        int highestScore = findHighestScore(gameBoard, columnNumber);
        List<Integer> winnerIndices = findWinners(gameBoard, columnNumber, highestScore);

        if (winnerIndices.size() == 1) {
            processSingleWinner(gameBoard, winnerIndices.get(0), columnNumber);
        } else if (winnerIndices.size() > 1) {
            processTie(gameBoard, columnNumber, winnerIndices);
        } else {
            System.out.println("Column " + columnNumber + " is full, but no one wins this column.");
        }
    }

    // Find the highest score in the specified column
    private int findHighestScore(String[][] gameBoard, int columnNumber) {
        int highestScore = Integer.MIN_VALUE;
        for (int i = 1; i < gameBoard.length; i++) {
            String cellValue = gameBoard[i][columnNumber - 1];
            if (isNumeric(cellValue)) {
                int score = Integer.parseInt(cellValue);
                if (score > highestScore) {
                    highestScore = score;
                }
            }
        }
        return highestScore;
    }

    // Find the indices of players who have the highest score in the specified column
    private List<Integer> findWinners(String[][] gameBoard, int columnNumber, int highestScore) {
        List<Integer> winnerIndices = new ArrayList<>();
        for (int i = 1; i < gameBoard.length; i++) {
            String cellValue = gameBoard[i][columnNumber - 1];
            if (isNumeric(cellValue)) {
                int score = Integer.parseInt(cellValue);
                if (score == highestScore) {
                    winnerIndices.add(i);
                }
            }
        }
        return winnerIndices;
    }

    // Process the scenario where a single player wins the column
    private void processSingleWinner(String[][] gameBoard, int winnerIndex, int columnNumber) {
        String winnerName = gameBoard[winnerIndex][0];
        System.out.println("Column " + columnNumber + " is full. " + winnerName + " wins this column!");

        int scoreColumnIndex = gameBoard[0].length - 1;
        String currentScoreStr = gameBoard[winnerIndex][scoreColumnIndex];
        int currentScore = isNumeric(currentScoreStr) ? Integer.parseInt(currentScoreStr) : 0;

        int newTotalScore = currentScore + columnNumber;
        gameBoard[winnerIndex][scoreColumnIndex] = String.valueOf(newTotalScore);
    }

    // Process the scenario where multiple players tie for the highest score in the column
    private void processTie(String[][] gameBoard, int columnNumber, List<Integer> winnerIndices) {
        System.out.println("Column " + columnNumber + " is full. It's a tie between:");
        for (int index : winnerIndices) {
            String playerName = gameBoard[index][0];
            System.out.println("- " + playerName);
        }
        System.out.println("No points are awarded for this column.");
    }


    private void displayColumnWinners(String[][] gameBoard) {
        System.out.println("=== Column Winners ===");

        for (int columnNumber = 2; columnNumber <= 12; columnNumber++) {
            int highestScore = Integer.MIN_VALUE;
            int[] winnerIndices = new int[gameBoard.length - 1];
            int winnerCount = 0;

            for (int i = 1; i < gameBoard.length; i++) {
                String cellValue = gameBoard[i][columnNumber - 1];
                if (isNumeric(cellValue)) {
                    int score = Integer.parseInt(cellValue);
                    if (score > highestScore) {
                        highestScore = score;
                        winnerIndices = new int[gameBoard.length - 1];
                        winnerIndices[0] = i;
                        winnerCount = 1;
                    } else if (score == highestScore) {
                        winnerIndices[winnerCount] = i;
                        winnerCount++;
                    }
                }
            }

            if (winnerCount == 1) {
                String winnerName = gameBoard[winnerIndices[0]][0];
                System.out.println("Column " + columnNumber + ": " + winnerName + " wins.");
            } else if (winnerCount > 1) {
                System.out.print("Column " + columnNumber + ": It's a tie between ");
                for (int j = 0; j < winnerCount; j++) {
                    System.out.print(gameBoard[winnerIndices[j]][0]);
                    if (j < winnerCount - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(".");
            } else {
                System.out.println("Column " + columnNumber + ": No winner.");
            }
        }
        System.out.println();
    }

    private boolean isColumnFull(String[][] gameBoard, int columnNumber) {
        for (int i = 1; i < gameBoard.length; i++) {
            String cellValue = gameBoard[i][columnNumber - 1].trim();
            if (cellValue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int chooseColumn() {
        int scoreColumn = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the column in which you wish to enter your scorer (2-12): ");
            if (scanner.hasNextInt()) {
                scoreColumn = scanner.nextInt();

                if (scoreColumn >= 2 && scoreColumn <= 12) {
                    validInput = true;
                } else {
                    System.out.println("Invalid column number. Please enter a number between 2 and 12.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer between 2 and 12.");
                scanner.next();
            }
        }
        return scoreColumn;
    }

    public int[] twoDiceRoundScore() {
        int[] userRandomScore = new int[2];
        for (int i = 0; i < 2; i++) {
            userRandomScore[i] = random.nextInt(6) + 1;
        }
        return userRandomScore;
    }

    public int calculateScoreOfTwoDice(int[] scores) {
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        return totalScore;
    }

    public void displayUserScore(int[] score) {
        for (int j : score) {
            System.out.print("[" + j + "]");
        }
        System.out.println();
    }

    public int[] throwTwoDice() {
        while (true) {
            System.out.print("Enter 't' to take your throw > ");
            String userInput = scanner.nextLine().trim().toLowerCase();
            System.out.println();

            if (isValidInput(userInput)) {
                return twoDiceRoundScore();
            } else {
                System.out.println("Invalid input. Please enter 't' to take your throw.");
            }
        }
    }

    public boolean isValidInput(String input) {
        return input.equalsIgnoreCase("t");
    }
}