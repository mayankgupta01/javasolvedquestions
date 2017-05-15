package hiredintech_topcoder.graphs;

/**
 * Created by mayank.gupta on 13/05/17.
 */
public class Trie {

    class TrieNode {

        boolean isLeaf;
        TrieNode[] children;
        char c;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            isLeaf = false;
        }
    }


    TrieNode root;

    Trie() {
        this.root = new TrieNode('*');
    }

    /*Assuming only alphabets are in dictionary*/

    public boolean insert(String s) {

        if(s.length() == 0)
            return false;

        TrieNode node = root;
        int i=0;
        for(; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(node.children[index] == null) {
                /*Add the node*/
                node.children[index] = new TrieNode(s.charAt(i));
            }
            node = node.children[index];
        }

        /*Mark last node as leaf node to indicate a word*/
        node.isLeaf = true;
        return true;
    }

    public boolean search(String s) {

        if(s.length() == 0) {
            return false;
        }

        TrieNode node = root;
        int i=0;

        for(;i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(node.children[index] == null)
                return false;
            node = node.children[index];
        }

        /*Check last node is leaf node to indicate a word*/
        return  node.isLeaf;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("mayank");
        trie.insert("man");
        trie.insert("moon");
        trie.insert("suvi");
        trie.insert("apoorva");
        trie.insert("guddan");
        trie.insert("kudlugate");

        System.out.println(trie.search("suvi"));
    }
}
