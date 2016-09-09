import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner mrScan = new Scanner(System.in);
		int cases = mrScan.nextInt();
		while (cases-- > 0) {
			int nums = mrScan.nextInt();
			int[] n = new int[nums];
			boolean[] visited = new boolean[nums];
			for (int i = 0; i < nums; i++) {
				n[i] = mrScan.nextInt();
			}
			int min = 0;
			int max = nums;
			int index = 0;
			while (true) {
				index = (max + min) / 2;

				int left = sum(n, index, 0);
				int right = sum(n, index, 1);

				//System.out.println(index + ": " + left + " " + right);
				if (left == right) {
					System.out.println("YES");
					break;
				} else if (left > right) {
					max = index + 1;
				} else {
					min = index - 1;
				}
				try {
					if (visited[index]) {
						System.out.println("NO");
						break;
					}
				} catch (Exception e) {
					System.out.println("NO");
					break;
				}
				visited[index] = true;



				// System.out.println(Arrays.toString(n));

			}
		}
	}

	public static int sum(int[] n, int index, int side) {
		int sum = 0;

		if (side == 0) {
			for (int i = 0; i < index; i++) {
				sum += n[i];
			}
		} else if (side == 1) {
			for (int i = index + 1; i < n.length; i++) {
				sum += n[i];
			}
		}
		return sum;
	}

}
