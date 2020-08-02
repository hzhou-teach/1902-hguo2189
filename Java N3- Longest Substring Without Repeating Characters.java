class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> characters = new ArrayList<String>();
        int maxim = 0;
        int current = 0;
        for (int n = 0; n < s.length(); n++) {
            for (int m = n; m < s.length(); m++) {
                String chr = s.substring(m, m + 1);
                for (String x : characters) {
                    if (chr.equals(x)) {
                        m = s.length() + 1;
                        maxim = Math.max(maxim, current);
                        current = 0;
                        characters = new ArrayList<String>();
                    }
                }
                if (m == s.length() + 1) {continue;}
                current++;
                characters.add(chr);
            }
        }
        if (maxim == 0) {return current;}
        else {return maxim;}
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxim = 0;
        ArrayList<Character> norepeat = new ArrayList<Character>();
        while (right < s.length()) {
            Character chr = s.charAt(right);
            int remove = 0;
            for (int n = 0; n < norepeat.size(); n++) {
                if (chr.equals(norepeat.get(n))) {
                    maxim = Math.max(maxim, right - left);
                    remove++;
                    while (remove > 0 && norepeat.size() != 0) {
                        left++;
                        norepeat.remove(0);
                        remove--;
                    }
                    break;
                }
                else {remove++;}
            }
            norepeat.add(chr);
            right++;
        }
        return Math.max(maxim, right - left);
    }
}