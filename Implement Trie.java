class Trie {

    TrieNode root;
    public Trie() {
    root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.children[word.charAt(i)-'a']==null){
               temp.children[word.charAt(i)-'a'] = new TrieNode(); 
            }
            temp = temp.children[word.charAt(i)-'a'];
        }
        temp.isEndOfWord=true;
    }
    
    public boolean search(String word) {
       TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            if(temp.children[word.charAt(i)-'a']==null){
                return false;
            }
             temp = temp.children[word.charAt(i)-'a'];
        }
        return (temp!=null && temp.isEndOfWord);
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
         for(int i=0;i<prefix.length();i++){
             if(temp.children[prefix.charAt(i)-'a']==null){
                return false;
            }
             temp = temp.children[prefix.charAt(i)-'a'];
         }
        return (temp!=null && (temp.isEndOfWord ||!temp.isEndOfWord));
    }
    
  class TrieNode{
          TrieNode children[] =new TrieNode[26];
          boolean isEndOfWord;
      public TrieNode(){
         isEndOfWord=false;
        for(int i=0;i<26;i++)
         children[i]=null;
      }
      
  }
}
