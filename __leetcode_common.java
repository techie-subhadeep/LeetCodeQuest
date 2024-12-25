import java.util.concurrent.*;
import java.util.*;

public class __leetcode_common {
}

class ListNode {
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

class LeetCodeUtils {
    public static <T> void printMatrix(List<List<T>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix.get(i).get(j) + "\t");
            }
            System.out.println("");
        }
    }

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static <T> T runWithTimeout(Callable<T> callable, int timeoutSeconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<T> future = executor.submit(callable);

        try {
            // Attempt to get the result within the specified timeout
            return future.get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            // Cancel the task and interrupt the thread
            future.cancel(true);
            // Throw a custom TimeoutException
            System.out.println("========= Task timed out after " + timeoutSeconds + " Seconds ========");
            Runtime.getRuntime().exit(1);
            // throw new TimeoutException("Task timed out after " + timeoutSeconds + "
            // Seconds");
        } catch (Exception e) {
        } finally {
            // Shut down the executor service
            executor.shutdownNow();
        }
        return null;
    }

    public static ListNode listToListNode(List<Integer> nums) {
        ListNode head = null;
        ListNode p = null;
        for (Integer num : nums) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                p = head;
            } else {
                p.next = node;
                p = p.next;
            }
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" ► ");
            }
            current = current.next;
        }
        System.out.print(" ► NULL\n");

    }
}