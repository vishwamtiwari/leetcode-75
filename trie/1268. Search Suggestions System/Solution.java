class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        Trie suggestions = new Trie();

        for (String product: products) {
            Trie current = suggestions;
            for (int i = 0; i < product.length(); i++) {
                int index = product.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new Trie();
                }
                current = current.children[index];
                if (current.words.size() < 3) {
                    current.words.add(product);
                }
            }
        }

        Trie current = suggestions;
        for (char c: searchWord.toCharArray()) {
            int index = c - 'a';
            if (current == null || current.children[index] == null) {
                current = null;
                result.add(new ArrayList<>());
                continue;
            }
            current = current.children[index];
            result.add(current.words);
        }

        return result;
    }

    class Trie {
        Trie[] children;
        List<String> words;

        Trie() {
            this.children = new Trie[26];
            this.words = new ArrayList<>();
        }
    }
}