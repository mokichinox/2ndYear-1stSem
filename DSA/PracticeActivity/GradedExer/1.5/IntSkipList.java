package SkipList;
import java.util.Random;

public class IntSkipList {
    private int maxLevel;
    private IntSkipListNode[] root;
    private int[] powers;
    private Random rd = new Random();
    IntSkipList() {
        this(4);
    }
    IntSkipList (int i) {
        maxLevel = i;
        root = new IntSkipListNode[maxLevel];
        powers = new int[maxLevel];
        for (int j = 0; j < maxLevel; j++)
            root[j] = null;
        choosePowers();
    }
    public boolean isEmpty() {
        return root[0] == null;
    }
    public void choosePowers() {
        powers[maxLevel-1] = (2 << (maxLevel-1)) - 1; // 2^maxLevel - 1
        for (int i = maxLevel - 2, j = 0; i >= 0; i--, j++)
            powers[i] = powers[i+1] - (2 << j); // 2^(j+1)
    }
    public int chooseLevel() {
        int level = 0;
        while (level < maxLevel - 1 && rd.nextBoolean()) { // 50% chance to go up a level
            level++;
        }
        return level;
    }
    // make sure (with isEmpty()) that skipListSearch() is called for a
// nonempty list;
    public int skipListSearch (int key) {
        int nodesTraversed = 0; // Counter for nodes traversed
        IntSkipListNode current = root[maxLevel - 1]; // Start from the highest level

        for (int lvl = maxLevel - 1; lvl >= 0; lvl--) {
            while (current != null && current.next[lvl] != null && current.next[lvl].key < key) {
                current = current.next[lvl]; // Move to the next node
                nodesTraversed++; // Increment the counter for each node checked
            }
            // Count the current node as well
            nodesTraversed++;
        }

        // Move down to the lowest level
        if (current != null) {
            current = current.next[0]; // Move down to the lowest level
            nodesTraversed++; // Count this final check
        }

        // Check if we found the key
        if (current != null && current.key == key) {
            return nodesTraversed; // Return the count of comparisons made
        } else {
            return -nodesTraversed; // Indicate not found with a negative count
        }
    }
    public void skipListInsert (int key) {
        IntSkipListNode[] curr = new IntSkipListNode[maxLevel];
        IntSkipListNode[] prev = new IntSkipListNode[maxLevel];
        IntSkipListNode newNode;
        int lvl, i;
        curr[maxLevel-1] = root[maxLevel-1];
        prev[maxLevel-1] = null;
        for (lvl = maxLevel - 1; lvl >= 0; lvl--) {
            while (curr[lvl] != null && curr[lvl].key < key) { // go to the next
                prev[lvl] = curr[lvl]; // if smaller;
                curr[lvl] = curr[lvl].next[lvl];
            }
            if (curr[lvl] != null && curr[lvl].key == key) // don't include
                return; // duplicates;
            if (lvl > 0) // go one level down
                if (prev[lvl] == null) { // if not the lowest
                    curr[lvl-1] = root[lvl-1]; // level, using a link
                    prev[lvl-1] = null; // either from the root
                }
                else { // or from the predecessor;
                    curr[lvl-1] = prev[lvl].next[lvl-1];
                    prev[lvl-1] = prev[lvl];
                }
        }
        lvl = chooseLevel(); // generate randomly level
// for newNode;
        newNode = new IntSkipListNode(key,lvl+1);
        for (i = 0; i <= lvl; i++) { // initialize next fields of
            newNode.next[i] = curr[i]; // newNode and reset to newNode
            if (prev[i] == null) // either fields of the root
                root[i] = newNode; // or next fields of newNode's
            else prev[i].next[i] = newNode; // predecessors;
        }
    }
}

