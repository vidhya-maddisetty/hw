import java.util.*;
import java.io.*;

public class WordSearch {
    private char[][] board;
    private Random rand;
    private ArrayList<String> wordList;
    private char[][] solution;

    private void loadWords(String filename) {
        wordList = new ArrayList<String>();
        try {
            File f = new File(filename);
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String s =sc.nextLine();
                wordList.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public WordSearch(int rows, int cols) {
        rand = new Random();
        loadWords("wordslist");
        System.out.println(wordList);
        board = new char[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                board[i][j]='-';
            }
        }

    }

    public WordSearch() {
        this(20,20);
    }

    public boolean addWord(int row, int col, int deltaR,int deltaC,String word,boolean re) {
        if (re==true){
	    String temp = "";
	    for (int i = 0; i<word.length(); i++){
		temp = word.charAt(i)+temp;
	    }
	    word = temp;
	}

	int r,c;

        if (deltaR<-1||deltaR>1||deltaC<-1||deltaC>1||
            (deltaR==0&&deltaC==0))
            return false;
        // see if we can add the word
        r = row;
        c = col;
        for (int i=0;i<word.length();i++) {
            try {
                if (board[r][c]!='-' && board[r][c]!=word.charAt(i)) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return false; // return false since we can't add the word - we're out of bounds
            }
            r=r+deltaR;
            c=c+deltaC;
        }
        r=row;
        c=col;
        for (int i=0;i<word.length();i++) {
            board[r][c]=word.charAt(i);
            r=r+deltaR;
            c=c+deltaC;
        }
    return true;
    }

    public boolean addWordRand(String w) {
	boolean re = true;
        int r = rand.nextInt(board.length);
        int c = rand.nextInt(board[0].length);
        int deltaR = rand.nextInt(3)-1;
        int deltaC = rand.nextInt(3)-1;
	int rev = rand.nextInt(2) - 1;
	if (rev == -1)
	    re = false; 
	else 
	    re = true;
        return addWord(r,c,deltaR,deltaC,w,re);
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

    public String toStringSolution() {
	String s="";
	for (int i=0;i<solution.length;i++) {
	    for (int j=0;j<solution[i].length;j++) {
		s=s+solution[i][j];
	    }
	    s=s+"\n";
	}
	return s;
    }

    public void fillBlanks() {
        for (int r=0;r<board.length;r++) {
            for (int c=0;c<board[0].length;c++) {
                if (board[r][c]=='-') {
                    board[r][c]=(char)('a'+rand.nextInt('z'-'a'));
                }
            }
        }
    }

    public void constructWordSearch(){
	ArrayList<String> words = new ArrayList<String>();
	for (int i = 0;i<wordList.size();i++){
	    addWordRand(wordList.get(i));
	    if (addWordRand(wordList.get(i))) {
		words.add(wordList.get(i));
		wordList.remove(wordList.get(i));
	    }
	    if (!addWordRand(wordList.get(i))){
		for (int j=0; j<10; j++){
		    addWordRand(wordList.get(i));
		    if (addWordRand(wordList.get(i))){
			words.add(wordList.get(i));
			wordList.remove(wordList.get(i));
			break;
		    }
		}
	    }
	}
	solution = new char[board.length][board[0].length];
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[0].length;j++)
		solution[i][j]=board[i][j];
	}
	fillBlanks();
	System.out.println(toStringSolution());
	System.out.println();
	System.out.println(this);
	System.out.println(words);
    }
}