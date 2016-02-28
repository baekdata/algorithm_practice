package Algorithm;

public class olymp05 { // 미로찾기, 소스 봐야함, 쓰기만 했음
	public olymp05() {
		String[] lines = { "######",
				"#S...#",
				"#.##.#",
				"#.##.#",
				"#...F#",
				"######"
		};
		char[][] ground = toStringArray(lines);

		findPath(new Path(1,1),ground);
	}
	private void findPath(Path path,char[][] ground) {
		Path[] p = new Path[4];
		p[0] = new Path(path.x-1,path.y);
		p[1] = new Path(path.x,path.y+1);
		p[2] = new Path(path.x+1,path.y);
		p[3] = new Path(path.x,path.y-1);

		for (int i = 0; i < p.length; i++) {

			p[i].prev = path;
			if(isAble(p[i],ground)) {
				if(isEnd(p[i],ground)) {
					System.out.print("find : ");
					print(p[i]);
					System.out.println();
				}else {
					findPath(p[i], ground);
				}
			}
		}
	}
	private void print(Path path) {
		if(path != null) {
			print(path.prev);
			System.out.print(path.toString());
		}
	}
	private boolean isEnd(Path p, char[][] ground) {
		return ground[p.x][p.y] == 'F';
	}
	private boolean isAble(Path p, char[][] ground) {
		try {
			if(ground[p.x][p.y] == '.'|| ground[p.x][p.y] == 'F') {
				Path prev = p.prev;
				while(prev != null) {
					if(prev.equals(p)) {
						return false;
					}
					prev = prev.prev;
				}
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	private char[][] toStringArray(String[] lines) {
		char[][] gr = new char[lines.length][];
		for (int i=0;i<lines.length;i++) {
			char[] li = lines[i].toCharArray();
			gr[i] = li;
		}
		return gr;
	}

	class Path{
		int x,y;
		Path prev;
		Path(int x, int y){
			this.x = x;
			this.y = y;

		}
		@Override
		public boolean equals(Object obj) {
			Path p = (Path) obj;

			return x == p.x && y==p.y;
		}
		@Override
		public String toString() {
			return String.format("(%d,%d)", x,y);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new olymp05();
	}
}