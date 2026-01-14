package org.example.interfaces;

import java.util.Set;

public interface ISuffixTree<C extends CharSequence> {

    /**
     * Does the sub-sequence exist in the suffix tree.
     * 
     * @param sub-sequence to locate in the tree.
     * @return True if the sub-sequence exist in the tree.
     */
    public boolean doesSubStringExist(C sub);

    /**
     * Get all the suffixes in the tree.
     * 
     * @return set of suffixes in the tree.
     */
    public Set<String> getSuffixes();
}