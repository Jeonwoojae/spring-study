class Trie {
    public class Node{
        public Map<Character, Node> children;
        public boolean isEndOfWord;

        public Node() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        insert(this.root, word);
    }

    private void insert(Node node, String word) {
        if (word.length() == 0) {
            node.isEndOfWord = true;
            return;
        }

        char c = word.charAt(0);
        Node child = node.children.get(c);

        if (child == null) {
            child = new Node(); // 자식 노드가 없으면 생성
            node.children.put(c, child);
        }

        insert(child, word.substring(1));
    }


    public boolean search(String word) {
        Node child = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!child.children.containsKey(c)) {
                return false;
            }
            child = child.children.get(c);
        }
        return child.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Node child = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!child.children.containsKey(c)) {
                return false;
            }
            child = child.children.get(c);
        }
        return true;
    }
}