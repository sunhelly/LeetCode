package leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haxl
 */
public class Trie {
    private class TrieNode{
        Map<Character, TrieNode> nodes = new HashMap<>();
        boolean isEnd = false;

        public TrieNode getNode(char c){
            return nodes.get(c);
        }

        public void addNode(char c){
            TrieNode node = new TrieNode();
            nodes.put(c, node);
        }

        public void setEnd(boolean isEnd){
            this.isEnd = isEnd;
        }

        public List<TrieNode> nexts(){
            return new ArrayList<>(nodes.values());
        }
    }

    class WordDictionary {
        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for(int i=0;i<word.length();i++){
                if(node.getNode(word.charAt(i))==null){
                    node.addNode(word.charAt(i));
                }
                node = node.getNode(word.charAt(i));
            }
            node.setEnd(true);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(word, root);
        }

        public boolean search(String word, TrieNode node){
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)=='.'){
                    List<TrieNode> nexts = node.nexts();
                    for (TrieNode next : nexts) {
                        if (search(word.substring(i+1), next)) {
                            return true;
                        }
                    }
                    return false;
                }else {
                    if (node.getNode(word.charAt(i)) == null) {
                        return false;
                    }
                    node = node.getNode(word.charAt(i));
                }
            }
            return node.isEnd;
        }
    }


}