package com.java.geeks.solution.hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class House {
	int i;
	int j;
	int distance;
	boolean isVisited;
	boolean isBomb;
	boolean isWall;

	public House(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

	public House() {
		super();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	@Override
	public String toString() {
		return "House [i=" + i + ", j=" + j + ", distance=" + distance + ", isVisited=" + isVisited + ", isBomb="
				+ isBomb + ", isWall=" + isWall + "]";
	}

}

public class SpideySense {

	public static void main(String[] args) {
//		char mat[][] = {{'O','O','O'},
//						{'W','B','B'},
//						{'W','O','O'}};
//		int n = 3;
//		int m = 3;

//		char mat[][] = {{'O','O','O','O','B'},
//						{'O','W','W','O','O'},
//						{'O','O','O','W','O'},
//						{'B','W','W','W','O'},
//						{'O','O','O','O','B'}
//						};

//		char mat[][] = {{'O','O','O','O','O','B'},
//						{'O','O','W','W','O','O'},
//						{'O','O','O','O','W','O'},
//						{'O','B','W','W','W','O'},
//						{'O','O','O','O','O','B'}
//						};
//		
//		int m = 6;//colms
//		int n = 5;//rows

		char mat[][] = { { 'W', 'B', 'W', 'B', 'O', 'O', 'O', 'W', 'B' },
				{ 'O', 'B', 'O', 'O', 'O', 'B', 'O', 'W', 'O' }, { 'B', 'B', 'B', 'W', 'B', 'B', 'B', 'O', 'B' },
				{ 'B', 'O', 'O', 'W', 'B', 'O', 'B', 'W', 'W' }, { 'B', 'B', 'W', 'O', 'B', 'B', 'B', 'W', 'O' } };

		// 5 9

		int m = 5;// rows
		int n = 9;// cols

//		O O O O B
//		O W W O O
//		O O O W O
//
//		B W W W O
//		O O O O B

		System.out.println(mat.length);
		System.out.println(mat[0].length);

//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				
//				System.out.print("i = "+i);
//				System.out.print(" ");
//				System.out.print("j = "+j);
//				System.out.print(", ");
//				System.out.println(mat[i][j]);
//			}
//			System.out.println();
//		}

		int result[][] = findDistance(mat, m, n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] findDistance(char mat[][], int m, int n) {


		House[][] houseMatrix = new House[m][n];
		List<House> bombList = new ArrayList<>();
		int result[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				House house = new House(i, j);
				if (mat[i][j] == 'W') {
					house.setWall(true);
				}else
				if (mat[i][j] == 'B') {
					house.setBomb(true);
					bombList.add(house);
				} 
				house.isVisited = false;
				houseMatrix[i][j] = house;
			}
		}
		if (bombList == null || bombList.size() == 0) {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (mat[i][j] == 'W') {
						result[i][j] = -1;
					}
					if (mat[i][j] == 'B') {
						result[i][j] = 0;
					}
					if (mat[i][j] == 'O') {
						result[i][j] = -1;
					}
				}
			}
			return result;
		}
		for (House bomb : bombList) {
			LinkedList<House> queue = new LinkedList<>();
			queue.addFirst(bomb);
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (houseMatrix[i][j].isBomb == true) {
						houseMatrix[i][j].isVisited = true;
					}
					if (houseMatrix[i][j].isWall == true) {
						houseMatrix[i][j].isVisited = true;
					}
					houseMatrix[i][j].isVisited = false;
				}
			}
			bomb.isVisited = true;

			while (!queue.isEmpty()) {
				House source = queue.removeLast();
				House up = null;
				House down = null;
				House left = null;
				House right = null;

				if ((source.i - 1) >= 0) {
					up = houseMatrix[source.i - 1][source.j];
				}
				if ((source.i + 1) <= m - 1) {
					down = houseMatrix[source.i + 1][source.j];
				}
				if ((source.j - 1) >= 0) {
					left = houseMatrix[source.i][source.j - 1];
				}
				if ((source.j + 1) <= n - 1) {
					right = houseMatrix[source.i][source.j + 1];
				}

				if (source.isBomb) {
					if (up != null && !up.isWall && !up.isBomb) {
						up.setDistance(1);
						up.isVisited = true;
						queue.addFirst(up);
					}
					if (down != null && !down.isWall && !down.isBomb) {
						down.setDistance(1);
						down.isVisited = true;
						queue.addFirst(down);
					}
					if (left != null && !left.isWall && !left.isBomb) {
						left.setDistance(1);
						left.isVisited = true;
						queue.addFirst(left);
					}
					if (right != null && !right.isWall && !right.isBomb) {
						right.setDistance(1);
						right.isVisited = true;
						queue.addFirst(right);
					}
				} else {
					if (up != null && !up.isBomb && !up.isWall && !source.isWall) {
						if (!up.isVisited) {
							queue.addFirst(up);
							up.isVisited = true;
							up.setDistance(source.getDistance() + 1);
						} else if (up.getDistance() > source.getDistance()) {
							up.setDistance(source.getDistance() + 1);
						}
					}
					if (down != null && !down.isBomb && !down.isWall && !source.isWall) {
						if (!down.isVisited) {
							queue.addFirst(down);
							down.isVisited = true;
							down.setDistance(source.getDistance() + 1);
						} else if (down.getDistance() > (source.getDistance())) {
							down.setDistance(source.getDistance() + 1);
						}
					}
					if (left != null && !left.isBomb && !left.isWall && !source.isWall) {
						if (!left.isVisited) {
							queue.addFirst(left);
							left.isVisited = true;
							left.setDistance(source.getDistance() + 1);
						} else if (left.getDistance() > (source.getDistance())) {
							left.setDistance(source.getDistance() + 1);
						}
					}
					if (right != null && !right.isBomb && !right.isWall && !source.isWall) {
						if (!right.isVisited) {
							queue.addFirst(right);
							right.isVisited = true;
							right.setDistance(source.getDistance() + 1);
						} else if (right.getDistance() > (source.getDistance())) {
							right.setDistance(source.getDistance() + 1);
						}
					}
				}
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (houseMatrix[i][j].isWall == true) {
						result[i][j] = -1;
					} else if (houseMatrix[i][j].isBomb == true) {
						result[i][j] = 0;
					}
					else {
						if (result[i][j] > houseMatrix[i][j].distance && houseMatrix[i][j].isVisited) {
							result[i][j] = houseMatrix[i][j].distance;
						} else {
		
						}

					}
				}
		
			}
		
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				 if (result[i][j]==Integer.MAX_VALUE) {
					 result[i][j]= -1;
				} 
			}
		}
		return result;
    }
	
	
}
