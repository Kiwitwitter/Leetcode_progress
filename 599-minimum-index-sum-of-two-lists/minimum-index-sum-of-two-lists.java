//
// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings. 
//
//
// You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
//
//
//
// Example 1:
//
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
// Output: ["Shogun"]
// Explanation: The only restaurant they both like is "Shogun".
//
//
//
// Example 2:
//
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["KFC", "Shogun", "Burger King"]
// Output: ["Shogun"]
// Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
//
//
//
//
// Note:
//
// The length of both lists will be in the range of [1, 1000].
// The length of strings in both lists will be in the range of [1, 30].
// The index is starting from 0 to the list length minus 1.
// No duplicates in both lists.
//
//


class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        for(int sum = 0; sum<list1.length + list2.length;sum++){
            for(int i=0;i<=sum;i++){
                if(i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i])){
                    res.add(list1[i]);
                }
            }
            if(res.size()>0){
                break;
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
