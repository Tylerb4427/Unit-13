package WordSearch;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
        m=new String[size][size];
        for(int x=0;x<m.length;x++)
            for(int y=0;y<m[x].length;y++)
                m[x][y]=""+str.charAt((x*size)+y);
    }

    public boolean isFound( String word )
    {
        boolean isFound=false;
        
        for(int r=0;r<m.length;r++)
            for(int c=0;c<m[r].length+1-word.length();c++)
                if(checkRight(word,r,c)||checkLeft(word,r,c))
                    isFound=true;
        
        
        for(int c=0;c<m.length;c++)
            for(int r=0;r<m[c].length+1-word.length();r++)
                if(checkDown(word,r,c)||checkUp(word,r,c))
                    isFound=true;

        
        for(int c=0;c<m.length+1-(word.length());c++)
            for(int r=0;r<m[c].length+1-(word.length());r++)
                if(checkDiagUpLeft(word,r,c)||checkDiagDownLeft(word,r,c)||checkDiagUpRight(word,r,c)||checkDiagDownRight(word,r,c))
                    isFound=true;

        return isFound;
    }

	public boolean checkRight(String w, int r, int c)
   {
        for(int i=0;i<w.length();i++)
            if(!(m[r][c+i].equals(""+w.charAt(i))))
                return false;
        return true;
        }

	public boolean checkLeft(String w, int r, int c)
	{
        for(int i=0;i<w.length();i++)
            if(!(m[r][m[r].length-(c+i+1)].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkUp(String w, int r, int c)
	{
        for(int i=0;i<w.length();i++)
            if(!(m[m.length-(r+i+1)][c].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkDown(String w, int r, int c)
   {
        for(int i=0;i<w.length();i++)
            if(!(m[r+i][c].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
        for(int i=0;i<w.length();i++)
            if(!(m[m.length-(r+i+1)][c+i].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
        for(int i=0;i<w.length();i++)
            if(!(m[m.length-(r+i+1)][m[r+i].length-(c+i+1)].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
        for(int i=0;i<w.length();i++)
            if(!(m[r+i][m[r+i].length-(c+i+1)].equals(""+w.charAt(i))))
                return false;
        return true;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
        for(int i=0;i<w.length();i++)
            if(!(m[r+i][c+i].equals(""+w.charAt(i))))
                return false;
        return true;
	}

    public String toString()
    {
        String ans ="";
 	for(int x=0;x<m.length;x++){
            for(int y=0;y<m[x].length;y++){
                ans+=m[x][y]+" ";}
            ans+="\n";
        }
        return ans;
    }
}
