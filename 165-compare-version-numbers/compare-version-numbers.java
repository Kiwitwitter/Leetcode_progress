// Compare two version numbers version1 and version2.
// If version1 &gt; version2 return 1;&nbsp;if version1 &lt; version2 return -1;otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not &quot;two and a half&quot; or &quot;half way to version three&quot;, it is the fifth second-level revision of the second first-level revision.
//
// Example 1:
//
//
// Input: version1 = &quot;0.1&quot;, version2 = &quot;1.1&quot;
// Output: -1
//
// Example 2:
//
//
// Input: version1 = &quot;1.0.1&quot;, version2 = &quot;1&quot;
// Output: 1
//
// Example 3:
//
//
// Input: version1 = &quot;7.5.2.4&quot;, version2 = &quot;7.5.3&quot;
// Output: -1
//


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for ( int i = 0; i < Math.max(v1.length, v2.length); i++ ) {
            int num1 = i < v1.length ? Integer.parseInt( v1[i] ) : 0;
            int num2 = i < v2.length ? Integer.parseInt( v2[i] ) : 0;
            if ( num1 < num2 ) {
                return -1;
            } else if ( num1 > num2 ) {
                return +1;
            }
        } 

        return 0;
    }
}
