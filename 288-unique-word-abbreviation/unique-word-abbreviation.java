// An abbreviation of a word follows the form &lt;first letter&gt;&lt;number&gt;&lt;last letter&gt;. Below are some examples of word abbreviations:
//
//
// a) it                      --&gt; it    (no abbreviation)
//
//      1
//      &darr;
// b) d|o|g                   --&gt; d1g
//
//               1    1  1
//      1---5----0----5--8
//      &darr;   &darr;    &darr;    &darr;  &darr;    
// c) i|nternationalizatio|n  --&gt; i18n
//
//               1
//      1---5----0
// &nbsp;    &darr;   &darr;    &darr;
// d) l|ocalizatio|n          --&gt; l10n
//
//
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word&#39;s abbreviation is unique if no other word from the dictionary has the same abbreviation.
//
// Example:
//
//
// Given dictionary = [ &quot;deer&quot;, &quot;door&quot;, &quot;cake&quot;, &quot;card&quot; ]
//
// isUnique(&quot;dear&quot;) -&gt; false
// isUnique(&quot;cart&quot;) -&gt; true
// isUnique(&quot;cane&quot;) -&gt; false
// isUnique(&quot;make&quot;) -&gt; true
//
//


public class ValidWordAbbr {
    private final Map<String, Set<String>> abbrDict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String s : dictionary) {
            String abbr = toAbbr(s);
            Set<String> words = abbrDict.containsKey(abbr)
                ? abbrDict.get(abbr) : new HashSet<>();
            words.add(s);
            abbrDict.put(abbr, words);
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        Set<String> words = abbrDict.get(abbr);
        return words == null || (words.size() == 1 && words.contains(word));
    }

    private String toAbbr(String s) {
        int n = s.length();
        if (n <= 2) {
            return s;
        }
        return s.charAt(0) + Integer.toString(n - 2) + s.charAt(n - 1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
