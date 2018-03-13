public static int[] intersect(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0 && length2 == 0){
            return new int[0];
        }
        //int length3 = length1 > length2 ? length1 : length2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new LinkedList<>();


        for (int i = 0; i < length1 ; i++) {
            map.put(nums1[i], map.containsKey(nums1[i]) ? 
(map.get(nums1[i]) + 1) : 1);
        }

        for (int i = 0; i < length2; i++) {
            int temp = nums2[i];

            if(map.containsKey(temp)){
                int amount = map.get(temp);
                if (amount > 0){
                    map.put(temp, map.get(temp) - 1);
                    list.add(temp);
                }
            }
        }
        int [] result = new int[list.size()];

        int k = 0;
        for (Integer arr:list) {
            result[k++] = arr;
        }

        return result;
    }
