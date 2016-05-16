Keep in mind this project was done in a short amount of time so the code quality may be a little messy at times.


Takes a dictionary and prints classes of anagrams on each line.

**Algorithm Design:**


I use n to represent the number of words. I use l to represent the number of letters. I use k to represent the number of digits in counting sort. 
For each word I use the following procedure:

(1) Sort word into alphabetical order using counting sort to obtain key.

(2) Pass the (key, word) pair to the hash method. The hash method uses a 26-ary, dynamically created decision tree (What most people call a trie). The tree routes keys, from left character to right character until there are no more characters. The word is stored in the node that results after the rightmost character in the key has been decided on. 

(3) The table is updated with this new anagram class (in which case a new node is created) or perhaps the key routed the word to a node where another word has already been stored. In this case the tree is updated with this new word.

(4) Printing the table is straightforward. Loop through the indices in the table (checking to make sure that there is more than 1 word) until you reach null.




**Time analysis:**

Since this is for each word I have to multiply every worst case run time by n.

(1) Preprocess to obtain key: Time is n(l+k) = O(nl)

(2) Hash key, value pair: Time is O(nl)

(3) Update table on each hash: Time is O(1)

(4) Print table: Time is O(n)

Total Time: O(nl)