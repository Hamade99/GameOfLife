
// This class draws the state of the game on screen.  It attaches itself at creation time to the GameOfLife object.  It also allows the user to toggle the state of a cell by clicking on it.

public class GameOfLifeUI extends JPanel{

  public GameOfLifeUI(int numbrows, int numbcols, int squaresize) {

		// init grid
		grid = new boolean[numbcols][numbrows];
		for (int i=0; i<numbcols; i++)
			for (int j=0; j<numbrows; j++)
				grid[i][j] = false;
		// choose some initial configuration
		// multiple inits might interfere with the shape behavior
		initGlider();
		initSmallExploder();
		initTumbler();

		this.squaresize = squaresize;
		setPreferredSize(new Dimension(numbcols*squaresize,numbrows*squaresize));

		this.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				toggleGridValue(e.getX(),e.getY());
			}
		});
	}

  public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		//draw background
		drawgrid(g2);

		//draw alive cells
		g2.setColor(Color.YELLOW);
		for (int i=0; i<grid.length; i++)
			for (int j=0; j<grid[0].length; j++)
				if (grid[i][j])
					g2.fill(new Rectangle2D.Double(i*squaresize+1,j*squaresize+1,squaresize-1,squaresize-1));
	}

  public void drawgrid(Graphics2D g2) {
		//fillbackground
		g2.setColor(Color.LIGHT_GRAY);
		g2.fill(getVisibleRect());
		//drawgrid
		g2.setColor(Color.GRAY);
		for (int i=0;i<=grid.length;i++)
			g2.drawLine(i*squaresize, 0, i*squaresize,grid[0].length*squaresize);
		for (int i=0;i<=grid[0].length;i++)
			g2.drawLine(0,i*squaresize,grid.length*squaresize,i*squaresize);
	}

}
