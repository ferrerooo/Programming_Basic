package zcy.Programming_Basic.dataStructure;
import java.util.*;
public class TreeTrie {

	public static void main(String[] args) {

	}
	
	// 这个结构的理解 太重要了！！！
	class TrieNode{
		public TrieNode[] childNodes;
		public int freq;
		public char nodeChar;
		public HashSet<Integer> hashSet = new HashSet<Integer>();
		public TrieNode(){
			childNodes = new TrieNode[26];
			freq = 0;
		}
	}
	
	public TrieNode root = new TrieNode();
	
	// FUNCTION 1. add
	public void AddTrieNode(TrieNode root, String word, int id) {
		if (word.length()==0)
			return;
		int k = word.charAt(0)-'a';
		if (root.childNodes[k]==null) {
			root.childNodes[k] = new TrieNode();
			root.childNodes[k].nodeChar = word.charAt(0);
		}
		root.childNodes[k].hashSet.add(id);
		
		String next = word.substring(1);
		if (next.length()==0)
			root.childNodes[k].freq++;
		
		AddTrieNode(root.childNodes[k], next, id);
	}
	
	// FUNCTION 2. search by Prefix. 检索单词的前缀,返回改前缀的Hash集合
	public HashSet<Integer> SearchTrie(String s) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		return SearchTrie(root, s, hashSet);
	}
	private HashSet<Integer> SearchTrie(TrieNode root, String word, HashSet<Integer> hashSet) {
		if (word.length() == 0)
			return hashSet;
		int k = word.charAt(0)-'a';
		String next = word.substring(1);
		if (next.length() == 0) {
			hashSet = root.childNodes[k].hashSet;
		}
		return SearchTrie(root.childNodes[k], next, hashSet);
	}
	
	// FUCNTION 3. word counter
	public int WordCount(String word){
		int[] count = new int[1];
		WordCount(root, word, count);
		return count[0];
	}
	private void WordCount(TrieNode root, String word, int[] count) {
		if (word.length() == 0) {
			return;
		}
		int k = word.charAt(0)-'a';
		String next = word.substring(1);
		if (next.length()==0) {
			count[0] = root.childNodes[k].freq;
		}
		WordCount(root.childNodes[k], next, count);
	}
	
	// FUNCTION 4. update old word with new word
	public void UpdateTrieNode(String newWord, String oldWord, int id) {
        UpdateTrieNode(root, newWord, oldWord, id);
    }
	private void UpdateTrieNode(TrieNode root, String newWord, String oldWord, int id) {
		//先删除
        DeleteTrieNode(oldWord, id);
        //再添加
        AddTrieNode(root, newWord, id);
	}
	
	// FUNCTION 5. delete
	public void DeleteTrieNode(String word, int id)
    {
        DeleteTrieNode(root, word, id);
    }
	private void DeleteTrieNode(TrieNode root, String word, int id) {
		if (word.length() == 0)
			return;
		int k = word.charAt(0)-'a';
		if (root.childNodes[k]==null)
			return;
		String next = word.substring(1);
		// ... to be continued
	}
	
	

}


/*
 * 
 public class Trie
    {
        public TrieNode trieNode = new TrieNode();

        #region Trie树节点
        /// <summary>
        /// Trie树节点
        /// </summary>
        public class TrieNode
        {
            /// <summary>
            /// 26个字符，也就是26叉树
            /// </summary>
            public TrieNode[] childNodes;

            /// <summary>
            /// 词频统计
            /// </summary>
            public int freq;

            /// <summary>
            /// 记录该节点的字符
            /// </summary>
            public char nodeChar;

            /// <summary>
            /// 插入记录时的编号id
            /// </summary>
            public HashSet<int> hashSet = new HashSet<int>();

            /// <summary>
            /// 初始化
            /// </summary>
            public TrieNode()
            {
                childNodes = new TrieNode[26];
                freq = 0;
            }
        }
        #endregion

        #region 插入操作
        /// <summary>
        /// 插入操作
        /// </summary>
        /// <param name="word"></param>
        /// <param name="id"></param>
        public void AddTrieNode(string word, int id)
        {
            AddTrieNode(ref trieNode, word, id);
        }

        /// <summary>
        /// 插入操作
        /// </summary>
        /// <param name="root"></param>
        /// <param name="s"></param>
        public void AddTrieNode(ref TrieNode root, string word, int id)
        {
            if (word.Length == 0)
                return;

            //求字符地址，方便将该字符放入到26叉树中的哪一叉中
            int k = word[0] - 'a';

            //如果该叉树为空，则初始化
            if (root.childNodes[k] == null)
            {
                root.childNodes[k] = new TrieNode();

                //记录下字符
                root.childNodes[k].nodeChar = word[0];
            }

            //该id途径的节点
            root.childNodes[k].hashSet.Add(id);

            var nextWord = word.Substring(1);

            //说明是最后一个字符，统计该词出现的次数
            if (nextWord.Length == 0)
                root.childNodes[k].freq++;

            AddTrieNode(ref root.childNodes[k], nextWord, id);
        }
        #endregion

        #region 检索操作
        /// <summary>
        /// 检索单词的前缀,返回改前缀的Hash集合
        /// </summary>
        /// <param name="s"></param>
        /// <returns></returns>
        public HashSet<int> SearchTrie(string s)
        {
            HashSet<int> hashSet = new HashSet<int>();

            return SearchTrie(ref trieNode, s, ref hashSet);
        }

        /// <summary>
        /// 检索单词的前缀,返回改前缀的Hash集合
        /// </summary>
        /// <param name="root"></param>
        /// <param name="s"></param>
        /// <returns></returns>
        public HashSet<int> SearchTrie(ref TrieNode root, string word, ref HashSet<int> hashSet)
        {
            if (word.Length == 0)
                return hashSet;

            int k = word[0] - 'a';

            var nextWord = word.Substring(1);

            if (nextWord.Length == 0)
            {
                //采用动态规划的思想，word最后节点记录这途经的id
                hashSet = root.childNodes[k].hashSet;
            }

            SearchTrie(ref root.childNodes[k], nextWord, ref hashSet);

            return hashSet;
        }
        #endregion

        #region 统计指定单词出现的次数

        /// <summary>
        /// 统计指定单词出现的次数
        /// </summary>
        /// <param name="root"></param>
        /// <param name="word"></param>
        /// <returns></returns>
        public int WordCount(string word)
        {
            int count = 0;

            WordCount(ref trieNode, word, ref count);

            return count;
        }

        /// <summary>
        /// 统计指定单词出现的次数
        /// </summary>
        /// <param name="root"></param>
        /// <param name="word"></param>
        /// <param name="hashSet"></param>
        /// <returns></returns>
        public void WordCount(ref TrieNode root, string word, ref int count)
        {
            if (word.Length == 0)
                return;

            int k = word[0] - 'a';

            var nextWord = word.Substring(1);

            if (nextWord.Length == 0)
            {
                //采用动态规划的思想，word最后节点记录这途经的id
                count = root.childNodes[k].freq;
            }

            WordCount(ref root.childNodes[k], nextWord, ref count);
        }

        #endregion

        #region 修改操作
        /// <summary>
        /// 修改操作
        /// </summary>
        /// <param name="newWord"></param>
        /// <param name="oldWord"></param>
        /// <param name="id"></param>
        public void UpdateTrieNode(string newWord, string oldWord, int id)
        {
            UpdateTrieNode(ref trieNode, newWord, oldWord, id);
        }

        /// <summary>
        /// 修改操作
        /// </summary>
        /// <param name="root"></param>
        /// <param name="newWord"></param>
        /// <param name="oldWord"></param>
        /// <param name="id"></param>
        public void UpdateTrieNode(ref TrieNode root, string newWord, string oldWord, int id)
        {
            //先删除
            DeleteTrieNode(oldWord, id);

            //再添加
            AddTrieNode(newWord, id);
        }
        #endregion

        #region 删除操作
        /// <summary>
        ///  删除操作
        /// </summary>
        /// <param name="root"></param>
        /// <param name="newWord"></param>
        /// <param name="oldWord"></param>
        /// <param name="id"></param>
        public void DeleteTrieNode(string word, int id)
        {
            DeleteTrieNode(ref trieNode, word, id);
        }

        /// <summary>
        /// 删除操作
        /// </summary>
        /// <param name="root"></param>
        /// <param name="newWord"></param>
        /// <param name="oldWord"></param>
        /// <param name="id"></param>
        public void DeleteTrieNode(ref TrieNode root, string word, int id)
        {
            if (word.Length == 0)
                return;

            //求字符地址，方便将该字符放入到26叉树种的哪一颗树中
            int k = word[0] - 'a';

            //如果该叉树为空,则说明没有找到要删除的点
            if (root.childNodes[k] == null)
                return;

            var nextWord = word.Substring(1);

            //如果是最后一个单词，则减去词频
            if (word.Length == 0 && root.childNodes[k].freq > 0)
                root.childNodes[k].freq--;

            //删除途经节点
            root.childNodes[k].hashSet.Remove(id);

            DeleteTrieNode(ref root.childNodes[k], nextWord, id);
        }
        #endregion
    }
}
 * 
 * */
