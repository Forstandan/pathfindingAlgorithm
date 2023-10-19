import java.util.List;
import java.util.Random;

public class Grid {
    public static class Block {
        private final int x;
        private final int y;
        private final boolean canTraverse;
        public Block(int x, int y, boolean canTraverse) {
            this.x = x;
            this.y = y;
            this.canTraverse = canTraverse;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public boolean isCanTraverse() { return canTraverse; }
    }

    // matrix of blocks
    Object[][] grid;
    int numOfBlocks;
    public Grid(int n) {
        this.grid = createGrid(n);
        numOfBlocks = n*n;
    }

    private Object[][] createGrid(int n) {
        Random rand = new Random();
        Object[][] grid = new Object[n][n];
        int x = 0;
        int y = 0;
        int row = 0;
        int col = 0;

        for (int i = 0; i < n*n; i++) {
            grid[row][col] = new Grid.Block(x, y, rand.nextBoolean());
            x++;
            y++;

            if (col >= n-1 && col % n-1 == 0) {
                col = 0;
                row++;
            }
            else {
                col++;
            }

        }

        return grid;
    }
}
