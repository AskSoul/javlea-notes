public class RemoveLinkListElements203Dummy {
    public static void main(String[] args) {
        RemoveLinkListElements203Dummy sol = new RemoveLinkListElements203Dummy();

        // 测试1：[1,2,6,3,4,5,6] val=6 → [1,2,3,4,5]
        ListNode h1 = build(new int[]{1,2,6,3,4,5,6});
        ListNode res1 = sol.removeElementsDummy(h1, 6);
        check("case1", equal(res1, new int[]{1,2,3,4,5}));

        // 测试2：头部节点需要删除 [6,1,2,3] val=6 → [1,2,3]
        ListNode h2 = build(new int[]{6,1,2,3});
        ListNode res2 = sol.removeElementsDummy(h2, 6);
        check("case2", equal(res2, new int[]{1,2,3}));

        // 测试3：尾部节点需要删除 [1,2,3,6] val=6 → [1,2,3]
        ListNode h3 = build(new int[]{1,2,3,6});
        ListNode res3 = sol.removeElementsDummy(h3, 6);
        check("case3", equal(res3, new int[]{1,2,3}));

        // 测试4：全部都要删 [7,7,7,7] val=7 → []
        ListNode h4 = build(new int[]{7,7,7,7});
        ListNode res4 = sol.removeElementsDummy(h4, 7);
        check("case4", equal(res4, new int[]{}));

        // 测试5：空链表 null val=5 → []
        ListNode h5 = null;
        ListNode res5 = sol.removeElementsDummy(h5, 5);
        check("case5", equal(res5, new int[]{}));

        // 测试6：单个节点，匹配删除 [5] val=5 → []
        ListNode h6 = build(new int[]{5});
        ListNode res6 = sol.removeElementsDummy(h6, 5);
        check("case6", equal(res6, new int[]{}));

        // 测试7：单个节点，不匹配 [3] val=5 → [3]
        ListNode h7 = build(new int[]{3});
        ListNode res7 = sol.removeElementsDummy(h7, 5);
        check("case7", equal(res7, new int[]{3}));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElementsDummy(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void check(String name, boolean b) {
        if (b) {
            System.out.println(name + ":pass");
        } else {
            System.out.println(name + ":fail");
        }
    }

    // 辅助：数组构建链表
    public static ListNode build(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int num : arr) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return dummy.next;
    }

    // 辅助：判断链表和预期数组是否相等
    public static boolean equal(ListNode head, int[] expect) {
        ListNode p = head;
        int idx = 0;
        while (p != null) {
            if (idx >= expect.length) return false;
            if (p.val != expect[idx]) return false;
            p = p.next;
            idx++;
        }
        return idx == expect.length;
    }
}
