import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] board;
    private Random rand;
    private ArrayList<String> wordList;
    public ArrayList<String> addedWords;
    
    private void loadWords(String filename) {
	wordList = new ArrayList<String>();

	try {
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNext()) {
		String s = sc.next();
		wordList.add(s);
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("Can't open wordlist - exiting");
	    System.exit(0);
	}
    }

    public WordSearch(int rows, int cols) {
	rand = new Random();
	loadWords("wordlist");
	board = new char[rows][cols];
	rand = new Random();
	for (int i=0;i<rows;i++) {
	    for (int j=0;j<cols;j++) {
		board[i][j]='-';
	    }
	}
    }
    
    public WordSearch() {
	this(20,20);
    }




    public boolean addWord(int row, int col, int deltaR, int deltaC, String word) {
	int r,c;
	
	if (deltaR<-1||deltaR>1||deltaC<-1||deltaC>1||
	    (deltaR==0&&deltaC==0))
	    return false;

	r = row;
	c=col;
	for (int i=0;i<word.length();i++) {
	    try {
		if (board[r][c]!='-' && board[r][c]!=word.charAt(i))
		    return false;

	    } catch (ArrayIndexOutOfBoundsException e) {
		return false;
	    }
	    r = r + deltaR;
	    c = c + deltaC;
	}

	r=row;
	c=col;
	for (int i=0;i<word.length();i++) {
	    board[r][c]=word.charAt(i);
	    r = r + deltaR;
	    c = c + deltaC;
	}

	return true;
    }

    public boolean addWordV(int row, int col, String word) {
	return addWord(row,col,1,0,word);
    }

    public boolean addWordH(int row, int col, String word) {
	return addWord(row,col,0,1,word);
    }
    
    public boolean addWordRand(String w) {
	int r = rand.nextInt(board.length);
	int c = rand.nextInt(board[0].length);
	int deltaR = rand.nextInt(3)-1;
	int deltaC = rand.nextInt(3)-1;
	return addWord(r,c,deltaR,deltaC,w.toUpperCase());
    }




    public void fillSpaces() {
	for (int r=0;r<board.length;r++) {
	    for (int c=0;c<board[0].length;c++) {
		if (board[r][c]=='-') {
		    board[r][c]=(char)('A'+rand.nextInt('Z'-'A'+1));
		}
	    }
	}
    }

    public void addListWord() {
	int i = rand.nextInt(wordList.size());
	String addedWord = wordList.get(i);
	boolean added = false;
	for (int j=0; j<10; j++) {
	    if (added == false) {
		if (addWordRand(addedWord) == true) {
		    added = true;
		    addedWords.add(addedWord);
		    wordList.remove(addedWord);
		}
	    }
	}
    }

    public void addWords(int n) {
	addedWords = new ArrayList<String>();
	while (addedWords.size() < n)
	    addListWord();
    }




    public void genGame() {
	addWords(15);
    }
	
	    
	
    public String toString() {
	String s="";
	
	for (int i=0;i<board.length;i++) {
	    for (int j=0;j<board[i].length;j++) {
		s=s+board[i][j];
	    }
	    s=s+"\n";
	}
	return s;
    }

	
}
