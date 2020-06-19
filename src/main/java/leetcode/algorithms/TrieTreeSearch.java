package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author haxl
 */
//212
public class TrieTreeSearch {
    private class TrieNode{
        private Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        private String word ="";
        private boolean isEnd = false;

        public void addNode(char c){
            if(children.get(c)==null){
                children.put(c, new TrieNode());
            }
        }

        public TrieNode getNode(char c){
            return children.get(c);
        }

        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        public void setWord(String word){
            this.word = word;
        }

        public String getWord(){
            return this.word;
        }

    }


    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        if(words==null||words.length==0||board==null||board.length==0||board[0].length==0){
            return new ArrayList<>(result);
        }

        TrieNode root = new TrieNode();
        for(int i=0;i<words.length;i++){
            TrieNode node = root;
            for(int j = 0;j<words[i].length();j++){
                node.addNode(words[i].charAt(j));
                node = node.getNode(words[i].charAt(j));
            }
            node.setEnd(true);
            node.setWord(words[i]);
        }
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                searchBoard(board, row, col, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void searchBoard(char[][] board, int row, int col, TrieNode parent, Set<String> result){
        TrieNode child = parent.getNode(board[row][col]);
        if(child == null){
            return;
        }
        if(child.isEnd){
            result.add(child.getWord());
            //这里不要return，有可能有end了但是还是其他word的前缀的情况
        }
        char originLetter = board[row][col];
        board[row][col]='#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for(int i=0;i<4;i++){
            int nextRow = row + rowOffset[i];
            int nextCol = col + colOffset[i];
            if(nextRow>=0&&nextRow<board.length&&nextCol>=0&&nextCol<board[0].length&&board[nextRow][nextCol]!='#'){
                searchBoard(board, nextRow, nextCol, child, result);
            }
        }
        board[row][col] = originLetter;
    }


}