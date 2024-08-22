class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int target = nums.length / 3;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) > target) {
                list.add(i);
            }
        }


        return list;
    }
}
