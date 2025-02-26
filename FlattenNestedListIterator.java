/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    NestedInteger nextEl;
    Stack<Iterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        
        stack=new Stack<>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return nextEl.getInteger();
    }

    @Override
    public boolean hasNext() {
        
        while(!stack.isEmpty())
        {
            if(!stack.peek().hasNext())
            {
                stack.pop();
            }
            else if((nextEl=stack.peek().next()).isInteger())
            {
                return true;
            }
            else{
                stack.push(nextEl.getList().iterator());
            }
        }
        
        return false;
        
        
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

 // Time Complexity : O(1)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no