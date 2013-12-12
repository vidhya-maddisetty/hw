import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] board;
    
    public WordSearch(int rows, int cols) {
        board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++) {
                board[i][j] = '-';
            }
        }
    }
    
    public WordSearch() {
        this(20,20);
    }
    
    public String toString() {
        String s = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length ;j++) {
                s = s + board[i][j];
            }
            s = s + "\n";
        }
        return s;
    }
    
    public boolean AddwordH(int r, int c, String word) {
        int w = word.length();
	
	if  (c >= board[0].length
	     ||
	     r >= board.length
	     ||
	     w + c > board[0].length) {
	    return false;
	}
	else {
	    for (int i = 0; i < w; i++){ 
		if (board[r][c + i] != "-".charAt(0)           
		    &&
		    board[r][c + i] != word.charAt(i)) {     
		    return false;
		}
	    }
	}
	for (int i = 0; i < w; i++) {
	    board[r][c + i] = word.charAt(i);
	}
	return true;
    }

    public boolean AddwordV(int r, int c, String word) {
	int w = word.length();
	
	if (w + r > board.length
	    ||
	    c >= board[0].length
	    ||
	    r >= board.length) {
	    return false;
	}
	else {
	    for (int i = 0; i < w; i++) {
		if (board[r + i][c] != "-".charAt(0)
		    &&
		    board[r + i][c] != word.charAt(i)) {
		    return false;
		}
	    }
	}
	for (int i = 0; i < w; i++) {
	    board[r + i][c] = word.charAt(i);
	}
	return true;
    }
    
    public boolean AddwordHReverse(int r, int c, String word) {
	int w = word.length();
	if (r - w < 0
	    ||
	    c >= board[0].length
	    ||
	    r >= board.length) {
	    return false;
	}
	else {
	    for (int i = w - 1; i >= 0; i--){ 
		if (board[r][c + i] != "-".charAt(0)           
		    &&
		    board[r][c + i] != word.charAt(i)) {     
		    return false;
		}
	    }
	}
	    for (int i = w - 1; i >= 0; i--) {
		board[r][c - i] = word.charAt(i);
	    }
	    return true;
	}

    public boolean AddwordVReverse(int r, int c, String word) {
	int w = word.length();
	if (c - w < 0
	    ||
	    c >= board[0].length
	    ||
	    r >= board.length) {
	    return false;
	}
	else {
	    for (int i = w - 1; i >= 0; i--){ 
		if (board[r + i][c] != "-".charAt(0)           
		    &&
		    board[r + i][c] != word.charAt(i)) {     
		    return false;
		}
	    }
	}
	    for (int i = w - 1; i >= 0; i--) {
		board[r - i][c] = word.charAt(i);
	    }
	    return true;
	}

    public boolean AddwordDiagLR(int r, int c, String word) {
	return true;
    }
}