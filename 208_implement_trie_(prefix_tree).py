'''
A trie (pronounced as "try") or prefix tree is a tree data structure
used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Solution:
- We use a defaultdict in order to add a new node to the trie for each letter in insert().
- Keep a bool associated with every node to see if a word ends at that node.
- TrieNode class keep a reference to its children which is a defaultdict of Trienodes
'''

from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isEndOfWord = False

class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        currentNode = self.root

        for char in word:
            currentNode = currentNode.children[char]

        currentNode.isEndOfWord = True

    def search(self, word: str) -> bool:
        currentNode = self.root

        for char in word:
            currentNode = currentNode.children.get(char)
            
            if not currentNode:
                return False
            
        return currentNode.isEndOfWord

        

    def startsWith(self, prefix: str) -> bool:
        
        currentNode = self.root

        for char in prefix:
            currentNode = currentNode.children.get(char)
            
            if not currentNode:
                return False
            
        return True



# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)